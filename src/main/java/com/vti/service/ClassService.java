package com.vti.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.ClassEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.vti.Enum.ClassStatus;
import com.vti.Enum.RequestStatus;
import com.vti.dto.request.ClassDTOCreate;
import com.vti.dto.request.ClassDTOUpdate;
import com.vti.dto.response.ClassDTOView;
import com.vti.entity.Class;
import com.vti.entity.ClassRequest;
import com.vti.repository.IClassRepository;

import ch.qos.logback.core.status.Status;

@Service
public class ClassService implements IClassService {

//	@Autowired
//	private ModelMapper mapper;

	@Autowired
	private ClassService classService;

	@Autowired
	private IClassRepository classRepository;

	@Autowired
	private Pageable pagingAndSorting;

	/**
	 * 
	 * this method use to get all class and map to ClassDTO
	 * 
	 * @return list<ClassDTO>
	 * @Description:
	 * @author: LQHuy
	 * @create_date: Mar 4, 2021
	 * @version: 1.0
	 * @param pageNumber
	 * @param pageSize
	 * @modifer: LQHuy
	 * @modifer_date: Mar 4, 2021
	 *
	 */
	@Override
	public List<ClassDTOView> getAllClass(Integer pageSize, Integer pageNumber, ClassStatus classStatus,String className) {
		System.out.println(classStatus);
		System.out.println(className);

		pagingAndSorting = PageRequest.of(pageNumber, pageSize);
		List<ClassDTOView> ClassDTO = new ArrayList<ClassDTOView>();
		List<Class> classes = new ArrayList<Class>();
		Page<Class> classE = null;

		if (classStatus == null && (className == null || className.equals(""))) {
			classE = classRepository.findAll(pagingAndSorting);
			List<Class> dd = classE.getContent();
			for (Class class1 : dd) {
				ClassDTO.add(classService.toDtoView(class1));
			}
		} else if (classStatus != null && (className == null || className.equals(""))) {
			classes = classRepository.findByClassStatus(classStatus.getValue(), pagingAndSorting);

			for (Class classe : classes) {
				ClassDTO.add(toDtoView(classe));
			}
		} else if (classStatus == null && (className != null || !className.equals(""))) {
			classes = classRepository.findByClassName1(className, pagingAndSorting);

			for (Class classe : classes) {
				ClassDTO.add(toDtoView(classe));
			}
		} else {
			classes = classRepository.findByClassNameAndStatus(className, classStatus.getValue(), pagingAndSorting);

			for (Class classe : classes) {
				ClassDTO.add(toDtoView(classe));
			}
		}

		return ClassDTO;
	}

	/**
	 * 
	 * this method use to get a ClassDTO by id
	 * 
	 * @param id
	 * @return ClassDTO
	 * @Description:
	 * @author: LQHuy
	 * @create_date: Mar 4, 2021
	 * @version: 1.0
	 * @throws Exception
	 * @modifer: LQHuy
	 * @modifer_date: Mar 4, 2021
	 *
	 */
	@Override
	public ClassDTOView findClassById(Short id) throws Exception {

		if (!classRepository.existsById(id)) {
			throw new Exception("Id not exist, please check again");
		}

		return ClassService.toDtoView(classRepository.findById(id).get());
	}

	/**
	 * 
	 * this method use to create class
	 * 
	 * @param classCreate
	 * @Description:
	 * @author: LQHuy
	 * @create_date: Mar 4, 2021
	 * @version: 1.0
	 * @throws Exception 
	 * @modifer: LQHuy
	 * @modifer_date: Mar 4, 2021
	 *
	 */
	@Override
	public void createClass(ClassDTOCreate classCreate) throws Exception {
		classRepository.save(classService.toEntity(classCreate));
	}

	/**
	 * 
	 * this method use to update information of class
	 * 
	 * @param classUpdate
	 * @Description:
	 * @author: LQHuy
	 * @create_date: Mar 4, 2021
	 * @version: 1.0
	 * @modifer: LQHuy
	 * @modifer_date: Mar 4, 2021
	 *
	 */
	@Override
	public void updateClass(ClassDTOUpdate classUpdate) {
		classRepository.save(classService.toEntity(classUpdate));
	}

