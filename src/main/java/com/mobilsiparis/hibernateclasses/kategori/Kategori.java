package com.mobilsiparis.hibernateclasses.kategori;

import com.mobilsiparis.hibernateclasses.urun.Urun;
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
 * Time: 17:21
 * To change this template use File | Settings | File Templates.
 */

@Component
@Entity
@Table(name = "kategori")
public class Kategori  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer kategoriId;

    public Integer getKategoriId() {
        return kategoriId;
    }

    public void setKategoriId(Integer kategoriId) {
        this.kategoriId = kategoriId;
    }

    @Column(name = "kategoriadi")
    private String kategoriAdi;

    public String getKategoriAdi() {
        return kategoriAdi;
    }

    public void setKategoriAdi(String kategoriAdi) {
        this.kategoriAdi = kategoriAdi;
    }

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "kategori",cascade = CascadeType.ALL)
    private List<Urun> uruns= new ArrayList<Urun>();

    public List<Urun> getUruns() {
        return uruns;
    }

    public void setUruns(List<Urun> uruns) {
        this.uruns = uruns;
    }
}