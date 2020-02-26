<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>MVC Views Part 1 - Example: Hello, Internet!</title>
	</head>
	<body>
		<c:choose>
			<c:when test="${empty param.name}">
				<c:set var="localName" value="Adult Trent"/>
			</c:when>
			<c:otherwise>
				<c:set var="localName" value="${param.name}"/>
			</c:otherwise>
		</c:choose>
		<h1>Hello, ${localName}</h1>
	</body>
</html>