package com.bonyeon.junitproject.service;

import com.bonyeon.junitproject.domain.BookRepository;
import com.bonyeon.junitproject.util.MailSender;
import com.bonyeon.junitproject.web.dto.BookRespDto;
import com.bonyeon.junitproject.web.dto.BookSaveReqDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    @InjectMocks // @Mock으로 선언된 가짜 정보를 주입받는다.
    private BookService bookService;
    @Mock // 가짜 환경에 띄우기
    private BookRepository bookRepository;
    @Mock
    private MailSender mailSender;

    // 문제점 -> 서비스 레이어만 테스트 하고 싶은데 레포지토리도 테스트가 진행된다.
    @Test
    public void 책등록하기_테스트() {
        // given
        BookSaveReqDto dto = new BookSaveReqDto();
        dto.setTitle("junit 강의");
        dto.setAuthor("bonyeon!!");

        // stub
        when(bookRepository.save(any()))
                .thenReturn(dto.toEntity());
        when(mailSender.send())
                .thenReturn(true);

        // when
        BookRespDto bookRespDto = bookService.책등록하기(dto);

        // then
        assertThat(dto.getTitle()).isEqualTo(bookRespDto.getTitle());
        assertThat(dto.getAuthor()).isEqualTo(bookRespDto.getAuthor());

    }
}
