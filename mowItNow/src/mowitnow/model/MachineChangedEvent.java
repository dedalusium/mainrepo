package mowitnow.model;

import java.util.EventObject;

/**
 * Evenement de changement
 * 
 * @author Nordwin
 *
 */
public class MachineChangedEvent extends EventObject {

	public MachineChangedEvent(Object source) {
		super(source);
	}

}
