/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.heigvd.osf.hellospringaop.services.impl;

import ch.heigvd.osf.hellospringaop.services.interfaces.IGreetingService;

/**
 *
 * @author oliechti
 */
public class JapaneseGreetingService implements IGreetingService {

    public String greet() {
        return "Spring bean ha konnichi ha to iiumasu";
    }


}
