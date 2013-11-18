/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.osf.hellospringaop.system;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 *
 * @author oliechti
 */
@Aspect
public class SystemPointCuts {

  @Pointcut("execution(* ch..*.*(..))")
  public void allMethods() {}

  @Pointcut("execution(* *create(..))")
  public void createMethods() {}

  @Pointcut("execution(* update*(..))")
  public void updateMethods() {}

  @Pointcut("execution(* delete*(..))")
  public void deleteMethods() {}

  @Pointcut("createMethods() && updateMethods() && deleteMethods()")
  public void allCRUDMethods() {}

}
