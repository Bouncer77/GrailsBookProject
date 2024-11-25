package example

class BookController {
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index() {
        respond Book.list(params), model:[bookCount: Book.count()]
    }

    def show(Book book) {
        respond book
    }

    def create() {
        respond new Book(params)
    }

    def save(Book book) {
        if (book == null) {
            notFound()
            return
        }

        if (book.hasErrors()) {
            respond book.errors, view:'create'
            return
        }

        book.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = "Книга успешно создана"
                redirect book
            }
            '*' { respond book, [status: CREATED] }
        }
    }

    def edit(Book book) {
        respond book
    }

    def update(Book book) {
        if (book == null) {
            notFound()
            return
        }

        if (book.hasErrors()) {
            respond book.errors, view:'edit'
            return
        }

        book.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = "Книга успешно обновлена"
                redirect book
            }
            '*'{ respond book, [status: OK] }
        }
    }

    def delete(Book book) {
        if (book == null) {
            notFound()
            return
        }

        book.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = "Книга успешно удалена"
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = "Книга не найдена"
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}