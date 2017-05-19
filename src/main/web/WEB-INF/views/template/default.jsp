<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html lang="ru">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <title>${title}</title>

        <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
        <link href="/resources/css/dashboard.css" rel="stylesheet">

        <script
                src="https://code.jquery.com/jquery-3.2.1.min.js"
                integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
                crossorigin="anonymous"></script>

        <script
                src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.16.0/jquery.validate.min.js"
                crossorigin="anonymous"></script>
    </head>

    <body>
        <nav class="navbar navbar-toggleable-md navbar-inverse fixed-top bg-inverse">
            <button class="navbar-toggler navbar-toggler-right hidden-lg-up" type="button" data-toggle="collapse"
                    data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false"
                    aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <a class="navbar-brand" href="/dashboard/">Jagos</a>

            <div class="collapse navbar-collapse" id="navbarsExampleDefault">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="/about/">О проекте</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/help/">Помощь</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/faq/">FAQ</a>
                    </li>
                </ul>
                <div class="form-inline mt-2 mt-md-0">
                    <form action="/j_spring_security_logout" method="post" id="logoutForm">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">
                            Выход
                        </button>
                    </form>
                </div>
            </div>
        </nav>

        <div class="container-fluid">
            <div class="row">
                <nav class="col-sm-3 col-md-2 hidden-xs-down bg-faded sidebar">
                    <ul class="nav nav-pills flex-column">
                        <li class="nav-item">
                            <a class="nav-link" href="/dashboard/">Обзор</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/courses/">Курсы</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/users/">Пользователи</a>
                        </li>
                    </ul>
                </nav>

                <main class="col-sm-9 offset-sm-3 col-md-10 offset-md-2 pt-3">
                    <h1>${title}</h1>
                    <tiles:insertAttribute name="body"/>
                </main>
            </div>
        </div>
    </body>
</html>