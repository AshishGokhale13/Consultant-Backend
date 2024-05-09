package com.mbpatil.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbpatil.Repository.PaymentsRepository;
import com.mbpatil.Repository.StudentRepository;
import com.mbpatil.customeOps.CustomOperations;
import com.mbpatil.dto.students.StudentsDto;
import com.mbpatil.dto.students.StudentsEntityDto;
import com.mbpatil.dto.students.UpdateStudentEducationDetails;
import com.mbpatil.dto.students.UpdateStudentPersonalDetailsDto;
import com.mbpatil.dto.students.UpdateStudentProfileDto;
import com.mbpatil.mapper.PaymentsMapper;
import com.mbpatil.mapper.StudentsMapper;
import com.mbpatil.models.Payments;
import com.mbpatil.models.Students;
import com.mbpatil.services.StudentServices;

@Service
public class StudentServicesImpl implements StudentServices {

	@Autowired
	StudentRepository studRepo;
	
	@Autowired
	PaymentsRepository payRepo;

	

	public StudentsEntityDto saveStudent(StudentsDto obj) {

		
		System.out.print(obj.toString());
		
		String filepath = CustomOperations.getNewFilePath(CustomOperations.createNewDirectoryPath(studentProfilePath),
				obj.getProfile().getOriginalFilename());
		StudentsEntityDto studObj = StudentsMapper.mapDtoToEntityDto(obj);
		studObj.setProfile(CustomOperations.getDirPath(filepath, "static"));
		Students studEntityObj = StudentsMapper.mapToEntity(studObj);

		try {
			studEntityObj = studRepo.save(studEntityObj);
			if(studEntityObj!=null)
			{
				CustomOperations.saveFile(obj.getProfile(), filepath);
				Payments pObj=PaymentsMapper.mapToEntity(obj.getPayment(), studEntityObj);
				pObj=payRepo.save(pObj);
				if(pObj!=null)
					return StudentsMapper.mapEntityToEntityDto(studEntityObj);
			}
			
			
			
			return StudentsMapper.mapEntityToEntityDto(studEntityObj);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<Students> getAllStudents() {

		return studRepo.findAll();
	}

	@Override
	public Students getStudent(Long id) {
		return studRepo.findById(id).orElse(null);
	}

	@Override
	public Students updateStudentProfile(Long id, UpdateStudentProfileDto obj) {

		Students StudObj = studRepo.findById(id).orElse(null);
		if (StudObj != null) {
			if (updateProfile(StudObj, obj))
				StudObj = studRepo.save(StudObj);
			if (StudObj != null)
				return StudObj;
		}
		return null;
	}

	@Override
	public Students updateStudentPersonalDetails(Long id, UpdateStudentPersonalDetailsDto obj) {
		Students StudObj = studRepo.findById(id).orElse(null);
		if (StudObj != null) {
			if (updatePersonalDetail(StudObj, obj))
				StudObj = studRepo.save(StudObj);
			if (StudObj != null)
				return StudObj;
		}
		return null;
	}

	@Override
	public Students updateStudentEducationalDetails(Long id, UpdateStudentEducationDetails obj) {
		Students StudObj = studRepo.findById(id).orElse(null);
		if (StudObj != null) {
			if (updateEducationalDetail(StudObj, obj))
				StudObj = studRepo.save(StudObj);
			if (StudObj != null)
				return StudObj;
		}
		return null;
	}

	public static boolean updateProfile(Students obj, UpdateStudentProfileDto upObj) {
		try {
			obj.setFirstName(upObj.getFirstName());
			obj.setMiddleName(upObj.getMiddleName());
			obj.setLastName(upObj.getLastName());
			obj.setDob(upObj.getDob());
			obj.setEmail(upObj.getEmail());
			obj.setGender(upObj.getGender());
			obj.setAdhar(upObj.getAdhar());
			obj.setMobileno(upObj.getMobileno());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean updatePersonalDetail(Students obj, UpdateStudentPersonalDetailsDto upObj) {
		try {
			obj.setMotherName(upObj.getMotherName());
			obj.setCast(upObj.getCast());
			obj.setCategory(upObj.getCategory());
			obj.setParentMobileno(upObj.getParentMobileno());
			obj.setAddress(upObj.getAddress());
			obj.setCity(upObj.getCity());
			obj.setDistrict(upObj.getDistrict());
			obj.setPincode(upObj.getPincode());
			obj.setState(upObj.getState());
			obj.setCountry(upObj.getCountry());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean updateEducationalDetail(Students obj, UpdateStudentEducationDetails upObj) {
		try {
			obj.setCollegeName(upObj.getCollegeName());
			obj.getEnterance().setGradeType(upObj.getGradeType());
			obj.getEnterance().setApplicationNumber(upObj.getApplicationNumber());
			obj.getEnterance().setRollNo(upObj.getRollNo());
			obj.getEnterance().setYear(upObj.getYear());
			obj.getEnterance().setMarks(upObj.getMarks());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteStudent(Long id) {
		
		if (studRepo.existsById(id)) {
			Payments pobj=payRepo.byStudentId(id);
			payRepo.delete(pobj);
			studRepo.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

}
