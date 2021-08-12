package com.mobilsiparis.configration;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import javax.faces.context.FacesContext;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: HP
 * Date: 16.12.2012
 * Time: 09:39
 * To change this template use File | Settings | File Templates.
 */
public class ViewScope implements Scope {
    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        if (FacesContext.getCurrentInstance().getViewRoot() != null) {
            Map<String, Object> viewMap = FacesContext.getCurrentInstance().getViewRoot().getViewMap();
            if (viewMap.containsKey(name)) {
                return viewMap.get(name);
            } else {
                Object object = objectFactory.getObject();
                viewMap.put(name, object);
                return object;
            }
        } else {
            return null;
        }
    }

    @Override
    public Object remove(String name) {
        if (FacesContext.getCurrentInstance().getViewRoot() != null) {
            return FacesContext.getCurrentInstance().getViewRoot().getViewMap().remove(name);
        } else {
            return null;
        }
    }

    @Override
    public void registerDestructionCallback(String name, Runnable runnable) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Object resolveContextualObject(String name) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getConversationId() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
