<%@page import="java.text.*, java.util.*, servlets.*" %>
<html>
<body>
<h1>Current JSP/Servlet Times</h1>
<table border="4">
<tr>
<th>URL</th><th>Total Requests</th><th># Pending</th>
<th>Weighted Average Time (mSec.)</th><th>Average Time</th>
</tr>
<%
    Times[] times = TimingFilter.getTimes();
    DecimalFormat formatter = new DecimalFormat("00.00");

    for ( int i = 0; i < times.length ; ++i ) {
       out.println("<tr>");
       out.println("<td>" + times[i].timerName + "</td>");
       out.println("<td>" + times[i].numAccesses + "</td>");
       out.println("<td>" + times[i].numPending + "</td>");
       out.println("<td>" + formatter.format(times[i].weightedAverage) + "</td>");
       out.println("<td>" + formatter.format(times[i].totalTime) + "</td>");
       out.println("</tr>");
        }

%>
</table>
</body>
</html>