	/**
	 * 
	 * this method use to delete Class
	 * 
	 * @param id
	 * @Description:
	 * @author: LQHuy
	 * @create_date: Mar 4, 2021
	 * @version: 1.0
	 * @modifer: LQHuy
	 * @modifer_date: Mar 4, 2021
	 *
	 */
	@Override
	public void deleteClass(Short id) {
		classRepository.delete(classRepository.findById(id).get());
	}

	/**
	 * 
	 * this method use to map object ClassDTOUpdate to object class
	 * 
	 * @param ClassDTO
	 * @return
	 * @Description:
	 * @author: LQHuy
	 * @create_date: Mar 4, 2021
	 * @version: 1.0
	 * @modifer: LQHuy
	 * @modifer_date: Mar 4, 2021
	 * @return Class
	 *
	 */
	public Class toEntity(ClassDTOUpdate ClassDTO) {

		ModelMapper modelMapper = new ModelMapper();
		Class classE = modelMapper.map(ClassDTO, Class.class);
		return classE;

	}

	/**
	 * 
	 * this method use to map object Class to object ClassDtoView
	 * 
	 * @param classE
	 * @return
	 * @Description:
	 * @author: LQHuy
	 * @create_date: Mar 6, 2021
	 * @version: 1.0
	 * @modifer: LQHuy
	 * @modifer_date: Mar 6, 2021
	 * @return: ClassDTOCreateAndView
	 *
	 */
	public static ClassDTOView toDtoView(Class classE) {
		ModelMapper modelMaper = new ModelMapper();

		ClassDTOView dto = modelMaper.map(classE, ClassDTOView.class);

		for (ClassRequest cr : classE.getClassRequest()) {
			if (cr.getRequestStatus() == RequestStatus.Accepted) {
				dto.setMentorName(cr.getMentor().getFullName());
				String pattern = "dd-MM-yyyy";
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
				String enddate = simpleDateFormat.format(classE.getEndDate());
				String startdate = simpleDateFormat.format(classE.getStartDate());

				dto.setEndDate(enddate);
				dto.setStartDate(startdate);
				return dto;
			}
		}

		String pattern = "dd-MM-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String enddate = simpleDateFormat.format(classE.getEndDate());
		String startdate = simpleDateFormat.format(classE.getStartDate());

		dto.setEndDate(enddate);
		dto.setStartDate(startdate);

		dto.setMentorName("Lớp này chưa có mentor nhận");
		return dto;
	}

	/**
	 * 
	 * this method use to map object ClassDTOCreate to object class
	 * 
	 * @param classE
	 * @return
	 * @Description:
	 * @author: LQHuy
	 * @create_date: Mar 13, 2021
	 * @version: 1.0
	 * @modifer: LQHuy
	 * @modifer_date: Mar 13, 2021
	 * @return: Class
	 * @throws Exception
	 *
	 */
	public static Class toEntity(ClassDTOCreate ClassDTO) throws Exception {
		
		Class classE = new Class();
		classE.setClassName(ClassDTO.getClassName());
		classE.setClassStatus(ClassStatus.Waiting);
		classE.setDescription(ClassDTO.getDescription());
		classE.setStudentNumber(ClassDTO.getStudentNumber());
		classE.setTeachingForm(ClassDTO.getTeachingForm());

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = null;
		Date d2 = null;
		try {
			d1 = format.parse(ClassDTO.getStartDate());
			d2 = format.parse(ClassDTO.getEndDate());
		} catch (ParseException e) {
			throw new Exception("Format date error");
		}

		classE.setStartDate(d1);
		classE.setEndDate(d2);

		return classE;
	}

	/**
	 * 
	 * 
	 * 
	 * @return
	 * @Description:
	 * @author: LQHuy
	 * @create_date: Mar 6, 2021
	 * @version: 1.0
	 * @modifer: LQHuy
	 * @modifer_date: Mar 6, 2021
	 *
	 */
	@Override
	public boolean existsByClassName(String className) {
		return classRepository.existsByClassName(className);
	}

	/**
	 * 
	 * 
	 * 
	 * @param className
	 * @return
	 * @Description:
	 * @author: LQHuy
	 * @create_date: Mar 6, 2021
	 * @version: 1.0
	 * @modifer: LQHuy
	 * @modifer_date: Mar 6, 2021
	 *
	 */
	@Override
	public Class findClassByClassName(String className) {
		// TODO Auto-generated method stub
		return classRepository.findByClassName(className);
	}

}
