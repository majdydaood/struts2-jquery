package ${package};

import ognl.OgnlRuntime;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import java.util.logging.Logger;


/**
 * To allow works Struts 2 with Google App Engine
 */
public class InitListener implements ServletContextListener {

    public InitListener() {
    }

    public void contextInitialized(ServletContextEvent sce) {
        OgnlRuntime.setSecurityManager(null);
    }

    public void contextDestroyed(ServletContextEvent sce) {
    }

}
