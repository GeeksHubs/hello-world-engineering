package com.example.book.respository;

import org.springframework.stereotype.Repository;

import com.example.book.model.BookModel;
import com.example.book.service.id.IdService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public class BookRepositoryImpl implements BookRepository {

  /**
   * Persistence
   */
  private List<BookModel> persist;

  /**
   * Id Service
   */
  private final IdService idService;

  /**
   * Constructor
   */
  public BookRepositoryImpl(final IdService idService) {
    this.idService = idService;
    persist = new ArrayList<>();
  }

  /**
   * Storage the data
   * @param persist
   */
  @Override
  public void setData(final List<BookModel> persist){
    this.persist = persist;
    setIdService(persist);
  }

  /**
   * Set Id Services
   * @param persist
   */
  private void setIdService(final List<BookModel> persist){
    final BookModel max = persist.stream().max(Comparator.comparing(BookModel::getId)).get();
    this.idService.set(max.getId());
  }

  /**
   * Retrieve de data
   * @return
   */
  @Override
  public List<BookModel> getData() {
    return this.persist;
  }

}
