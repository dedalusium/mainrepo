/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mowitnow.model;

import java.util.EventListener;

/**
 *
 * @author isen
 */
public interface ModelListener extends EventListener{
       void modelChanged(ModelChangedEvent e);
}
