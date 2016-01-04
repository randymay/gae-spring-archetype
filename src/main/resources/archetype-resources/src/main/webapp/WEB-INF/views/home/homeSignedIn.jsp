<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Welcome to the Spring GAE Bootstrap application! Congratulations for signing up!</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

    <div th:replace="fragments/cssIncludes :: cssIncludes">CSS Includes</div>

</head>
<body>

<div th:replace="fragments/header :: header">Header</div>

<div class="container-fluid">
    <div id="row-fluid">
        <h3 class="page-title">
            You have successfully logged in!
        </h3>
    </div>
</div>

<div th:replace="fragments/jsIncludes :: jsIncludes"></div>

<div th:replace="fragments/footer :: footer"></div>

</body>
</html>