package validators;

import org.apache.commons.lang.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import commands.CommandExample;

public class CommandExampleValidator implements Validator{

	public boolean supports(Class clazz) {
		
//		return clazz.isAssignableFrom(CommandExample.class);
//		return CommandExample.class.isAssignableFrom(clazz);
		return clazz.equals(CommandExample.class);	
	}

	public void validate(Object cmd, Errors errors) {
		CommandExample command = (CommandExample)cmd;
		if (StringUtils.isEmpty(command.getName())){
			errors.rejectValue("name","name.error.empty"); 
		}
		
		ValidationUtils.rejectIfEmpty(errors, "select", "select.error.emtpy");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.error.empty");
	}

}
