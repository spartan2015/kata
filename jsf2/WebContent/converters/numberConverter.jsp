<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">    
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<f:view>
	<h:form>
		<div>no options</div>
		<h:inputText value="#{bean.doubleNumber}">
			<f:convertNumber />
		</h:inputText>
		
		<div  style="font-size:24px">type="number"</div>
		<h:inputText value="#{bean.doubleNumber}">
			<f:convertNumber type="number" />
		</h:inputText>		
		<div>type="number"</div>
		<h:inputText value="#{bean.doubleNumber}">
			<f:convertNumber type="number" />
		</h:inputText>	
		<div>type="number"  groupingUsed="true"</div>
		<h:inputText value="#{bean.doubleNumber}">
			<f:convertNumber type="number" groupingUsed="true"/>
		</h:inputText>
		
		<div>type="number"  groupingUsed="true" integerOnly="true"-specifies only integer will BE PARSED BACK to the sever</div>
		<h:inputText value="#{bean.doubleNumber}">
			<f:convertNumber type="number" groupingUsed="true" integerOnly="true"/>
		</h:inputText>
		
		<div>type="number"  minIntegerDigits="1" maxIntegerDigits="10" minFractionDigits="0" maxFractionDigits="0"  </div>
		<h:inputText value="#{bean.doubleNumber}">
			<f:convertNumber type="number" minIntegerDigits="1" maxIntegerDigits="10" minFractionDigits="0" maxFractionDigits="0"/>
		</h:inputText>
		
		
		<div>
		Decimal format patterns have two parts—a positive subpattern and a negative sub-
pattern—that are separated by a semicolon. The negative subpattern is optional;
if you leave it out, negative numbers will be displayed using the positive subpat-
tern, with the localized minus sign in front (“-” in most cases).
    Each subpattern consists of literal and special characters that specify the for-
matting for the number with an optional prefix and suffix. Some of the special
characters can only be used in the number portion of the subpattern; others can be
used in either the prefix or the suffix. These characters are summarized in table 6.10.
     Here are some examples that don’t have a prefix or suffix. The pattern
“###,###” for the number 40404 displays “40,404” in the U.S. locale. The pat-
tern “#,###” and “######,###” also display “40,404”, but “###, #####”,
“#,#####”, and “######,####” display “4,0404”—the grouping separa-
tor closest to the right always wins.
    For the number -40404, both “#,###” and “#,###;-#,###” display “-40,404”,
but the pattern “#,###;(#,###)” displays “(40,404)”. You use a “0” when you
want to display a specific number of digits—for example, for the number 99, the
pattern “0000” displays “0099”. The same pattern for the number 99999 displays
“9999”—note that last digit has been lopped off.
		
		</div>
		

		
		<div>pattern="#,###.###"</div>
		<h:inputText value="#{bean.doubleNumber}">
			<f:convertNumber type="number" pattern="#,###.###"/>
		</h:inputText>
		
		<div>pattern="#,###.###;(#,###.###)"</div>
		<h:inputText value="#{bean.doubleNumber}">
			<f:convertNumber type="number" pattern="#,###.###"/>
		</h:inputText>
		
		<div>pattern="000000"</div>
		<h:inputText value="#{bean.doubleNumber}">
			<f:convertNumber type="number" pattern="000000"/>
		</h:inputText>
		
		
		<div style="font-size:24px;">type="currency"</div>
		<h:inputText  value="#{bean.doubleNumber}">
			<f:convertNumber type="currency"/>
		</h:inputText>
		<div>type="currency" currencyCode="USD"</div>
		<h:inputText  value="#{bean.doubleNumber}">
			<f:convertNumber type="currency" currencyCode="USD"/>
		</h:inputText>
		<div>type="currency" currencyCode="ROL"</div>
		<h:inputText  value="#{bean.doubleNumber}">
			<f:convertNumber type="currency" currencyCode="ROL"/>
		</h:inputText>
		<div>type="currency" currencySymbol="$"</div>
		<h:inputText  value="#{bean.doubleNumber}">
			<f:convertNumber type="currency" currencySymbol="$"/>
		</h:inputText>
		<div>type="currency" currencyCode="USD" currencySymbol="$"</div>
		<h:inputText  value="#{bean.doubleNumber}">
			<f:convertNumber type="currency" currencyCode="USD" currencySymbol="$"/>
		</h:inputText>
		
		
				<div>
		     For the number 40404, the pattern “¤#,##0.00;(¤#,##0.00)” displays
“$40,404.00” in the United States. For -40404, it would display “($40,404.00)”. In
the U.K., “£40,404.00” and “-£40,404.00” would be displayed, respectively.
    You can also use the international currency symbol, which eliminates symbol
ambiguity (for example, “$” could mean U.S. dollars, but it could also mean Canadian
dollars or any currency in any other country uses has a dollar). The only difference
is that you use two currency symbols: “¤¤#,##0.00;(¤¤#, ##0.00)”. For the same
number, this would display USD40,404.00 for the United States, and CAD40,
404.00 for Canada.
		
		</div>
		<div>pattern="¤#,###.##"</div>
		<h:inputText value="#{bean.doubleNumber}">
			<f:convertNumber type="currency" pattern="¤#,###.##"/>
		</h:inputText>
		
		<div  style="font-size:24px;">type="percentage"</div>
		<h:inputText  value="#{bean.doubleNumber}">
			<f:convertNumber type="percent"/>
		</h:inputText>
		
		<div >type="percentage" pattern="#,###.00%"</div>
		<h:inputText  value="#{bean.doubleNumber}">
			<f:convertNumber type="percent" pattern="#,###.00%"/>
		</h:inputText>
		
		<h:commandButton ></h:commandButton>
	</h:form>	

</f:view>