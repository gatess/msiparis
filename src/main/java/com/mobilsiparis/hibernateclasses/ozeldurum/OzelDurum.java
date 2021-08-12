package com.mobilsiparis.hibernateclasses.ozeldurum;

import com.mobilsiparis.hibernateclasses.urun.Urun;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Gokhan
 * Date: 08.12.2013
 * Time: 17:26
 * To change this template use File | Settings | File Templates.
 */
@Component
@Entity
@Table(name="ozeldurum")

public class OzelDurum  {

           @Id
           @GeneratedValue(strategy = GenerationType.AUTO)
            private Integer durumId;

    public Integer getDurumId() {
        return durumId;
    }

    public void setDurumId(Integer durumId) {
        this.durumId = durumId;
    }


    @Column(name="durumadi")
    private String durumAdi;

    public String getDurumAdi() {
        return durumAdi;
    }

    public void setDurumAdi(String durumAdi) {
        this.durumAdi = durumAdi;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "urun_id",nullable = false)
    private Urun urun;

    public Urun getUrun() {
        return urun;
    }

    public void setUrun(Urun urun) {
        this.urun = urun;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OzelDurum)) return false;

        OzelDurum ozelDurum = (OzelDurum) o;

        if (durumAdi != null ? !durumAdi.equals(ozelDurum.durumAdi) : ozelDurum.durumAdi != null) return false;
        if (!durumId.equals(ozelDurum.durumId)) return false;

        return true;
    }


}
