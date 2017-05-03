package java8.modifiers.cat;
import static java.util.Collections.*;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class StaticAndFinal {
	
	private int id;
	private String name;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// compiles	
	final static void someMethod(){ // useless but since override does not apply but compatible
		
	}
	
	@Override
	public String toString(){
		return ToStringBuilder.reflectionToString(this);		
		
		// StringBuilder does not override equals like String does
	}
	
	@Override 
	public boolean equals(Object other){
		//return EqualsBuilder.reflectionEquals(this, other, false);
		if (!(other instanceof StaticAndFinal)) return false;
		StaticAndFinal sfOther = (StaticAndFinal)other;
		
		return new EqualsBuilder().appendSuper(super.equals(other))
				.append(id, sfOther.id)
				.append(name, sfOther.name)
				.isEquals();
	}
}
