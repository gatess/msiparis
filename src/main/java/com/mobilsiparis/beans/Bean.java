package com.mobilsiparis.beans;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 * Created with IntelliJ IDEA.
 * User: Gokhan
 * Date: 04.01.2014
 * Time: 15:51
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean
@SessionScoped
public class Bean {

    public void navigate(ActionEvent event){
                  try{
                      FacesContext.getCurrentInstance().getExternalContext().redirect("menu1.xhtml");

                  }   catch (Exception e){

                        e.printStackTrace();
                  }


    }


    public void showMessage() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "What we do in life", "Echoes in eternity.");

      //  RequestContext.getCurrentInstance().showMessageInDialog(message);
    }


    private boolean karar =false;

    public boolean isKarar() {
        return karar;
    }

    public void setKarar(boolean karar) {
        this.karar = karar;
    }

    @Autowired
     MasaBean masaBean;
    private double sayi;


    private String js="<script>alert('foo');</script>";

    public String getJs() {
        return js;
    }

    public void setJs(String js) {
        this.js = js;
    }

    public double getSayi() {
        return sayi;
    }

    public void setSayi(double sayi) {
        this.sayi = sayi;
    }

    public String rasgele() {
        setSayi(Math.random() * 10);
        return "ajaxdeneme";
    }
    public String deneme(){
        karar=true;
        return "ajaxdeneme";
    }

    public String logout(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "masasec";
    }
    public void workBeforeView()throws  Exception{

        if(masaBean.getMasaNo()==null){
            FacesContext.getCurrentInstance().getExternalContext().redirect("masasec.xhtml");
        }
    }
    public void destroyWorld(ActionEvent actionEvent){
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "System Error",  "Please try again later.");

        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
