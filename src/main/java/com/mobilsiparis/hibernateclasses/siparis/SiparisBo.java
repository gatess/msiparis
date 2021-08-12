package com.mobilsiparis.hibernateclasses.siparis;

import com.mobilsiparis.hibernateclasses.Operations;
import com.mobilsiparis.hibernateclasses.hesap.Hesap;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gokhan
 * Date: 13.12.2013
 * Time: 10:57
 * To change this template use File | Settings | File Templates.
 */
public interface SiparisBo extends Operations {
    public Object findMaxId();
    public List<Siparis> findByHesapNo(Hesap hesap);
}
