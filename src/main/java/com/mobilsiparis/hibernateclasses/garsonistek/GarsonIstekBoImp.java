package com.mobilsiparis.hibernateclasses.garsonistek;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gokhan
 * Date: 08.05.2014
 * Time: 22:09
 * To change this template use File | Settings | File Templates.
 */
@Component
public class GarsonIstekBoImp implements GarsonIstekBo {
    @Autowired
    GarsonIstekDao garsonIstekDao;

    @Override
    public void save(Object object) throws Exception {
        garsonIstekDao.save(object);
    }

    @Override
    public void update(Object object) throws Exception {
        garsonIstekDao.update(object);
    }

    @Override
    public void saveOrUpdate(Object object) throws Exception {
        garsonIstekDao.saveOrUpdate(object);
    }

    @Override
    public boolean delete(Object object) throws Exception {
        garsonIstekDao.delete(object);
        return false;
    }

    @Override
    public List allValues() throws Exception {
     return   garsonIstekDao.allValues();
    }

    @Override
    public Object findMaxId() {
       return garsonIstekDao.findMaxId();
    }
}
