<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<a href="?action=add" class="add btn btn-primary">Добавить</a><br>
<div class="table-responsive">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>#</th>
            <th>Название</th>
            <th>Описание</th>
            <th>Автор</th>
            <th>Управление</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.courses}" var="course">
            <tr>
                <td><c:out value="${course.id}"/></td>
                <td><c:out value="${course.title}"/></td>
                <td><c:out value="${course.description}"/></td>
                <td><c:out value="${course.authorId}"/></td>
                <td>
                    <a class="edit" href="?action=edit&id=<c:out value="${course.id}"/>">Редактировать</a>
                    <a class="delete" href="?action=delete&id=<c:out value="${course.id}"/>">Удалить</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>