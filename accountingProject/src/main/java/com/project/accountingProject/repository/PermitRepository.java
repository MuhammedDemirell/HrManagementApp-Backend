package com.project.accountingProject.repository;

import com.project.accountingProject.model.entity.Permit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface PermitRepository extends JpaRepository<Permit, UUID> {

    @Query("select p from Permit p join fetch p.employee e")
    List<Permit> findAllPermits();


}
