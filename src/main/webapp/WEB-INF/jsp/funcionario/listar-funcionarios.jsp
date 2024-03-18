<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>


<div class="container mt-5" id="mainContainer">
    <h2 id="header">Funcionários</h2>
    <a href="/funcionarios/adicionar" class="btn btn-primary mb-2" id="addFuncionarioButton" aria-label="Adicionar Funcionário">Adicionar Funcionário</a>
    <table class="table table-striped table-hover table-bordered mt-3 table-responsive table-sm" id="funcionarioTable">

        <thead>
            <tr>
                <th id="nomeHeader">Nome</th>
                <th id="dataNascimentoHeader">Data de Nascimento</th>
                <th id="cpfHeader">CPF</th>
                <th id="funcionarioHeader">Funcionário</th>
                <th id="gerenteHeader">Gerente</th>
                <th class="text-center" id="acoesHeader">Ações</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="funcionario" items="${funcionarios}">
                <tr>
                    <td>${funcionario.nome}</td>
                    <td>${funcionario.dataNascimento}</td>
                    <td>${funcionario.cpf}</td>
                    <td>${funcionario.funcionario}</td>
                    <td>${funcionario.gerente}</td>
                    <td align="center">
                        <a href="/funcionarios/${funcionario.id}/editar" class="btn btn-sm btn-success" id="editarFuncionarioButton" aria-label="Editar Funcionário">Editar</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</t:layout>