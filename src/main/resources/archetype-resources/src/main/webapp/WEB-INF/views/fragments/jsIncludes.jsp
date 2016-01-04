<!DOCTYPE html>

<html xmlns:th="http://www.thymeleaf.org">
<head>
</head>
<body>
<div th:fragment="jsIncludes">
<!-- JS Core -->
<script src="${pageContext.request.contextPath}/resources/jquery/js/jquery-2.1.1.js"
        th:src="@{resources/jquery/js/jquery-2.1.1.js}" type="text/javascript"></script>
</div>
</body>
</html>



