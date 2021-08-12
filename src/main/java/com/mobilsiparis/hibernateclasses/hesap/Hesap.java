package com.mobilsiparis.hibernateclasses.hesap;


import com.mobilsiparis.hibernateclasses.hesapistek.HesapIstek;
import com.mobilsiparis.hibernateclasses.siparis.Siparis;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Serhat on 14.06.2014.
 */
@Component
@Entity
@Table(name="hesap")
public class Hesap implements Serializable{
private List<Siparis> siparis =new ArrayList<Siparis>();
   private Integer hesapIstekId;
    private Integer hesapId;
    private int masaNo;
    private double fiyat;
    private boolean isnull;



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getHesapId() {
        return hesapId;
    }

    public void setHesapId(Integer hesapId) {
        this.hesapId = hesapId;
    }


    @Column(name = "masano")
    public int getMasaNo() {return this.masaNo;}

    public void setMasaNo(int masaNo) {
       this.masaNo=masaNo;
    }



    @Column(name="fiyat")
    public double getFiyat() {
        return fiyat;
    }

    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }



    @Column(name="isnull",columnDefinition = "bit(1) default 0")
    public boolean isIsnull() {
        return isnull;
    }

    public void setIsnull(boolean isnull) {
        this.isnull = isnull;
    }



    @Column(name="hesapistekid")
    public Integer getHesapIstekId() {
        return hesapIstekId;
    }

    public void setHesapIstekId(Integer hesapIstekId) {
        this.hesapIstekId = hesapIstekId;
    }

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "hesap",cascade = CascadeType.ALL)

    public List<Siparis> getSiparis() {
        return siparis;
    }

    public void setSiparis(List<Siparis> siparis) {
        this.siparis = siparis;
    }
}
