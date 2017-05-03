package internationalization;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumberFormatAndCurrency {
	
	public static void main(String[] args) {
		

		NumberFormat nf = NumberFormat.getInstance();
		NumberFormat nfc = NumberFormat.getCurrencyInstance();
		NumberFormat nfc_uk = NumberFormat.getCurrencyInstance(Locale.UK);
		
		System.out.println(nf.format(123.1235)); // IT ROUNDS ON 3 decimals
		System.out.println(nf.getMaximumFractionDigits());
		nf.setMaximumFractionDigits(5);
		System.out.println(nf.format(123.123456)); // rounds on 5 decimals
		
		System.out.println(nfc.format(123.12345)); // currency rounds on 2
		System.out.println(nfc.getMaximumFractionDigits());
		nfc.setMaximumFractionDigits(5);
		System.out.println(nfc.format(123.123456));
		
		
		System.out.println(nfc_uk.format(123.12345)); // currency rounds on 2
		System.out.println(nfc_uk.getMaximumFractionDigits());
		nfc_uk.setMaximumFractionDigits(5);
		System.out.println(nfc_uk.format(123.123456));
	
		
		try{
			System.out.println("Parsing:");
			Number n = nf.parse("123.123456");
			System.out.println(n.doubleValue());
			
			nf.setParseIntegerOnly(true);
			System.out.println(nf.parse("123.123456").doubleValue());
			
		}catch(ParseException pe){pe.printStackTrace();}
	}

}
