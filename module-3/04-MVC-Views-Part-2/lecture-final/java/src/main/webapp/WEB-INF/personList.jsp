<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Person List Example</title>
	</head>
	<body>
		<table>
		<c:forEach items="${persons}" var="person">
			<tr>
				<td>${person.firstName}</td>
				<td>${person.lastName}</td>
				<td>${person.age}</td>
				<td>${person.adult? "yes" : "no"}</td>
			</tr>
		</c:forEach>
		</table>
	</body>
</html>