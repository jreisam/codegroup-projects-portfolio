package br.com.codegroup.portfolio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author João Robson 12/08/2023
 */
@Entity
@Table(name = "Pessoas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person extends BaseModel {

    @Column(nullable = false)
    private String nome;
    private Date dataNascimento;
    @Column(length = 14, unique = true)
    private Long cpf;
    private boolean funcionario;
    private String cargo;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "membros",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private List<Project> projetos;

}
