package beans.advanced.editors;

import java.beans.PropertyEditorSupport;

import beans.advanced.beans.PhoneNumber;

public class PhoneEditor extends PropertyEditorSupport {
	@Override
	public String getAsText() {		
		PhoneNumber ph = (PhoneNumber)getValue();
		return ph.getAreaCode() + "-" + ph.getPrefix() + "- " + ph.getNumber();
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (text == null){
			throw new IllegalArgumentException("phone number is null");
		}else{
			String[] ar = text.split("-");
			if (ar.length != 3){
				throw new IllegalArgumentException("format required: areacode-prefix-number");				
			}else{
				PhoneNumber ph = new PhoneNumber();
				ph.setAreaCode(ar[0]);
				ph.setPrefix(ar[1]);
				ph.setNumber(ar[2]);
				setValue(ph);
			}
		}
	}

}
