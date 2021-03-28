package com.example.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.book.model.BookModel;
import com.example.book.service.book.BookServices;
import com.example.book.service.hateoas.HateoasService;

import java.util.List;

@RestController
public class BookController {

	/**
	 * Sum Services
	 */
	private final BookServices bookServices;

	/**
	 * Hate OAS service
	 */
	private final HateoasService hateoasService;

	/**
	 * Constructor
	 */
	@Autowired
	public BookController(final BookServices bookServices, final HateoasService hateoasService){
		this.bookServices = bookServices;
		this.hateoasService = hateoasService;
	}

	@GetMapping(value = "books", produces = { "application/hal+json" })
	public List<BookModel> getBooks() {
		final List<BookModel> books =this.bookServices.getBooks();
		for(BookModel b : books) {
			b.removeLinks();
			b.add(hateoasService.createLinkWithSelfRel("book/" + b.getId(), BookController.class));
		}
		return books;
	}

}
