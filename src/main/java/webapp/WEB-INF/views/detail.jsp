<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>상세 정보</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/information.css" >
</head>
<body>
<table>
    <thead>
    <tr>
        <th>년도</th>
        <th>학기</th>
        <th>교과목명</th>
        <th>교과구분</th>
        <th>담당교수</th>
        <th>학점</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="courses" items="${id_courses}">
        <tr>
            <td><c:out value="${courses.year}" /></td>
            <td><c:out value="${courses.semester}" /></td>
            <td><c:out value="${courses.class_name}" /></td>
            <td><c:out value="${courses.class_type}" /></td>
            <td><c:out value="${courses.professor}" /></td>
            <td><c:out value="${courses.point}" /></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
