<%@page contentType="text/html;charset=UTF-8" language="java" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
            <%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

                <t:layout>

                    <div class="container w-50">
                        <h1 class="mt-5 mb-5 text-center" id="editarProjetoModalLabel">Adicionar Projeto</h1>


                        <form action="<c:url value='/projetos/atualizar'/>" method="POST" id="addFuncionarioForm">>

                            <input type="hidden" id="id" name="id" value="${projeto.id}">
                            <input type="hidden" id="membros" name="menbros" value="${projeto.membros}">
                            <div class="row mb-3">
                                <label for="nome" class="col-sm-2 col-form-label">Nome</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="nome" name="nome" required
                                        value="${projeto.nome}">
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label for="dataInicio" class="col-sm-2 col-form-label">Data de Início</label>
                                <div class="col-sm-10">
                                    <input type="date" class="form-control" id="dataInicio" name="dataInicio"
                                        value="${projeto.dataInicio}">
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label for="dataPrevisaoFim" class="col-sm-2 col-form-label">Data de Previsão de
                                    Fim</label>
                                <div class="col-sm-10">
                                    <input type="date" class="form-control" id="dataPrevisaoFim" name="dataPrevisaoFim"
                                        value="${projeto.dataPrevisaoFim}">
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label for="dataFim" class="col-sm-2 col-form-label">Data de Fim</label>
                                <div class="col-sm-10">
                                    <input type="date" class="form-control" id="dataFim" name="dataFim"
                                        value="${projeto.dataFim}">
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label for="descricao" class="col-sm-2 col-form-label">Descrição</label>
                                <div class="col-sm-10">
                                    <textarea class="form-control" id="descricao"
                                        name="descricao">${projeto.descricao}</textarea>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label for="status" class="col-sm-2 col-form-label">Status</label>
                                <div class="col-sm-10">
                                    <select class="form-select" id="status" name="status">
                                        <option value="Em Analise" ${projeto.status=='Em Analise' ? 'selected' : '' }>Em
                                            Análise</option>
                                        <option value="Analise Realizada" ${projeto.status=='Analise Realizada'
                                            ? 'selected' : '' }>Análise Realizada</option>
                                        <option value="Analise Aprovada" ${projeto.status=='Analise Aprovada'
                                            ? 'selected' : '' }>Análise Aprovada</option>
                                        <option value="Iniciado" ${projeto.status=='Iniciado' ? 'selected' : '' }>
                                            Iniciado</option>
                                        <option value="Planejado" ${projeto.status=='Planejado' ? 'selected' : '' }>
                                            Planejado</option>
                                        <option value="Em Andamento" ${projeto.status=='Em Andamento' ? 'selected' : ''
                                            }>Em Andamento</option>
                                        <option value="Encerrado" ${projeto.status=='Encerrado' ? 'selected' : '' }>
                                            Encerrado</option>
                                        <option value="Cancelado" ${projeto.status=='Cancelado' ? 'selected' : '' }>
                                            Cancelado</option>
                                    </select>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label for="orcamento" class="col-sm-2 col-form-label">Orçamento</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="orcamento" name="orcamento"
                                        value="${projeto.orcamento}">
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label for="risco" class="col-sm-2 col-form-label">Risco</label>
                                <div class="col-sm-10">
                                    <select class="form-select" id="risco" name="risco">
                                        <option value="Baixo Risco" ${projeto.risco=='Baixo Risco' ? 'selected' : '' }>
                                            Baixo</option>
                                        <option value="Medio Risco" ${projeto.risco=='Medio Risco' ? 'selected' : '' }>
                                            Médio</option>
                                        <option value="Alto Risco" ${projeto.risco=='Alto Risco' ? 'selected' : '' }>
                                            Alto</option>
                                    </select>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label for="gerente" class="col-sm-2 col-form-label">Gerente</label>
                                <div class="col-sm-10">
                                    <select class="form-select" id="gerente" name="gerente">
                                        <option value="${projeto.gerente.id}" selected>${projeto.gerente.nome}</option>
                                    <c:forEach var="gerentes" items="${gerentes}">
                                        <option value=${gerentes.id}  >${gerentes.nome}</option>
                                    </c:forEach>
                                    </select>
                                </div>
                            </div>


                            <table class="table table-striped table-hover table-bordered mt-3 table-responsive table-sm"
                                id="funcionarioTable">
                                <thead>
                                    <tr>
                                        <th id="nomeHeader">Membros</th>
                                        <th>Excluir</th>
                                    </tr>
                                </thead>
                            <hr/>

                                        <a type="button" class="btn btn-primary" href="/projetos/${projeto.id}/adicionar-membros">Adicionar Membro</a>

                                <tbody>
                                    <c:forEach var="membros" items="${projeto.membros}">
                                        <tr>
                                            <td>${membros.nome}</td>
                                            <td width="10%"><a
                                                    href="/projetos/${projeto.id}/excluir-membro/${membros.id}"
                                                    class="btn btn-sm btn-danger" id="excluirFuncionarioButton"
                                                    aria-label="Excluir Funcionário">Excluir</a></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>

                        <div class="mt-5 modal-footer">
                            <button type="submit" class="btn btn-primary brn-sm">Atualizar</button>
                        </div>
                    </div>
        </form>



</t:layout>