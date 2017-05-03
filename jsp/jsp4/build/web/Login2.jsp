<%


String user = request.getParameter("username");
String pass = request.getParameter("password");


session.setAttribute("username",user);
session.setAttribute("password",pass);



%>
<form action="ColorChoose2" method="post">
    
<select multiple name="color">
    
    <optgroup label="Group Label">        
        <option value="Red">Red</option>
        <option value="Green">Green</option>
        <option value="Blue">Blue</option>
    </optgroup>
</select>

<br>


<input type="submit" name="choose_color" value="Choose Color">
    
</form>