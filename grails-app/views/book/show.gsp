<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main">
        <title>Просмотр книги</title>
    </head>
    <body>
        <div class="nav" role="navigation">
            <ul>
                <li><g:link class="list" action="index">К списку книг</g:link></li>
                <li><g:link class="create" action="create">Создать новую книгу</g:link></li>
            </ul>
        </div>
        <div id="show-book" class="content scaffold-show">
            <h1>Просмотр книги</h1>
            <g:if test="${flash.message}">
                <div class="message">${flash.message}</div>
            </g:if>
            <ol class="property-list book">
                <li class="fieldcontain">
                    <span class="property-label">Название:</span>
                    <span class="property-value">${book.title}</span>
                </li>
                <li class="fieldcontain">
                    <span class="property-label">Автор:</span>
                    <span class="property-value">${book.author}</span>
                </li>
                <li class="fieldcontain">
                    <span class="property-label">Год:</span>
                    <span class="property-value">${book.year}</span>
                </li>
                <li class="fieldcontain">
                    <span class="property-label">ISBN:</span>
                    <span class="property-value">${book.isbn}</span>
                </li>
            </ol>
            <g:form>
                <g:hiddenField name="id" value="${book?.id}"/>
                <div class="buttons">
                    <g:link class="edit" action="edit" id="${book?.id}">Редактировать</g:link>
                    <g:actionSubmit class="delete" action="delete" value="Удалить" 
                        onclick="return confirm('Вы уверены?');"/>
                </div>
            </g:form>
        </div>
    </body>
</html>