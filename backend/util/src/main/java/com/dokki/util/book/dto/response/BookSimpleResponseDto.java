package com.dokki.util.book.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookSimpleResponseDto {

	private String bookId;
	private String bookTitle;
	private String bookCoverPath;

	//	public static BookSimpleResponseDto fromEntity(BookEntity bookEntity) {
	//		// TODO : 채우기
	//		return new BookSimpleResponseDto();
	//	}
	//
	//
	//	public static Page<BookSimpleResponseDto> fromEntityPage(Page<BookEntity> bookEntityPage) {
	//		return bookEntityPage.map(BookSimpleResponseDto::fromEntity);
	//	}

}