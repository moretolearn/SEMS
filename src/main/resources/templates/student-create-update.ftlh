<#import "/spring.ftl" as spring>
<#include "menu.ftlh">
<!doctype html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="<@spring.url 'css/style.css'/>">
<script src="<@spring.url 'js/Jquery.js'/>"></script>
<script src="<@spring.url 'js/CustomJS.js'/>"></script>
</head>
<body>
    <div class="container">
        <h1>
            <#if !isUpdate>Create</#if>
            <#if isUpdate>Update</#if>
            Student
        </h1>
        <div>
            <form id="student_form" action="<#if isUpdate>/student-update/${student.id}</#if><#if !isUpdate>/student-parent-create</#if>" method="post">
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
                            <td><div name="id">${student.id}</div></td>
                        </tr>
                        </#if>
                        <tr>
                            <th>Name</th>
                            <@spring.bind "student.name" /> 
                            <td><input type="text" id="names" name="${spring.status.expression}" value="${spring.status.value?default("")}"/><h6 id="namecheck"style="color: red;">**Name is required</h6></td>
                        </tr>
                        <tr>
                            <th>Grade</th>
                            <@spring.bind "student.grade"/>
                            <td><input type="text" id="grade" name="${spring.status.expression}" value="${spring.status.value?default("")}"/><h6 id="gradecheck"style="color: red;">**Grade is required</h6></td>
                        </tr>
                        <tr>
                            <th>Age</th>
                            <@spring.bind "student.age"/>
                            <td><input type="text" id="age" name="${spring.status.expression}" value="${spring.status.value?default("")}"/><h6 id="agecheck"style="color: red;">**Age is required</h6></td>
                        </tr>
                        <tr>
                            <th>Class</th>
                            <@spring.bind "student.clz"/>
                            <td><input type="text" id="clz" name="${spring.status.expression}" value="${spring.status.value?default("")}"/><h6 id="clzcheck"style="color: red;">**Class is required</h6></td>
                        </tr>
                        <tr>
                            <th>Tel.Phone</th>
                            <@spring.bind "student.tp"/>
                            <td><input type="text" id="tp" name="${spring.status.expression}" value="${spring.status.value?default("")}"/><h6 id="tpcheck"style="color: red;">**Tel.Phone is required</h6></td>
                        </tr>
                        <tr>
                            <th>Email</th>
                            <@spring.bind "student.email"/>
                            <td><input type="text" id="email" name="${spring.status.expression}" value="${spring.status.value?default("")}"/><h6 id="emailcheck"style="color: red;">**Email is required</h6></td>
                        </tr>
                        <#if !isUpdate>
                        <tr><th colspan="2">
                        <h1>
            			<#if !isUpdate>Create</#if>
            			<#if isUpdate>Update</#if>
            			Parent
        				</h1></th>
        				</tr>
        				<tr>
                            <th>Mother Name</th>
                            <@spring.bind "parent.motherName"/>
                            <td><input type="text" id="motherName" name="${spring.status.expression}" value="${spring.status.value?default("")}"/><h6 id="mnamecheck"style="color: red;">**Mother Name is required</h6></td>
                            
                        </tr>
                        <tr>
                            <th>Father Name</th>
                            <@spring.bind "parent.fatherName"/>
                            <td><input type="text" id="fatherName" name="${spring.status.expression}" value="${spring.status.value?default("")}"/><h6 id="fnamecheck"style="color: red;">**Father Name is required</h6></td>
                        </tr>
                        <tr>
                            <th>Tel.Phone</th>
                            <@spring.bind "parent.tp"/>
                            <td><input type="text" id="ptp" name="${spring.status.expression}" value="${spring.status.value?default("")}"/><h6 id="ptpcheck"style="color: red;">**Tel.Phone is required</h6></td>
                        </tr>
                        </#if>
                    </tbody>
                </table>
                <input type="submit" id="submitbtn" value="Save" class="btn btn-primary">
				<input type="reset" id="resetbtn" value="Reset" class="btn btn-primary">
            </form>
        </div>
    </div>
</body>
</html>