package com.mobilsiparis.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created with IntelliJ IDEA.
 * User: Gokhan
 * Date: 04.03.2014
 * Time: 10:05
 * To change this template use File | Settings | File Templates.
 */
public class SessionCounterListener  implements HttpSessionListener {
    private static int totalActiveSessions;

    public static int getTotalActiveSessions() {
        return totalActiveSessions;
    }



    @Override
    public void sessionCreated(HttpSessionEvent arg0) {
        totalActiveSessions++;
        System.out.println("sessionCreated - add one session into counter");
        printCounter(arg0);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent arg0) {
        totalActiveSessions--;
        System.out.println("sessionDestroyed - deduct one session from counter");
        printCounter(arg0);
    }

    private void printCounter(HttpSessionEvent sessionEvent){

        HttpSession session = sessionEvent.getSession();

        ApplicationContext ctx =
                WebApplicationContextUtils.
                        getWebApplicationContext(session.getServletContext());

        CounterService counterService =
                (CounterService) ctx.getBean("counterService");

        counterService.printCounter(totalActiveSessions);
    }

}
