package com.project.accountingProject.repository;

import com.project.accountingProject.model.entity.JobInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobInfoRepository extends JpaRepository<JobInfo, Long> {
}
