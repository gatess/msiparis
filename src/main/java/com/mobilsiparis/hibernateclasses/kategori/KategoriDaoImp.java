package com.mobilsiparis.hibernateclasses.kategori;

import com.mobilsiparis.configration.CustomHibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gokhan
 * Date: 09.12.2013
 * Time: 21:06
 * To change this template use File | Settings | File Templates.
 */
@Repository("kategoriDaoImp")
@Transactional
public class KategoriDaoImp extends CustomHibernateDaoSupport implements KategoriDao {
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
        List list = getHibernateTemplate().find("select kategori from Kategori kategori");
        return list;
          //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Kategori findById(Integer id) {
        List list= getHibernateTemplate().find("select kategori  from Kategori kategori where kategori.kategoriId=?",id);
        return (Kategori)list.get(0);
    }
}
