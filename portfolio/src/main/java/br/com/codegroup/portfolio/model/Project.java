package br.com.codegroup.portfolio.model;

import br.com.codegroup.portfolio.enums.ProjectRiskEnum;
import br.com.codegroup.portfolio.enums.ProjectStatusEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "Projetos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project extends BaseModel {

// nome, data de início, gerente responsável, previsão de término, data real de término, orçamento total, descrição e status.

    @Column(length = 200, nullable = false, unique = true)
    private String nome;
    private Date dataInicio;
    private Date dataPrevisaoFim;
    private Date dataFim;
    @Column(length = 5000)
    private String descricao;
    //    @ManyToOne
//    @JoinColumn(name = "projetoIdGerente", referencedColumnName = "id", nullable = true)
    private Long idGerente;
    @Enumerated
    @Column(length = 45)
    private ProjectStatusEnum status;
    @Enumerated
    @Column(length = 45)
    private ProjectRiskEnum risco;
    private Float orcamento;
    @ManyToMany(mappedBy = "projetos")
    private List<Person> pessoas;


}
