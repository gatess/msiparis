package com.mobilsiparis.beans;

import com.mobilsiparis.hibernateclasses.hesap.Hesap;
import com.mobilsiparis.hibernateclasses.hesap.HesapBo;
import com.mobilsiparis.hibernateclasses.masa.Masa;
import com.mobilsiparis.hibernateclasses.masa.MasaBo;
import com.mobilsiparis.hibernateclasses.siparis.Siparis;
import com.mobilsiparis.hibernateclasses.siparis.SiparisBo;
import com.mobilsiparis.hibernateclasses.user.User;
import com.mobilsiparis.hibernateclasses.user.UserBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gokhan
 * Date: 13.02.2014
 * Time: 15:24
 * To change this template use File | Settings | File Templates.
 */
@Component(value = "applicationbean")
@Scope(value = "singleton")
public class ApplicationBean implements Serializable {


    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    MasaBo masaBo;

    @Autowired
    Masa masa;
    List<Masa> masalar;


    @Autowired
    Siparis siparis;

    @Autowired
    SiparisBo siparisBo;

    List<Siparis> siparisler;

    List<Hesap> hesaplar;

    @Autowired
    Hesap hesap;

    @Autowired
    HesapBo hesapBo;

    @Autowired
    User user;

    @Autowired
    UserBo userBo;

    @PostConstruct
    public void hemenSonra(){

        try{
            masalar = masaBo.allValues();
            for(int i=0;i<masalar.size();i++){

                masa=masalar.get(i);
                masa.setIsfull(false);
                masaBo.update(masa);
            }

            siparisler=  siparisBo.allValues();
            for(Siparis sprs :siparisler){
                sprs.setSent(true);
                siparisBo.update(sprs);
            }

           hesaplar= hesapBo.allValues();
           for(Hesap hesap:hesaplar){
               hesap.setIsnull(true);
               hesapBo.update(hesap);

            }
            user =(User) userBo.findByPassword("123456");
            System.out.println("");

        }
        catch (Exception e){

            e.printStackTrace();
        }

    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
