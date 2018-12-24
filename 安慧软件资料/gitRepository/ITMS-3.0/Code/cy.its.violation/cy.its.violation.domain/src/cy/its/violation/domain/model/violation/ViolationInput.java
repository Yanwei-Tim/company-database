package cy.its.violation.domain.model.violation;

import cy.its.com.domain.Value;

/**
 * Υ��¼������
 * 
 * @author STJ
 *
 */
public abstract class ViolationInput extends Value {

	abstract void ExcuteInput(Violation violation) throws Exception;
	
	public void Excute(Violation violation) throws Exception {
		ExcuteInput(violation);
		violation.unlockForInput();
	}
}
