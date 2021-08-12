package com.mobilsiparis.hibernateclasses.hesapistek;

import com.mobilsiparis.hibernateclasses.hesap.Hesap;
import org.hibernate.annotations.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Serhat on 14.06.2014.
 */



@Component
@Entity
@Table(name="hesapistek")
public class HesapIstek {

    private Integer hesapIstekId;
    private Integer hesapId;
    private Date tarih;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getHesapIstekId() {
        return hesapIstekId;
    }

    public void setHesapIstekId(Integer hesapIstekId) {
        this.hesapIstekId = hesapIstekId;
    }
    @Column(name="hesapId",nullable = false)


    public Integer getHesapId(){return this.hesapId;}
    public void setHesapId(Integer hesapId) {
        this.hesapId = hesapId;
    }

    @Column(name="Tarih")

    public Date getTarih() {
        return tarih;
    }

    public void setTarih(Date tarih) {
        this.tarih = tarih;
    }
}
