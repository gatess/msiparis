package com.mobilsiparis.hibernateclasses.hesap;

import com.mobilsiparis.hibernateclasses.Operations;
import com.mobilsiparis.hibernateclasses.siparis.Siparis;

import java.util.List;

/**
 * Created by Serhat on 14.06.2014.
 */
public interface HesapBo extends Operations {

public Object findByMasaNo(int masaNo);


}
