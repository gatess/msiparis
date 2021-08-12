package com.mobilsiparis.beans;

import com.mobilsiparis.hibernateclasses.garsonistek.GarsonIstek;
import com.mobilsiparis.hibernateclasses.garsonistek.GarsonIstekBo;
import com.mobilsiparis.hibernateclasses.hesap.Hesap;
import com.mobilsiparis.hibernateclasses.hesap.HesapBo;
import com.mobilsiparis.hibernateclasses.hesapistek.HesapIstek;
import com.mobilsiparis.hibernateclasses.hesapistek.HesapIstekBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Gokhan
 * Date: 20.06.2014
 * Time: 09:39
 * To change this template use File | Settings | File Templates.
 */
@Component(value ="hesapbean")
@Scope(value = "session")
public class HesapBean implements Serializable{

    @Autowired
    MasaBean masaBean;

    @Autowired
    GarsonIstek garsonIstek;

   @Autowired
    HesapIstek hesapIstek;

    @Autowired
    HesapIstekBo hesapIstekBo;

    @Autowired
    Hesap hesap;

    @Autowired
    HesapBo hesapBo;


    @Autowired
    GarsonIstekBo garsonIstekBo;
    public void garsonCagir(ActionEvent event){

        try {    Integer id = (Integer)garsonIstekBo.findMaxId();
            Date date = new Date();
            int masaId=masaBean.getMasaNo();
            if(id!=null)
                garsonIstek.setIstekId(id+1);
            else
                garsonIstek.setIstekId(1);
            garsonIstek.setMasaNo(masaId);
            garsonIstek.setIstekTarihi(date);
            garsonIstekBo.save(garsonIstek);
        }
        catch (Exception e){

            e.printStackTrace();

        }

    }

    public void hesapIstek(ActionEvent event){

        try {    Integer id = (Integer)hesapIstekBo.findMaxId();
            Date date = new Date();
            int hesapId=masaBean.getHesap().getHesapId();
            if(id!=null)
                hesapIstek.setHesapIstekId(id+1);
            else
               hesapIstek.setHesapIstekId(1);
        hesapIstek.setHesapId(hesapId);
            garsonIstek.setIstekTarihi(date);
            hesapIstekBo.save(hesapIstek);
        }
        catch (Exception e){

            e.printStackTrace();

        }

    }

    @PostConstruct
    public void workAfterConstruct(){

       hesap= masaBean.getHesap();
    }


    public MasaBean getMasaBean() {
        return masaBean;
    }

    public void setMasaBean(MasaBean masaBean) {
        this.masaBean = masaBean;
    }

    public GarsonIstek getGarsonIstek() {
        return garsonIstek;
    }

    public void setGarsonIstek(GarsonIstek garsonIstek) {
        this.garsonIstek = garsonIstek;
    }

    public HesapBo getHesapBo() {
        return hesapBo;
    }

    public void setHesapBo(HesapBo hesapBo) {
        this.hesapBo = hesapBo;
    }

    public Hesap getHesap() {
        return hesap;
    }

    public void setHesap(Hesap hesap) {
        this.hesap = hesap;
    }

    public GarsonIstekBo getGarsonIstekBo() {
        return garsonIstekBo;
    }

    public void setGarsonIstekBo(GarsonIstekBo garsonIstekBo) {
        this.garsonIstekBo = garsonIstekBo;
    }
}
