package br.com.codegroup.portfolio.dto;

import lombok.Data;

/**
 * @author João Robson 12/08/2023
 */
@Data
public class ProjectMemberDto {

    private Long idProjeto;
    private Long idPessoa;
    private boolean funcionario;

}
