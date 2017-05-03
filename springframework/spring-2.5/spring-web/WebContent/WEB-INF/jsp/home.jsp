<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type='text/javascript'
        src='dwr/engine.js'></script>
<script type='text/javascript'
    src='dwr/util.js'></script>
        
<script type='text/javascript'
        src='dwr/interface/Traffic.js'></script>

   


<script type="text/javascript">
function criteriaChanged() {	  
	  var zipCode = document.forms.item(0).zip.value;	  	  
	  Traffic.getTrafficInfo(zipCode,updateTable);  
	}


function updateTable(results) {		
	  DWRUtil.removeAllRows("trafficTable");
	  DWRUtil.addRows("trafficTable", results, cellFuncs);
	}
/*
The final parameter to addRows() is a bit peculiar and demands some explana-
tion. addRows() will add one row to the table for each TrafficInfo it finds in the
results array. But how will it know how to populate each column in the table?
That’s where the cellFuncs array comes in:
*/	
   var cellFuncs = [
      function(data) { return data.name; },
      function(data) { return data.location; }
   ];

</script>
</head>
<body>
home man

<form id="trafficForm">
<input type="text" name="zip" maxlength="5"
    onkeyup="criteriaChanged();"/>
</form>     


<table width="100%" border="1" style="font-size:8pt;">
  <thead>
    <tr><td width="100">Name</td><td>Location</td></tr>
  </thead>
  <tbody id="trafficTable"></tbody>
</table>

</body>
</html>