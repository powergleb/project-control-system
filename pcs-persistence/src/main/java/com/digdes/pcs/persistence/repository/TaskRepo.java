package com.digdes.pcs.persistence.repository;


import com.digdes.pcs.persistence.model.Task;
import org.springframework.data.domain.ManagedTypes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TaskRepo extends JpaRepository<Task, Long>, JpaSpecificationExecutor<Task> {
    Optional<Task> findByName(String name);
}