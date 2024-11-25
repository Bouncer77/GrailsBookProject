<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main">
        <title>Редактировать книгу</title>
    </head>
    <body>
        <div class="nav" role="navigation">
            <ul>
                <li><g:link class="list" action="index">К списку книг</g:link></li>
            </ul>
        </div>
        <div id="edit-book" class="content scaffold-edit">
            <h1>Редактировать книгу</h1>
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
            <g:form method="PUT" id="${book?.id}">
                <g:render template="form"/>
                <div class="buttons">
                    <g:actionSubmit class="save" action="update" value="Обновить"/>
                    <g:actionSubmit class="delete" action="delete" value="Удалить" 
                        onclick="return confirm('Вы уверены?');"/>
                </div>
            </g:form>
        </div>
    </body>
</html>