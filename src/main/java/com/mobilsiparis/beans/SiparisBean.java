package com.mobilsiparis.beans;

import com.mobilsiparis.helper.Utils;
import com.mobilsiparis.hibernateclasses.garsonistek.GarsonIstek;
import com.mobilsiparis.hibernateclasses.garsonistek.GarsonIstekBo;
import com.mobilsiparis.hibernateclasses.hesap.Hesap;
import com.mobilsiparis.hibernateclasses.hesap.HesapBo;
import com.mobilsiparis.hibernateclasses.ozeldurum.OzelDurum;
import com.mobilsiparis.hibernateclasses.ozeldurum.OzelDurumBo;
import com.mobilsiparis.hibernateclasses.siparis.Siparis;
import com.mobilsiparis.hibernateclasses.siparis.SiparisBo;
import com.mobilsiparis.hibernateclasses.siparisurun.SiparisUrun;
import com.mobilsiparis.hibernateclasses.siparisurun.SiparisUrunBo;
import com.mobilsiparis.hibernateclasses.urun.Urun;
import com.mobilsiparis.hibernateclasses.urun.UrunBo;
import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Gokhan
 * Date: 17.01.2014
 * Time: 13:32
 * To change this template use File | Settings | File Templates.
 */
@Component(value ="siparisbean")
@Scope(value = "session")
public class SiparisBean implements Serializable{

    Logger logger= Logger.getLogger("gates");
    private HtmlDataTable dataTable;
    private Integer urunId;
    private List<Urun> siparisListesi= new ArrayList<Urun>();
    private List<SiparisUrun> siparisUrunList = new ArrayList<SiparisUrun>();
    private List<List<SelectItem>> options= new ArrayList<List<SelectItem>>();

    private List<OzelDurum> ozelDurumlar= new ArrayList<OzelDurum>();
    @Autowired
    private Urun selectedOrder;



    @Autowired
    SiparisUrun siparisUrun;

    @Autowired
    Siparis siparis;

    @Autowired
    SiparisBo siparisBo;

    @Autowired
    UrunBo urunBo;

    @Autowired
    Urun urun;

    @Autowired
    MasaBean masaBean;

    @Autowired
    SiparisUrunBo siparisUrunBo;

    @Autowired
    OzelDurumBo ozelDurumBo;

    @Autowired
    HesapBean hesapBean;

    @Autowired
    Hesap hesap;

    @Autowired
    HesapBo hesapBo;

    @Autowired
    GarsonIstek garsonIstek;

    @Autowired
    GarsonIstekBo garsonIstekBo;



    @PostConstruct
    public void init(){

        System.out.println("");
    }

    public void garsonCagir(){

        try {
            Date date = new Date();
            int masaId=masaBean.getMasaNo();

            garsonIstek.setMasaNo(masaId);
            garsonIstek.setIstekTarihi(date);
            garsonIstekBo.save(garsonIstek);

            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Uyarı",
                    "Garson İsteğiniz İLetilmiştir.");

           RequestContext.getCurrentInstance().showMessageInDialog(message);
        }
        catch (Exception e){

            e.printStackTrace();

        }

    }

    public void siparisiVer(ActionEvent event){
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



            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("alert('Siparişleriniz İletilmiştir');");
            //votingBean.setControl(true);

        }   catch (Exception e){

            e.printStackTrace();
        }

    }


    public void siparisEkle(ActionEvent event){

           try {
              urunId=(Integer)event.getComponent().getAttributes().get("urunId");
              urun=(Urun)urunBo.findById(urunId);
             // List<OzelDurum> ozeldurumlar= ozelDurumBo.findByUrunId(urunId);
              //Set<OzelDurum> ozeldurumlars= new HashSet<OzelDurum>();
              // for(int i=0;i<ozeldurumlar.size();i++){

              //     ozeldurumlars.add(ozeldurumlar.get(i));
              // }
              //urun.setOzelDurums(ozeldurumlars);
              siparisListesi.add(urun);
           }
           catch (Exception e){

               e.printStackTrace();
               logger.warn("siparis eklemede hata var");
           }


    }


    public void siparisCikart(ActionEvent event){

        try {

          //  int index = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("index").toString());
            urunId=(Integer)event.getComponent().getAttributes().get("urunId");
            urun=(Urun)urunBo.findById(urunId);
           siparisListesi.remove(urun);
           //selectedOrder= null;
            System.out.println("");

        }
        catch (Exception e){

            e.printStackTrace();
               logger.warn("sipariscıkartamada hata var");
        }
    }

    public Integer getUrunId() {
        return urunId;
    }

    public void setUrunId(Integer urunId) {
        this.urunId = urunId;
    }

    public List<Urun> getSiparisListesi() {
        return siparisListesi;
    }

    public void setSiparisListesi(List<Urun> siparisListesi) {
        this.siparisListesi = siparisListesi;
    }

    public UrunBo getUrunBo() {
        return urunBo;
    }

    public void setUrunBo(UrunBo urunBo) {
        this.urunBo = urunBo;
    }

    public Urun getUrun() {
        return urun;
    }

    public void setUrun(Urun urun) {
        this.urun = urun;
    }

    public HtmlDataTable getDataTable() {
        return dataTable;
    }

    public void setDataTable(HtmlDataTable dataTable) {
        this.dataTable = dataTable;
    }

    public OzelDurumBo getOzelDurumBo() {
        return ozelDurumBo;
    }

    public void setOzelDurumBo(OzelDurumBo ozelDurumBo) {
        this.ozelDurumBo = ozelDurumBo;
    }
    public void redirect()throws Exception{
        FacesContext.getCurrentInstance().getExternalContext().redirect("menu.xhtml");
    }

    public Siparis getSiparis() {
        return siparis;
    }

    public Urun getSelectedOrder() {
        return selectedOrder;
    }

    public void setSelectedOrder(Urun selectedOrder) {
        this.selectedOrder = selectedOrder;
    }
}
