package com.mbpatil.dto.staff;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StaffDto {
	
	Long staffId;
	
	@NotNull
	String name;
	@NotNull
	Long mobile;
	@NotNull
	String email;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date dob;
	@NotNull
	Long adharNo;
	

	@NotNull
	String panNo;
	
	MultipartFile profile;
	String profilePath;
	
	@NotNull
	String gender;
	
	
	public StaffDto(Long staffId, @NotNull String name, @NotNull Long mobile, @NotNull String email, @NotNull Date dob,
			@NotNull Long adharno, @NotNull String panno, String profilePath, @NotNull String gender) {
		super();
		this.staffId = staffId;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.dob = dob;
		this.adharNo = adharno;
		this.panNo = panno;
		this.profilePath = profilePath;
		this.gender = gender;
	}
}
