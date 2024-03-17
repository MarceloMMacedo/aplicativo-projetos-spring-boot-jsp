
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:layout>
</t:layout>
    <div class="container">
        <h2>Funcionários</h2>
        <a href="/adicionarFuncionario" class="btn btn-primary mb-2">Adicionar Funcionário</a>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Data de Nascimento</th>
                    <th>CPF</th>
                    <th>Funcionário</th>
                    <th>Gerente</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="funcionario" items="${funcionarios}">
                    <tr>
                        <td>${funcionario.id}</td>
                        <td>${funcionario.nome}</td>
                        <td>${funcionario.dataNascimento}</td>
                        <td>${funcionario.cpf}</td>
                        <td>${funcionario.funcionario}</td>
                        <td>${funcionario.gerente}</td>
                        <td>
                            <a href="/editarFuncionario/${funcionario.id}" class="btn btn-success">Editar</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

