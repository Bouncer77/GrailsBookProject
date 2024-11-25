# GrailsBookProject
Grails 2.5.6 -> Grails 3.3.15

Стек: Grails 2.5.6, Java 8. В качестве БД можно использовать Postgresql или какую-то встроенную (h2 например)
Реализовать приложение для выставления оценки книге.  Требуется только API без какого либо веб приложения. 
Приложением будут пользоваться только анонимные пользователи. Т.е. не нужно реализовывать форму регистрации и входа.
Доступные действия:

получить список книг
добавить книгу
удалить книгу
изменить информацию о книге - наименование книги, изображение обложки книги, автор, год издания, краткое описание книги
выставить оценку книге - максимальная оценка 5, минимальная 1. Анонимный пользователь может выставить только один раз оценку. Итоговая оценка книги формируется как средняя оценка.
Во время реализации должны использоваться:

сервисы
контроллеры
доменные классы
транзакции - в качестве транзакции нужно использовать static transactional = true
Дополнительно (если время останется. Не обязательная часть):
написать bash скрипт который переведет c Grails 2.5.6 на Grails 3.3.15.

# Особенности 

Убедитесь, что версия Groovy, которую вы указываете, совместима с версией Grails, которую вы используете. Например, Grails 2.5.x обычно использует Groovy 2.4.x.

Для нашей версии Grails 2.5.6 используется либа groovy-2.4.21 и Java 8 (8.0.392-zulu)

# Examples

`http://localhost:8080/example/api/books`

```json
[
  {
    "id": 1,
    "name": "1984",
    "author": "George Orwell",
    "year": 1949,
    "isbn": "978-0451524935"
  },
  {
    "id": 2,
    "name": "Война и мир",
    "author": "Лев Толстой",
    "year": 1869,
    "isbn": "978-5170880851"
  },
  {
    "id": 3,
    "name": "Мастер и Маргарита",
    "author": "Михаил Булгаков",
    "year": 1967,
    "isbn": "978-5170878895"
  }
]
```
