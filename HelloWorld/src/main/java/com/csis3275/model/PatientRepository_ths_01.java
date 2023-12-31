package com.csis3275.model;


import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository_ths_01 extends CrudRepository<Patient_ths_01,Long>{
	
	@Query("SELECT p FROM Patient_ths_01 p WHERE " +
	        "LOWER(p.firstName) LIKE LOWER(:keyword) OR " +
	        "LOWER(p.lastName) LIKE LOWER(:keyword) OR " +
	        "LOWER(p.email) LIKE LOWER(:keyword) OR " +
	        "LOWER(CAST(p.height AS string)) LIKE LOWER(:keyword) OR " +
	        "LOWER(CAST(p.weight AS string)) LIKE LOWER(:keyword)")
	List<Patient_ths_01> search(@Param("keyword") String keyword);
	    
	@Query("SELECT p FROM Patient_ths_01 p")
	List<Patient_ths_01> findAll();
	
	
	List<Patient_ths_01> findAllByOrderByFirstNameAsc();
	List<Patient_ths_01> findAllByOrderByLastNameAsc();
	

	
	//pagination 
	Page<Patient_ths_01> findAll(Pageable pageable);

	//Page<Patient_ths_01> findByFirstNameContaining(String keyword, Pageable pageable);
	List<Patient_ths_01> findByLastNameContaining(String lastName);
    
    List<Patient_ths_01> findByEmailContaining(String email);
	 
	  
	    
	    
}
