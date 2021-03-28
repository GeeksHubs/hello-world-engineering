package com.example.book.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import org.springframework.hateoas.RepresentationModel;

@Data
@AllArgsConstructor
public class BookModel extends RepresentationModel<BookModel> {
  private long id;
  private String name;
  private int age;
}
