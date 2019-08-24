<%--
  Created by IntelliJ IDEA.
  User: chris
  Date: 2019-08-14
  Time: 14:37
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Register</title>
    <g:external dir="css" file="bootstrap.css"/>
    <meta name="layout" content="main" />
    <asset:javascript src="application.js"/>
    <asset:stylesheet src="application.css"/>
</head>
<body>
<g:hasErrors>
    <div class="errors">
        <g:renderErrors bean="${urc}" as="list" />
    </div>
    <div class="errors">
        <g:renderErrors bean="${user}" as="list" />
    </div>
    <div>
    </div>
</g:hasErrors>
<g:form action="registerUser">
    <br><br><br><br>
    <div class="container">
        <div class="row">
            <div class="col">
            </div>
            <div class="col">
                <asset:image src="logo.png" class="grails-logo"/>
                <br><br>
                <div class="form-group">
                    <g:textField name="firstName" value="${urc.firstName}" placeholder="First Name"/>
                </div>
                <div class="form-group">
                    <g:textField name="lastName"  value="${urc.lastName}" placeholder="Last Name"/>
                </div>
                <div class="form-group">
                    <g:textField name="email" value="${urc.email}" placeholder="Email"/>
                </div>
                <div class="form-group">
                    <g:textField name="username" value="${urc.username}" placeholder="Username"/>
                </div>
                <div class="form-group">
                    <g:passwordField name="password" placeholder="Password"/>
                </div>
                <div class="form-group">
                    <g:passwordField name="secondPassword" placeholder="Re-Enter Password"/>
                </div>
                <div class="form-group">
                    <g:submitButton class="btn btn-primary" name="register" value="Register"/>
                </div>
                <br>
                Already have an account? <g:link controller="user" action="login">Sign In</g:link>
            <div class="col">
            </div>
        </div>
    </div>
</g:form>

</body>
</html>