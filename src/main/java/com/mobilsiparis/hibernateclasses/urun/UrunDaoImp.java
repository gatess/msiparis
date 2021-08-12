package com.mobilsiparis.hibernateclasses.urun;

import com.mobilsiparis.configration.CustomHibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gokhan
 * Date: 13.12.2013
 * Time: 10:50
 * To change this template use File | Settings | File Templates.
 */
@Repository("UrunDaoImp")
@Transactional
public class UrunDaoImp extends CustomHibernateDaoSupport implements UrunDao {

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
        List list = getHibernateTemplate().find("select urun from Urun urun");
        return list;
          //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List findByKategoriId(Integer katId) {
        List list = getHibernateTemplate().find("select urun from Urun urun where urun.kategori.kategoriId = ?",katId);
        return list;
    }

    @Override
    public Object findById(Integer id) {
        List list = getHibernateTemplate().find("select urun from Urun urun where urun.urunId=?",id);
        return list.get(0);
    }
}
