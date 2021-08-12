package com.mobilsiparis.hibernateclasses.urundetay;

import com.mobilsiparis.hibernateclasses.urun.Urun;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Gokhan
 * Date: 12.12.2013
 * Time: 22:18
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "urun_detay")
public class UrunDetay {

    private Urun urun;
    private Integer urunId;
    @GenericGenerator(name="generator",strategy = "foreign",
    parameters =@Parameter(name = "property",value = "urun"))
    @Id
    @GeneratedValue(generator = "generator")
    public Integer getUrunId() {
        return urunId;
    }

    public void setUrunId(Integer urunId) {
        this.urunId = urunId;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn

    public Urun getUrun() {
        return urun;
    }

    public void setUrun(Urun urun) {
        this.urun = urun;
    }

    @Column(name ="icindekiler")
    private String icindekiler;

    public String getIcindekiler() {
        return icindekiler;
    }

    public void setIcindekiler(String icindekiler) {
        this.icindekiler = icindekiler;
    }

    @Column(name="resim_adi")
    private String resimAdi;

    public String getResimAdi() {
        return resimAdi;
    }

    public void setResimAdi(String resimAdi) {
        this.resimAdi = resimAdi;
    }


}
