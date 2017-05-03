<html>
<body>

<%
// Initialize an array with some data to display.

    Person[] people = new Person[]
        { new Person("Samantha Tippin", 9, "770-123-4567"),
          new Person("Kaitlyn Tippin", 6, "770-123-4567"),
          new Person("Edward Alexander", 3, "No phone"),
          new Person("Star Alexander", 12, "Phone off hook"),
          new Person("Norton Alexander", 12, "No phone")
        };

// Stick the array in the request where the servlet can get to it.
    request.setAttribute("people", people);
%>
<%-- Invoke the Table servlet, tell it the name of the attribute
     where the data is stored (data=people), set the border size to 4
     on the <table> tag, and describe each column to display --%>

<jsp:include page="/TableServlet" flush="true">
    <jsp:param name="data" value="people"/>

    <jsp:param name="tableOptions" value="BORDER=4"/>

    <jsp:param name="column" value="name"/>
    <jsp:param name="columnType" value="data"/>
    <jsp:param name="columnHeader" value="Name"/>

    <jsp:param name="column" value="age"/>
    <jsp:param name="columnType" value="data"/>
    <jsp:param name="columnHeader" value="Age"/>

    <jsp:param name="column" value="getPhoneNumber"/>
    <jsp:param name="columnType" value="data"/>
    <jsp:param name="columnHeader" value="Phone #"/>
</jsp:include>
</body>
</html>
<%!
// Define a class to contain information. This would normally not
// be defined within a JSP.
    public class Person
    {
        public String name;
        public int age;
        protected String phoneNumber;

        public Person(String aName, int anAge,
            String aPhoneNumber)
        {
            name = aName;
            age = anAge;
            phoneNumber = aPhoneNumber;
        }

// Just to show that methods work as well as fields, allow the
// phone number to be accessed only via a method call.
        public String getPhoneNumber()
        {
            return phoneNumber;
        }
    }
%>

