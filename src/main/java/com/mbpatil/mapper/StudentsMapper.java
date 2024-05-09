package com.mbpatil.mapper;

import com.mbpatil.dto.students.StudentsDto;
import com.mbpatil.dto.students.StudentsEntityDto;
import com.mbpatil.models.Students;

public class StudentsMapper {

	public static Students mapToEntity(StudentsEntityDto obj) {
		/* 
		 * Map to Entity Method is used to convert StudentEntityDto obj to Setudent Entity Obj
		 * */
		
		
		return new Students(obj.getStudent_id(),obj.getFirstName(),obj.getMiddleName(),obj.getLastName(),obj.getMotherName(),obj.getDob(),
							obj.getCast(),obj.getCategory(),obj.getGender(),obj.getAdhar(),obj.getMobileno(),obj.getParentMobileno(),
							obj.getEmail(),obj.getAddress(),obj.getCity(),obj.getDistrict(),obj.getPincode(),obj.getPassword(),obj.getState(),obj.getCountry(),obj.getCollegeName(),
							obj.getProfile(),			
							EnteranceMapper.mapToEntity(obj.getEnterance())
							);
	}
	
	public static StudentsEntityDto mapDtoToEntityDto(StudentsDto obj) {
		
		/* 
		 * this  Method is used to convert StudentsDto obj to StudentsEntityDto Entity Obj
		 
		 */
		
		return new StudentsEntityDto(obj.getStudent_id(),obj.getFirstName(),obj.getMiddleName(),obj.getLastName(),obj.getMotherName(),obj.getDob(),
				obj.getCast(),obj.getCategory(),obj.getGender(),obj.getAdhar(),obj.getMobileno(),obj.getParentMobileno(),
				obj.getEmail(),obj.getAddress(),obj.getCity(),obj.getDistrict(),obj.getPincode(),obj.getPassword(),obj.getState(),obj.getCountry(),obj.getCollegeName()
				,obj.getEnterance());
	}
	
	public static StudentsEntityDto mapEntityToEntityDto(Students obj) {
		/* 
		 * Map to Entity Method is used to convert StudentEntityDto obj to Setudent Entity Obj
		 * */
		return new StudentsEntityDto (obj.getStudent_id(),obj.getFirstName(),obj.getMiddleName(),obj.getLastName(),obj.getMotherName(),obj.getDob(),
				obj.getCast(),obj.getCategory(),obj.getGender(),obj.getAdhar(),obj.getMobileno(),obj.getParentMobileno(),
				obj.getEmail(),obj.getAddress(),obj.getCity(),obj.getDistrict(),obj.getPincode(),obj.getPassword(),obj.getState(),obj.getCountry(),obj.getCollegeName(),
				obj.getProfile(),EnteranceMapper.mapToDto(obj.getEnterance()));
	}
	
	
	
	
	
	

}
