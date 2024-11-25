class UrlMappings {
    static mappings = {
        "/api/books"(controller: "book") {
            action = [GET: "index", POST: "save"]
        }

        "/api/books/$id"(controller: "book") {
            action = [GET: "show", PUT: "update", DELETE: "delete"]
        }

        "/api/books/search"(controller: "book") {
            action = [GET: "search"]
        }

        "500"(GET: '/handleError')
        "404"(GET: '/handleError404')

    }
}