package com.tis1.bepf.project;

import java.util.List;

public interface ProjectService {
    Project createProject(Long id, String name, String stack, String region);
    void deleteProject(Long id);

    List<Project> findAllProjects();
}
