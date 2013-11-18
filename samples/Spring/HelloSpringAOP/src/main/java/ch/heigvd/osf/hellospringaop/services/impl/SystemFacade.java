/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.heigvd.osf.hellospringaop.services.impl;

import ch.heigvd.osf.hellospringaop.services.interfaces.IGreetingService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author oliechti
 */
public class SystemFacade {

    private Log log = LogFactory.getLog(IGreetingService.class);

    private IGreetingService greetingService;

    public void setGreetingService(IGreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public void doStuff() {
        log.info("System facade invoked... delegating work to the wired greeting service");
        log.info("Wired greeting service says: " + greetingService.greet());
        log.info("System facade done with processing.");
    }

}
