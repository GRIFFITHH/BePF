package com.tis1.bepf.project;

import java.util.List;

public class ProjectServiceImpl implements ProjectService{

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }

    @Override
    public Project createProject(Long id, String name, String stack, String region) {
        return null;
    }

    @Override
    public void deleteProject(Long id) {
        // to be written.
    }

    @Override
    public List<Project> findAllProjects() {
        return projectRepository.findAll();
    }
}
