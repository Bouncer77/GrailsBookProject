<div class="fieldcontain">
    <label for="title">Название</label>
    <g:textField name="title" value="${book?.title}"/>
</div>

<div class="fieldcontain">
    <label for="author">Автор</label>
    <g:textField name="author" value="${book?.author}"/>
</div>

<div class="fieldcontain">
    <label for="year">Год</label>
    <g:field type="number" name="year" value="${book?.year}"/>
</div>

<div class="fieldcontain">
    <label for="isbn">ISBN</label>
    <g:textField name="isbn" value="${book?.isbn}"/>
</div>