class UrlMappings {
    static mappings = {
        "/api/books"(controller: "book") {
            action = [GET: "getBooks", POST: "save"]
        }

        "/api/books/year/desc"(controller: "book") {
            action = [GET: "getBooksOrderByYearDesc"]
        }

        "/api/books/$id"(controller: "book") {
            action = [GET: "getBookById", PUT: "bookUpdate", DELETE: "bookDelete"]
        }
    }
}