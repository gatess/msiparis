package com.mobilsiparis.hibernateclasses.garsonistek;

import com.mobilsiparis.hibernateclasses.Operations;

/**
 * Created with IntelliJ IDEA.
 * User: Gokhan
 * Date: 08.05.2014
 * Time: 22:09
 * To change this template use File | Settings | File Templates.
 */
public interface GarsonIstekDao extends Operations {
    public Object findMaxId();
}
