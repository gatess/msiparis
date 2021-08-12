package com.mobilsiparis.hibernateclasses.productvotes;

import com.mobilsiparis.configration.CustomHibernateDaoSupport;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gokhan
 * Date: 11.03.2014
 * Time: 15:49
 * To change this template use File | Settings | File Templates.
 */
@Repository("productvotesdaoımp")
@Transactional
public class ProductVotesDaoImp extends CustomHibernateDaoSupport implements ProductVotesDao  {
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
       return  getHibernateTemplate().find("select productVotes from ProductVotes productVotes");
    }
}
