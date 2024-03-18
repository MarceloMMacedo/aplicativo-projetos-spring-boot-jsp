<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
<button type="button" class="btn btn-primary m-5" data-bs-toggle="modal" data-bs-target="#adicionarProjetoModal">
  Adicionar Projeto
</button>
    <div class=" m-4">
		<div class="row">
            <c:forEach items="${projetos}" var="projeto">
                <div class="col-sm-4  mt-md-2 h-100 mb ">
                <a href="/projetos/${projeto.id}" aria-label="Editar Projeto">
                            <div class="card shadow p-3 m-3 bg-white rounded">
                                <div class="card-header d-flex justify-content-between">
                                    <div>
                                        <h6 class="text-left d-block      m-2">${projeto.dataInicio}</h6>
                                        <h6 class="text-left d-block     m-2">${projeto.dataPrevisaoFim}</h6>
                                    </div>
                                    <div>
                                        <span class="text-right d-block badge bg-primary m-2">${projeto.risco}</span> <span
                                            class="text-right d-block badge text-bg-info m-2">${projeto.status}</span>
                                    </div>
                                </div>
                                <div class="card-body">
                                    <div
                                        class=" text-center   align-items-center justify-content-center">
                                        <h5 class=" card-title   ">${projeto.nome}</h5>
                                        <p class="card-text  text-truncate  "> ${projeto.descricao}</p>


                                    </div>
                                </div>
                                <div class="card-footer p-3   text-dark">
                                    <div class="container-circle  align-items-center justify-content-center ">
                                        <c:forEach items="${projeto.primeiroInicialNomeMembros}" var="membro">
                                            <span class="badge bg-primary circle m-1 p-1">${membro}</span>
                                        </c:forEach>

                                    </div>
                                     <div class="card-header d-flex justify-content-between">
                                    <div>
                                        <h6 class="text-left d-block      m-2">${projeto.gerente.nome}</h6>
                                    </div>
                                    <div>
                                        <span class="text-right d-block  m-2"><fmt:formatNumber type="currency" currencyCode="BRL" value="${projeto.orcamento}" />
                                        </span>
                                    </div>
                                </div>

                                </div>
                            </div>
                            </a>
                        </div>

            </c:forEach>

        </div>
    </div>

<!-- Modal -->
<div class="modal fade" id="adicionarProjetoModal" tabindex="-1" aria-labelledby="adicionarProjetoModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
        <div class="modal-header">
            <h5 class="modal-title" id="adicionarProjetoModalLabel">Adicionar Projeto</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Fechar"></button>
        </div>
        <div class="modal-body">
            <form action="projetos/adicionar" method="POST">
            <div class="row mb-3">
                <label for="nome" class="col-sm-2 col-form-label">Nome</label>
                <div class="col-sm-10">
                <input type="text" class="form-control" id="nome" name="nome" required>
                </div>
            </div>
            <div class="row mb-3">
                <label for="dataInicio" class="col-sm-2 col-form-label">Data de Início</label>
                <div class="col-sm-10">
                <input type="date" class="form-control" id="dataInicio" name="dataInicio"  required>
                </div>
            </div>
            <div class="row mb-3">
                <label for="dataPrevisaoFim" class="col-sm-2 col-form-label">Data de Previsão de Fim</label>
                <div class="col-sm-10">
                <input type="date" class="form-control" id="dataPrevisaoFim" name="dataPrevisaoFim"  required>
                </div>
            </div>
            <div class="row mb-3">
                <label for="dataFim" class="col-sm-2 col-form-label">Data de Fim</label>
                <div class="col-sm-10">
                <input type="date" class="form-control" id="dataFim" name="dataFim"  required>
                </div>
            </div>
            <div class="row mb-3">
                <label for="descricao" class="col-sm-2 col-form-label">Descrição</label>
                <div class="col-sm-10">
                <textarea class="form-control" id="descricao" name="descricao" rows="3"  required></textarea>
                </div>
            </div>
            <%-- <div class="row mb-3">
                <label for="status" class="col-sm-2 col-form-label">Status</label>
                <div class="col-sm-10">
                <select class="form-select" id="status" name="status"  required>
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
            </div> --%>
            <div class="row mb-3">
                <label for="orcamento" class="col-sm-2 col-form-label">Orçamento</label>
                <div class="col-sm-10">
                <input type="number" class="form-control" id="orcamento" name="orcamento"  required>
                </div>
            </div>
            <div class="row mb-3">
                <label for="risco" class="col-sm-2 col-form-label">Risco</label>
                <div class="col-sm-10">
                <select class="form-select" id="risco" name="risco"  required>
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
                <select class="form-select" id="gerente" name="gerente"  required>
                    <c:forEach items="${gerentes}" var="gerente">
                    <option value="${gerente.id}">${gerente.nome}</option></c:forEach>
                </select>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fechar</button>
                <button type="submit" class="btn btn-primary">Enviar</button>
            </div>
            </form>
        </div>
        </div>
    </div>
</div>

</t:layout>