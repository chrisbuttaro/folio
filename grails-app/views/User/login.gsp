<%--
  Created by IntelliJ IDEA.
  User: chris
  Date: 2019-08-14
  Time: 14:37
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login</title>
    <g:external dir="css" file="bootstrap.css"/>
    <meta name="layout" content="main" />
    <asset:javascript src="application.js"/>
    <asset:stylesheet src="application.css"/>
</head>
<body>
<g:hasErrors>
    <div class="errors">
        <g:renderErrors bean="${ulc}" as="list" />
    </div>
</g:hasErrors>
<g:form action="loginUser">
    <br><br><br><br>
    <div class="container">
        <div class="row">
            <div class="col">
            </div>
            <div class="col">
                <div class="form-group">
                <asset:image src="logo.png" class="grails-logo"/>
                <br><br>
                    <g:textField name="username" value="${ulc.username}" placeholder="Username"/>
                </div>
                <div class="form-group">
                    <g:passwordField name="password" placeholder="Password"/>
                </div>
                <div class="form-group">
                    <g:submitButton class="btn btn-primary" name="login" value="Login"/>
                </div>
            </div>
            <div class="col">
            </div>
        </div>
    </div>
</g:form>
</body>
</html>