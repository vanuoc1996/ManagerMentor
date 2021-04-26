/**
 * @author: LQHuy
 * @create_date: Mar 13, 2021
 * @TODO
 * @ClassRequestController
 */
package com.vti.controller;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.response.ClassRequestDTOView;
import com.vti.entity.ClassRequest;
import com.vti.repository.IClassRequestRepository;
import com.vti.service.ClassRequestService;
import com.vti.service.IClassRequestService;
import com.vti.utils.MapListDto;
import com.vti.validation.annotation.IdExists;
import com.vti.validation.annotation.isInteger;

/**
 * @author Administrator
 *
 */
@CrossOrigin("*")
@RestController
@RequestMapping(value = "api/v1/classRequest")
@Validated
public class ClassRequestController {

	@Autowired
	private IClassRequestService classRequestService;

	@Autowired
	private MapListDto mapDto;

	@GetMapping
	public ResponseEntity<?> getAllClassRequest(
			@isInteger String PageSize,
			@isInteger String PageNumber) {

		if (PageNumber == null || PageNumber.equals("")) {
			PageNumber = "0";
		}

		if (PageSize == null || PageSize.equals("")) {
			PageSize = "10";
		}

		return new ResponseEntity<List<ClassRequestDTOView>>(mapDto.toDtoList(
				classRequestService.getAllClassRequest(Integer.parseInt(PageSize), Integer.parseInt(PageNumber)),
				ClassRequest.class), HttpStatus.OK);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getClassRequestById(@PathVariable(name = "id") String id) throws Exception {

		try {
			Short.parseShort(id);
		} catch (Exception e) {
			throw new Exception("Id must have type of short");
		}
		return new ResponseEntity<ClassRequestDTOView>(classRequestService.getClassRequestById(Short.parseShort(id)),
				HttpStatus.OK);

	}

	@PostMapping( "/acceptRequest/{id}")
	public ResponseEntity<?> AcceptRequest(@PathVariable(name = "id") String id) throws Exception {

		try {
			Short.parseShort(id);
		} catch (Exception e) {
			throw new Exception("Id must have type of short");
		}

		
		classRequestService.AcceptRequest(Short.parseShort(id));
		return new ResponseEntity<String>("Accept successful", HttpStatus.OK);
	}

	@PutMapping(value = "/refuseRequest/{id}")
	public ResponseEntity<?> RefuseRequest(@PathVariable(name = "id") String id) throws Exception {
		try {
			Short.parseShort(id);
		} catch (Exception e) {
			throw new Exception("Id must have type of short");
		}

		classRequestService.RefuseRequest(Short.parseShort(id));
		return new ResponseEntity<String>("Refuse successful", HttpStatus.OK);
	}
}
