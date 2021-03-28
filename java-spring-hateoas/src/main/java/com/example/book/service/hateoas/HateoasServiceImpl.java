package com.example.book.service.hateoas;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.stereotype.Service;

import com.example.book.controller.BookController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Service
public class HateoasServiceImpl implements HateoasService {

  public HateoasServiceImpl () {

  }


  /**
   * Create Link with self ref
   * @param refendPoint
   * @param controller
   * @param <T>
   * @return
   */
  public <T> Link createLinkWithSelfRel(String refendPoint, Class<T> controller) {
    return linkTo(controller).slash(refendPoint).withSelfRel();
  }

}
