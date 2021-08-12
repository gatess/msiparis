package com.mobilsiparis.hibernateclasses.siparisurun;

import com.mobilsiparis.hibernateclasses.siparis.SiparisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gokhan
 * Date: 13.12.2013
 * Time: 11:08
 * To change this template use File | Settings | File Templates.
 */
@Component
public class SiparisUrunBoImp implements SiparisUrunBo {
    @Autowired
    SiparisUrunDao siparisUrunDao;


    @Override
    public void save(Object object) throws Exception {
        siparisUrunDao.save(object);
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void update(Object object) throws Exception {

        siparisUrunDao.update(object);
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void saveOrUpdate(Object object) throws Exception {
        siparisUrunDao.saveOrUpdate(object);
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean delete(Object object) throws Exception {
        siparisUrunDao.delete(object);
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List allValues() throws Exception {
        return siparisUrunDao.allValues();
    }

    @Override
    public Object findMaxId() {
      return  siparisUrunDao.findMaxId();
    }

    @Override
    public List<SiparisUrun> findBySiparisId(Integer siparisId) {
        return siparisUrunDao.findBySiparisId(siparisId);
    }
}
