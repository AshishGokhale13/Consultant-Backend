package com.mbpatil.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mbpatil.models.Students;

public interface StudentRepository extends JpaRepository<Students, Long>{

}
