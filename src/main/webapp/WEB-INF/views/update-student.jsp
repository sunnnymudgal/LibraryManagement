    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    <head>
        <title>Library Management</title>
    </head>
    <body>

    <h1>Edit Student</h1>
        <form action="/id/{studentId}">
            <label for="studentId">Student ID:</label>
            <input type="text" id="studentId" required><br><br>
            <label for="studentName">Student Name:</label>
            <input type="text" id="studentName"><br><br>
            <button type="submit">Update</button>
        </form>

    </body>
    </html>
