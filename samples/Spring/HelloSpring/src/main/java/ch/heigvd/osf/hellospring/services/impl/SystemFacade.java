/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.heigvd.osf.hellospring.services.impl;

import ch.heigvd.osf.hellospring.services.interfaces.IGreetingService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author oliechti
 */
public class SystemFacade {

    private Log log = LogFactory.getLog(IGreetingService.class);

    private IGreetingService greetingService;

    /**
     * Setter for the greetingService property. This is what makes dependengy
     * injection possible: the IoC container will call this method and pass
     * an instance of the bean defined in the XML configuratin file
     * @param greetingService a spring bean defined in the XML configuratinf ile
     */
    public void setGreetingService(IGreetingService greetingService) {
        this.greetingService = greetingService;
    }

    /**
     * This method will be called from the applicatin. It does not do much, except
     * for delegating processing to the wired beans (thank you dependency injection)
     */
    public void doStuff() {
        log.info("System facade invoked... delegating work to the wired greeting service");
        log.info("Wired greeting service says: " + greetingService.greet());
        log.info("System facade done with processing.");
    }

}
