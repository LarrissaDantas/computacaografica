package br.edu.uepb.cg.enums;

/**
 * Mapeia os tipos de eixos.
 * 
 * @author Douglas Rafael
 */
public enum Eixo {
    X("X"), Y("Y"), Z("Z"), XY("XY"), XZ("XZ"), YZ("YZ");
    
    private final String value;

    Eixo(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
}
