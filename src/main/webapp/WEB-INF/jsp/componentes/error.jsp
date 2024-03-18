<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
@heading-color: #ff45ae;
@sub-heading-color: #66f38a;
@color: #9f9f9fb3;

.vc-container {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  height: 100vh;
  background: url("https://www.publicdomainpictures.net/pictures/80000/velka/red-brick-wall-clipart.jpg#.W5guDpUt1yw.link")
    center repeat;
  background-size: contain;

  &::before {
    content: "";
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background: linear-gradient(
      rgba(0, 0, 0, 0.9),
      rgba(0, 0, 0, 0.5),
      rgba(0, 0, 0, 0.9)
    );
    z-index: 1;
  }
}

.vc-content {
  text-align: center;
  color: #fff;
  z-index: 2;
  font-family: "Monoton", cursive;
}

.vc-heading {
  font-size: 12.1em;
  margin: 0 0 20px;
  color: @heading-color;
  text-shadow: 0 0 40px;
  font-weight: 100;
  animation: blink 6s ease-in-out;
}

.vc-sub-heading {
  margin: 0;
  font-size: 5em;
  color: @sub-heading-color;
  text-shadow: 0 0 60px;
  font-weight: 100;
  animation: blink-sub 6s ease-in-out;
}

.blink-infinite {
  animation: infinite-blink 0.2s 3s infinite;
}

@media screen and (max-width: 500px) {
  .vc-heading {
    font-size: 8em;
  }
  .vc-sub-heading {
    font-size: 1.3em;
  }
}

@keyframes blink {
  35%,
  37%,
  39%,
  41%,
  100% {
    color: @heading-color;
    text-shadow: 0 0 40px;
  }
  0%,
  34%,
  36%,
  36%,
  38%,
  40% {
    color: @color;
    text-shadow: none;
  }
}

@keyframes blink-sub {
  35%,
  37%,
  39%,
  41%,
  100% {
    color: @sub-heading-color;
    text-shadow: 0 0 60px;
  }
  0%,
  34%,
  36%,
  36%,
  38%,
  40% {
    color: @color;
    text-shadow: none;
  }
}

@keyframes infinite-blink {
  60%,
  80% {
    color: @color;
    text-shadow: none;
  }
  70%,
  100% {
    color: @sub-heading-color;
    text-shadow: 0 0 30px;
  }
}
 .btn {
  --bs-btn-padding-y: 0.5rem;
  --bs-btn-padding-x: 1rem;
  --bs-btn-font-size: 1.25rem;
  --bs-btn-border-radius: var(--bs-border-radius-lg);
}

</style>

<link rel="stylesheet" type="text/css" href="<c:url value="/static/node_modules/bootstrap/dist/css/bootstrap.min.css" />" />
</head>
<body>
 <div class="vc-container">
  <div class="vc-content">
    <h1 class="vc-heading">OPS!</h1>
    <p class="vc-sub-heading ">${message}</p>
     <a class="btn btn-alert  " id="homeLink" aria-current="page" href="/">Home</a>
  </div>
</div>
</body>
</body>
</html>