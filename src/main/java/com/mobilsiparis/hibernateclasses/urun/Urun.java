package com.mobilsiparis.hibernateclasses.urun;

import com.mobilsiparis.hibernateclasses.kategori.Kategori;
import com.mobilsiparis.hibernateclasses.ozeldurum.OzelDurum;
import com.mobilsiparis.hibernateclasses.siparisurun.SiparisUrun;
//import com.mobilsiparis.hibernateclasses.specialmenu.SpecialMenu;
import com.mobilsiparis.hibernateclasses.specialmenu.SpecialMenu;
import com.mobilsiparis.hibernateclasses.urundetay.UrunDetay;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Gokhan
 * Date: 08.12.2013
 * Time: 16:58
 * To change this template use File | Settings | File Templates.
 */
@Component
@Entity
@Table(name = "urun")
public class Urun  {

   private Set<SpecialMenu> specialMenus = new HashSet<SpecialMenu>();

    private UrunDetay urunDetay;
    private Integer urunId;
    private Kategori kategori;
    private Set<OzelDurum> ozelDurums= new HashSet<OzelDurum>(0);
    private String adi;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getUrunId() {
        return urunId;
    }

    public void setUrunId(Integer urunId) {
        this.urunId = urunId;
    }

    @Column(name = "urunadi")
    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }


    @Column(name = "fiyat")
    private double fiyat;

    public double getFiyat() {
        return fiyat;
    }

    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }
    @Column(name="stok",columnDefinition = "bit(1) default 1")
    private boolean stok;

    public boolean isStok() {
        return stok;
    }

    public void setStok(boolean stok) {
        this.stok = stok;
    }

    @ManyToOne(fetch = FetchType.EAGER)
     @JoinColumn(name = "kategori_id")
    public Kategori getKategori() {
        return kategori;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }

    @OneToMany(fetch=FetchType.EAGER,mappedBy = "urun")
    public Set<OzelDurum> getOzelDurums() {
        return ozelDurums;
    }

    public void setOzelDurums(Set<OzelDurum> ozelDurums) {
        this.ozelDurums = ozelDurums;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Urun)) return false;

        Urun urun = (Urun) o;

        if (adi != null ? !adi.equals(urun.adi) : urun.adi != null) return false;
        if (!urunId.equals(urun.urunId)) return false;

        return true;
    }




   @ManyToMany(fetch = FetchType.EAGER, mappedBy = "uruns")
    public Set<SpecialMenu> getSpecialMenus() {
        return specialMenus;
    }

    public void setSpecialMenus(Set<SpecialMenu> specialMenus) {
        this.specialMenus = specialMenus;
    }

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "urun", cascade = CascadeType.ALL)
    public UrunDetay getUrunDetay() {
        return urunDetay;
    }

    public void setUrunDetay(UrunDetay urunDetay) {
        this.urunDetay = urunDetay;
    }
}
