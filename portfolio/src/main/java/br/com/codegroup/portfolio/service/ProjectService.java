package br.com.codegroup.portfolio.service;

import br.com.codegroup.portfolio.model.Project;
import br.com.codegroup.portfolio.repository.PersonRepository;
import br.com.codegroup.portfolio.repository.ProjectRepository;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author João Robson 12/08/2023
 */
public interface ProjectService {

    Project createProject(Project project);
    Project getProjectById(Long projectId);
    List<Project> getAllProjects();
    Project updateProject(Project project);
    void deleteProject(Long projectId);

}
