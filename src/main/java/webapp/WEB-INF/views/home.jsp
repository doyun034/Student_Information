<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>학사 정보 시스템</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/home.css">
</head>
<body>
<div class="container">
  <p><a href="${pageContext.request.contextPath}/allinformation">학년별 이수 학점 조회</a></p>
  <p><a href="${pageContext.request.contextPath}/selectclass">수강 신청하기</a></p>
  <p><a href="${pageContext.request.contextPath}/information">수강 신청 조회</a></p>

  <c:if test="${pageContext.request.userPrincipal.name != null}">
    <button id="logout-btn" onclick="document.getElementById('logout').submit()">Logout</button>
  </c:if>

  <form id="logout" action="<c:url value="/logout"/> " method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
  </form>
</div>
</body>
</html>
