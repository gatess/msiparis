package com.mobilsiparis.beans;

import com.mobilsiparis.helper.Utils;
import com.mobilsiparis.hibernateclasses.hesap.Hesap;
import com.mobilsiparis.hibernateclasses.hesap.HesapBo;
import com.mobilsiparis.hibernateclasses.masa.Masa;
import com.mobilsiparis.hibernateclasses.masa.MasaBo;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.model.SelectItem;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gokhan
 * Date: 15.12.2013
 * Time: 17:09
 * To change this template use File | Settings | File Templates.
 */
@Component(value = "masabean")
@Scope(value = "session")
public class MasaBean implements Serializable {

    private Boolean karar = false;
    private Boolean jsCondition = false;
    private String js = "<script>alert('foo');</script>";

    //@Autowired
    //ApplicationContext applicationContext;

    private Boolean disable = false;
    private Integer masaNo;

    @Autowired
    Masa masa;

    @Autowired
    private MasaBo masaBo;

    @Autowired
    Hesap hesap;


    @Autowired
    HesapBo hesapBo;


    public MasaBo getMasaBo() {
        return masaBo;
    }

    public void setMasaBo(MasaBo masaBo) {
        this.masaBo = masaBo;
    }

    private List<SelectItem> options = new ArrayList<SelectItem>();

    private List<Masa> masalar = new ArrayList<Masa>();


    public void workBeforeView(ComponentSystemEvent event) throws Exception {
        // FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }

    @PostConstruct
    public void hemenSonra() throws Exception {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        masalar.addAll(masaBo.allValues());
        for (int i = 0; i < masalar.size(); i++) {
            Masa masa = (Masa) masalar.get(i);
            SelectItem option = new SelectItem(masa.getMasaNo(), String.valueOf(masa.getMasaNo()));
            options.add(option);
        }
        // BeanDefinitionRegistry factory=  ( BeanDefinitionRegistry ) applicationContext.getAutowireCapableBeanFactory();
        //((DefaultListableBeanFactory)factory).destroyScopedBean("menubean");
        //MenuBean menuBean=(MenuBean) FacesContext.getCurrentInstance().getApplication().getELResolver().getValue(FacesContext.getCurrentInstance().getELContext(),null,"menubean");
        //  FacesContext.getCurrentInstance().getExternalContext().invalidateSession();



    }


    public Integer getMasaNo() {
        return masaNo;
    }

    public void setMasaNo(Integer masaNo) {
        this.masaNo = masaNo;
    }

    public List<SelectItem> getOptions() {
        return options;
    }

    public void setOptions(List<SelectItem> options) {
        this.options = options;
    }

    public List<Masa> getMasalar() {
        return masalar;
    }

    public void setMasalar(List<Masa> masalar) {
        this.masalar = masalar;
    }


    public void navigate1() {
        try {
            masa = masaBo.findMasa(masaNo);
            if (masa.isIsfull()) {
                // Utils.executeJavascirpt("alert('Sectiginiz Masa Doludur Lütfen Başka Masa Seçiniz')");
                // Utils.showErrorMessage("Sectiginiz Masa Doludur Lütfen Başka Masa Seçiniz");
                // Utils.showInfoMessage("Sectiginiz Masa Doludur Lütfen Başka Masa Seçiniz");
                // FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "What we do in life",
                //  "Echoes in eternity.");

                //  RequestContext.getCurrentInstance().showMessageInDialog(message);

                  /* FacesContext facesContext = FacesContext.getCurrentInstance();
                   ExtendedRenderKitService service =  (ExtendedRenderKitService)
                           Service.getRenderKitService(facesContext, ExtendedRenderKitService.class);
                   service.addScript(facesContext, "alert('hi');");*/

                //   RequestContext context = RequestContext.getCurrentInstance();
                //    context.execute("alert('deneme');");


                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Uyarı",
                        "Seçtiğiniz Masa Doludur Lütfen Başka Bir Masa seçiniz");

               RequestContext.getCurrentInstance().showMessageInDialog(message);

            } else {

                masa.setIsfull(true);
                masaBo.update(masa);


                hesap.setFiyat(0);

                hesap.setMasaNo(masaNo);
                hesap.getSiparis().clear();
                hesapBo.save(hesap);


                FacesContext facesContext = FacesContext.getCurrentInstance();
                String redirect = "index";// define the navigation rule that must be used in order to redirect the user to
                // the adequate page...
                NavigationHandler myNav = facesContext.getApplication().getNavigationHandler();
                myNav.handleNavigation(facesContext, null, redirect);
                System.out.println("abc");
            }
        } catch (Exception ex) {

            System.out.println("hata");
            ex.printStackTrace();
        }

    }

    public String navigate() throws Exception {
        System.out.println("girdi");
        masa = masaBo.findMasa(masaNo);
        if (masa.isIsfull()) {
            // Utils.executeJavascirpt("alert('Sectiginiz Masa Doludur Lütfen Başka Masa Seçiniz')");
            // Utils.showErrorMessage("Sectiginiz Masa Doludur Lütfen Başka Masa Seçiniz");
            // Utils.showInfoMessage("Sectiginiz Masa Doludur Lütfen Başka Masa Seçiniz");
            //RequestContext.getCurrentInstance().openDialog("uyari");

            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Uyarı",
                    "Seçtiğiniz masa doldur. Lütfen doğru masayı seçiniz !");

            RequestContext.getCurrentInstance().showMessageInDialog(message);
            karar = true;

            return "masasec.xhtml";
        } else {
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

            masa.setIsfull(true);
            masaBo.update(masa);
            return "index.xhtml";
        }

    }

    public Boolean getDisable() {
        return disable;
    }

    public void setDisable(Boolean disable) {
        this.disable = disable;
    }

    public Masa getMasa() {
        return masa;
    }

    public void setMasa(Masa masa) {
        this.masa = masa;
    }


    public void islem(ActionEvent event) {

        disable = false;
    }

    public Boolean getKarar() {
        return karar;
    }

    public void setKarar(Boolean karar) {
        this.karar = karar;
    }

    public Boolean getJsCondition() {
        return jsCondition;
    }

    public void setJsCondition(Boolean jsCondition) {
        this.jsCondition = jsCondition;
    }

    public String getJs() {
        return js;
    }

    public void setJs(String js) {
        this.js = js;
    }

    public Hesap getHesap() {
        return hesap;
    }

    public void setHesap(Hesap hesap) {
        this.hesap = hesap;
    }
}
