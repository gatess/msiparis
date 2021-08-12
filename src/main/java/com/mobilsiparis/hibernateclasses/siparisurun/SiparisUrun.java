package com.mobilsiparis.hibernateclasses.siparisurun;



import com.mobilsiparis.hibernateclasses.siparis.Siparis;
import com.mobilsiparis.hibernateclasses.urun.Urun;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Gokhan
 * Date: 11.12.2013
 * Time: 23:39
 * To change this template use File | Settings | File Templates.
 */
@Component
@Entity
@Table(name = "siparis_urun")

public class SiparisUrun implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer siparisUrunId;

    public Integer getSiparisUrunId() {
        return siparisUrunId;
    }

    public void setSiparisUrunId(Integer siparisUrunId) {
        siparisUrunId = siparisUrunId;
    }

    @Column(name = "siparis_id")
    private Integer siparisId;

    public Integer getSiparisId() {
        return siparisId;
    }

    public void setSiparisId(Integer siparisId) {
        this.siparisId = siparisId;
    }

    @Column(name="urun_id")
    private Integer urunId;

    public Integer getUrunId() {
        return urunId;
    }

    public void setUrunId(Integer urunId) {
        this.urunId = urunId;
    }

     @Column(name="ozeldurum_id")
     private Integer ozelDurumId;
    public Integer getOzelDurumId() {
        return ozelDurumId;
    }

    public void setOzelDurumId(Integer ozelDurumId) {
        this.ozelDurumId = ozelDurumId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SiparisUrun)) return false;

        SiparisUrun that = (SiparisUrun) o;

        if (ozelDurumId != null ? !ozelDurumId.equals(that.ozelDurumId) : that.ozelDurumId != null) return false;
        if (siparisId != null ? !siparisId.equals(that.siparisId) : that.siparisId != null) return false;
        if (!siparisUrunId.equals(that.siparisUrunId)) return false;
        if (urunId != null ? !urunId.equals(that.urunId) : that.urunId != null) return false;

        return true;
    }


}
