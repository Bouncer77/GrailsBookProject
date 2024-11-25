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

        def newBook = new Book(request.JSON)
        newBook.update(flush: true)
/*
        Book book = Book.get(id)
        println "In DB: ${book}"
        println "---------"

        if (!book) {
            render status: NOT_FOUND
            return
        }

        def newBook = new Book(request.JSON)
        println "Input: ${newBook}"
        println "---------"

        newBook.setId(book.getId())
        println "Set ID: ${newBook}"
        println "---------"

        if (!newBook.update(flush: true)) {
            render status: UNPROCESSABLE_ENTITY
            return
        }*/

        withFormat {
            json { render newBook as JSON }
        }
    }

    // DELETE /api/books/${id}/delete
    def bookDelete(Integer id) {
        def book = Book.get(id)
        book.delete()
        println "Deleted: ${book}"

        /*def sql = new Sql(dataSource)
        try {
            sql.execute("DELETE FROM book WHERE id = ?", [id])
            render status: NO_CONTENT
        } catch (Exception e) {
            render status: INTERNAL_SERVER_ERROR, text: "Error deleting book: ${e.message}"
        } finally {
            sql.close()
        }*/
    }
}