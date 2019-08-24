<%--
  Created by IntelliJ IDEA.
  User: chris
  Date: 2019-08-22
  Time: 08:43
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>${params.id}</title>
    <g:external dir="css" file="bootstrap.css"/>
    <asset:javascript src="application.js"/>
</head>

<body>

<g:render template="menubar"/>
<br>
<g:if test="${user.username == session.user?.username}">
    <button type="button" class="btn btn-outline-primary" data-toggle="modal" data-target="#addPhotoModal">Add Photo</button>
    <button type="button" class="btn btn-outline-secondary">Secondary</button>
    <button type="button" class="btn btn-outline-success">Success</button>
    <button type="button" class="btn btn-outline-danger">Danger</button>
    <button type="button" class="btn btn-outline-warning">Warning</button>
    <button type="button" class="btn btn-outline-info">Info</button>
    <button type="button" class="btn btn-outline-light">Light</button>
    <button type="button" class="btn btn-outline-dark">Dark</button>
    <br>
    ${params.id}
</g:if>
<g:elseif test="${session.user != null}">
    ${params.id}
    <br>
    Logged in as ${session.user.username}
</g:elseif>
<g:else>
    <g:link controller="user" action="login">Sign In</g:link>
</g:else>

<!-- Create Gallery Modal -->
<div id="addPhotoModal" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Add Photo</h4>
            </div>
            <div class="modal-body">
                <g:uploadForm controller="image" action="createGalImage" id="${gallery.name}">
                    <g:textField name="name" value="${name}" placeholder="Image Name"/>
                    New Photo: <input name="src" value="${src}" type="file"/>
                    <g:submitButton class="btn btn-primary" name="create" value="Create"/>
                    <g:hiddenField name="user" value="${user}" />
                </g:uploadForm>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<g:set var="counter" value="${0}" />
<g:each var="image" in="${gallery}">
    <g:if test="${(counter % 4) == 0}">
        <div class="row">
        <div class="col-md-2">
        </div>
    </g:if>
    <div class="col-md-2">
        <div class="container">
            <img src="${createLink(controller:'image', action:'renderImage', id:image.name)}" class=image alt="Responsive image"/>
            <div class="overlay">
                <g:link controller='gallery' action='gallery' id='${gallery.name}'>yello link?</g:link>
            </div>
        </div>
    </div>
    <g:set var="counter" value="${counter + 1}" />
    <g:if test="${(counter % 4) == 0}">
        </div>
    </g:if>
</g:each>

</body>
</html>