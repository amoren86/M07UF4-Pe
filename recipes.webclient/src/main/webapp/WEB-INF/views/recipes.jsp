<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ca">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Recetas</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Recetas</h1>
				<p>Lista de deliciosas recetas</p>
			</div>
		</div>
	</section>
	<section class="container">
		<div class="row">
			<c:forEach items="${recipes}" var="recipe">
				<div class=" col-md-6" style="padding-bottom: 15px">
					<div class="thumbnail">
						<div class="caption">
							<c:choose>
								<c:when test="${recipe.category=='FIRSTS'}">
									<h4>Primero</h4>
								</c:when>
								<c:when test="${recipe.category=='SECONDS'}">
									<h4>Segundo</h4>
								</c:when>
								<c:when test="${recipe.category=='DESSERTS'}">
									<h4>Postre</h4>
								</c:when>
							</c:choose>
							<h5>
								<spring:url var="recipeDetailsUrl" value="/recipe_details">
									<spring:param name="recipe_id" value="${recipe.id}"></spring:param>
								</spring:url>
								<a href="${recipeDetailsUrl}">${recipe.name}</a>
							</h5>
							<p>${recipe.time}&nbsp;minutos&nbsp;-&nbsp;${recipe.diners}&nbsp;personas</p>
							<p>
								Dificultad:
								<c:choose>
									<c:when test="${recipe.difficulty=='SUPEREASY'}">
										<span style="color: green">superfácil</span>
									</c:when>
									<c:when test="${recipe.difficulty=='EASY'}">
										<span style="color: green">fácil</span>
									</c:when>
									<c:when test="${recipe.difficulty=='MEDIUM'}">
										<span style="color: orange">media</span>
									</c:when>
									<c:when test="${recipe.difficulty=='HARD'}">
										<span style="color: red">difícil</span>
									</c:when>
								</c:choose>
							</p>
							<p>
								<spring:url var="votePositive" value="/vote_positive">
									<spring:param name="recipe_id" value="${recipe.id}"></spring:param>
									<spring:param name="redirect_to" value="/"></spring:param>
								</spring:url>
								<spring:url var="voteNegative" value="/vote_negative">
									<spring:param name="recipe_id" value="${recipe.id}"></spring:param>
									<spring:param name="redirect_to" value="/"></spring:param>
								</spring:url>
								Votes: ${recipe.positiveVotes}&nbsp;<a href="${votePositive}"><i
									class="fa fa-thumbs-up"></i></a>&nbsp;&nbsp;
									 ${recipe.negativeVotes}&nbsp;<a href="${voteNegative}"><i
									class="fa fa-thumbs-down"></i></a>
							</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
</body>
</html>
