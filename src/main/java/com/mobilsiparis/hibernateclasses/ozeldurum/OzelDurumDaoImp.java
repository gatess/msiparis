package com.mobilsiparis.hibernateclasses.ozeldurum;

import com.mobilsiparis.configration.CustomHibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Gokhan
 * Date: 13.12.2013
 * Time: 10:44
 * To change this template use File | Settings | File Templates.
 */
@Repository("OzelDurumDaoImp")
@Transactional

public class OzelDurumDaoImp extends CustomHibernateDaoSupport implements OzelDurumDao {

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
    public List findByUrunId(Integer urunId) {
        List list= getHibernateTemplate().find("select ozelDurum from OzelDurum ozelDurum where ozelDurum.urun.id=?",urunId);
        return list;
    }

    @Override
    public Object findById(Integer id) {
        List list = getHibernateTemplate().find("select ozelDurum from OzelDurum ozelDurum where ozelDurum.id=?",id);
        Set set = new HashSet();
        return list.get(0);
    }

    @Override
    public Boolean ozelDurumKontrol(Integer urunId) {
        List list= getHibernateTemplate().find("select ozelDurum from OzelDurum ozelDurum where ozelDurum.urun.id=?",urunId);
        if(list.size()==0)
            return false;
        else
            return true;
    }
}
