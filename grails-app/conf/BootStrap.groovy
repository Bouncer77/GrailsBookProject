import example.Book
import grails.converters.JSON

class BootStrap {
    def init = { servletContext ->
        // Настройка JSON рендеринга
        JSON.registerObjectMarshaller(Book) { Book book ->
            return [
                    id          : book.id,
                    name        : book.name,
                    author      : book.author,
                    year        : book.year,
                    description : book.description
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
                            name: "War and Peace",
                            author: "Leo Tolstoy",
                            year: 1869,
                            description: "978-5170880851"
                    ).save(failOnError: true)

                    new Book(
                            id: 3,
                            name: "The Master and Margarita",
                            author: "Mikhail Bulgakov",
                            year: 1967,
                            description: "978-5170878895"
                    ).save(failOnError: true)

                    println "Added ${Book.count()} tests books"
                }
            }
        }
    }
}