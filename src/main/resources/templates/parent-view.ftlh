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
                    <th>Mother Name</th>
                    <th>Father Name</th>
                    <th>Tel.Phone</th>
                </tr>
            </thead>
            <tbody>
                <#list parents as parent>
                <tr>
                    <th scope="row">${parent.id}</th>
                    <td>${parent.motherName}</td>
                    <td>${parent.fatherName}</td>
                    <td>${parent.tp}</td>
                    <td><a href="/parent-update/${parent.id}" class="btn btn-warning" role="button">Update</a>
                    <a href="/parent-delete/${parent.id}" class="btn btn-danger" role="button">Delete</a></td>
                </tr>
                </#list>
            </tbody>
        </table>
    </div>
</body>
</html>