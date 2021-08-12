package com.mobilsiparis.hibernateclasses.siparisurun;

import com.mobilsiparis.configration.CustomHibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gokhan
 * Date: 13.12.2013
 * Time: 11:08
 * To change this template use File | Settings | File Templates.
 */
@Repository("siparisUrunDaoImp")
@Transactional

public class SiparisUrunDaoImp extends CustomHibernateDaoSupport implements SiparisUrunDao {

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
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Object findMaxId() {
        List liste = getHibernateTemplate().find("select max(siparisUrunId) from SiparisUrun siparisurun  ");
        return liste.get(0);
    }

    @Override
    public List<SiparisUrun> findBySiparisId(Integer siparisId) {
        return getHibernateTemplate().find("select siparisUrun from  SiparisUrun  siparisUrun where siparisUrun.siparisId=?", siparisId);
    }
}
