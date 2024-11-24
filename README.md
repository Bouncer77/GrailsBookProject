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
