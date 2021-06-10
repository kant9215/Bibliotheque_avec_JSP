<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="bins.Biblio"%>
 <%@page import="bins.Livre"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bibliotheque</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>

	<h1>Bienvenue dans la bibliotheque de Babel</h1>
	<% Biblio biblio = (Biblio) request.getAttribute("bibliotheque"); 
	for (Livre livre : biblio.getLivres()) { %>
		
		<div class="livre">
			<p>Titre : <%=livre.getTitre() %></p>
			<p>Auteur : <%=livre.getAuteur() %></p>
			<p>Reference : <%=livre.getReference()%></p>
		</div>
	<% }%>
	<button><a href = "patate">Patate</a></button>
	

<form action="form" method="POST">
<h2>Ajout de livre dans ma bibliotheque</h2>
	<div>
	<label for="titre">Titre de votre livre :</label>
	<input type="text" id="titre" name="titre">
	</div>
	<div>
	<label for="auteur">Auteur de votre livre :</label>
	<input type="text" id="auteur" name="auteur">
	</div>
	<div>
	<label for="reference">Reference de votre livre :</label>
	<input type="text" id="reference" name="reference">
	</div>
	<button>Rajouter ce livre</button>
	</form>	
</body>
</html>