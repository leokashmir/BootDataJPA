<!DOCTYPE HTML>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Pragma" content="no-cache"> 
    <meta http-equiv="Cache-Control" content="no-cache"> 
    <meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">
    
    <title>Gerenciador de Tarefas | Home</title>
    
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
     <link href="static/css/style.css" rel="stylesheet">
    
    <!--[if lt IE 9]>
		<script src="static/js/html5shiv.min.js"></script>
		<script src="static/js/respond.min.js"></script>
	<![endif]-->
</head>
<body>

	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Bootsample</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="nova">Noca Tarefa</a></li>
					<li><a href="todas">Todas as Tarefas</a></li>
				</ul>
			</div>
		</div>
	</div>
	
	<c:choose>
		<c:when test="${mode == 'MODO_HOME'}">
			<div class="container" id="homeDiv">
				<div class="jumbotron text-center">
					<h1>Bem vindo!</h1>
				</div>
			</div>
		</c:when>
		<c:when test="${mode == 'MODO_TAREFAS'}">
			<div class="container text-center" id="tasksDiv">
				<h3>Minhas Terefas</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered text-left">
						<thead>
							<tr>
								<th>Id</th>
								<th>Nome</th>
								<th>Descricao</th>
								<th>Criando em:</th>
								<th>Finalizada</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="tarefa" items="${tarefas}">
								<tr>
									<td>${tarefa.id}</td>
									<td>${tarefa.name}</td>
									<td>${tarefa.description}</td>
									<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${tarefa.dateCreated}"/></td>
									<td>${tarefa.finished}</td>
									<td><a href="update?id=${tarefa.id}"><span class="glyphicon glyphicon-pencil"></span></a></td>
									<td><a href="delete?id=${tarefa.id}"><span class="glyphicon glyphicon-trash"></span></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		<c:when test="${mode == 'MODO_NOVO' || mode == 'MODO_UPDATE'}">
			<div class="container text-center">
				<h3>Gerenciador de Tarefas</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="save">
					<input type="hidden" name="id" value="${tarefa.id}"/>
					<div class="form-group">
						<label class="control-label col-md-3">Nome</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="name" value="${tarefa.name}"/>
						</div>				
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Descricao</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="description" value="${tarefa.description}"/>
						</div>				
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Finalizado</label>
						<div class="col-md-7">
							<input type="radio" class="col-sm-1" name="finished" value="true"/>
							<div class="col-sm-1">Sim</div>
							<input type="radio" class="col-sm-1" name="finished" value="false" checked/>
							<div class="col-sm-1">Nao</div>
						</div>				
					</div>		
					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="Salvar"/>
					</div>
				</form>
			</div>
		</c:when>		
	</c:choose>

	<script src="static/js/jquery-1.11.1.min.js"></script>    
    <script src="static/js/bootstrap.min.js"></script>
</body>
</html>