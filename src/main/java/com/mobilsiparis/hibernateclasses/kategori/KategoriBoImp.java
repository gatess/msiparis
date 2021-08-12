package com.mobilsiparis.hibernateclasses.kategori;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gokhan
 * Date: 09.12.2013
 * Time: 21:05
 * To change this template use File | Settings | File Templates.
 */
@Component
public class KategoriBoImp implements KategoriBo {

     @Autowired
     private KategoriDao kategoriDao;


    @Override
    public void save(Object object) throws Exception {
       kategoriDao.save(object);
    }

    @Override
    public void update(Object object) throws Exception {
       kategoriDao.update(object);
    }

    @Override
    public void saveOrUpdate(Object object) throws Exception {
        kategoriDao.saveOrUpdate(object);
    }

    @Override
    public boolean delete(Object object) throws Exception {
        kategoriDao.delete(object);
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List allValues() throws Exception {

       return kategoriDao.allValues();

    }

    @Override
    public Kategori findById(Integer id) {
      return  kategoriDao.findById(id);
       }
}
