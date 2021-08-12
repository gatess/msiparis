package com.mobilsiparis.hibernateclasses.siparisurun;

import com.mobilsiparis.hibernateclasses.Operations;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gokhan
 * Date: 13.12.2013
 * Time: 11:08
 * To change this template use File | Settings | File Templates.
 */
public interface SiparisUrunBo extends Operations {
    public Object findMaxId();
    public List<SiparisUrun> findBySiparisId(Integer siparisId);
}
