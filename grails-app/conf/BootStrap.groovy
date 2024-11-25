import example.Book
import grails.converters.JSON

class BootStrap {
    def init = { servletContext ->
        // Настройка JSON рендеринга
        JSON.registerObjectMarshaller(Book) { Book book ->
            return [
                    id    : book.id,
                    name  : book.name,
                    author: book.author,
                    year  : book.year,
                    isbn  : book.description
            ]
        }


        environments {
            development {
                if (!Book.count()) {
                    new Book(
                            id: 1,
                            name: "1984",
                            author: "George Orwell",
                            year: 1949,
                            description: "978-0451524935"
                    ).save(failOnError: true)

                    new Book(
                            id: 2,
                            name: "Война и мир",
                            author: "Лев Толстой",
                            year: 1869,
                            description: "978-5170880851"
                    ).save(failOnError: true)

                    new Book(
                            id: 3,
                            name: "Мастер и Маргарита",
                            author: "Михаил Булгаков",
                            year: 1967,
                            description: "978-5170878895"
                    ).save(failOnError: true)

                    println "Добавлено ${Book.count()} тестовых книг"
                }
            }
        }
    }
}