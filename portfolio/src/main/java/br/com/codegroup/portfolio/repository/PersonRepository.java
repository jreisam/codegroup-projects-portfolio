package br.com.codegroup.portfolio.repository;

import br.com.codegroup.portfolio.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author João Robson 12/08/2023
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByNome(String nome);

    Optional<Person> findById(Long id);
}
