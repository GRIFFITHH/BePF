package com.tis1.bepf.project;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpringDataJpaProjectRepository extends JpaRepository<Project, Long>,  ProjectRepository{
    @Override
    Optional<Project> findByName(String name);

    @Override
    Optional<Project> findByStack(String stack);

    @Override
    Optional<Project> findByRegion(String region);
}
