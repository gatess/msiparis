package com.mobilsiparis.hibernateclasses.hesap;

import com.mobilsiparis.hibernateclasses.Operations;

import java.util.List;

/**
 * Created by Serhat on 14.06.2014.
 */
public interface HesapDao extends Operations {
public Object findByMasaNo(int masaNo);
}
