<#include "menu.ftlh">
<!doctype html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script src="js/Jquery.js"></script>
<script src="js/CustomJS.js"></script>
</head>
<body>
    <div class="container">
        <h1 data-idtest=${isUpdate???c} id="h1tag">
            <#if !isUpdate>Create</#if>
            <#if isUpdate>Update</#if>
            Subject
        </h1>
        <div>
            <form action="<#if isUpdate>/subject-update/${subject.id}</#if><#if !isUpdate>/subject-create</#if>" name="subject" method="post">
                <table class="table border border-primary">
                    <#--<tbody>
                    <thead>
                        <tr>
                            <th>Field</th>
                            <th>Value</th>
                        </tr>
                    </thead>
                    <tbody> -->
                        <#if isUpdate>
                        <tr>
                            <th>ID</th>
                            <td><div name="id">${subject.id}</div></td>
                        </tr>
                        </#if>
                        <tr>
                            <th>Name</th>
                            <td><input type="text" name="subName" value="<#if subject.subName??>${subject.subName}</#if>" /></td>
                        </tr>
                        <tr>
                            <th>Grade</th>
                            <td><input type="text" name="chapters" value="<#if subject.chapters??>${subject.chapters}</#if>" /></td>
                        </tr>
                    </tbody>
                </table>
                <input type="submit" id="submitbtn" value="Save" class="btn btn-primary">
				<input type="reset" id="resetbtn" value="Reset" class="btn btn-primary">
            </form>
        </div>
    </div>
</body>
</html>