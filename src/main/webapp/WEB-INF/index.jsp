<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css">
<meta charset="ISO-8859-1">
<title>LetsLearn!</title>
</head>
<body>
<div class="container">
<h1>Hello!
</h1>

</div>
<div class="container"><h2>Welcome to LetsLearn!</h2></div>
 <form class="login" method="post" action="/login">
        <div class="mb-3 row">
            <label for="email" class="form-label">Email</label>
            <input type="text" id="email" name="email"/>
        </div>
        <div class="mb-3 row">
        
            <label for="password" class="form-label">Password</label>
            <input type="password" id="password" name="password"/>
            </div>
        
        <button class="btn btn-success" type="submit">Log In!
        </button>
        
        
    </form>
</body>
</html>