<#import "/spring.ftl" as spring>
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
        <h1>
            <#if !isUpdate>Create</#if>
            <#if isUpdate>Update</#if>
            Teacher
        </h1>
        <div>
            <form id="teacher-form" action="<#if isUpdate>/teacher-update/${teacher.id}</#if><#if !isUpdate>/teacher-create</#if>" method="post">
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
                            <td><div name="id">${teacher.id}</div></td>
                        </tr>
                        </#if>
                       	<div>
                        <tr>
                            <th>Name</th>
                            <@spring.bind "teacher.name"/> 
                            <td><input type="text" id="name" name="${spring.status.expression}" value="${spring.status.value?default("")}"/></td>
                        </tr>
                        </div>
                        <tr>
                        <th>Subject</th>
                        <td>
                        <@spring.bind "teacher.subjects"/> 
                        <select name="${spring.status.expression}">
  						<#list subjects as subject>
    					<option value="${subject.id}">${subject.subName}</option>
  						</#list>
						</select>
                        </td>
                        </tr>
                        <tr>
                            <th>Age</th>
                            <@spring.bind "teacher.age"/> 
                            <td><input type="text" id="age" name="${spring.status.expression}" value="${spring.status.value?default("")}"/></td>
                        </tr>
                        <tr>
                        
                        3
                        
                            <th>Tel.Phone</th>
                            <@spring.bind "teacher.tp"/> 
                            <td><input type="text" id="tp" name="${spring.status.expression}" value="${spring.status.value?default("")}"/></td>
                        </tr>
                        <tr>
                            <th>Email</th>
                            <@spring.bind "teacher.email" /> 
                            <td><input type="text" id="email" name="${spring.status.expression}" value="${spring.status.value?default("")}"/></td>
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