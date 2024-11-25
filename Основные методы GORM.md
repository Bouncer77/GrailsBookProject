1. **`list`**: Возвращает список всех объектов данного доменного класса.
   ```groovy
   def books = Book.list()
   ```

2. **`get`**: Возвращает объект по его идентификатору.
   ```groovy
   def book = Book.get(id)
   ```

3. **`save`**: Сохраняет объект в базе данных. Можно использовать с параметром `flush: true` для немедленного
   сохранения.
   ```groovy
   book.save(flush: true)
   ```

4. **`delete`**: Удаляет объект из базы данных.
   ```groovy
   book.delete()
   ```

5. **`count`**: Возвращает количество объектов в базе данных.
   ```groovy
   def count = Book.count()
   ```

6. **`findAll`**: Возвращает список объектов, соответствующих критериям.
   ```groovy
   def books = Book.findAllByAuthor("George Orwell")
   ```


7. **`findBy`**: Возвращает первый объект, соответствующий критериям.
   ```groovy
   def book = Book.findByName("1984")
   ```


8. **`findWhere`**: Возвращает первый объект, соответствующий критериям, заданным в виде карты.
   ```groovy
   def book = Book.findWhere(name: "1984", author: "George Orwell")
   ```


9. **`executeQuery`**: Выполняет HQL-запрос и возвращает результат.
   ```groovy
   def books = Book.executeQuery("from Book where year > :year", [year: 1950])
   ```


10. **`executeUpdate`**: Выполняет HQL-запрос для обновления данных.
    ```groovy
    Book.executeUpdate("update Book set year = :newYear where year = :oldYear", [newYear: 2020, oldYear: 1949])
    ```
