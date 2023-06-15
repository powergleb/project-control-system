package com.digdes.pcs.persistence.repository;


import com.digdes.pcs.persistence.model.EmployeeToProject;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface EmployeeToProjectRepo extends JpaRepository<EmployeeToProject, UUID> {
    List<EmployeeToProject> findByProjectId(UUID project);
    List<EmployeeToProject> findByProjectId(UUID project, Pageable pageable);
    Optional<EmployeeToProject> findByProjectIdAndEmployeeId(UUID project, UUID employee);
}