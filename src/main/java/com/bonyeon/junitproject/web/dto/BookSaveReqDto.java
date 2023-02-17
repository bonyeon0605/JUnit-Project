package com.bonyeon.junitproject.web.dto;

import com.bonyeon.junitproject.domain.Book;
import lombok.Getter;
import lombok.Setter;

@Setter // Controller에서 setter가 호출되면서 Dto에 값이 채워짐
@Getter
public class BookSaveReqDto {

    private String title;
    private String author;

    public Book toEntity() {
        return Book.builder()
                .title(title)
                .author(author)
                .build();
    }

}
