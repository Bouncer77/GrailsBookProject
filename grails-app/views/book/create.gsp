<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main">
        <title>Создать новую книгу</title>
    </head>
    <body>
        <div class="nav" role="navigation">
            <ul>
                <li><g:link class="list" action="index">К списку книг</g:link></li>
            </ul>
        </div>
        <div id="create-book" class="content scaffold-create">
            <h1>Создать новую книгу</h1>
            <g:if test="${flash.message}">
                <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${book}">
                <ul class="errors" role="alert">
                    <g:eachError bean="${book}" var="error">
                        <li><g:message error="${error}"/></li>
                    </g:eachError>
                </ul>
            </g:hasErrors>
            <g:form action="save">
                <g:render template="form"/>
                <div class="buttons">
                    <g:submitButton name="create" class="save" value="Создать"/>
                </div>
            </g:form>
        </div>
    </body>
</html>