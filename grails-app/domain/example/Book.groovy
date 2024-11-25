package example

class Book {

    // Уникальный идентификатор книги
    Integer id

    // наименование книги
    String name

    // изображение обложки книги
    // String img

    // автор
    String author

    // год издания
    Integer year

    // краткое описание книги
    String description

    // оценку книге - максимальная оценка 5, минимальная 1
    // Integer score

    static constraints = {
        name blank: false
        author blank: false
        year nullable: false, min: 1000
        description nullable: true
    }

    String toString() {
        "${name} by ${author}"
    }
}