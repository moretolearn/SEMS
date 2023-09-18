<#include "menu.ftlh">
<!doctype html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        
        <table class="table border border-primary">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Grade</th>
                    <th>Age</th>
                    <th>Email</th>
                     <th>Class</th>
                    <th>Tel.Phone</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <#list students as student>
                <tr>
                    <th scope="row">${student.id}</th>
                    <td>${student.name}</td>
                    <td>${student.grade}</td>
                    <td>${student.age}</td>
                    <td>${student.email}</td>
                    <td>${student.clz}</td>
                    <td>${student.tp}</td>
                    <td><a href="/student-update/${student.id}" class="btn btn-warning" role="button">Update</a>
                    <a href="/student-delete/${student.id}" class="btn btn-danger" role="button">Delete</a></td>
                </tr>
                </#list>
            </tbody>
        </table>
    </div>
</body>
</html>