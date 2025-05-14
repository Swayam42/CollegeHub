<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Form</title>
</head>
<body>
    <h2>Enter User Details</h2>
    <form action="/user" method="post">
        Name: <input type="text" name="name"/><br/><br/>
        Email: <input type="email" name="email"/><br/><br/>
        <input type="submit" value="Submit"/>
    </form>
</body>
</html>
