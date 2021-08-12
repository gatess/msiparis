package com.mobilsiparis.hibernateclasses.siparis;

import com.mobilsiparis.hibernateclasses.hesap.Hesap;
import com.mobilsiparis.hibernateclasses.siparisurun.SiparisUrun;
import org.springframework.stereotype.Component;

import javax.annotation.Generated;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Gokhan
 * Date: 11.12.2013
 * Time: 23:08
 * To change this template use File | Settings | File Templates.
 */
@Component
@Entity
@Table(name = "Siparis")
public class Siparis implements Serializable {


    private Integer siparisId;
    private Integer masaNo;
    private double toplamFiyat;
    private Integer urunSayisi;
    private Date tarih;
    private  String ozelİstek;
    private boolean isSent=false;
    private Hesap hesap;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
      public Integer getSiparisId() {
        return siparisId;
    }

    public void setSiparisId(Integer siparisId) {
        this.siparisId = siparisId;
    }

    @Column(name="masano")
     public Integer getMasaNo() {
        return masaNo;
    }

    public void setMasaNo(Integer masaNo) {
        this.masaNo = masaNo;
    }

    @Column(name = "toplamfiyat")
      public double getToplamFiyat() {
        return toplamFiyat;
    }

    public void setToplamFiyat(double toplamFiyat) {
        this.toplamFiyat = toplamFiyat;
    }

    @Column(name = "urun_sayisi")
    public Integer getUrunSayisi() {
        return urunSayisi;
    }

    public void setUrunSayisi(Integer urunSayisi) {
        this.urunSayisi = urunSayisi;
    }


    @Column(name="tarih")
     public Date getTarih() {
        return tarih;
    }

    public void setTarih(Date tarih) {
        this.tarih = tarih;
    }


    @Column(name="ozel_istek")
     public String getOzelİstek() {
        return ozelİstek;
    }

    public void setOzelİstek(String ozelİstek) {
        this.ozelİstek = ozelİstek;
    }

    @Column(name="isSent")
    public boolean isSent() {
        return isSent;
    }

    public void setSent(boolean sent) {
        isSent = sent;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hesap_id")
    public Hesap getHesap() {
        return hesap;
    }

    public void setHesap(Hesap hesap) {
        this.hesap = hesap;
    }
}
