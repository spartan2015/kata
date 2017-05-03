package org.mseco.learning.jsf.api;

import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

public class SelectItemAPI {
	void api() {
		// you can associate SelectItems with a Map, array, List or Collection
		
		SelectItem si = new SelectItem();
		si.setLabel("");
		si.setValue("");
		si.setDescription("");
		si.setDisabled(false);
		/*
		 *  The value property requires a con-
verter so that the user's selection(s) can be translated to and from the proper type.
If you stick to standard Java data types, JSF will automatically use one of the stan-
dard converters. However, if you use your own class, you will need to write your
own converter (see chapter 12 for an example).
		 */
		
		SelectItemGroup sig = new SelectItemGroup();
		sig.setLabel("");
		sig.setValue("");
		sig.setDescription("");
		sig.setSelectItems(new SelectItem[0]);
		
		
	}
}
