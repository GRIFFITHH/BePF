package com.tis1.bepf.project;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaProjectRepository extends JpaRepository<Project, Long>,  ProjectRepository{
    @Override
    Optional<Project> findByAuthor(String author);

    @Override
    Optional<Project> findByStack(String stack);

    @Override
    Optional<Project> findByRegion(String region);
}
