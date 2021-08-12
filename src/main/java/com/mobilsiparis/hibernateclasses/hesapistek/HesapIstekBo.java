package com.mobilsiparis.hibernateclasses.hesapistek;

import com.mobilsiparis.hibernateclasses.Operations;

import java.util.List;

/**
 * Created by Serhat on 14.06.2014.
 */
public interface HesapIstekBo extends Operations {

    public Object findMaxId();
    List allValues() throws Exception;
}
