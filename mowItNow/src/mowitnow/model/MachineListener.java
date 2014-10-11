package mowitnow.model;

import java.util.EventListener;

/**
 * listener de machine
 * 
 * @author Nordwin
 *
 */
public interface MachineListener extends EventListener {
	void modelChanged(MachineChangedEvent e);
}
