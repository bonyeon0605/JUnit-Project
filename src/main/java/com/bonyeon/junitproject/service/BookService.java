package com.bonyeon.junitproject.service;

import com.bonyeon.junitproject.domain.Book;
import com.bonyeon.junitproject.domain.BookRepository;
import com.bonyeon.junitproject.web.dto.BookRespDto;
import com.bonyeon.junitproject.web.dto.BookSaveReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    // 3. 책 한권 보기

    // 4. 책 삭제

    // 5. 책 수정
}
