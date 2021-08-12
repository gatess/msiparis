package com.mobilsiparis.hibernateclasses.hesapistek;

import com.mobilsiparis.configration.CustomHibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Serhat on 14.06.2014.
 */

@Repository("hesapIstekDaoImp")
@Transactional

public class HesapIstekDaoImp extends CustomHibernateDaoSupport implements HesapIstekDao {
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
        List liste = getHibernateTemplate().find("select hesapIstek from HesapIstek garsonIstek ");
        return liste;  //To change body of implemented methods use File | Settings | File Templates.
    }
    @Override
    public Object findMaxId() {
        List liste = getHibernateTemplate().find("select max(hesapIstekId) from HesapIstek ");
        return liste.get(0);}
}
