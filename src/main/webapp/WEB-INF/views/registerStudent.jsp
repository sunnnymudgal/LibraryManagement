<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Library Management</title>
</head>
<body>

<div>
    <div>
        <div>
            <div>
                <h2>REGISTER A STUDENT HERE</h2>
            </div>

            <div>
                <form:form action="/home/register-process" method="POST" modelAttribute="student">
                    <div>
                        <label for="id">Student ID</label>
                        <div>
                            <form:input path="id" autocomplete="off" />
                        </div>
                    </div>

                    <div>
                        <label for="name">Student Name</label>
                        <div>
                            <form:input path="studentName" />
                        </div>
                    </div>

                    <div>
                        <button type="submit">Register</button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>

</body>
</html>
