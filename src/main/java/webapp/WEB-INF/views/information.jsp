<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>수강 신청 조회</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/information.css" >
</head>
<body>
<h2>수강 신청 조회</h2>
<table>
    <thead>
    <tr>
        <th>년도</th>
        <th>학기</th>
        <th>교과코드</th>
        <th>교과목명</th>
        <th>교과구분</th>
        <th>교수</th>
        <th>학점</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="register" items="${id_registers}">
        <tr>
            <td>${register.year}</td>
            <td>${register.semester}</td>
            <td>${register.class_code}</td>
            <td>${register.class_name}</td>
            <td>${register.class_type}</td>
            <td>${register.professor}</td>
            <td>${register.point}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
