package com.example.book;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.NestedServletException;

import com.example.book.model.BookModel;
import com.example.book.respository.BookRepository;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import javax.servlet.ServletException;

@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTests {

  private static final String BOOKS_END_POINT = "/books/";

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private BookRepository bookRepository;

  @BeforeEach
  public void before() throws Exception {
    final List<BookModel> data = getData();
    bookRepository.setData(data);
  }

  /**
   * Factory method
   * @return
   */
  private static List<BookModel> getData() {
    return new ArrayList() {
      {
        add(new BookModel(0, "Las metamorfosis", 1900));
        add(new BookModel(1, "Crimen y castigo", 1866));
        add(new BookModel(2, "El idiota", 1869));
        add(new BookModel(3, "El hombre invisible", 1952));
        add(new BookModel(4, "Romancero gitano", 1899));
        add(new BookModel(5, "Fausto", 1832));
      }
    };
  }

  /**
   * [
   *    {
   *       "id":0,
   *       "name":"Las metamorfosis",
   *       "age":1900,
   *       "links":[
   *          {
   *             "rel":"self",
   *             "href":"http://localhost/book/0"
   *          }
   *       ]
   *    },
   *    {
   *       "id":1,
   *       "name":"Crimen y castigo",
   *       "age":1866,
   *       "links":[
   *          {
   *             "rel":"self",
   *             "href":"http://localhost/book/1"
   *          }
   *       ]
   *    },
   *    {
   *       "id":2,
   *       "name":"El idiota",
   *       "age":1869,
   *       "links":[
   *          {
   *             "rel":"self",
   *             "href":"http://localhost/book/2"
   *          }
   *       ]
   *    },
   *    {
   *       "id":3,
   *       "name":"El hombre invisible",
   *       "age":1952,
   *       "links":[
   *          {
   *             "rel":"self",
   *             "href":"http://localhost/book/3"
   *          }
   *       ]
   *    },
   *    {
   *       "id":4,
   *       "name":"Romancero gitano",
   *       "age":1899,
   *       "links":[
   *          {
   *             "rel":"self",
   *             "href":"http://localhost/book/4"
   *          }
   *       ]
   *    },
   *    {
   *       "id":5,
   *       "name":"Fausto",
   *       "age":1832,
   *       "links":[
   *          {
   *             "rel":"self",
   *             "href":"http://localhost/book/5"
   *          }
   *       ]
   *    }
   * ]
   * @throws Exception
   */
  @Test
  public void getBooks() throws Exception {
    String expected = "[{\"id\":0,\"name\":\"Las metamorfosis\",\"age\":1900,\"links\":[{\"rel\":\"self\",\"href\":\"http://localhost/book/0\"}]},{\"id\":1,\"name\":\"Crimen y castigo\",\"age\":1866,\"links\":[{\"rel\":\"self\",\"href\":\"http://localhost/book/1\"}]},{\"id\":2,\"name\":\"El idiota\",\"age\":1869,\"links\":[{\"rel\":\"self\",\"href\":\"http://localhost/book/2\"}]},{\"id\":3,\"name\":\"El hombre invisible\",\"age\":1952,\"links\":[{\"rel\":\"self\",\"href\":\"http://localhost/book/3\"}]},{\"id\":4,\"name\":\"Romancero gitano\",\"age\":1899,\"links\":[{\"rel\":\"self\",\"href\":\"http://localhost/book/4\"}]},{\"id\":5,\"name\":\"Fausto\",\"age\":1832,\"links\":[{\"rel\":\"self\",\"href\":\"http://localhost/book/5\"}]}]";
    this.mockMvc.perform(get(BOOKS_END_POINT))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(expected));
  }

}

