package com.tis1.bepf;

import com.tis1.bepf.project.MemoryProjectRepository;
import com.tis1.bepf.project.ProjectRepository;
import com.tis1.bepf.project.ProjectService;
import com.tis1.bepf.project.ProjectServiceImple;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ProjectService projectService() {
        return new ProjectServiceImple(projectRepository());
    }

    @Bean
    public ProjectRepository projectRepository() {
        return new MemoryProjectRepository();
    }

}
