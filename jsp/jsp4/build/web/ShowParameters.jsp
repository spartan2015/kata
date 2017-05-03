<html>
<body>
You passed me the following parameters:
< pre>
<%

// Find out the names of all the parameters.
    java.util.Enumeration params = request.getParameterNames();

    while (params.hasMoreElements())
    {
// Get the next parameter name.
        String paramName = (String) params.nextElement();

// Use getParameterValues in case there are multiple values.
        String paramValues[] =
            request.getParameterValues(paramName);

// If there is only one value, print it out.
        if (paramValues.length == 1)
        {
            out.println(paramName+"="+paramValues[0]);
        }
        else
        {
// For multiple values, loop through them.
            out.print(paramName+"=");

            for (int i=0; i < paramValues.length; i++)
            {
// If this isn't the first value, print a comma to separate values.
                if (i > 0) out.print(',');

                out.print(paramValues[i]);
            }
            out.println();
        }
    }
%>
</pre>
</body>
</html>
