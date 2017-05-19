<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<section class="row text-center placeholders">
    <div class="col-6 col-sm-3 placeholder">
        <div class="cicle-slide cicle-green">${coursesCount}</div>
        <h4>Курсов</h4>
        <span class="text-muted">добавлено на сайт</span>
    </div>
    <div class="col-6 col-sm-3 placeholder">
        <div class="cicle-slide cicle-blue">${lessonsCount}</div>
        <h4>Уроков</h4>
        <span class="text-muted">во всех курсах</span>
    </div>
    <div class="col-6 col-sm-3 placeholder">
        <div class="cicle-slide cicle-red">${usersCount}</div>
        <h4>Пользователей</h4>
        <span class="text-muted">зарегистрировано на сайте</span>
    </div>
    <div class="col-6 col-sm-3 placeholder">
        <div class="cicle-slide cicle-yellow">57</div>
        <h4>Комментариев</h4>
        <div class="text-muted">оставлено пользователями</div>
    </div>
</section>
<style>
    .cicle-slide {
        background-color: #00DC83;
        border-radius: 50%;
        text-align: center;
        padding-top: 65px;
        font-weight: bold;
        font-size: 3rem;
        width: 200px;
        height: 200px;
        margin: 1.5rem auto;
    }
    .cicle-green {
        background-color: #00DC83;
    }
    .cicle-blue {
        background-color: #0275D8;
    }
    .cicle-red {
        background-color: #E32636;
    }
    .cicle-yellow {
        background-color: #FFBA00;
    }

</style>