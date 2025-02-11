package com.board.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class MenuVo {
	// Field
	private int      menu_seq;
	@NonNull
	private String   menu_id;
	@NonNull
	private String   menu_name;
}






