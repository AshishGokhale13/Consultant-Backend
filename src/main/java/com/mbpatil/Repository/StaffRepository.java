package com.mbpatil.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mbpatil.models.Staff;

public interface StaffRepository extends JpaRepository<Staff, Long> {

}
