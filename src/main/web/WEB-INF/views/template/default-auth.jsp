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
    <link href="/resources/css/signin.css" rel="stylesheet">
</head>

<body>

<div class="container">
    <tiles:insertAttribute name="body"/>
</div> <!-- /container -->
</body>
</html>