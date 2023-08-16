package br.com.codegroup.portfolio.service;

import br.com.codegroup.portfolio.model.Person;
import br.com.codegroup.portfolio.repository.PersonRepository;
import br.com.codegroup.portfolio.repository.PersonRepository;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author João Robson 14/08/2023
 */
@Service
public class PersonServiceImpl implements PersonService {


    @Autowired
    private PersonRepository projectRepository;
    @Autowired
    private PersonRepository personRepository;

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

    public void deletePerson(Long projectId) {
        personRepository.deleteById(projectId);
    }

}
