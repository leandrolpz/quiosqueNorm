<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Cliente</title>
</head>
<body>
	<h1>Dados do Cliente</h1>
	<table border="3">
		<tr>
			<th>id</th>
			<th>nome</th>
			<th>gênero</th>
			<th>Data de Nascimento</th>
			<th>Idade</th>
			<th>Telefone/Celular</th>
			<th>Email</th>
			<th>Endereço</th>
			<th>Produto de Interesse</th>
			<th>Edit</th>
			<th>Excluir</th>
				
			
		</tr>
		<c:forEach items="${cliente }" var="c">
		<tr>	
		 <td>${c.id }</td>
		 <td>${c.nome }</td>
		 <td>${c.genero }</td>
		 <td><fmt:formatDate value="${c.dataNascimento.time}" pattern="dd/MMM/yyyy"/> </td>
		 <td>${c.idade }</td>
		 <td>${c.telecel }</td>
		 <td>${c.email }</td>
		 <td>${c.endereco }</td>
		 <td>${c.prodInteresse }</td>
		 <td><a href="alterarCliente?idCliente=${c.id}">Edit</a></td>
		 <td><a href="excluirCliente?idCliente=${c.id }">Excluir</a></td>
		 </tr>
		</c:forEach>
		
	</table>
	
	<table border="3">
	<tr>
		<h1>Contadores</h1>
		<th>Quantidade Masculino</th>
		<th>Quantidade Feminino</th>
		
	
	</tr>
	
	
	</table>
</body>
</html>