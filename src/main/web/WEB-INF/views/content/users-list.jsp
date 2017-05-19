<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<a href="?action=add" class="add btn btn-primary">Добавить</a><br>
<div class="table-responsive">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>#</th>
            <th>Имя</th>
            <th>Фамилия</th>
            <th>E-mail</th>
            <th>Управление</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.users}" var="user">
            <tr class="<c:if test="${user.groupId == 1}">admin</c:if><c:if test="${!user.blocked}"> disabled</c:if>">
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.lastName}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td>
                    <a class="edit" href="?action=edit&id=<c:out value="${user.id}"/>">Редактировать</a>
                    <a class="delete" href="?action=delete&id=<c:out value="${user.id}"/>">Удалить</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>