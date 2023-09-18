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
                    <th>Subject Name</th>
                    <th>Chapters</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <#list subjects as subject>
                <tr>
                    <th scope="row">${subject.id}</th>
                    <td>${subject.subName}</td>
                    <td>${subject.chapters}</td>
                    <td><a href="/subject-update/${subject.id}" class="btn btn-warning" role="button">Update</a>
                    <a href="/subject-delete/${subject.id}" class="btn btn-danger" role="button">Delete</a></td>
                </tr>
                </#list>
            </tbody>
        </table>
    </div>
</body>
</html>