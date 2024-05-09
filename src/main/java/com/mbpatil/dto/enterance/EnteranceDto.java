package com.mbpatil.dto.enterance;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EnteranceDto {

	
	Long id;
	@NotEmpty
	String gradeType;
	@NotEmpty
	String applicationNumber;
	
	@NotEmpty
	String rollNo;
	
	@NotNull
	int year;
	
	@NotNull
	double marks;

	
	
}
