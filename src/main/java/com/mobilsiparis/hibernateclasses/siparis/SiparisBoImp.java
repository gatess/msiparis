package com.mobilsiparis.hibernateclasses.siparis;

import com.mobilsiparis.hibernateclasses.hesap.Hesap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gokhan
 * Date: 13.12.2013
 * Time: 10:57
 * To change this template use File | Settings | File Templates.
 */
@Component
public class SiparisBoImp implements SiparisBo {

    @Autowired
    SiparisDao siparisDao;
    @Override
    public void save(Object object) throws Exception {
       siparisDao.save(object);
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void update(Object object) throws Exception {

        siparisDao.update(object);
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void saveOrUpdate(Object object) throws Exception {
        siparisDao.saveOrUpdate(object);
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean delete(Object object) throws Exception {
        siparisDao.delete(object);
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List allValues() throws Exception {
       return siparisDao.allValues();
    }

    @Override
    public Object findMaxId() {
        return siparisDao.findMaxId();
    }

    @Override
    public List<Siparis> findByHesapNo(Hesap hesap){return siparisDao.findByHesapNo(hesap);}
}
