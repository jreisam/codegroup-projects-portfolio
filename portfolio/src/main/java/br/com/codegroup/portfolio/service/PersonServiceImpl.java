package br.com.codegroup.portfolio.service;

import br.com.codegroup.portfolio.dto.ProjectMemberDto;
import br.com.codegroup.portfolio.model.Person;
import br.com.codegroup.portfolio.model.Project;
import br.com.codegroup.portfolio.repository.PersonRepository;
import br.com.codegroup.portfolio.repository.PersonRepository;
import br.com.codegroup.portfolio.repository.ProjectRepository;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author João Robson 14/08/2023
 */
@Service
public class PersonServiceImpl implements PersonService {


    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ProjectService projectService;

    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person getPersonById(final Long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(this.getClass().getName() + " not found!"));
    }

    @Override
    public Person createPerson(final Person project) {
        return personRepository.save(project);
    }

    @Override
    public Person updatePerson(Person person) {
        Person existingPerson = personRepository.findById(person.getId()).get();
        existingPerson.setNome(person.getNome());
        existingPerson.setCpf(person.getCpf());
        existingPerson.setFuncionario(person.isFuncionario());
        existingPerson.setDataNascimento(person.getDataNascimento());
        existingPerson.setProjetos(person.getProjetos());
        Person updatedPerson = personRepository.save(existingPerson);
        return updatedPerson;
    }

    @Override
    public void deletePerson(Long projectId) {
        personRepository.deleteById(projectId);
    }

    @Override
    public Person addPersonToProject(@Valid ProjectMemberDto projectMemberDto) {
        Person personAdded = new Person();
        Optional<Person> personExistent = null;
        Project project = projectRepository.findById(projectMemberDto.getIdProjeto()).get();
        List<Project> projectList = new ArrayList<>();
   //     Project project = projectService.getProjectById(projectMemberDto.getIdProjeto());
        if (project != null) {
            if(projectMemberDto.getIdPessoa() != null) {
                // verifica se pessoa já foi cadastrada
                personExistent = personRepository.findById(projectMemberDto.getIdPessoa());
            }
            // caso positivo, a mantém no fluxo; caso negativo seta seus campos pelo Dto
            Person personAlreadyAdded = personExistent != null ? personExistent.get() : null;
            if (personAlreadyAdded != null) {
                // seta então somente a nova informação se é funcionário ou não
                personAdded.setFuncionario(projectMemberDto.isFuncionario());
                personAdded.getProjetos().add(project);
            } else if (projectMemberDto.isFuncionario()) {
                // mas sendo novo funcionário, faz-se então seu cadastro, seguido da atribuição de membro para o projeto informado
                projectList.add(project);
                personAdded.setFuncionario(projectMemberDto.isFuncionario());
                personAdded.setNome(projectMemberDto.getNome());
                personAdded.setCpf(projectMemberDto.getCpf());
                personAdded.setCargo(projectMemberDto.getCargo());
                personAdded.setDataNascimento(projectMemberDto.getDataNascimento());
                personAdded.setProjetos(projectList);
            }
            personAdded =  personRepository.save(personAdded);
        }

        return personAdded;
    }
}
