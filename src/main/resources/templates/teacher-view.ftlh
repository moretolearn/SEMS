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
                    <th>Age</th>
                    <th>Email</th>
                    <th>Tel.Phone</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <#list teachers?sort_by("name") as teacher>
                <tr>
                    <th scope="row">${teacher.id}</th>
                    <td>${teacher.name}</td>
                    <td>${teacher.age}</td>
                    <td>${teacher.email}</td>
                    <td>${teacher.tp}</td>
                    <td><a href="/teacher-update/${teacher.id}" class="btn btn-warning" role="button">Update</a>
                    <a href="/teacher-delete/${teacher.id}" class="btn btn-danger" role="button">Delete</a></td>
                </tr>
                </#list>
            </tbody>
        </table>
    </div>
</body>
</html>