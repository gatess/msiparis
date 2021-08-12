package com.mobilsiparis.beans;


import com.mobilsiparis.hibernateclasses.kategori.Kategori;
import com.mobilsiparis.hibernateclasses.kategori.KategoriBo;
import com.mobilsiparis.hibernateclasses.urun.Urun;
import com.mobilsiparis.hibernateclasses.urun.UrunBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ComponentSystemEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Gokhan
 * Date: 16.12.2013
 * Time: 22:49
 * To change this template use File | Settings | File Templates.
 */
@Component(value ="menubean")
@Scope(value = "session")
public class MenuBean implements Serializable {

    private List<Kategori> kategoriler= new ArrayList<Kategori>();


    @Autowired
    MasaBean masabean;

    @Autowired
    UrunBo urunBo;

    @Autowired
    KategoriBo kategoriBo;

    @Autowired
    Kategori kategori;

    @Autowired
    Urun selectedUrun;

    private List<String> cikolatalar;
    private List<String> meyveler;

    private List<String> secilenMalzemeler;





    public void workBeforeView(ComponentSystemEvent event) throws Exception{

        if(masabean.getMasaNo()==null){
            FacesContext.getCurrentInstance().getExternalContext().redirect("masasec.xhtml");
        }
    }
    @PostConstruct
    public void hemenSonra()throws Exception{

        if(masabean.getMasaNo()==null){
            FacesContext.getCurrentInstance().getExternalContext().redirect("masasec.xhtml");
        }
           kategoriler= kategoriBo.allValues();

          // for(int i=0;i<kategoriler.size();i++){

                         // kategoriler.get(i).setUruns(urunBo.findByKategoriId(i+1));
               //kategoriBo.update(kategoriler.get(i));
           //}

        cikolatalar = new ArrayList<String>();
        cikolatalar.add("Bitter");
        cikolatalar.add("Beyaz");
        cikolatalar.add("Frambuaz");
        cikolatalar.add("Fındıklı");
        meyveler = new ArrayList<String>();
        meyveler.add("Muz");
        meyveler.add("Çilek");
        meyveler.add("Ananas");
        meyveler.add("Kivi");
                   System.out.print("deneme");


    }

        @PreDestroy
        public void hemenOnce(){
            System.out.println("Menu classı parçalandi");
        }

    public void showDetail(ActionEvent event){

     Integer   urunId=(Integer)event.getComponent().getAttributes().get("urunId");
     selectedUrun = (Urun)urunBo.findById(urunId);
    }
    public UrunBo getUrunBo() {
        return urunBo;
    }

    public void setUrunBo(UrunBo urunBo) {
        this.urunBo = urunBo;
    }

    public KategoriBo getKategoriBo() {
        return kategoriBo;
    }

    public void setKategoriBo(KategoriBo kategoriBo) {
        this.kategoriBo = kategoriBo;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }


    public List getKategoriler() {
        return kategoriler;
    }

    public void setKategoriler(List kategoriler) {
        this.kategoriler = kategoriler;
    }
    public String redirect(){
        return "menu";
    }

    public Urun getSelectedUrun() {
        return selectedUrun;
    }

    public void setSelectedUrun(Urun selectedUrun) {
        this.selectedUrun = selectedUrun;
    }

    public List<String> getCikolatalar() {
        return cikolatalar;
    }

    public void setCikolatalar(List<String> cikolatalar) {
        this.cikolatalar = cikolatalar;
    }

    public List<String> getMeyveler() {
        return meyveler;
    }

    public void setMeyveler(List<String> meyveler) {
        this.meyveler = meyveler;
    }

    public List<String> getSecilenMalzemeler() {
        return secilenMalzemeler;
    }

    public void setSecilenMalzemeler(List<String> secilenMalzemeler) {
        this.secilenMalzemeler = secilenMalzemeler;
    }
}
