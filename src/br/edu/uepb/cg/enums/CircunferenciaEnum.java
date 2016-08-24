package br.edu.uepb.cg.enums;

/**
 * Mapeia os tipos de algoritmos para desenhar circunferência
 * 
 * @author Douglas Rafael
 */
public enum CircunferenciaEnum {
    EQUACAO_EXPLICITA("Equação Explícita"), PONTO_MEDIO("Ponto Médio"), TRIGONOMETRIA("Trigonométrica");
    
    private final String titulo;

    CircunferenciaEnum(String titulo) {
        this.titulo = titulo;
    }
    
    public String getTitulo() {
        return titulo;
    }
}
