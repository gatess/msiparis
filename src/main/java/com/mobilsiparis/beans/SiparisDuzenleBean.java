package com.mobilsiparis.beans;


import com.mobilsiparis.helper.Utils;
import com.mobilsiparis.hibernateclasses.hesap.Hesap;
import com.mobilsiparis.hibernateclasses.hesap.HesapBo;
import com.mobilsiparis.hibernateclasses.ozeldurum.OzelDurum;
import com.mobilsiparis.hibernateclasses.ozeldurum.OzelDurumBo;
import com.mobilsiparis.hibernateclasses.siparis.Siparis;
import com.mobilsiparis.hibernateclasses.siparis.SiparisBo;
import com.mobilsiparis.hibernateclasses.siparisurun.SiparisUrun;
import com.mobilsiparis.hibernateclasses.siparisurun.SiparisUrunBo;
import com.mobilsiparis.hibernateclasses.urun.Urun;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gokhan
 * Date: 30.01.2014
 * Time: 11:38
 * To change this template use File | Settings | File Templates.
 */
@Component(value ="siparisduzenlebean")
@Scope(value = "session")
public class SiparisDuzenleBean implements Serializable {




    @Autowired
    HesapBean hesapBean;

    @Autowired
    Hesap hesap;

    @Autowired
    HesapBo hesapBo;

    @Autowired
    VotingBean votingBean;


    private List<Urun> siparisListesi= new ArrayList<Urun>();

    private List<SiparisUrun> siparisUrunList = new ArrayList<SiparisUrun>();
    /* @Autowired
    private List<OneMenuSelectItem> options;*/
    private List<OzelDurum> ozelDurumlar= new ArrayList<OzelDurum>();


    @Autowired
    private OzelDurum selectedOzelDurum;
    @Autowired
    Urun urun;

    @Autowired
    SiparisBean siparisBean;

    @Autowired
    OzelDurumBo ozelDurumBo;

    @Autowired
    SiparisBo siparisBo;

    @Autowired
    MasaBean masaBean;

    @Autowired
    Siparis siparis;

    @Autowired
    SiparisUrun siparisUrun;

    @Autowired
    SiparisUrunBo siparisUrunBo;


    public void workBeforeView()throws  Exception{

        if(masaBean.getMasaNo()==null){
            FacesContext.getCurrentInstance().getExternalContext().redirect("masasec.xhtml");
        }
    }
   @PostConstruct
    public void hemenSonra(){

        this.siparisListesi=siparisBean.getSiparisListesi();

         /*  for(int i=0;i<siparisBean.getSiparisListesi().size();i++){

                  urun=siparisBean.getSiparisListesi().get(i);
                  List<SelectItem> option= new ArrayList<SelectItem>();
               for(Iterator<OzelDurum> it= urun.getOzelDurums().iterator();it.hasNext();) {
                   OzelDurum ozelDurum= it.next();
                   option.add(new SelectItem(ozelDurum.getDurumId(),ozelDurum.getDurumAdi()));
               }
               options.add(new OneMenuSelectItem(option));
           }  */
    }


