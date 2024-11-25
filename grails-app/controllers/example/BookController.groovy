package example

import grails.converters.JSON
import org.springframework.http.HttpStatus

class BookController {
    static responseFormats = ['json']
    static allowedMethods = [
            save: "POST",
            update: "PUT",
            delete: "DELETE"
    ]

    // GET /api/books
    def index() {
        def books = Book.list()
        withFormat {
            json { render books as JSON }
        }
    }

    // GET /api/books/${id}
    def show(Long id) {
        def book = Book.get(id)
        if (!book) {
            render status: NOT_FOUND
            return
        }
        withFormat {
            json { render book as JSON }
        }
    }

    /*// Обработчик ошибок 500 серверная ошибка
    def handleError(Exception e) {
        log.error("An error occurred: ${e.message}", e)
        render status: HttpStatus.INTERNAL_SERVER_ERROR
    }

    // Обработчик ошибок 404 не найден
    def handleError404() {
        log.error("An error occurred: ${e.message}", e)
        render status: HttpStatus.NOT_FOUND
    }*/

    // POST /api/books
    def save() {
        try {
            def book = new Book(request.JSON)

            println "Input: ${book}"

            if (!book.save(flush: true)) {
                render status: UNPROCESSABLE_ENTITY
                return
            }
            return
            response.status = HttpStatus.CREATED
            withFormat {
                json { render book as JSON }
            }
        } catch (Exception e) {
            handleError(e)
        }
    }



    // PUT /book/${id}
    def update(Long id) {
        def book = Book.get(id)
        if (!book) {
            render status: NOT_FOUND
            return
        }

        book.properties = request.JSON
        if (!book.save(flush: true)) {
            render status: UNPROCESSABLE_ENTITY
            return
        }

        withFormat {
            json { render book as JSON }
        }
    }

    // DELETE /book/${id}
    def delete(Long id) {
        def book = Book.get(id)
        if (!book) {
            render status: NOT_FOUND
            return
        }

        book.delete(flush: true)
        render status: NO_CONTENT
    }

    // GET /book/search?q=${query}
    def search() {
        def query = params.q
        def books = Book.createCriteria().list {
            or {
                ilike('title', "%${query}%")
                ilike('author', "%${query}%")
                ilike('isbn', "%${query}%")
            }
        }

        withFormat {
            json { render books as JSON }
        }
    }
}