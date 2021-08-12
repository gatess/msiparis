package com.mobilsiparis.beans;

import com.mobilsiparis.hibernateclasses.urundetay.UrunDetay;
import com.mobilsiparis.hibernateclasses.urundetay.UrunDetayBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gokhan
 * Date: 11.03.2014
 * Time: 09:26
 * To change this template use File | Settings | File Templates.
 */
@Component("productdetailbean")
@Scope("session")
public class ProductDetailBean implements Serializable {

    private List<UrunDetay> urunDetays;
    @Autowired
    UrunDetayBo urunDetayBo;

    @PostConstruct
    public void afterConstruct()throws Exception{
        urunDetays=urunDetayBo.allValues();
        System.out.println("deneme");
    }

    public List<UrunDetay> getUrunDetays() {
        return urunDetays;
    }

    public void setUrunDetays(List<UrunDetay> urunDetays) {
        this.urunDetays = urunDetays;
    }
}
