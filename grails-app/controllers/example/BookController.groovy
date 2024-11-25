package example

import grails.converters.JSON
import groovy.sql.Sql

import javax.sql.DataSource

class BookController {

    static transactional = true

    static responseFormats = ['json']

    DataSource dataSource

    // GET /api/indexCustom
    def getBooksOrderByYearDesc() {
        def sql = new Sql(dataSource)
        def books = []

        sql.eachRow('SELECT * FROM book') { row ->
            books << [
                    id: row.id,
                    name: row.name,
                    author: row.author,
                    year: row.year,
                    description: row.description
            ]
        }

        sql.close()

        render books as JSON
    }

    // GET /api/books
    def getBooks() {
        def books = Book.list(sort: "year")
        withFormat {
            json { render books as JSON }
        }
    }

    // GET /api/books/${id}
    def getBookById(Integer id) {
        def book = Book.get(id)
        if (!book) {
            render status: NOT_FOUND
            return
        }
        withFormat {
            json { render book as JSON }
        }
    }

    // POST /api/books
    def save() {
        def book = new Book(request.JSON)
        println "Input: ${book}"
        book.save()

        withFormat {
            json { render book as JSON }
        }
    }


    // PUT /api/books/${id}
    def update(Integer id) {

        Book book = Book.get(id)
        Book newBook = new Book(request.JSON)
        newBook.setId(book.getId())

        newBook.update(flush: true)

        withFormat {
            json { render newBook as JSON }
        }
    }

    // DELETE /api/books/${id}
    def bookDelete(Integer id) {

        println "Deleted: ${id}"
        def book = Book.get(id)

        // book.delete() // не работает

        def sql = new Sql(dataSource)
        try {
            sql.execute("DELETE FROM book WHERE id = ?", [id])
        } catch (Exception e) {
            render status: INTERNAL_SERVER_ERROR, text: "Error deleting book: ${e.message}"
        } finally {
            sql.close()
        }

        println "Deleted: ${book}"

        withFormat {
            json { render book as JSON }
        }
    }
}