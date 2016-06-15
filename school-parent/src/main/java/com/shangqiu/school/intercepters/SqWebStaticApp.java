package com.shangqiu.school.intercepters;


import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author qiaoran
 *
 */
@Component
public class SqWebStaticApp {


    @Value("${domain.fsever}")
    private String imgUrl;

    public SqWebStaticApp() {
    }

    @EventListener
     public void onApplicationEvent(ContextRefreshedEvent event) {

        if (event.getApplicationContext() instanceof WebApplicationContext) {
            ServletContext servletcontext  = ((WebApplicationContext)event.getApplicationContext()).getServletContext();
            servletcontext.setAttribute("fsever",imgUrl);
        }

    }
}
