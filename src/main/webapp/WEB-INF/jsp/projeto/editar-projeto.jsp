<%@page contentType="text/html;charset=UTF-8" language="java" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
            <%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

                <t:layout>

                    <div class="container  w-">
                        <h1 class="mt-5 mb-5 text-center" id="editarProjetoModalLabel">Editar Projeto</h1>
                        <button type="button" class="btn btn-primary mb-5"
                            href="/projetos/${projeto.id}/adicionar-membros" id="mudarStatus" ${projeto.status
                            eq 'Encerrado' or projeto.status eq 'Cancelado' ? 'disabled' : '' } data-bs-toggle="modal"
                            data-bs-target="#confirmModal">Mudar Status</button>

                        <button type="button" class="btn btn-danger mb-5" id="mudarStatus" ${projeto.status
                            eq 'Encerrado' or projeto.status eq 'Cancelado'  or projeto.status eq 'Planejado'
                              or projeto.status eq 'Planejado' or projeto.status eq 'Em Andamento' or projeto.status eq 'Iniciado' ? 'disabled' : '' } data-bs-toggle="modal"
                            data-bs-target="#confirCancelmModal">
                            Cancelar Projeto</button>
                            <button  type="button" class="btn btn-danger  ml-3 mb-5" data-bs-toggle="modal"
                                         data-bs-target="#confirExcluiModal"  ${projeto.status eq 'Encerrado'
                                                        or projeto.status eq 'Em Andamento' or projeto.status eq 'Iniciado' ? 'disabled' : '' } >
                                                        Excluir Projeto</button>
                        <div class="row mb-3">
                            <label for="nome" class="col-sm-2 col-form-label">Status</label>
                            <div class="col-sm-10">
                                <label class="form-control"> ${projeto.status} </label>
                            </div>
                        </div>
                        <form action="<c:url value='/projetos/atualizar'/>" method="POST" id="addFuncionarioForm">

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
                                    <option value=${gerentes.id}>${gerentes.nome}</option>
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
                        <hr />
                        <button type="submit" class="btn btn-primary brn-sm m-5" ${projeto.status eq 'Encerrado' or
                            projeto.status eq 'Cancelado' ? 'disabled' : '' }>Atualizar</button>
                        <button type="button" class="btn btn-primary m-5" ${projeto.status eq 'Encerrado' or projeto.status
                            eq 'Cancelado' ? 'disabled' : '' } data-bs-toggle="modal"
                            data-bs-target="#addmenbrosModal">Adicionar Membro</button>





                    </form>
                        <tbody>
                            <c:forEach var="membros" items="${projeto.membros}">
                                <tr>
                                    <td>${membros.nome}</td>
                                    <td width="10%"><button ${projeto.status eq 'Encerrado' or projeto.status
                                    eq 'Cancelado' ? 'disabled' : '' } onclick = "excluirMembro(${projeto.id},${membros.id})"
                                            class="btn btn-sm btn-danger" id="excluirFuncionarioButton"
                                            aria-label="Excluir Funcionário">Excluir</button></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>


                    </div>


                    <!-- Modal de confirmação -->

                    <div class="modal fade" id="confirmModal" tabindex="-1" aria-labelledby="confirmModalLabel"
                        aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="confirmModalLabel">Confirmação de Mudança de Status</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                        aria-label="Fechar"></button>
                                </div>
                                <div class="modal-body">
                                    <p>Deseja realmente mudar o status do projeto?</p>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary"
                                        data-bs-dismiss="modal">Cancelar</button>
                                    <button type="button" class="btn btn-primary"
                                        onclick="confirmarMudancaStatus(${projeto.id})">Confirmar</button>
                                </div>
                            </div>
                        </div>
                    </div>


                    <!-- Modal de confirmação -->

                    <div class="modal fade" id="confirCancelmModal" tabindex="-1"
                        aria-labelledby="confirmModalLabelcancel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="confirmModalLabelcancel">Confirmação de Mudança de
                                        Status</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                        aria-label="Fechar"></button>
                                </div>
                                <div class="modal-body">
                                    <p class="text-danger">Deseja Cancelar projeto?</p>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary"
                                        data-bs-dismiss="modal">Cancelar</button>
                                    <button type="button" class="btn btn-primary btn-danger"
                                        onclick="confirmarCancelarProjeto(${projeto.id})">Cancelar Projeto</button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Modal de membros -->
                    <div class="modal fade" id="addmenbrosModal" tabindex="-1" aria-labelledby="addmenbrosLabel"
                        aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="addmenbrosLabel">Adicionar Membros</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                        aria-label="Fechar"></button>
                                </div>
                                <div class="modal-body">
                                    <div class="form-group">
                                        <label for="funcionario">Funcionário</label>
                                        <select class="form-control" id="membroSelect" name="membroId">
                                            <c:forEach items="${funcionarios}" var="funcionario">
                                                <option value="${funcionario.id}">${funcionario.nome}</option>
                                            </c:forEach>
                                        </select>
                                    </div>

                                </div>

                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary"
                                    data-bs-dismiss="modal">Cancelar</button>
                                <a id="associarLink" href="/projetos/${projetoId}/associar/{funcionarioId}"
                                    class="btn btn-primary" disabled>Associar Membro</a>
                            </div>
                        </div>
                        </div>
                    </div>

 <!-- Modal de exclusão -->

                    <div class="modal fade" id="confirExcluiModal" tabindex="-1"
                        aria-labelledby="confirmModalLabelcancel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="confirmModalLabelcancel">Confirmação de Mudança de
                                        Status</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                        aria-label="Fechar"></button>
                                </div>
                                <div class="modal-body">
                                    <p class="text-danger">Deseja Excluir projeto?</p>
                                    <p> <small>Esta ação não poderá ser desfeita.</small></p>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary"
                                        data-bs-dismiss="modal">Cancelar</button>
                                    <button type="button" class="btn btn-primary btn-danger"
                                        onclick="confirmarExcluirProjeto(${projeto.id})">Excluir Projeto</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <script>
                    function excluirMembro(projetoId, membroId) {
                         var xhr = new XMLHttpRequest();
                            xhr.open('POST',"/projetos/" + projetoId + "/excluir-membro/" + membroId, true);
                            xhr.onreadystatechange = function () {
                                if (xhr.readyState === 4 && xhr.status === 200) {
                                    var response = xhr.responseText;

                                    alert(response);
                                    window.location.href = "/projetos/" + projetoId;
                                }
                            };
                            xhr.send();
                    }
                        function confirmarMudancaStatus(projetoId) {
                            var xhr = new XMLHttpRequest();
                            xhr.open('POST', '/projetos/mudar-status-projeto/' + projetoId, true);
                            xhr.onreadystatechange = function () {
                                if (xhr.readyState === 4 && xhr.status === 200) {
                                    var response = xhr.responseText;
                                    var modal = document.getElementById("confirmModal");
                                    var bootstrapModal = bootstrap.Modal.getInstance(modal);
                                    bootstrapModal.hide();
                                    alert(response);
                                    window.location.href = "/projetos/" + projetoId;
                                }
                            };
                            xhr.send();

                        }
                        function confirmarCancelarProjeto(projetoId) {

                            var xhr = new XMLHttpRequest();
                            xhr.open('POST', '/projetos/cancelar-projeto/' + projetoId, true);
                            xhr.onreadystatechange = function () {
                                if (xhr.readyState === 4 && xhr.status === 200) {
                                    var response = xhr.responseText;
                                    var modal = document.getElementById("confirCancelmModal");
                                    var bootstrapModal = bootstrap.Modal.getInstance(modal);
                                    bootstrapModal.hide();
                                    alert(response);
                                    window.location.href = "/";
                                }
                            };
                            xhr.send();
                        }
                        function atualizarLinkAssociar() {
                            var selectedOption = document.getElementById("membroSelect").options[document.getElementById("membroSelect").selectedIndex];
                            var selectedId = selectedOption.value;
                            var linkHref = "/projetos/${projetoId}/associar/" + selectedId;
                            var associarLink = document.getElementById("associarLink");

                            associarLink.href = linkHref;

                            if (selectedId) {
                                associarLink.removeAttribute("disabled");
                            } else {
                                associarLink.setAttribute("disabled", "disabled");
                            }
                        }
                        function confirmarExcluirProjeto(projetoId) {

                            var xhr = new XMLHttpRequest();
                            xhr.open('POST', '/projetos/' + projetoId +'/excluir', true);
                            xhr.onreadystatechange = function () {
                                if (xhr.readyState === 4 && xhr.status === 200) {
                                    var response = xhr.responseText;
                                    var modal = document.getElementById("confirExcluiModal");
                                    var bootstrapModal = bootstrap.Modal.getInstance(modal);
                                    bootstrapModal.hide();
                                    alert(response);
                                    window.location.href = "/";
                                }
                            };
                            xhr.send();
                        }
                        document.getElementById("membroSelect").addEventListener("change", atualizarLinkAssociar);
                        document.addEventListener("DOMContentLoaded", atualizarLinkAssociar)
                    </script>

                </t:layout>
