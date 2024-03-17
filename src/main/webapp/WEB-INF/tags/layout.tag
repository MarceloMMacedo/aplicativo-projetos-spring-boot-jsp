<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@tag description="Simple Wrapper Tag" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt_br">

<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />

<title>Desafio Java</title>

<link rel="stylesheet" type="text/css" href="<c:url value="/static/node_modules/bootstrap/dist/css/bootstrap.min.css" />" />
<link rel="stylesheet" type="text/css" href="<c:url value="/static/navbar.css" />" />

<body>

<jsp:include page="/WEB-INF/jsp/componentes/cabecalho.jsp"></jsp:include>
<jsp:doBody/>
<script src="<c:url value="/static/node_modules/bootstrap/dist/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/static/nvabar.js" />"></script>

</body>

</html>