En la carpeta 'src/src/java/com/example/' se encuentra el proyecto con la definición del ejemplo implementado.

En la carpeta 'src/test/java/com/example/book' se encuentra el fichero con la suite de test.


A continuación se muestran los resultados
```
MockHttpServletRequest:
      HTTP Method = GET
      Request URI = /books/
       Parameters = {}
          Headers = []
             Body = null
    Session Attrs = {}

Handler:
             Type = com.example.book.controller.BookController
           Method = com.example.book.controller.BookController#getBooks()

Async:
    Async started = false
     Async result = null

Resolved Exception:
             Type = null

ModelAndView:
        View name = null
             View = null
            Model = null

FlashMap:
       Attributes = null

MockHttpServletResponse:
           Status = 200
    Error message = null
          Headers = [Content-Type:"application/hal+json"]
     Content type = application/hal+json
             Body = [{"id":0,"name":"Las metamorfosis","age":1900,"links":[{"rel":"self","href":"http://localhost/book/0"}]},{"id":1,"name":"Crimen y castigo","age":1866,"links":[{"rel":"self","href":"http://localhost/book/1"}]},{"id":2,"name":"El idiota","age":1869,"links":[{"rel":"self","href":"http://localhost/book/2"}]},{"id":3,"name":"El hombre invisible","age":1952,"links":[{"rel":"self","href":"http://localhost/book/3"}]},{"id":4,"name":"Romancero gitano","age":1899,"links":[{"rel":"self","href":"http://localhost/book/4"}]},{"id":5,"name":"Fausto","age":1832,"links":[{"rel":"self","href":"http://localhost/book/5"}]}]
    Forwarded URL = null
   Redirected URL = null
          Cookies = []

```
