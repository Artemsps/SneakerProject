<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="index.jsp"></jsp:include>
	<div class="container">
		<table class="table">
			<tr>
				<th>Vorname</th>
				<th>Nachname</th>
				<th>Email</th>
				<th>Nutzername</th>
				<th>Alter</th>
			</tr>
			<c:forEach items="${ KUNDENLISTE }" var="kunde">
				<tr>
					<td>${kunde.vorname}</td>
					<td>${kunde.nachname}</td>
					<td>${kunde.email}</td>
					<td>${kunde.nutzername}</td>
					<td>${kunde.alter}</td>
				</tr>
			</c:forEach>
		</table>
		<br />
		<hr />
		<br />
		<table class="table">
			<tr>
				<th>Modell</th>
				<th>Größe</th>
				<th>Anzahl</th>
				<th>Preis</th>
			</tr>
			<c:forEach items="${ SCHUHLISTE }" var="schuh">
				<tr>
					<td>${schuh.modell}</td>
					<td>${schuh.groesse}</td>
					<td>${schuh.anzahl}</td>
					<td>${schuh.preis}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>