<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>학년별 이수 학점 조회</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/information.css" >
</head>
<body>
<table>
    <thead>
    <tr>
        <th>년도</th>
        <th>학기</th>
        <th>취득 학점</th>
        <th>상세보기</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="entry" items="${id_YearAndSemester}">
        <c:set var="tokens" value="${fn:split(entry.key, '-')}"/>
        <tr>
            <td><c:out value="${tokens[0]}" /></td>
            <td><c:out value="${tokens[1]}" /></td>
            <td><c:out value="${entry.value}" /></td>
            <td><a href="detail?year=<c:out value="${tokens[0]}" />&semester=<c:out value="${tokens[1]}" />">상세보기</a></td>
        </tr>
    </c:forEach>
    <tr>
        <td>총계</td>
        <td></td>
        <td>64</td>
    </tr>
    </tbody>
</table>
</body>
</html>
