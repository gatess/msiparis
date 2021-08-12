package com.mobilsiparis.hibernateclasses.hesapistek;

import com.mobilsiparis.hibernateclasses.garsonistek.GarsonIstekDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Serhat on 14.06.2014.
 */
@Component
public class HesapIstekBoImp implements HesapIstekBo {

    @Autowired
    HesapIstekDao hesapIstekDao;

    @Override
    public void save(Object object) throws Exception {
        hesapIstekDao.save(object);
    }

    @Override
    public void update(Object object) throws Exception {
        hesapIstekDao.update(object);
    }

    @Override
    public void saveOrUpdate(Object object) throws Exception {
        hesapIstekDao.saveOrUpdate(object);
    }

    @Override
    public boolean delete(Object object) throws Exception {
        hesapIstekDao.delete(object);
        return false;
    }
    @Override
    public Object findMaxId() {
        return hesapIstekDao.findMaxId();
    }
    @Override
    public List allValues() throws Exception {
        return   hesapIstekDao.allValues();
    }
}
