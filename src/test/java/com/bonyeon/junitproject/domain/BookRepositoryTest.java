package com.bonyeon.junitproject.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@DataJpaTest // DB와 관련된 컴포넌트만 메모리에 로딩
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @BeforeEach
    public void 데이터준비() {
        String title = "junit5";
        String author = "bonyeon";

        Book book = Book.builder()
                .title(title)
                .author(author)
                .build();

        bookRepository.save(book);
    }

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

    } // 트랜잭션 종료 (저장된 데이터를 초기화)

    // 2. 책 목록 보기
    @Test
    public void 책목록보기() {
        // given
        String title = "junit5";
        String author = "bonyeon";

        // when
        List<Book> books = bookRepository.findAll();
        // then
        assertEquals(title, books.get(0).getTitle());
        assertEquals(author, books.get(0).getAuthor());

    } // 트랜잭션 종료 (저장된 데이터를 초기화)

    // 3. 책 1건 보기
    @Sql("classpath:db/tableInit.sql")
    @Test
    public void 책한건보기() {
        // given
        String title = "junit5";
        String author = "bonyeon";

        // when
        Book bookPS = bookRepository.findAll().get(0); //todo findById(1L) 로 전체 테스트 시 실패 이유 찾기

        // then
        assertEquals(title, bookPS.getTitle());
        assertEquals(author, bookPS.getAuthor());

    }

    // 1L, junit5, bonyeon
    // 4. 책 수정
    @Sql("classpath:db/tableInit.sql")
    @Test
    public void 책수정() {
        // given
        Long id = 1L;
        String title = "junit5";
        String author = "mr.koo";

        // when
        Book bookPS = bookRepository.save(Book.builder()
                .id(id)
                .title(title)
                .author(author)
                .build());

//        bookRepository.findAll().stream()
//                .forEach(book -> System.out.println(book.toString()));

        // then
        assertEquals(id, bookPS.getId());
        assertEquals(title, bookPS.getTitle());
        assertEquals(author, bookPS.getAuthor());
    }

    // 5. 책 삭제
    @Sql("classpath:db/tableInit.sql")
    @Test
    public void 책삭제() {
        // given
        Long id = 1L;

        // when
        bookRepository.deleteById(id);

        // then
        assertFalse(bookRepository.findById(id).isPresent());
    }

}
