<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form name="loginForm" class="form-signin" action="<c:url value='j_spring_security_check' />" method="post">
    <h2 class="form-signin-heading">${title}</h2>
    <label for="username" class="sr-only">E-mail</label>
    <input name="username" type="username" id="username" class="form-control" placeholder="E-mail" required autofocus value="">
    <label for="password" class="sr-only">Пароль</label>
    <input name="password" type="password" id="password" class="form-control" placeholder="Пароль" required value="">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <c:if test="${not empty error}">
        <div class="error" style="margin-bottom: 10px; color: red;">${error}</div>
    </c:if>
    <c:if test="${not empty msg}">
        <div class="msg" style="margin-bottom: 10px;">${msg}</div>
    </c:if>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>
</form>