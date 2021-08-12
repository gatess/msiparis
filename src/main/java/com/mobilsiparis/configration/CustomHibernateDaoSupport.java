package com.mobilsiparis.configration;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Created with IntelliJ IDEA.
 * User: HP
 * Date: 16.12.2012
 * Time: 09:46
 * To change this template use File | Settings | File Templates.
 */
public abstract class CustomHibernateDaoSupport extends HibernateDaoSupport {
    @Autowired
    public void anyMethodName(SessionFactory sessionFactory)
    {
        setSessionFactory(sessionFactory);
    }
}
