package com.kodillalibrary.library.repository;

import com.kodillalibrary.library.domain.books.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long> {
}
