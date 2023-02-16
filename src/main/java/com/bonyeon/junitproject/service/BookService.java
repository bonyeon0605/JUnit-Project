package com.bonyeon.junitproject.service;

import com.bonyeon.junitproject.domain.Book;
import com.bonyeon.junitproject.domain.BookRepository;
import com.bonyeon.junitproject.web.dto.BookRespDto;
import com.bonyeon.junitproject.web.dto.BookSaveReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BookService {

    @Autowired
    private final BookRepository bookRepository;

    // 1. 책등록
    @Transactional(rollbackFor = RuntimeException.class)
    public BookRespDto 책등록하기(BookSaveReqDto dto) {
        Book savedBook = bookRepository.save(dto.toEntity());

        return new BookRespDto().toDto(savedBook);
    }

    // 2. 책 목록보기
    public List<BookRespDto> 책목록보기() {
        return bookRepository.findAll().stream()
                .map(new BookRespDto()::toDto)
                .collect(Collectors.toList());
    }

    // 3. 책 한건 보기
    public BookRespDto 책한건보기(Long id) {
        Optional<Book> bookOP = bookRepository.findById(id);
        if (bookOP.isPresent()) {
            return new BookRespDto().toDto(bookOP.get());
        }
        throw new RuntimeException("해당 아이디를 찾을 수 없습니다.");
    }

    // 4. 책 삭제

    // 5. 책 수정
}
