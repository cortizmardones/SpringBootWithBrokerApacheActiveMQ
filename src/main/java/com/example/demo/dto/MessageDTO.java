package com.example.demo.dto;

import lombok.Builder;

@Builder
public record MessageDTO(
		
		int id,
		String message
		
		) {

}
