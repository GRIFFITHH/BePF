package com.tis1.bepf.project;

public class ProjectServiceImple implements ProjectService{

    private final ProjectRepository projectRepository;

    public ProjectServiceImple(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }

    @Override
    public Project createProject(Long id, String name, String stack, String region) {
        return new Project(id, name, stack, region);
    }

    @Override
    public void deleteProject(Long id) {
        // to be written.
    }
}
