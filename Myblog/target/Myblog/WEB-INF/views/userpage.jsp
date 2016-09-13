<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href="my-style.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<%@ include file='inlineheader.jsp'%>
<!--  ========= Body ========= -->

<sec:authentication property="principal.email" />
<h1>USER PRODUCT PAGE</h1>
	<!--  ========= Table to populate data ======= -->
	<center>
		<div class="container">
			<table>
				<table id="myTable" class="table table-striped">
					<thead>
						<tr>
							<th>Serial No</th>
							<th>Name</th>
							<th>Category</th>
							<th>Price</th>
							
							<th>Status</th>
							<th>Description</th>
							<th>Details</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listfromtable}" var="element">
							<tr>
								<td>${element.userId}</td>

								<td>${element.name}</td>

								<td>${element.email}</td>

								
								
								

							</tr>
						</c:forEach>
					</tbody>
				</table>
				</div>
				</center>
  </body>
</html>