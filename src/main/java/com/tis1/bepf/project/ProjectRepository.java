package com.tis1.bepf.project;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository {
    Project save(Project project);
    Optional<Project> findById(Long id);
    Optional<Project> findByAuthor(String author);
    Optional<Project> findByStack(String stack);
    Optional<Project> findByRegion(String region);
    List<Project> findAll();
}
