package com.mobilsiparis.hibernateclasses.garsonistek;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Gokhan
 * Date: 08.05.2014
 * Time: 21:54
 * To change this template use File | Settings | File Templates.
 */
@Component
@Entity
@Table(name = "garsonistek")
public class GarsonIstek implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer istekId;

    public Integer getIstekId() {
        return istekId;
    }

    public void setIstekId(Integer istekId) {
        this.istekId = istekId;
    }

    @Column(name="masano")
    private Integer masaNo;

    public Integer getMasaNo() {
        return masaNo;
    }

    public void setMasaNo(Integer masaNo) {
        this.masaNo = masaNo;
    }

    @Column(name="istektarihi")
    private Date istekTarihi;

    public Date getIstekTarihi() {
        return istekTarihi;
    }

    public void setIstekTarihi(Date istekTarihi) {
        this.istekTarihi = istekTarihi;
    }


}
