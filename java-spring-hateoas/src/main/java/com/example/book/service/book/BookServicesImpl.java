package com.example.book.service.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.book.model.BookModel;
import com.example.book.respository.BookRepository;
import com.example.book.service.id.IdService;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class BookServicesImpl implements BookServices {

	/**
	 * Book Repository
	 */
	private final BookRepository bookRepository;

	/**
	 * Id Services
	 */
	private final IdService idService;

	/**
	 * Constructor
	 * @param idService
	 */
	@Autowired
	public BookServicesImpl(final IdService idService, final BookRepository bookRepository) {
		this.idService = idService;
		this.bookRepository = bookRepository;
	}

	/**
	 * Retrieves all Book
	 * @return
	 */
	@Override
	public List<BookModel> getBooks() {
		return bookRepository.getData();
	}

}
