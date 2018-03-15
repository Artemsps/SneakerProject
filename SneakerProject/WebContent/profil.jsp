<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Profil</title>
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/main-header-style.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col-md-5  toppad  pull-right col-md-offset-3 ">
				<A href="edit.html">Edit Profile</A> <A href="edit.html">Logout</A>
				<br>
			</div>
			<div
				class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad">


				<div class="panel panel-info">
					<div class="panel-heading">
						<h3 class="panel-title">${LOGIN_KUNDE.nutzername}</h3>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class=" col-md-9 col-lg-9 ">
								<table class="table table-user-information">
									<tbody>
										<tr>
											<td>Vorname:</td>
											<td>${LOGIN_KUNDE.vorname}</td>
										</tr>
										<tr>
											<td>Nachname:</td>
											<td>${LOGIN_KUNDE.nachname}</td>
										</tr>
										<tr>
											<td>Date of Birth</td>
											<td>${LOGIN_KUNDE.alter}</td>
										</tr>
										<tr>
										<tr>
											<td>Straﬂe</td>
											<td>Lorem Ipsum</td>
										</tr>
										<tr>
											<td>Hausnummer</td>
											<td>Lorem Ipsum</td>
										</tr>
										<tr>
											<td>PLZ und Stadt</td>
											<td>Lorem Ipsum</td>
										</tr>
										<tr>
											<td>Email</td>
											<td><a href="mailto:${LOGIN_KUNDE.email}">${LOGIN_KUNDE.email}</a></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<div class="panel-footer">
						<a data-original-title="Broadcast Message" data-toggle="tooltip"
							type="button" class="btn btn-sm btn-primary"><i
							class="glyphicon glyphicon-envelope"></i></a> <span
							class="pull-right"> <a href="edit.html"
							data-original-title="Edit this user" data-toggle="tooltip"
							type="button" class="btn btn-sm btn-warning"><i
								class="glyphicon glyphicon-edit"></i></a> <a
							data-original-title="Remove this user" data-toggle="tooltip"
							type="button" class="btn btn-sm btn-danger"><i
								class="glyphicon glyphicon-remove"></i></a>
						</span>
					</div>

				</div>
			</div>
		</div>
		</div>
</body>
</html>