<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bins.Livre"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bibliotheque</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body id="bibliotheque">

	<%-- <!-- utilisation jstl -->
	<h2><c:out value="Hello you"/></h2>
	
	<c:set var="maVar" value ="value"/>	
	<p><c:out value="${maVar}"/></p>
	
	<% String maVar2="test"; %>
	<p><%=maVar2%></p>
	
	<c:if test="${15 < 50}">
		<h2>test validé</h2>
	</c:if> --%>
	
	<c:choose>
		<c:when test="${11<2 }">un</c:when>
		<c:when test="${1<2 }">deux</c:when>
		<c:when test="${1<2 }">trois</c:when>
		<c:otherwise>huit</c:otherwise>
	</c:choose>
		
	<h1>Bienvenue dans la bibliotheque de Babel</h1>
	<!-- affichage des livres -->
	<c:forEach var="livre" items='${bibliotheque}'>
		
	<div class="livre">
		<p>
			Titre :${livre.titre}
		</p>
		<p>
			Auteur :${livre.auteur}
		</p>
		<p>
			Reference :${livre.reference}
		</p>
		<a href="bibliotheque?action=delete&reference=${livre.getReference()}">Supprimer ce livre</a>
		<a href="bibliotheque?action=modif&reference=${livre.getReference()}">Modifier ce livre</a>
	</div>
	</c:forEach>
	<a  href="patate"><button>
		J'm'en fous de lire, je veux des patates
	</button>
	</a>


	<form action='bibliotheque?to=${modifLivre != null ? "mod":"add"}' method="POST">	<!-- action = servlet appelé par  -->
	
		<h2>${modifLivre != null? "Modifier ce livre":"Ajout de livre dans ma bibliotheque"}</h2>
		<div>
			<label for="titre">Titre de votre livre :</label> 
			<input type="text" id="titre" name="titre" value='${modifLivre != null? modifLivre.titre :"" }'>
		</div>
		<div>	
			<label for="auteur">Auteur de votre livre :</label> 	
			<input type="text" id="auteur" name="auteur" value='${modifLivre != null? modifLivre.getAuteur() :""}'>
		</div>
		<div>
			<label for="reference">Reference de votre livre :</label> 
			<input type="text" id="reference" name="reference" value='${modifLivre != null? modifLivre.reference:"" }'${modifLivre != null? "disabled":""}>
			<c:if test="${modifLivre != null}">
			<input type="hidden" name="reference" value='${ modifLivre.reference }'> <!-- // car quand disabled on envoi pas la reference donc faut lenvoyer ici -->
			</c:if>
		</div>
		<button type="submit">${modifLivre != null ? "Modifier le livre": "Rajouter ce livre"}</button>
	</form>

</body>
</html>