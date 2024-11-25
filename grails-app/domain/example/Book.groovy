package example

class Book {

    // public static int count = 0
    // private static List<Book> books = new ArrayList<>()

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

    Book(Book book) {
        this.id = book.id
        this.name = book.name
        this.author = book.author
        this.year = book.year
        this.description = book.description
    }

    Book(Integer id, String name, String author, Integer year, String description) {
        this.id = id
        this.name = name
        this.author = author
        this.year = year
        this.description = description
    }

    Book(Map json) {
        this.id = json.id as Integer
        this.name = json.name
        this.author = json.author
        this.year = json.year as Integer
        this.description = json.description
    }

    static constraints = {
        name blank: false
        author blank: false
        year nullable: false, min: 1000
        description nullable: true
    }

    Integer getId() {
        return id
    }

    void setId(Integer id) {
        this.id = id
    }

    String getName() {
        return name
    }

    String getAuthor() {
        return author
    }

    Integer getYear() {
        return year
    }

    String getDescription() {
        return description
    }

    static getConstraints() {
        return constraints
    }

    @Override
    String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", description='" + description + '\'' +
                '}';
    }
}