package com.example.book.respository;

import com.example.book.model.BookModel;

import java.util.List;

public interface BookRepository {

  /**
   * Storage the data
   *
   * @param persist
   */
  void setData(List<BookModel> persist);

  /**
   * Retrieve de data
   *
   * @return
   */
  List<BookModel> getData();
}
