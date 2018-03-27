<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sneaker Shop</title>
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/main-header-style.css" rel="stylesheet">
<style>
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}
</style>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="container-fluid">
		<div class="jumbotron">
			<h1>Sneaker Shop!</h1>
			<p>Hier finden Sie die neuesten Sneaker und mehr!</p>
			<p>
				<a class="btn btn-primary btn-lg" href="#" role="button">Mehr
					erfahren</a>
			</p>
		</div>
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
						<li class="active"><a href="#">SneakerLove <span
								class="sr-only">(aktuell)</span></a></li>
						<li><a href="#">Shop</a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">Menü <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="#">Aktion</a></li>
								<li><a href="#">Andere Aktion</a></li>
								<li><a href="#">Irgendwas anderes</a></li>
								<li role="separator" class="divider"></li>
								<li><a href="#">Abgetrennter Link</a></li>
								<li role="separator" class="divider"></li>
								<li><a href="#">Noch ein abgetrennter Link</a></li>
							</ul></li>
					</ul>
					<form class="navbar-form navbar-right" role="search">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Suchen">
						</div>
						<button type="submit" class="btn btn-default">Los</button>
					</form>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>



		<div class="row">
			<div class="col-sm-6 col-md-2">
				<div class="panel panel-default">
					<div class="panel-heading">Panel-Überschrift ohne Titel</div>
					<div class="panel-body">Panel-Inhalt</div>
				</div>
			</div>
			
			<form action="WarenkorbServlet" method="GET">
			
			<c:forEach items="${SCHUHLISTE}" var="schuh">
			
			
			<input type="hidden" name="schuhid" value="${ schuh.schuhid }">

				<c:url var="warenkorbHinzuLink" value="WarenkorbServlet">
					<c:param name="command" value="HINZUFUEGEN_IN_WARENKORB" />
					<c:param name="schuhid" value="${ schuh.schuhid }" />
				
				</c:url>
			
			
				<div class="col-sm-6 col-md-2">
					<div class="thumbnail">
						<img src="img/platzhalter.png"
							alt="${schuh.marke} x ${schuh.marke}"
							title="${schuh.marke} x ${schuh.modell}">
						<div class="caption">
							<strong>${schuh.marke} x ${schuh.modell}</strong>
							<p>Preis: ${schuh.preis} EUR</p>
							<p>
								<a href="#" class="btn btn-right btn-default" role="button">Ansehen</a>
								<a href="#" class="btn btn-right btn-default" role="button">In den Warenkorb legen</a>
							</p>
						</div>
					</div>
				</div>
			</c:forEach>
			</form>
		</div>


		<footer><jsp:include page="footer.jsp"></jsp:include></footer>

	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>