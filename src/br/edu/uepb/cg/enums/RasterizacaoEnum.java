package br.edu.uepb.cg.enums;

/**
 * Mapeia os tipos de algoritmos para rasterizaçao da reta
 * 
 * @author Douglas Rafael
 */
public enum RasterizacaoEnum {
    DDA("DDA (Digital Differential Analyser)"), PONTO_MEDIO("Bresenham (Ponto Médio)");
    
    private final String titulo;

    RasterizacaoEnum(String titulo) {
        this.titulo = titulo;
    }
    
    public String getTitulo() {
        return titulo;
    }
}
