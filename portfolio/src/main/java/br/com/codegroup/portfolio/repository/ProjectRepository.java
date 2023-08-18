package br.com.codegroup.portfolio.repository;

import br.com.codegroup.portfolio.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

/**
 * @author João Robson 12/08/2023
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {


    Optional<Project> findByNome(String nome);

    Optional<Project> findById(Long id);



    Optional<List<Project>> findAllByPessoas_Id(Long personId);
}
