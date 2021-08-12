package com.mobilsiparis.hibernateclasses.hesap;

import com.mobilsiparis.configration.CustomHibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Serhat on 14.06.2014.
 */
@Repository("hesapDaoImp")
@Transactional
public class HesapDaoImp extends CustomHibernateDaoSupport implements HesapDao {

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
        List liste= getHibernateTemplate().find("select hesap from Hesap hesap ");
        return liste;
    }


    @Override
    public Object findByMasaNo(int masaNo) {
        List liste = getHibernateTemplate().find("select hesap from Hesap hesap where hesap.masaNo=? and hesap.isnull=false ",masaNo);
        return (Hesap)liste.get(0);
    }
}
