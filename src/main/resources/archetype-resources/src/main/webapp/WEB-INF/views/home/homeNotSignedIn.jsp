<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Welcome to the Spring GAE Bootstrap application! Get started quickly by signing up!</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

    <div th:replace="fragments/cssIncludes :: cssIncludes">CSS Includes</div>

</head>
<body>

<div th:replace="fragments/header :: header">Header</div>

<div>
    <div>
        <h3>
            Please sign in
        </h3>

        <div>
            <a href="" th:href="@{loginURL}">Sign in</a>
        </div>
    </div>
</div>

<div th:replace="fragments/jsIncludes :: jsIncludes"></div>

<div th:replace="fragments/footer :: footer"></div>

</body>
</html>