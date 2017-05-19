<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form method="post" action="${action}" id="user-form">
    <div class="form-group">
        <label for="name">Ваше имя</label>
        <form:input path="name" cssClass="form-control" id="name"/>
    </div>
    <div class="form-group">
        <label for="lastName">Ваша фамилия</label>
        <form:input path="lastName" cssClass="form-control" id="lastName"/>
    </div>
    <div class="form-group">
        <label for="email">Электронная почта</label>
        <form:input path="email" cssClass="form-control" id="email"/>
    </div>
    <div class="form-group">
        <label for="password">Пароль</label>
        <form:password path="password" cssClass="form-control" id="password"/>
    </div>
    <div class="form-group">
        <label for="groupId">Группа</label>
        <form:select path="groupId" cssClass="form-control" id="groupId">
            <form:option value="0" disabled="true">Выберите группу</form:option>
            <form:options items="${groups}"/>
        </form:select>
    </div>
    <div class="form-check">
        <label class="form-check-label">
            <!--todo: исправить название флага на осмысленный-->
            <form:checkbox path="blocked" cssClass="form-check-input"/>
            Активен
        </label>
    </div>
    <form:hidden path="id"/>
    <button type="submit" class="btn btn-primary">Сохранить</button>
</form:form>

<script>
    $("#user-form").validate({
        rules: {
            name: {
                required: true,
                minlength: 3,
                maxlength: 20
            },
            lastName: {
                required: true,
                minlength: 3,
                maxlength: 20
            },
            email: {
                required: true,
                email: true,
                minlength: 6,
                maxlength: 20
            },
            password: {
                required: true,
                minlength: 8,
            },
            groupId: {
                required: true,
            }
        }
    });
</script>