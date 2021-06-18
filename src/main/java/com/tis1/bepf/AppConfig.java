package com.tis1.bepf;

import com.tis1.bepf.project.ProjectRepository;
import com.tis1.bepf.project.ProjectService;
import com.tis1.bepf.project.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
public class AppConfig {

    private final ProjectRepository projectRepository;

    @Autowired
    public AppConfig(ProjectRepository projectRepository) { this.projectRepository = projectRepository; }

    @Bean
    public ProjectService projectService() {
        return new ProjectServiceImpl(projectRepository);
    }
}
