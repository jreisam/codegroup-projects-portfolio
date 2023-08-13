package br.com.codegroup.portfolio.service;

import br.com.codegroup.portfolio.model.Project;
import br.com.codegroup.portfolio.repository.PersonRepository;
import br.com.codegroup.portfolio.repository.ProjectRepository;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author João Robson 12/08/2023
 */
public class ProjectService {


    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private PersonRepository personRepository;

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    public Project findById(final Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(this.getClass().getName() + " not found!"));
    }


    public void save(final Project project) {
        projectRepository.save(project);
    }

    public void update(Long id, Project project) {
        Project projectOld = findById(id);
        project.setId(projectOld.getId());

        projectRepository.save(project);
    }


}
