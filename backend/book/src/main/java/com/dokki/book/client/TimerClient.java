package com.dokki.book.client;


import com.dokki.util.timer.dto.response.TimerSimpleResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@FeignClient(name = "timer-service") // microservice name
public interface TimerClient {

	/**
	 * 한 달 독서 기록을 조회합니다. (프로필에서 사용, 달력 형태)", notes = "하루 중 가장 읽은 시간이 긴 책 리스트를 반환합니다. 리스트 요소의 형태는 {day: Integer, bookId: String}와 같습니다.
	 *
	 * @param userId
	 * @param year
	 * @param month
	 * @return
	 */
	@GetMapping("/timers/history/{userId}")
	List<Map<String, String>> getMonthlyReadTimeHistory(@PathVariable Long userId, @RequestParam("year") Integer year, @RequestParam Integer month);

	/**
	 * 타이머 정보를 삭제합니다.
	 *
	 * @param userId
	 * @param bookId
	 * @return
	 */
	@DeleteMapping("/timers/{userId}/{bookId}")
	Boolean deleteTimer(@PathVariable Integer userId, @PathVariable String bookId);

	/**
	 * 타이머 정보 중 누적 시간을 조회합니다.
	 * 조회하고 싶은 도서의 book_status_id를 리스트로 Request에 담아 요청합니다. 타이머 뷰에서 이용합니다.
	 *
	 * @param bookStatusIdList
	 * @return
	 */
	@GetMapping("/timers")
	List<TimerSimpleResponseDto> getAccumTime(@RequestBody List<Long> bookStatusIdList);

	/**
	 * 독서 완독 시간 정보를 추가 또는 삭제(null)합니다.
	 * 도서 상태 변경할 때 이용합니다.
	 *
	 * @param bookStatusId
	 * @param done
	 * @return
	 */
	@PutMapping("/timers/{bookStatusId}/endtime")
	Boolean modifyEndTime(@PathVariable Long bookStatusId, @RequestParam Boolean done);

}