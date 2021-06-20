package com.tis1.bepf.project;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ProjectService {

    Project createProject(String author, String stack, String region, Integer period, Integer size, String title, String content);

    void deleteProject(Long id);

    Optional<Project> findProjectWithId(Long id);

    Optional<Project> findProjectWithStack(String stack);

    Optional<Project> findProjectWithTitle(String title);

    Optional<Project> findProjectWithPeriod(Integer period);

    List<Project> findAllProjects();
}
