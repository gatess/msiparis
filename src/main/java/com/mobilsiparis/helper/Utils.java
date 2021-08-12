package com.mobilsiparis.helper;

import org.primefaces.context.RequestContext;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Created with IntelliJ IDEA.
 * User: Gokhan
 * Date: 08.05.2014
 * Time: 23:15
 * To change this template use File | Settings | File Templates.
 */
public class Utils {

    public static void executeJavascirpt(String script)
    {
        RequestContext context = RequestContext.getCurrentInstance();
        // context.addCallbackParam("saved", true);    //basic parameter
        // context.addCallbackParam("user", user);     //pojo as json

        //execute javascript oncomplete
        context.execute(script);
    }

    public static void showErrorMessage(String summary)
    {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, summary);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public static void showWarningMessage(String summary)
    {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, summary, summary);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public static void showInfoMessage(String summary)
    {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, summary);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public static void showErrorMessage(String summary, String detail)
    {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}
