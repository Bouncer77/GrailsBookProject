package example

class Book {
    String title
    String author
    Integer year
    String isbn

    static constraints = {
        title blank: false
        author blank: false
        year nullable: false, min: 1000
        isbn nullable: true
    }

    String toString() {
        "${title} by ${author}"
    }
}