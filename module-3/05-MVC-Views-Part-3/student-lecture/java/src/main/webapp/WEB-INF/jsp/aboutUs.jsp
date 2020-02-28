<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:url value="/css/site.css" var="cssURL" />
<link rel="stylesheet" type="text/css" href="${cssURL}">
<title>Solar System Geek</title>
</head>

<body>

<c:url value="/" var="homePageURL" />
<a href="${homePageURL}"> 
    <c:url value="/img/ssg_logo.png" var="logoURL" />
    <img src="${logoURL}" id="logo" />
</a>

<div id="content">

<c:url value="/aboutUs" var="aboutUsURL" />    
    <nav>
    		<ul>
    			<li><a href="${homePageURL}">Home</a></li>
    			<li><a href="${aboutUsURL}">About Us</a></li>
    			<li><a href="#">Another Link</a></li>
    		</ul>
    </nav>
    
    <h1>About Us</h1>

<p>
	Solar System Geek is an educational resource dedicated to learning about the Solar System! Pluto is not a planet!!!
</p>

</div> <%-- ends the content div --%>

<p class="copyright">Copyright &copy; Solar System Geek Inc 2015</p>

</body>

</html>