package example

import grails.converters.JSON

class BookController {
    static responseFormats = ['json']
    static allowedMethods = [
            save: "POST",
            update: "PUT",
            delete: "DELETE"
    ]

    // GET /book
    def index() {
        def books = Book.list()
        withFormat {
            json { render books as JSON }
        }
    }

    // GET /book/${id}
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

    // POST /book
    def save() {
        def book = new Book(request.JSON)
        if (!book.save(flush: true)) {
            render status: UNPROCESSABLE_ENTITY
            return
        }

        response.status = CREATED.value()
        withFormat {
            json { render book as JSON }
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