package com.mobilsiparis.beans;

import com.mobilsiparis.hibernateclasses.masa.Masa;
import com.mobilsiparis.hibernateclasses.masa.MasaBo;
import com.mobilsiparis.hibernateclasses.urun.Urun;
import com.mobilsiparis.hibernateclasses.urun.UrunBo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.context.FacesContext;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Gokhan
 * Date: 15.12.2013
 * Time: 18:29
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    @Autowired
   MasaBo masaBo;
    @Autowired
     Masa masa;
    public void masalariBosalt()throws Exception{

        for(int i=1;i<4;i++){

            masa= (Masa)masaBo.findMasa(i);
            masa.setIsfull(false);
            masaBo.update(masa);
        }

    }
    public static void main(String[] args) {
        try {
           /* MenuBean menuBean = new MenuBean();
            //System.out.println(menuBean.getUrunler().get(1));
              Main main = new Main();
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            //get current date time with Date()
            Date date = new Date();
            System.out.println(dateFormat.format(date));

            //get current date time with Calendar()
            Calendar cal = Calendar.getInstance();
            System.out.println(dateFormat.format(cal.getTime()));*/

            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

        }
        catch (Exception e){
                    e.printStackTrace();
        }

    }
}
