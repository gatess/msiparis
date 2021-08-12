package com.mobilsiparis.converters;

import com.mobilsiparis.beans.SiparisBean;
import com.mobilsiparis.beans.SiparisDuzenleBean;

import com.mobilsiparis.hibernateclasses.ozeldurum.OzelDurum;
import com.mobilsiparis.hibernateclasses.ozeldurum.OzelDurumBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gokhan
 * Date: 03.02.2014
 * Time: 09:45
 * To change this template use File | Settings | File Templates.
 */
@Component
@FacesConverter( forClass = OzelDurum.class ,value = OneMenuConverter.CONVERTER_ID)
public class OneMenuConverter implements Converter {


    public static final String CONVERTER_ID= "onemenuconverter";


    SiparisBean siparisBean;
    SiparisDuzenleBean siparisDuzenleBean;
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uıComponent, String s) {
        //To change body of implemented methods use File | Settings | File Templates.
        siparisBean=(SiparisBean)facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(),null,"siparisbean");
        siparisDuzenleBean=(SiparisDuzenleBean)facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(),null,"siparisduzenlebean");
        List<OzelDurum> tempOzelDurums=siparisDuzenleBean.getOzelDurumlar();
        tempOzelDurums.add((OzelDurum)siparisBean.getOzelDurumBo().findById(Integer.parseInt(s)));
       // siparisDuzenleBean.get().add((OzelDurum)siparisBean.getOzelDurumBo().findById(Integer.parseInt(s)));
        return (OzelDurum)siparisBean.getOzelDurumBo().findById(Integer.parseInt(s));
      // return Integer.parseInt(s);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uıComponent, Object o) {
         //To change body of implemented methods use File | Settings | File Templates.
        if (o == null)
            return "";

        return String.valueOf (((OzelDurum)o).getDurumId());
    }
}
