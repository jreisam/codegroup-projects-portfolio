package br.com.codegroup.portfolio.service;

import br.com.codegroup.portfolio.enums.ProjectStatusEnum;
import br.com.codegroup.portfolio.model.Person;
import br.com.codegroup.portfolio.model.Project;
import br.com.codegroup.portfolio.repository.PersonRepository;
import br.com.codegroup.portfolio.repository.ProjectRepository;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author João Robson 14/08/2023
 */
@Service
public class ProjectServiceImpl implements ProjectService {


    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project getProjectById(final Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(this.getClass().getName() + " not found!"));
    }

    @Override
    public Project createProject(final Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project updateProject(Project project) {
        Project existingProject = projectRepository.findById(project.getId()).get();
        existingProject.setNome(project.getNome());
        existingProject.setIdGerente(project.getIdGerente());
        existingProject.setDescricao(project.getDescricao());
        existingProject.setPessoas(project.getPessoas());
        existingProject.setOrcamento(project.getOrcamento());
        existingProject.setDataInicio(project.getDataInicio());
        existingProject.setDataPrevisaoFim(project.getDataPrevisaoFim());
        existingProject.setDataFim(project.getDataFim());
        existingProject.setRisco(project.getRisco());
        existingProject.setStatus(project.getStatus());
        Project updatedProject = projectRepository.save(existingProject);
        return updatedProject;
    }

    @Override
    public void deleteProject(Long projectId) {
        Project existingProject = projectRepository.findById(projectId).get();
        if (existingProject.getStatus() == ProjectStatusEnum.INICIADO ||
            existingProject.getStatus() == ProjectStatusEnum.EM_ANDAMENTO ||
            existingProject.getStatus() == ProjectStatusEnum.ENCERRADO) {
            return;
        }
        projectRepository.deleteById(projectId);
    }


}
