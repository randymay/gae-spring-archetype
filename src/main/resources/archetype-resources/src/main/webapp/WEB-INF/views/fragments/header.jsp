<!DOCTYPE html>

<html xmlns:th="http://www.thymeleaf.org">
<head>
</head>
<body>
<nav th:fragment="header">
    <div>

        <ul class="nav navbar-nav navbar-right">
            <li th:switch="${user}">
                <a th:case="${null}" href="${loginURL}" th:href="@{${loginURL}}">
                    <i class="glyphicon glyphicon-log-in"></i>
                    Sign in
                </a>
                <a th:case="*" href="${logoutURL}" th:href="@{${logoutURL}}"
                   class="btn display-block font-normal btn-danger">
                    <i class="glyphicon glyphicon-log-out"></i>
                    Sign out
                </a>
            </li>
        </ul>
    </div>
</nav>
</body>
</html>