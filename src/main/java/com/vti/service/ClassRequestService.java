/**
 * @author: LQHuy
 * @create_date: Mar 13, 2021
 * @TODO
 * @ClassRequestService
 */
package com.vti.service;

import java.util.List;

import javax.websocket.server.ServerEndpoint;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vti.Enum.ClassStatus;
import com.vti.Enum.RequestStatus;
import com.vti.dto.response.ClassRequestDTOView;
import com.vti.entity.ClassRequest;
import com.vti.repository.IClassRepository;
import com.vti.repository.IClassRequestRepository;

/**
 * @author Administrator
 *
 */
@Service
@PropertySource("classpath:messages_en.properties")
//@PropertySource("classpath:messages_vi.properties")
public class ClassRequestService implements IClassRequestService {

	@Autowired
	private IClassRequestRepository classRequestRepository;

	@Autowired
	private IClassRepository classRepository;

	@Autowired
	private Environment env;

	@Autowired
	Pageable pagingAndSorting;

	/**
	 * 
	 * this method use to get all class request
	 * 
	 * @return
	 * @Description:
	 * @author: LQHuy
	 * @create_date: Mar 13, 2021
	 * @version: 1.0
	 * @modifer: LQHuy
	 * @modifer_date: Mar 13, 2021
	 *
	 */
	@Override
	public List<ClassRequest> getAllClassRequest(Integer pageSize, Integer pageNumber) {
		pagingAndSorting = PageRequest.of(pageNumber, pageSize);
		List<ClassRequest> classRequest = classRequestRepository.findAll(pagingAndSorting).getContent();

		return classRequest;
	}

	/**
	 * 
	 * this method use to get class request by id
	 * 
	 * @return
	 * @Description:
	 * @author: LQHuy
	 * @create_date: Mar 13, 2021
	 * @version: 1.0
	 * @throws Exception
	 * @modifer: LQHuy
	 * @modifer_date: Mar 13, 2021
	 *
	 */
	@Override
	public ClassRequestDTOView getClassRequestById(Short id) throws Exception {

		if (!classRequestRepository.existsById(id)) {
			throw new Exception("Id not exist, please check again");
		}

		return toDto(classRequestRepository.findById(id).get());
	}

	/**
	 * 
	 * this method use to convert classRequest to classRequestDTO
	 * 
	 * @param classRequest
	 * @return
	 * @Description:
	 * @author: LQHuy
	 * @create_date: Mar 13, 2021
	 * @version: 1.0
	 * @modifer: LQHuy
	 * @modifer_date: Mar 13, 2021
	 * @return: ClassRequestDTOView
	 *
	 */
	public ClassRequestDTOView toDto(ClassRequest classRequest) {

		ClassRequestDTOView CRDV = new ClassRequestDTOView();
		CRDV.setId(classRequest.getId());
		CRDV.setClassName(classRequest.getClasss().getClassName());
		CRDV.setMentor(classRequest.getMentor().getFullName());
		CRDV.setRequestStatus(classRequest.getRequestStatus());
		CRDV.setNumberStudent(classRequest.getClasss().getStudentNumber());
		CRDV.setTeachingForm(classRequest.getClasss().getTeachingForm());
		CRDV.setDescription(classRequest.getClasss().getDescription());
		return CRDV;

	}

	/**
	 * 
	 * this method use to accept request
	 * 
	 * @param id
	 * @throws Exception
	 * @Description:
	 * @author: LQHuy
	 * @create_date: Mar 13, 2021
	 * @version: 1.0
	 * @modifer: LQHuy
	 * @modifer_date: Mar 13, 2021
	 * @return: void
	 *
	 */
	@Override
	public void AcceptRequest(Short id) throws Exception {

		if (!classRequestRepository.existsById(id)) {
			throw new Exception("Id not exist, please check again");
		}

		ClassRequest CR = classRequestRepository.findById(id).get();
		if (CR.getRequestStatus() == RequestStatus.Accepted) {
			throw new Exception(env.getProperty("ClassRequest.Status.AlreadyAccepted", String.class));
		} else if (CR.getRequestStatus() == RequestStatus.Refused) {
			throw new Exception(env.getProperty("ClassRequest.Status.AlreadyRefused", String.class));
		}
		refuseMentorWhenAccepted(CR.getClasss().getId(), CR.getMentor().getId());

		changeClassStatusWhenAccepted(CR.getClasss().getId());

		CR.setRequestStatus(RequestStatus.Accepted);

		classRequestRepository.save(CR);
	}

	/**
	 * 
	 * This method use to refuse request
	 * 
	 * @param id
	 * @throws Exception
	 * @Description:
	 * @author: LQHuy
	 * @create_date: Mar 13, 2021
	 * @version: 1.0
	 * @modifer: LQHuy
	 * @modifer_date: Mar 13, 2021
	 * @return: void
	 *
	 */
	@Override
	public void RefuseRequest(Short id) throws Exception {

		if (!classRequestRepository.existsById(id)) {
			throw new Exception("Id not exist, please check again");
		}

		ClassRequest CR = classRequestRepository.findById(id).get();
		if (CR.getRequestStatus() == RequestStatus.Accepted) {
			throw new Exception(env.getProperty("ClassRequest.Status.AlreadyAccepted", String.class));
		} else if (CR.getRequestStatus() == RequestStatus.Refused) {
			throw new Exception(env.getProperty("ClassRequest.Status.AlreadyRefused", String.class));
		}

		CR.setRequestStatus(RequestStatus.Refused);

		classRequestRepository.save(CR);

	}

	public void refuseMentorWhenAccepted(Short classId, Short mentorId) {
		classRequestRepository.refuseMentorWhenAccepted(classId, mentorId);
	}

	public void changeClassStatusWhenAccepted(Short classId) {
		classRepository.updateClassStatuss(classId);
	}

}
