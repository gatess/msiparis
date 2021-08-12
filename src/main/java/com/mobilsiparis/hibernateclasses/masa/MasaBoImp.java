package com.mobilsiparis.hibernateclasses.masa;

import com.mobilsiparis.hibernateclasses.kategori.KategoriDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gokhan
 * Date: 15.12.2013
 * Time: 16:43
 * To change this template use File | Settings | File Templates.
 */
@Component
public class MasaBoImp implements MasaBo {

    @Autowired
    private MasaDao masaDao;


    @Override
    public void save(Object object) throws Exception {
        masaDao.save(object);
    }

    @Override
    public void update(Object object) throws Exception {
        masaDao.update(object);
    }

    @Override
    public void saveOrUpdate(Object object) throws Exception {
        masaDao.saveOrUpdate(object);
    }

    @Override
    public boolean delete(Object object) throws Exception {
        masaDao.delete(object);
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List allValues() throws Exception {

      List list=  masaDao.allValues();

          return list;
    }

    @Override
    public Masa findMasa(int masaNo) {
       Masa masa= masaDao.findMasa(masaNo);
        return masa;
    }

    @Override
    public List bosMasalar() {
        return masaDao.bosMasalar();
    }
}
