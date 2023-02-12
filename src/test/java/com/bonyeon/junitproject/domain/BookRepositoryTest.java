package com.bonyeon.junitproject.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest // DB와 관련된 컴포넌트만 메모리에 로딩
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    // 1. 책 등록
    @Test
    public void 책등록() {
        // given(데이터 준비)
        String title = "junit5";
        String author = "bonyeon";

        Book book = Book.builder()
                .title(title)
                .author(author)
                .build();

        // when(테스트 실행)
        Book savedBook = bookRepository.save(book);

        // then(검증)
        assertEquals(title, savedBook.getTitle());
        assertEquals(author, savedBook.getAuthor());

    }

    // 2. 책 목록 보기

    // 3. 책 1건 보기

    // 4. 책 수정

    // 5. 책 삭제

}
