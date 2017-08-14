<%--
  Created by IntelliJ IDEA.
  User: Eugene
  Date: 2017/8/14
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户信息页面</title>
</head>
<body>
    <h1>新增用户</h1>
    <span style="color: red;"><b>${ex.message}</b></span>
    <form action="${pageContext.request.contextPath}/user/register" method="post" enctype="multipart/form-data">
        <label for="userName">账号:</label>
        <input type="text" id="userName" name="userName" placeholder="请输入账号" />

        <label for="password">密码:</label>
        <input type="text" id="password" name="password" placeholder="请输入密码" />

        <label for="headImage">头像:</label>
        <input type="file" id="headImage" name="headImage" />

        <button id="register">注册</button>
    </form>

    <h1>用户列表</h1>
    <c:choose>
        <c:when test="${requestScope.users != null && requestScope.users.size() > 0}">
            <table>
                <thead>
                <th>
                <td>用户名</td>
                <td>密码</td>
                </th>
                </thead>

                <tbody>
                    <c:forEach var="item" items="${requestScope.users}">
                        <tr>
                            <td>${item.userName}</td>
                            <td>${item.password}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:when>

        <c:otherwise>
            <span>暂无数据</span>
        </c:otherwise>
    </c:choose>


</body>
</html>
