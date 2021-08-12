package com.mobilsiparis.hibernateclasses.siparis;

import com.mobilsiparis.configration.CustomHibernateDaoSupport;
import com.mobilsiparis.hibernateclasses.hesap.Hesap;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gokhan
 * Date: 13.12.2013
 * Time: 10:57S
 * To change this template use File | Settings | File Templates.
 */
@Repository("siparisDaoImp")
@Transactional
public class SiparisDaoImp extends CustomHibernateDaoSupport implements SiparisDao {
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
       return getHibernateTemplate().find("select  siparis from Siparis siparis");
    }

    @Override
    public Object findMaxId() {
        List liste = getHibernateTemplate().find("select max(siparisId) from Siparis ");
        return liste.get(0);
    }
    @Override
    public List<Siparis> findByHesapNo(Hesap hesap){
        List<Siparis> siparisList=getHibernateTemplate().find("select siparis from Siparis siparis where hesap=? ",hesap);
  return siparisList;  }
}
