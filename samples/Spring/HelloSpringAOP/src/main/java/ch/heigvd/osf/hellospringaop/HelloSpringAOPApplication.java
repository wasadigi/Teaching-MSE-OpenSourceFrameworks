package ch.heigvd.osf.hellospringaop;

import ch.heigvd.osf.hellospringaop.services.impl.SystemFacade;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * This simple application illustrates the basic use of the Spring IoC
 * container. The application instantiates one container and specifies the
 * location of its XML configuration file. In this file, 3 beans are defined.
 * The first bean, named "mySystem", needs one implementation of the IGreetingService
 * interface to work. The implementation is injected by the IoC container, based
 * on the XML configuration file.
 *
 */
public class HelloSpringAOPApplication {


    private Log log = LogFactory.getLog(HelloSpringAOPApplication.class);

    public void startApplication() {
        log.info("Starting HelloSpringAOP application... Welcome!");
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"my-spring-configuration.xml"});

        log.info("Getting a reference to the 'mySystem' bean (facade)");
        SystemFacade facade = (SystemFacade)context.getBean("mySystem");
        log.info("Invoking doStuff method on the facade; processing will be delegated to wired IGreetingService bean");
        facade.doStuff();

        log.info("Done.");
    }

    public static void main(String[] args) {
        new HelloSpringAOPApplication().startApplication();
    }
}
