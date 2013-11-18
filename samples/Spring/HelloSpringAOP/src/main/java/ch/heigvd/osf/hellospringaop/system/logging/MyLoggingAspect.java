/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.osf.hellospringaop.system.logging;

import ch.heigvd.osf.hellospringaop.HelloSpringAOPApplication;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 *
 * @author oliechti
 */
@Aspect
public class MyLoggingAspect {

    private Log log = LogFactory.getLog(HelloSpringAOPApplication.class);

    @Before("ch.heigvd.osf.hellospringaop.system.SystemPointCuts.allMethods()")
    public void doLogOperation(JoinPoint joinPoint) {
        log.info("Just about to call a CRUD operation!!");
        log.info("joinPoint: " + joinPoint);
        log.info("joinPoint.getThis(): " + joinPoint.getThis());
        log.info("joinPoint.getTarget(): " + joinPoint.getTarget());
        log.info("joinPoint.getStaticPart(): " + joinPoint.getStaticPart());
        log.info("joinPoint.getSourceLocation(): " + joinPoint.getSourceLocation());
        log.info("joinPoint.getSignature(): " + joinPoint.getSignature().getName());

    }
}


