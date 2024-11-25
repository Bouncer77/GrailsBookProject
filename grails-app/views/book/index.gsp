<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main">
        <title>Список книг</title>
    </head>
    <body>
        <div class="nav" role="navigation">
            <ul>
                <li><g:link class="create" action="create">Добавить книгу</g:link></li>
            </ul>
        </div>
        <div id="list-book" class="content scaffold-list">
            <h1>Список книг</h1>
            <g:if test="${flash.message}">
                <div class="message">${flash.message}</div>
            </g:if>
            <table>
                <thead>
                    <tr>
                        <th>Название</th>
                        <th>Автор</th>
                        <th>Год</th>
                        <th>ISBN</th>
                        <th>Действия</th>
                    </tr>
                </thead>
                <tbody>
                    <g:each in="${bookList}" var="book">
                        <tr>
                            <td>${book.title}</td>
                            <td>${book.author}</td>
                            <td>${book.year}</td>
                            <td>${book.isbn}</td>
                            <td>
                                <g:link action="show" id="${book.id}">Просмотр</g:link>
                                <g:link action="edit" id="${book.id}">Редактировать</g:link>
                            </td>
                        </tr>
                    </g:each>
                </tbody>
            </table>
        </div>
    </body>
</html>