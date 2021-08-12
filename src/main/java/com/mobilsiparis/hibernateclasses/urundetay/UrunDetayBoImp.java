package com.mobilsiparis.hibernateclasses.urundetay;

import com.mobilsiparis.hibernateclasses.urun.UrunDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gokhan
 * Date: 13.12.2013
 * Time: 11:02
 * To change this template use File | Settings | File Templates.
 */
@Component
public class UrunDetayBoImp implements UrunDetayBo {


    @Autowired
    UrunDetayDao urunDetayDaoDao;


    @Override
    public void save(Object object) throws Exception {
        urunDetayDaoDao.save(object);
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void update(Object object) throws Exception {

        urunDetayDaoDao.update(object);
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void saveOrUpdate(Object object) throws Exception {
        urunDetayDaoDao.saveOrUpdate(object);
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean delete(Object object) throws Exception {
        urunDetayDaoDao.delete(object);
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List allValues() throws Exception {
        return urunDetayDaoDao.allValues();
    }
}
