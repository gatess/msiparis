package com.mobilsiparis.hibernateclasses.user;

import com.mobilsiparis.configration.CustomHibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ishak on 10.07.2014.
 */
@Repository("userDaoImp")
@Transactional
public class UserDaoImp extends CustomHibernateDaoSupport implements UserDao {
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
        List list = getHibernateTemplate().find("select user from User user");
        return list;
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Object findByPassword(String password) {

        return getHibernateTemplate().find("select user from User user where user.passWord=?",password).get(0);
    }
}