package com.tis1.bepf.project;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ProjectRepository {
    void save(Project project);
    Optional<Project> findById(Long id);
    Optional<Project> findByName(String name);
    Optional<Project> findByStack(String stack);
    Optional<Project> findByRegion(String region);
    List<Project> findAll();
}
