package com.vti.controller;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.Enum.ClassStatus;
import com.vti.Enum.RequestStatus;
import com.vti.dto.request.ClassDTOCreate;
import com.vti.dto.request.ClassDTOUpdate;
import com.vti.dto.response.ClassDTOView;
import com.vti.entity.Class;
import com.vti.repository.IClassRepository;
import com.vti.service.ClassService;
import com.vti.service.IClassService;
import com.vti.utils.ValidationUtils;
import com.vti.validation.annotation.ClassNameNotExists;
import com.vti.validation.annotation.IdExists;
import com.vti.validation.annotation.isInteger;

/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
@RestController
@RequestMapping(value = "api/v1/class")
@CrossOrigin(origins = "*")
@Validated
public class ClassController {

	@Autowired
	private IClassRepository classRepository;

	@Autowired
	private IClassService classService;

	@Autowired
	private Environment env;


	/**
	 * 
	 * this class use to get all class
	 * 
	 * @return
	 * @Description:
	 * @author: LQHuy
	 * @create_date: Mar 4, 2021
	 * @version: 1.0
	 * @modifer: LQHuy
	 * @modifer_date: Mar 4, 2021
	 * @return ResponseEntity<?>
	 * @throws Exception
	 *
	 */
	@GetMapping
	public ResponseEntity<?> GetAllClass(
			@isInteger(message = "Page size must have type is short") String PageSize,
			@isInteger(message = "Page number must have type is short") String PageNumber,
			@RequestParam(required = false) String Status, @RequestParam(required = false) String ClassName) throws Exception {
		
		if(PageNumber == null || PageNumber.equals("")) {
			PageNumber = "0";
		}
		
		if(PageSize == null || PageSize.equals("")) {
			PageSize = "10";
		}

		if (Status != null) {
		} else {
			Status = null;
		}
		

//		return new ResponseEntity<String>("ok", HttpStatus.OK);
		return new ResponseEntity<List<ClassDTOView>>(classService.getAllClass(Integer.parseInt(PageSize),
				Integer.parseInt(PageNumber), convertStringToStatusEnum(Status), ClassName),
				HttpStatus.OK);	}

	/**
	 * 
	 * this method use tp get class by id
	 * 
	 * @param id
	 * @return
	 * @Description:
	 * @author: LQHuy
	 * @create_date: Mar 4, 2021
	 * @version: 1.0
	 * @modifer: LQHuy
	 * @modifer_date: Mar 4, 2021
	 * @return ResponseEntity<?>
	 * @throws Exception 
	 * @throws NumberFormatException 
	 *
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> GetClassById(@PathVariable(name = "id") String id) throws NumberFormatException, Exception {
		
		try {
			Short.parseShort(id);
		} catch (Exception e) {
			throw new Exception("Id must have type of short");
		}
		
		return new ResponseEntity<ClassDTOView>(classService.findClassById(Short.parseShort(id)), HttpStatus.OK);
	}

	/**
	 * 
	 * this method use to create class
	 * 
	 * @param classCreate
	 * @return
	 * @Description:
	 * @author: LQHuy
	 * @create_date: Mar 4, 2021
	 * @version: 1.0
	 * @modifer: LQHuy
	 * @modifer_date: Mar 4, 2021
	 * @return ResponseEntity<?>
	 * @throws Exception 
	 *
	 */
	@PostMapping
	public ResponseEntity<?> CreateClass(@RequestBody @Valid ClassDTOCreate classCreate) throws Exception {
		classService.createClass(classCreate);
		return new ResponseEntity<String>("Create sucessful", HttpStatus.CREATED);
	}

	/**
	 * 
	 * This method use to update class
	 * 
	 * @param classUpdate
	 * @return
	 * @throws Exception
	 * @Description:
	 * @author: LQHuy
	 * @create_date: Mar 4, 2021
	 * @version: 1.0
	 * @modifer: LQHuy
	 * @modifer_date: Mar 4, 2021
	 * @return ResponseEntity<?>
	 *
	 */
	@PutMapping
	public ResponseEntity<?> UpdateClass(@RequestBody @Valid ClassDTOUpdate classUpdate) throws Exception {
		classService.updateClass(classUpdate);
		return new ResponseEntity<String>("Update sucessful", HttpStatus.OK);
	}

	/**
	 * 
	 * This method use to delete class
	 * 
	 * @param id
	 * @return
	 * @Description:
	 * @author: LQHuy
	 * @create_date: Mar 4, 2021
	 * @version: 1.0
	 * @modifer: LQHuy
	 * @modifer_date: Mar 4, 2021
	 * @return ResponseEntity<?>
	 *
	 */
	@DeleteMapping
	public ResponseEntity<?> DeleteClass(@RequestParam @IdExists Short id) {
		classService.deleteClass(id);
		return new ResponseEntity<String>("Delete sucessful", HttpStatus.OK);
	}

	public ClassStatus convertStringToStatusEnum(String status) throws Exception {
		if(status==null) {
			return null;
		}
		
		switch (status) {
		case "Waiting":
			return ClassStatus.of("-1");
		case "Accepted":
			return ClassStatus.of("0");
		case "Begin":
			return ClassStatus.of("1");
		default:
			throw new Exception("Status is not valid");
		}
	}

}
