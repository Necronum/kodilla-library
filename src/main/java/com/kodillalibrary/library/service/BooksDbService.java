package com.kodillalibrary.library.service;

import com.kodillalibrary.library.domain.books.Books;
import com.kodillalibrary.library.domain.books.BooksDto;
import com.kodillalibrary.library.exception.ResourceNotFoundException;
import com.kodillalibrary.library.mapper.BooksMapper;
import com.kodillalibrary.library.repository.BooksRepository;
import com.kodillalibrary.library.repository.CopiesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class BooksDbService {
    private final BooksMapper booksMapper;
    private final BooksRepository booksRepository;
    private final CopiesRepository copiesRepository;

    public List<BooksDto> getBooks(){
        List<Books> books = booksRepository.findAll();
        return booksMapper.mapToBooksDtoList(books);
    }

    public BooksDto getBook(Long id){
        return booksRepository.findById(id)
                .map(booksMapper::mapToBooksDto)
                .orElseThrow(() -> new ResourceNotFoundException("Book with id: " + id + " not found"));
    }

    public void deleteBook(Long id){
        booksRepository.deleteById(id);
    }

    public BooksDto updateBook(Long id, BooksDto booksDto){
        return booksRepository.findById(id).map(books -> {
                    Books updatedBook = booksMapper.mapToBooks(booksDto);
                    booksRepository.save(updatedBook);
                    return booksMapper.mapToBooksDto(updatedBook);
                }).orElseThrow(() -> new ResourceNotFoundException("Book with id: " + id + " not found"));
    }

    public void createBook(BooksDto booksDto) {
        booksRepository.save(booksMapper.mapToBooks(booksDto));
    }
}
