<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
   <div class="container mt-5 p-5" id="mainContainer">
        <h2 id="header">Editar Funcionário</h2>
        <form action="<c:url value='/funcionarios/atualizar'/>" method="POST" id="addFuncionarioForm">
        <input type="hidden" name="id" value="${funcionario.id}">
            <div class="row">
                <div class="col-md-12 form-group">
                    <label for="nome">Nome</label>
                    <input type="text" class="form-control" id="nome" name="nome" required aria-required="true" value="${funcionario.nome}">
                </div>
                <div class="col-md-6 form-group">
                    <label for="dataNascimento">Data de Nascimento</label>
                    <input type="date" class="form-control" id="dataNascimento" name="dataNascimento" required aria-required="true" value='${funcionario.dataNascimento}'   >             </div>
                <div class="col-md-6 form-group">
                    <label for="cpf">CPF</label>
                    <input type="text" class="form-control" id="cpf" name="cpf" required aria-required="true" value="${funcionario.cpf}">
                </div>
                <div class="col-md-6 form-group">
                    <label for="funcionario">Funcionário</label>
                   <select class="form-control" id="funcionario" name="funcionario" aria-required="true">
                       <c:choose>
                           <c:when test="${funcionario.funcionario eq 'Sim'}">
                               <option value="Sim" selected>Sim</option>
                               <option value="Não">Não</option>
                           </c:when>
                           <c:otherwise>
                               <option value="Sim">Sim</option>
                               <option value="Não" selected>Não</option>
                           </c:otherwise>
                       </c:choose>
                   </select>
                </div>
                <div class="col-md-6 form-group">
                    <label for="gerente">Gerente</label>
                <select class="form-control" id="gerente" name="gerente" aria-required="true">
                    <c:choose>
                        <c:when test="${funcionario.gerente eq 'Sim'}">
                            <option value="Sim" selected>Sim</option>
                            <option value="Não">Não</option>
                        </c:when>
                        <c:otherwise>
                            <option value="Sim">Sim</option>
                            <option value="Não" selected>Não</option>
                        </c:otherwise>
                    </c:choose>
                </select>
                </div>
            </div>
            <button type="submit" class="btn btn-primary mt-3">Atualizar</button>
        </form>
    </div>
</t:layout>
