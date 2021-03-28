package com.example.book.service.id;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class IdServiceImpl implements IdService {

  /**
   * UID
   */
  private static AtomicLong counter;

  /**
   * Constructor
   */
  public IdServiceImpl() {
    counter = new AtomicLong();
  }

  /**
   * Retrieves counter
   * @return
   */
  public long get() {
    return this.counter.get();
  }

  /**
   * Increment & get the value
   * @return
   */
  public long incrementAndGet() {
    return this.counter.incrementAndGet();
  }

  /**
   * Set max value
   * @param max
   */
  public void set(final long max){
    this.counter.set(max);
  }
}
