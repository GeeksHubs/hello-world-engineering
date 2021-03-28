package com.example.book.service.book;

import com.example.book.model.BookModel;

import java.util.List;
import java.util.NoSuchElementException;

public interface BookServices {

  /**
   * Retrieves all Books
   * @return
   */
  List<BookModel> getBooks();

}
