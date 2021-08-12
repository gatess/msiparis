package com.mobilsiparis.hibernateclasses.user;

import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Created by ishak on 10.07.2014.
 */

    @Component
    @Entity
    @Table(name = "user")
    public class User  {

    private String logoAdi;
    private String arkaplanAdi;
    private String baslik;
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer userId;

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        @Column(name = "password")
        private String passWord;

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    @Column(name = "logoadi")
    public String getLogoAdi() {
        return logoAdi;
    }

    public void setLogoAdi(String logoAdi) {
        this.logoAdi = logoAdi;
    }



    @Column(name="arkaplanAdi")
    public String getArkaplanAdi() {
        return arkaplanAdi;
    }

    public void setArkaplanAdi(String arkaplanAdi) {
        this.arkaplanAdi = arkaplanAdi;
    }
    @Column(name="baslik")

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }
}
