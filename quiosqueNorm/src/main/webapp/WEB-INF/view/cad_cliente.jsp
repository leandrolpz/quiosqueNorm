<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<link href="form.css" rel="stylesheet">
<title>Cadastro do cliente</title>
</head>
<body>
	<header>
		<h1>Bem-Vindo! Faça seu cadastro!</h1>
	</header>
	<main>
		<form id="cadas_form" class="form_class" action="salvar" method="post">
			<table>
				<tr>
					<td class="form_td"><label>Digite seu nome</label></td>
					<td><input id="nome" class="dat_td" type="text" name="nome"
						required="required" placeholder="Insira o seu nome" autofocus value="${cliente.nome }"/>
					</td>
				</tr>
				<tr>           
            	 <td><label>Masculino</label></td>
				 <td><input type = "radio" class="checkbox" name="genero" value="masculino"/></td>
				 <td><label>Feminino</label></td>
				 <td><input type = "radio" class="checkbox" name="genero" value="feminino" id="gen"/></td>
				
				</tr>
				<tr>
					<td><label>Data de nascimento</label></td>
					<td><input id="dataNascimento" name="dataNascimento" class="dat_td" type="date" required
					value='<fmt:formatDate pattern="yyyy-MM-dd" value="${cliente.dataNascimento.time }"/>'></td>
				</tr>
				<tr>
					<td><label>Informe seu endereço</label></td>
					<td><input id="endereco" class="dat_td" type="text"
						name="endereco" required="required"
						placeholder="Insira o seu endereço" autofocus value="${cliente.endereco }"></td>
				</tr>
				<tr>
					<td><label>Informe seu Telefone ou Celular</label></td>
					<td><input id="cell" class="dat_td" type="text"
						name="telecel" required="required"
						placeholder="Telefone ou Celular" autofocus value="${cliente.telecel }"></td>
				</tr>
				<tr>
					<td><label>Informe seu E-mail</label></td>
					<td><input id="email" class="dat_td" type="text" name="email"
						required="required" placeholder="Insira seu E-mail" autofocus value="${cliente.email }"></td>
				</tr>
				<tr>
					<td><label>Indique seus produtos de mais interesse</label></td>
					<td><input id="produtos" class="dat_td" type="text"
						name="prodInteresse" placeholder="Bebida de interesse"
						autofocus value="${cliente.prodInteresse}"></td>
				</tr>
		
		
				<tr>
					<td><button class="submit_bt" type="submit">Salvar</button>
				</tr>
			</table>
		</form>
	</main>
	<footer>
		<p>
			Desenvolvido por <a href="#">Davi e Leandro</a>
		</p>
	</footer>
</body>
</html>