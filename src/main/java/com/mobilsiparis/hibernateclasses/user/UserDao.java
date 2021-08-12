package com.mobilsiparis.hibernateclasses.user;

import com.mobilsiparis.hibernateclasses.Operations;

/**
 * Created by ishak on 10.07.2014.
 */
public interface UserDao extends Operations {
    public Object findByPassword(String password);
}