    public void siparisiVer(){
        try{
             int ozelDurumluUrunSayisi=0,j=0;
            Integer id=(Integer)siparisBo.findMaxId();

            double toplamfiyat=0;
            for(int i=0;i<siparisListesi.size();i++){
                toplamfiyat+=siparisListesi.get(i).getFiyat();

            }
            int masano=masaBean.getMasaNo();
            int urunSayisi=siparisListesi.size();
            //Timestamp date = Timestamp.
            Date date = new Date();
            if(id!=null)
                siparis.setSiparisId(id+1);
            else
                siparis.setSiparisId(1);

           // hesap=masaBean.getHesap();
            //hesap= hesapBean.getHesap();
            hesap=(Hesap)hesapBo.findByMasaNo(masano);
            siparis.setMasaNo(masano);
            siparis.setTarih(date);
            siparis.setUrunSayisi(urunSayisi);
            siparis.setToplamFiyat(toplamfiyat);
            siparis.setHesap(hesap);

            siparisBo.save(siparis);


            hesap.setFiyat(hesap.getFiyat()+toplamfiyat);
            hesap.setMasaNo(masano);
            hesap.getSiparis().add(siparis);
            hesapBo.update(hesap);
            for(int i=0;i<siparisListesi.size();i++){
                siparisUrun.setSiparisId(siparis.getSiparisId());
                siparisUrun.setUrunId(siparisListesi.get(i).getUrunId());
                if((Integer)siparisUrunBo.findMaxId()!=null)
                    siparisUrun.setSiparisUrunId((Integer)siparisUrunBo.findMaxId()+1);
                else
                    siparisUrun.setSiparisUrunId(1);
            if(ozelDurumBo.ozelDurumKontrol(siparisUrun.getUrunId())) ozelDurumluUrunSayisi++;
            }

            for(int i=0;i<siparisListesi.size();i++){
                siparisUrun.setSiparisId(siparis.getSiparisId());
                siparisUrun.setUrunId(siparisListesi.get(i).getUrunId());
                if((Integer)siparisUrunBo.findMaxId()!=null)
                    siparisUrun.setSiparisUrunId((Integer)siparisUrunBo.findMaxId()+1);
                else
                    siparisUrun.setSiparisUrunId(1);
                if(ozelDurumBo.ozelDurumKontrol(siparisUrun.getUrunId())) {
                    if(ozelDurumlar.size()>ozelDurumluUrunSayisi){
                        siparisUrun.setOzelDurumId(ozelDurumlar.get(j+ozelDurumluUrunSayisi).getDurumId());
                        j++;
                    }
                    else{
                        siparisUrun.setOzelDurumId(ozelDurumlar.get(i).getDurumId());
                    }

                }

                else  {
                    siparisUrun.setOzelDurumId(null);
                }

                siparisUrunBo.save(siparisUrun);




            }

            siparisListesi.clear();
            siparisBean.getSiparisListesi().clear();


              RequestContext context = RequestContext.getCurrentInstance();
               context.execute("alert('Siparişleriniz İletilmiştir');");
            votingBean.setControl(true);

        }   catch (Exception e){

            e.printStackTrace();
        }

    }

    public List<SiparisUrun> getSiparisUrunList() {
        return siparisUrunList;
    }

    public void setSiparisUrunList(List<SiparisUrun> siparisUrunList) {
        this.siparisUrunList = siparisUrunList;
    }



    public List<OzelDurum> getOzelDurumlar() {
        return ozelDurumlar;
    }

    public void setOzelDurumlar(List<OzelDurum> ozelDurumlar) {
        this.ozelDurumlar = ozelDurumlar;
    }

    public Urun getUrun() {
        return urun;
    }

    public void setUrun(Urun urun) {
        this.urun = urun;
    }

    public SiparisBean getSiparisBean() {
        return siparisBean;
    }

    public void setSiparisBean(SiparisBean siparisBean) {
        this.siparisBean = siparisBean;
    }

    public OzelDurumBo getOzelDurumBo() {
        return ozelDurumBo;
    }

    public void setOzelDurumBo(OzelDurumBo ozelDurumBo) {
        this.ozelDurumBo = ozelDurumBo;
    }

    public List<Urun> getSiparisListesi() {
        return siparisListesi;
    }

    public void setSiparisListesi(List<Urun> siparisListesi) {
        this.siparisListesi = siparisListesi;
    }

    public OzelDurum getSelectedOzelDurum() {
        return selectedOzelDurum;
    }

    public void setSelectedOzelDurum(OzelDurum selectedOzelDurum) {
        this.selectedOzelDurum = selectedOzelDurum;
    }

    public Siparis getSiparis() {
        return siparis;
    }

    public void setSiparis(Siparis siparis) {
        this.siparis = siparis;
    }
}
