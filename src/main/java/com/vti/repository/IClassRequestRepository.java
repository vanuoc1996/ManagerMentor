package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vti.Enum.RequestStatus;
import com.vti.entity.ClassRequest;

@Repository
public interface IClassRequestRepository extends JpaRepository<ClassRequest, Short>,PagingAndSortingRepository<ClassRequest, Short> {
	
	/**
	 * 
	 * this method use to refuse the remaining requests when a request already accepted with this class
	 * 
	 * @param classId
	 * @param mentorId
	 * @Description:
	 * @author: LQHuy
	 * @create_date: Mar 14, 2021
	 * @version: 1.0
	 * @modifer: LQHuy
	 * @modifer_date: Mar 14, 2021
	 * @return: void
	 *
	 */
	@Modifying
	@Transactional
    @Query(value = "UPDATE classRequest SET requestStatus = '1' WHERE (classId =:classId AND requestMentorId !=:mentorId)", nativeQuery = true)
    void refuseMentorWhenAccepted(@Param("classId") Short classId, @Param("mentorId") Short mentorId);
	

}
