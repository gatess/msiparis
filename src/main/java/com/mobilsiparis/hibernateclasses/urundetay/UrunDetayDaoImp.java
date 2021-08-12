package com.mobilsiparis.hibernateclasses.urundetay;

import com.mobilsiparis.configration.CustomHibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gokhan
 * Date: 13.12.2013
 * Time: 11:02
 * To change this template use File | Settings | File Templates.
 */
@Repository("UrunDetayDaoImp")
@Transactional
public class UrunDetayDaoImp extends CustomHibernateDaoSupport implements UrunDetayDao {

    @Override
    public void save(Object object) throws Exception {
        getHibernateTemplate().save(object);
    }

    @Override
    public void update(Object object) throws Exception {
        getHibernateTemplate().update(object);
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void saveOrUpdate(Object object) throws Exception {
        getHibernateTemplate().saveOrUpdate(object);
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean delete(Object object) throws Exception {

        getHibernateTemplate().delete(object);
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List allValues() throws Exception {
        return getHibernateTemplate().find("select urunDetay from UrunDetay urunDetay");
    }
}
