<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<style>
.enabledClass{
background-color:blue;
}
.disabledClass{
background-color:grey;
}
</style>
<f:view>
	<h:form>
		<div>This UISelectItem just represents a select item - it does not display anything - it is usually used
		in a container like SelectOneRadio</div>
		<div>For a collection of SelectItem you should use f:selectItems
		where value can be SelectItem, a collection, an array, a map</div>
		
		<div>selectOneRadio</div>
		<h:selectOneRadio>
			<f:selectItem itemLabel="label1" itemValue="value1" itemDescription="desc1" />
			<f:selectItem itemLabel="label2" itemValue="value2" itemDescription="desc2" />
			<f:selectItem value="#{userForm.selectItem}"/>
			<f:selectItems value="#{userForm.selectItems}" />
		</h:selectOneRadio>
		<div>SelectOneListbox</div>
		<h:selectOneListbox>
			<f:selectItem itemLabel="label1" itemValue="value1" itemDescription="desc1" />
			<f:selectItem itemLabel="label2" itemValue="value2" itemDescription="desc2" />
			<f:selectItem value="#{userForm.selectItem}"/>
			<f:selectItems value="#{userForm.selectItems}" />
		</h:selectOneListbox>
		<div>selectOneMenu</div>
		<h:selectOneMenu>
			<f:selectItem itemLabel="label1" itemValue="value1" itemDescription="desc1" />
			<f:selectItem itemLabel="label2" itemValue="value2" itemDescription="desc2" />
			<f:selectItem value="#{userForm.selectItem}"/>
			<f:selectItems value="#{userForm.selectItems}" />
		</h:selectOneMenu>
		<div>selectManyCheckbox</div>
		<h:selectManyCheckbox layout="pageDirection" enabledClass="enabledClass" disabledClass="disabledClass">
			<f:selectItem itemLabel="label1" itemValue="value1" itemDescription="desc1" />
			<f:selectItem itemLabel="label2" itemValue="value2" itemDescription="desc2" />
			<f:selectItem value="#{userForm.selectItem}"/>
			<f:selectItems value="#{userForm.selectItems}" />
		</h:selectManyCheckbox>
		<div>selectManyListbox</div>
		<h:selectManyListbox>
			<f:selectItem itemLabel="label1" itemValue="value1" itemDescription="desc1" />
			<f:selectItem itemLabel="label2" itemValue="value2" itemDescription="desc2" />
			<f:selectItem value="#{userForm.selectItem}"/>
			<f:selectItems value="#{userForm.selectItems}" />
		</h:selectManyListbox>
		<div>selectManyMenu</div>
		<h:selectManyMenu>
			<f:selectItem itemLabel="label1" itemValue="value1" itemDescription="desc1" />
			<f:selectItem itemLabel="label2" itemValue="value2" itemDescription="desc2" />
			<f:selectItem value="#{userForm.selectItem}"/>
			<f:selectItems value="#{userForm.selectItems}" />
		</h:selectManyMenu>
		
		
	</h:form>

</f:view>