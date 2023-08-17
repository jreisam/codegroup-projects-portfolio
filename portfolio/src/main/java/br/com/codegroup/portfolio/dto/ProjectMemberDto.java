package br.com.codegroup.portfolio.dto;

import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

/**
 * @author João Robson 12/08/2023
 */
@Data
public class ProjectMemberDto {

    private Long idProjeto;
    private Long idPessoa;
    @Column(nullable = false)
    private String nome;
    private Date dataNascimento;
    @Column(length = 14, unique = true)
    private String cpf;
    private String cargo;
    private boolean funcionario;

}
