package com.digdes.pcs.persistence.repository;


import com.digdes.pcs.persistence.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TaskRepo extends JpaRepository<Task, UUID>, JpaSpecificationExecutor<Task> {
    Optional<Task> findByName(String name);
}