<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Name List Example</title>
	</head>
	<body>
		<ol>
			<c:forEach items="${nameList}" var="name">
				<li>${name}</li>
			</c:forEach>
		</ol>
		
		<ol>
			<c:forEach var="index" begin="0" end="${nameList.size() - 1}">
			<li>${nameList[index]}</li>
			</c:forEach>
		</ol>
	</body>
</html>