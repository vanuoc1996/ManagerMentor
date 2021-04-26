package com.vti.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vti.dto.response.ClassDTOView;
import com.vti.entity.Class;

@Repository
public interface IClassRepository extends JpaRepository<Class, Short>, PagingAndSortingRepository<Class, Short> {

//	void findAll(Pageable pageable);

	/**
	 * 
	 * this method use to find a class by className
	 * 
	 * @param className
	 * @return Class
	 * @Description:
	 * @author: LQHuy
	 * @create_date: Mar 4, 2021
	 * @version: 1.0
	 * @modifer: LQHuy
	 * @modifer_date: Mar 4, 2021
	 * @return Class
	 *
	 */
	public Class findByClassName(String className);

	/**
	 * 
	 * this method use to check class exists by ClassName
	 * 
	 * @param className
	 * @return
	 * @Description:
	 * @author: LQHuy
	 * @create_date: Mar 6, 2021
	 * @version: 1.0
	 * @modifer: LQHuy
	 * @modifer_date: Mar 6, 2021
	 * @return: boolean
	 *
	 */
	public boolean existsByClassName(String className);

	/**
	 * 
	 * this method use to check class exists by id
	 * 
	 * @param id
	 * @return
	 * @Description:
	 * @author: LQHuy
	 * @create_date: Mar 7, 2021
	 * @version: 1.0
	 * @modifer: LQHuy
	 * @modifer_date: Mar 7, 2021
	 *
	 */
	public boolean existsById(Short id);

	@Query(value = "select * from class where classstatus =:status", nativeQuery = true)
	public List<Class> findByClassStatus(@Param("status") String status, Pageable pageable);

	@Query(value = "select * from class where classname like %:className%", nativeQuery = true)
	public List<Class> findByClassName1(@Param("className") String className, Pageable pageable);

	@Query(value = "select * from class where classname like %:className% and classstatus =:status", nativeQuery = true)
	public List<Class> findByClassNameAndStatus(@Param("className") String className,
			@Param("status") String status, Pageable pageable);

	@Modifying
	@Transactional
	@Query(value = "update class set classstatus = '0' where classid =:classid ", nativeQuery = true)
	public void updateClassStatuss(@Param("classid") Short id);

}
