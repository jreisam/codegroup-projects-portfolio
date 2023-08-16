package br.com.codegroup.portfolio.enums;

/**
 * @author João Robson 12/08/2023
 */
public enum ProjectRiskEnum {

    RISCO_BAIXO("RISCO_BAIXO"),
    RISCO_MEDIO("RISCO_MEDIO"),
    RISCO_ALTO("RISCO_ALTO");

    private final String text;

    ProjectRiskEnum(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return this.text;
    }
}
