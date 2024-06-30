<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>수강 신청하기</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/selectclass.css" >
</head>
<body>
<sf:form method="post" action="${pageContext.request.contextPath}/doselect" modelAttribute="select">
    <table class="formtable">
        <tr>
            <td class="label"> 년도:</td>
            <td><sf:input class="control" type="text" path="year"/>  <br/>
                <sf:errors path="year" class="error"/>
            </td>
        </tr>
        <tr>
            <td class="label"> 학기:</td>
            <td><sf:input class="control" type="text" path="semester"/>  <br/>
                <sf:errors path="semester" class="error"/>
            </td>
        </tr>
        <tr>
            <td class="label"> 교과코드:</td>
            <td><sf:input class="control" type="text" path="class_code"/>  <br/>
                <sf:errors path="class_code" class="error"/>
            </td>
        </tr>
        <tr>
            <td class="label"> 교과목명:</td>
            <td><sf:input class="control" type="text" path="class_name"/>  <br/>
                <sf:errors path="class_name" class="error"/>
            </td>
        </tr>
        <td class="label"> 교과구분:</td>
        <td><sf:input class="control" type="text" path="class_type"/>  <br/>
            <sf:errors path="class_type" class="error"/>
        </td>
        <tr>
            <td class="label"> 담당교수:</td>
            <td><sf:input class="control" type="text" path="professor"/>  <br/>
                <sf:errors path="professor" class="error"/>
            </td>
        </tr>
        <tr>
            <td class="label"> 학점:</td>
            <td><sf:input class="control" type="text" path="point"/>  <br/>
                <sf:errors path="point" class="error"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="신청"/> </td>
        </tr>
    </table>
</sf:form>
</body>
</html>