<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/main-header-style.css" rel="stylesheet">
<link href="css/navbar.css" rel="stylesheet">
</head>
<body>
	<c:url var="profilLink" value="ProfilServlet" />
	<div class="container-fluid">
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<!-- Titel und Schalter werden für eine bessere mobile Ansicht zusammengefasst -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
						aria-expanded="false">
						<span class="sr-only">Navigation ein-/ausblenden</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
				</div>
				<!-- Alle Navigationslinks, Formulare und anderer Inhalt werden hier zusammengefasst und können dann ein- und ausgeblendet werden -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li><a href="#">Impressum</a></li>
					</ul>
					<ul class="nav navbar-nav navbar-center">
						<li><a href="index.jsp"><strong>SNEAKERLOVE</strong></a>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="${profilLink}">Profil</a></li>
						<li><a href="login.jsp">Login</a></li>
						<li>
							<form action="LoginServlet" method="GET">
								<button type="submit" class="btn myBTN btn-danger">Logout</button>
							</form>
						</li>
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>
	</div>
</body>
</html>