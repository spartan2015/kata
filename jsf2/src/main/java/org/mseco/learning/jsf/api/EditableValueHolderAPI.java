package org.mseco.learning.jsf.api;

import javax.faces.application.Application;
import javax.faces.component.EditableValueHolder;
import javax.faces.context.FacesContext;
import javax.faces.el.MethodBinding;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;
import javax.faces.validator.LongRangeValidator;
import javax.faces.validator.Validator;

public class EditableValueHolderAPI {
	void api(){
		
		FacesContext ctx = FacesContext.getCurrentInstance();
		Application app = ctx.getApplication();
		
		EditableValueHolder evh = null;
		
		evh.addValidator(app.createValidator(LongRangeValidator.VALIDATOR_ID));
		evh.removeValidator(app.createValidator(LongRangeValidator.VALIDATOR_ID));
		Validator[] v = evh.getValidators();
		
		MethodBinding mb = evh.getValidator();
		
		evh.isRequired();
		evh.setRequired(true);
		
		evh.addValueChangeListener(new ValueChangeListener(){
			public void processValueChange(ValueChangeEvent event){
				
			}
		});
		ValueChangeListener[] vcl = evh.getValueChangeListeners();
		evh.removeValueChangeListener(null);
		
		MethodBinding mb1 = evh.getValueChangeListener();
		evh.setValueChangeListener(app.createMethodBinding("#{some.bean.method}", null));
		
		// check if the components value is valid: is must pass all converters and validators
		evh.isValid();
		
		/*
		 *    EditableValueHolders also have an immediate property, which forces conver-
sion and validation to take place during the Apply Request Values phase:
              You may want to set it to true if you need to access the value of a component even 
        if validation of other controls in the same form fails.
		 */
		evh.isImmediate();
		evh.setImmediate(true);
		
	}
}
