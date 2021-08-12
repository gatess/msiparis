package com.mobilsiparis.hibernateclasses.hesapistek;

import com.mobilsiparis.hibernateclasses.Operations;

/**
 * Created by Serhat on 14.06.2014.
 */
public interface HesapIstekDao extends Operations {
    public Object findMaxId();
}
