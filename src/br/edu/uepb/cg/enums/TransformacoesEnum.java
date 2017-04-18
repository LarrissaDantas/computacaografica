package br.edu.uepb.cg.enums;

/**
 * Mapeia os tipos de tranformações 2D/3D em objetos
 *
 * @author Douglas Rafael
 */
public enum TransformacoesEnum {
    TRANSLACAO("Translação"), ESCALA("Escala"), ROTACAO("Rotação"), REFLEXAO("Reflexão"), CISALHAMENTO("Cisalhamento"), COMPOSTA("Composta");

    private final String titulo;

    TransformacoesEnum(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }
}
