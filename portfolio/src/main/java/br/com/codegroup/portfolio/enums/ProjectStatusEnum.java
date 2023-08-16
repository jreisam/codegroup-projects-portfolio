package br.com.codegroup.portfolio.enums;

/**
 * @author João Robson 12/08/2023
 */
public enum ProjectStatusEnum {

    EM_ANALISE("EM_ANALISE"),
    ANALISE_REALIZADA("ANALISE_REALIZADA"),
    ANALISE_APROVADA("ANALISE_APROVADA"),
    INICIADO("INICIADO"),
    PLANEJADO("PLANEJADO"),
    EM_ANDAMENTO("EM_ANDAMENTO"),
    ENCERRADO("ENCERRADO"),
    CANCELADO("CANCELADO");

    private final String text;

    ProjectStatusEnum(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return this.text;
    }
}
