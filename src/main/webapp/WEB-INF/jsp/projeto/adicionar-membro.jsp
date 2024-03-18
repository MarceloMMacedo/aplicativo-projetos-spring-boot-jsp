<%@page contentType="text/html;charset=UTF-8" language="java" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
            <%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

                <t:layout>


  <div class="container w-50">
        <h1 class="modal-title" id="meuModalLabel">Associar Funcionário ao Projeto</h1>

<div class="form-group">
  <label for="funcionario">Funcionário</label>
  <select class="form-control" id="membroSelect" name="membroId">
    <c:forEach items="${funcionarios}" var="funcionario">
      <option value="${funcionario.id}">${funcionario.nome}</option>
    </c:forEach>
  </select>
</div>
<hr/>
<div class="modal-footer">
  <a id="associarLink" href="/projetos/${projetoId}/associar/{funcionarioId}" class="btn btn-primary" disabled>Associar</a>
</div>
</div>
<script>
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

  document.getElementById("membroSelect").addEventListener("change", atualizarLinkAssociar);
  document.addEventListener("DOMContentLoaded", atualizarLinkAssociar);
</script>
                </t:layout>
