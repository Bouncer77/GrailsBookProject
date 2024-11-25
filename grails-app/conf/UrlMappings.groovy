class UrlMappings {
    static mappings = {
        "/api/books"(controller: "book") {
            action = [GET: "getBooks", POST: "save"]
        }

        "/api/books/year/desc"(controller: "book") {
            action = [GET: "getBooksOrderByYearDesc"]
        }

        "/api/books/$id"(controller: "book") {
            action = [GET: "getBookById", POST: "update", DELETE: "bookDelete"]
        }


        "/api/students"(controller: "student") {
            action = [GET: "index", POST: "save"]
        }

        "/api/students/$id"(controller: "student") {
            action = [GET: "show", DELETE: "delete"]
        }

        "/api/students/create"(controller: "student") {
            action = [GET: "create"]
        }
    }
}