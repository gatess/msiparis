package com.mobilsiparis.hibernateclasses.urun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gokhan
 * Date: 13.12.2013
 * Time: 10:50
 * To change this template use File | Settings | File Templates.
 */
@Component
public class UrunBoImp implements UrunBo {

    @Autowired
    UrunDao urunDao;


    @Override
    public void save(Object object) throws Exception {
        urunDao.save(object);
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void update(Object object) throws Exception {

        urunDao.update(object);
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void saveOrUpdate(Object object) throws Exception {
        urunDao.saveOrUpdate(object);
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean delete(Object object) throws Exception {
        urunDao.delete(object);
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List allValues() throws Exception {
        urunDao.allValues();
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List findByKategoriId(Integer katId) {
        List list = urunDao.findByKategoriId(katId);
        return list;
    }

    @Override
    public Object findById(Integer id) {
        return urunDao.findById(id);
    }
}
