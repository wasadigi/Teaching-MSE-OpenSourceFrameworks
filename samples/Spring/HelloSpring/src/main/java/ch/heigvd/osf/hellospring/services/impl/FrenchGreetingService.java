/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.heigvd.osf.hellospring.services.impl;

import ch.heigvd.osf.hellospring.services.interfaces.IGreetingService;

/**
 *
 * @author oliechti
 */
public class FrenchGreetingService implements IGreetingService {

    public String greet() {
        return "Un bean spring qui dit Bonjour!";
    }


}
