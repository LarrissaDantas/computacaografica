package br.edu.uepb.cg.enums;

/**
 * Mapeia os tipos de tranformações em proc. de imagem
 *
 * @author Douglas Rafael
 */
public enum GraficosEnum {
    COLUNA("Coluna"), BARRA("Barra"), PIE("Pie");

    private final String titulo;

    GraficosEnum(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }
}
