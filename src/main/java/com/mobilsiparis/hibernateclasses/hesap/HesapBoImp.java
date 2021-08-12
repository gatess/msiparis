package com.mobilsiparis.hibernateclasses.hesap;

import com.mobilsiparis.hibernateclasses.siparis.SiparisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Serhat on 14.06.2014.
 */
@Component
public class HesapBoImp implements HesapBo {

    @Autowired
    HesapDao hesapDao;
    @Override
    public void save(Object object) throws Exception {
        hesapDao.save(object);
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void update(Object object) throws Exception {

       hesapDao.update(object);
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void saveOrUpdate(Object object) throws Exception {
        hesapDao.saveOrUpdate(object);
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean delete(Object object) throws Exception {
        hesapDao.delete(object);
        return false;
    }

    @Override
    public List allValues() throws Exception {
        return   hesapDao.allValues();
    }

    @Override
    public Object findByMasaNo(int masaNo) {
       return hesapDao.findByMasaNo(masaNo);
    }
}




