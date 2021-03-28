package com.example.book.service.id;

import com.example.book.model.BookModel;

public interface IdService {

  /**
   * Retreives the id operation
   * @return
   */
  long get();

  /**
   * Increments and return the value
   * @return
   */
  long incrementAndGet();

  /**
   * Set max value
   * @param max
   */
  void set(final long max);
}
