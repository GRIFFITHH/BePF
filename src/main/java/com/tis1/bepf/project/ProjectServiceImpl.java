package com.tis1.bepf.project;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService{

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }


    @Override
    public Project createProject(String author, String stack, String region, Integer period, Integer size, String title, String content) {
        return null;
    }

    @Override
    public void deleteProject(Long id) {
        // to be written.
    }

    @Override
    public Optional<Project> findProjectWithId(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Project> findProjectWithStack(String stack) {
        return Optional.empty();
    }

    @Override
    public Optional<Project> findProjectWithTitle(String title) {
        return Optional.empty();
    }

    @Override
    public Optional<Project> findProjectWithPeriod(Integer period) {
        return Optional.empty();
    }

    @Override
    public List<Project> findAllProjects() {
        return projectRepository.findAll();
    }
}
