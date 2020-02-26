<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Example</title>
</head>
<body>

<c:forEach begin="1" end="100" var="counter">
	<c:set var="displayValue" value="${101 - counter}"/>
	<div>
	${displayValue}
	<c:if test="${displayValue % 2 == 0}">- Even!</c:if>
	<c:if test="${displayValue % 2 != 0}">- Odd!</c:if>
	</div>
</c:forEach>

</body>
</html>