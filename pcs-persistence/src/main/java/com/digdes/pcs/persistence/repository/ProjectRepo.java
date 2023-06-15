package com.digdes.pcs.persistence.repository;

import com.digdes.pcs.persistence.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProjectRepo extends JpaRepository<Project, UUID> {
    Optional<Project> findByCode(String code);
}