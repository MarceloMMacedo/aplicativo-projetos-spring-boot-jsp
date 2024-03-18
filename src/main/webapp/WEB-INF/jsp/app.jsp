<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
<!-- Botão para abrir o modal -->
<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#adicionarProjetoModal">
  Adicionar Projeto
</button>

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
              <input type="date" class="form-control" id="dataInicio" name="dataInicio">
            </div>
          </div>
          <div class="row mb-3">
            <label for="dataPrevisaoFim" class="col-sm-2 col-form-label">Data de Previsão de Fim</label>
            <div class="col-sm-10">
              <input type="date" class="form-control" id="dataPrevisaoFim" name="dataPrevisaoFim">
            </div>
          </div>
          <div class="row mb-3">
            <label for="dataFim" class="col-sm-2 col-form-label">Data de Fim</label>
            <div class="col-sm-10">
              <input type="date" class="form-control" id="dataFim" name="dataFim">
            </div>
          </div>
          <div class="row mb-3">
            <label for="descricao" class="col-sm-2 col-form-label">Descrição</label>
            <div class="col-sm-10">
              <textarea class="form-control" id="descricao" name="descricao" rows="3"></textarea>
            </div>
          </div>
          <div class="row mb-3">
            <label for="status" class="col-sm-2 col-form-label">Status</label>
            <div class="col-sm-10">
              <select class="form-select" id="status" name="status">
                <option value="EM_ANALISE">Em Análise</option>
                <option value="ANALISE_REALIZADA">Análise Realizada</option>
                <option value="ANALISE_APROVADA">Análise Aprovada</option>
                <option value="INICIADO">Iniciado</option>
                <option value="PLANEJADO">Planejado</option>
                <option value="EM_ANDAMENTO">Em Andamento</option>
                <option value="ENCERRADO">Encerrado</option>
                <option value="CANCELADO">Cancelado</option>
              </select>
            </div>
          </div>
          <div class="row mb-3">
            <label for="orcamento" class="col-sm-2 col-form-label">Orçamento</label>
            <div class="col-sm-10">
              <input type="number" class="form-control" id="orcamento" name="orcamento">
            </div>
          </div>
          <div class="row mb-3">
            <label for="risco" class="col-sm-2 col-form-label">Risco</label>
            <div class="col-sm-10">
              <select class="form-select" id="risco" name="risco">
                <option value="BAIXO_RISCO">Baixo Risco</option>
                <option value="MEDIO_RISCO">Médio Risco</option>
                <option value="ALTO_RISCO">Alto Risco</option>
              </select>
            </div>
          </div>
          <div class="row mb-3">
            <label for="gerente" class="col-sm-2 col-form-label">Gerente</label>
            <div class="col-sm-10">
              <select class="form-select" id="gerente" name="gerente">
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
