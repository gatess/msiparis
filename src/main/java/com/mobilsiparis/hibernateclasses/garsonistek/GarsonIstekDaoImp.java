package com.mobilsiparis.hibernateclasses.garsonistek;

import com.mobilsiparis.configration.CustomHibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gokhan
 * Date: 08.05.2014
 * Time: 22:15
 * To change this template use File | Settings | File Templates.
 */
@Repository("garsonIstekDaoImp")
@Transactional
public class GarsonIstekDaoImp extends CustomHibernateDaoSupport implements GarsonIstekDao {
    @Override
    public void save(Object object) throws Exception {
           getHibernateTemplate().save(object);
    }

    @Override
    public void update(Object object) throws Exception {
       getHibernateTemplate().update(object);
    }

    @Override
    public void saveOrUpdate(Object object) throws Exception {
        getHibernateTemplate().saveOrUpdate(object);
    }

    @Override
    public boolean delete(Object object) throws Exception {
        getHibernateTemplate().delete(object);
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List allValues() throws Exception {
       List liste = getHibernateTemplate().find("select garsonIstek from GarsonIstek garsonIstek ");
        return liste;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Object findMaxId() {
        List liste = getHibernateTemplate().find("select max(istekId) from GarsonIstek ");
        return liste.get(0);
    }
}
