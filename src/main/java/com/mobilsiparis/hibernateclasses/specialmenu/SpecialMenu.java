package com.mobilsiparis.hibernateclasses.specialmenu;

import com.mobilsiparis.hibernateclasses.urun.Urun;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@Entity
@Table(name = "special_menu" )
public class SpecialMenu {

    private List<Urun> uruns = new ArrayList<Urun>();
    private Integer menuId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    @Column(name = "menu_name")
    private String menuName;

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    @Column(name = "fiyati")
    private Double fiyat;

    public Double getFiyat() {

        return fiyat;
    }

    public void setFiyat(Double fiyat) {
        this.fiyat = fiyat;
    }


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "menu_product", catalog = "msiparis", joinColumns = {
            @JoinColumn(name = "menuId", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "urunId",
                    nullable = false, updatable = false) })
    public List<Urun> getUruns() {
        return uruns;
    }

    public void setUruns(List<Urun> uruns) {
        this.uruns = uruns;
    }
}