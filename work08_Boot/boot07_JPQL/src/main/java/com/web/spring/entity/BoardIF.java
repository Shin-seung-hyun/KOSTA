package com.web.spring.entity;

import java.time.LocalDateTime;

/*
	SELECT b.board_id, b.title, b.custom_id, c.name
	이 컬럼들을 읽어오는 템플릿 기능을 Getter로 만들어야 한다.
	
	Spring Data JPA가 해당 템플릿을 바탕으로 알아서 구현체를 생성한다.
*/
public interface BoardIF {

	Long getBoardId();
	String getTitle();
	String getContent();
	String getName();
	LocalDateTime getRegDate();
	int getCount();
	Integer getCustomId();
	
}
