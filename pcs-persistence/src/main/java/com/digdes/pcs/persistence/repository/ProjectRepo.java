package com.digdes.pcs.persistence.repository;


import com.digdes.pcs.core.util.enums.ProjectStatusEnum;
import com.digdes.pcs.persistence.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProjectRepo extends JpaRepository<Project, UUID> {
    Optional<Project> findByCode(String code);


    @Query(value = "SELECT p FROM Project p WHERE p.projectStatus IN :statuses AND (p.code LIKE %:input% OR p.name LIKE %:input%)")
    List<Project> find(
            @Param("statuses") Collection<ProjectStatusEnum> statuses,
            @Param("input") String input);
}