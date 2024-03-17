<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-dark bg-dark navbar-expand-lg " id="mainNavbar">
	<div class="container-fluid">
		<a class="navbar-brand" href="#" id="navbarBrand">Gerenciador de Projetos</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarToggler" aria-controls="navbarToggler" aria-expanded="false"
			aria-label="Alternar navegação">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarToggler">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
			<li class="nav-item">
					<a class="nav-link active" id="homeLink" aria-current="page" href="/">Home</a>
				</li>
				<li class="nav-item">
					<a class="nav-link active" id="funcionariosLink" aria-current="page" href="/funcionarios/">Funcionários</a>
				</li>

			</ul>

		</div>
	</div>
</nav>
