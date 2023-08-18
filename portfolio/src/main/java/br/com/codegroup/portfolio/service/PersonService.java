package br.com.codegroup.portfolio.service;

import br.com.codegroup.portfolio.dto.ProjectMemberDto;
import br.com.codegroup.portfolio.model.Person;
import br.com.codegroup.portfolio.model.Project;

import java.util.List;
import java.util.Optional;

/**
 * @author João Robson 14/08/2023
 */
public interface PersonService {

    Person createPerson(Person person);
    Person getPersonById(Long personId);
    List<Person> getAllPersons();
    Person updatePerson(Person person);
    void deletePerson(Long personId);

    Person addPersonToProject(ProjectMemberDto projectMemberDto);


}
