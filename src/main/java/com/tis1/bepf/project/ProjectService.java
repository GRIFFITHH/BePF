package com.tis1.bepf.project;

public interface ProjectService {
    Project createProject(Long id, String name, String stack, String region);
    void deleteProject(Long id);
}
