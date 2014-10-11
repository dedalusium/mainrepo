/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mowitnow.model;

import java.util.EventObject;

/**
 *
 * @author isen
 */
public class ModelChangedEvent extends EventObject{

 

    public ModelChangedEvent(Object source) {
        super(source);
    }

   
}
