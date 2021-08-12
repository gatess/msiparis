package com.mobilsiparis.hibernateclasses.masa;

import com.mobilsiparis.configration.CustomHibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gokhan
 * Date: 15.12.2013
 * Time: 16:43
 * To change this template use File | Settings | File Templates.
 */
@Repository
@Transactional
public class MasaDaoImp extends CustomHibernateDaoSupport implements MasaDao {

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
        getHibernateTemplate().update(object);
    }

    @Override
    public boolean delete(Object object) throws Exception {
        getHibernateTemplate().delete(object);
        return true;
    }

    @Override
    public List allValues() throws Exception {

        List list = getHibernateTemplate().find("select masa from Masa masa");
        return list;
          //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Masa findMasa(int masaNo) {
        List liste = getHibernateTemplate().find("select masa from Masa masa where masaNo=?",masaNo);
        return (Masa)liste.get(0);
    }

    @Override
    public List bosMasalar() {
        List liste = getHibernateTemplate().find("select masa from Masa masa where masa.isfull=?",true);
        return liste;
    }
}
