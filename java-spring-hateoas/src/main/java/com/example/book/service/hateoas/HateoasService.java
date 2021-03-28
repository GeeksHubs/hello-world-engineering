package com.example.book.service.hateoas;

import org.springframework.hateoas.Link;

public interface HateoasService {

  /**
   * Create Link with self ref
   * @param refendPoint
   * @param controller
   * @param <T>
   * @return
   */
  <T> Link createLinkWithSelfRel(String refendPoint, Class<T> controller);
}
