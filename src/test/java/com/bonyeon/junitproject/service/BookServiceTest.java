package com.bonyeon.junitproject.service;

import com.bonyeon.junitproject.domain.BookRepository;
import com.bonyeon.junitproject.util.MailSenderStub;
import com.bonyeon.junitproject.web.dto.BookRespDto;
import com.bonyeon.junitproject.web.dto.BookSaveReqDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class BookServiceTest {

    @Autowired
    private BookRepository bookRepository;

    // 문제점 -> 서비스 레이어만 테스트 하고 싶은데 레포지토리도 테스트가 진행된다.
    @Test
    public void 책등록하기_테스트() {
        // given
        BookSaveReqDto dto = new BookSaveReqDto();
        dto.setTitle("junit 강의");
        dto.setAuthor("bonyeon!!");

        // stub
        MailSenderStub mailSenderStub = new MailSenderStub();
        // 가짜로 bookRepository 만들기!!

        // when
        BookService bookService = new BookService(bookRepository, mailSenderStub);
        BookRespDto bookRespDto = bookService.책등록하기(dto);

        // then
        assertEquals(dto.getTitle(), bookRespDto.getTitle());
        assertEquals(dto.getAuthor(), bookRespDto.getAuthor());

    }
}
