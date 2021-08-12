package com.mobilsiparis.beans;

import com.mobilsiparis.hibernateclasses.specialmenu.SpecialMenu;
import com.mobilsiparis.hibernateclasses.specialmenu.SpecialMenuBo;
import com.mobilsiparis.hibernateclasses.urun.Urun;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gokhan
 * Date: 17.03.2014
 * Time: 08:49
 * To change this template use File | Settings | File Templates.
 */
@Component
@Scope("session")
public class SpecialMenuBean implements Serializable {

    private List<String> icerik = new ArrayList<String>();

    private List<SpecialMenu> specialMenuList= new ArrayList<SpecialMenu>();

    private List<Urun> urunList;

    @Autowired
    SpecialMenuBo specialMenuBo;

    @PostConstruct
    public void afterConstruct() throws  Exception{

      specialMenuList= specialMenuBo.allValues();

        for(int i=0;i<specialMenuList.size();i++){

          urunList =  specialMenuList.get(i).getUruns();
         List<String>  temp= new ArrayList<String>();
            for (int j=0;j<urunList.size();j++){

                    temp.add(urunList.get(j).getAdi());

            }
            icerik.add(StringUtils.join(temp,"+"));

        }

    }

    public List<String> getIcerik() {
        return icerik;
    }

    public void setIcerik(List<String> icerik) {
        this.icerik = icerik;
    }

    public List<SpecialMenu> getSpecialMenuList() {
        return specialMenuList;
    }

    public void setSpecialMenuList(List<SpecialMenu> specialMenuList) {
        this.specialMenuList = specialMenuList;
    }

    public List<Urun> getUrunList() {
        return urunList;
    }

    public void setUrunList(List<Urun> urunList) {
        this.urunList = urunList;
    }
}
