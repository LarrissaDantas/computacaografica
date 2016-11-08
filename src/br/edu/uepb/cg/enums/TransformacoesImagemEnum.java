package br.edu.uepb.cg.enums;

/**
 * Mapeia os tipos de tranformações em proc. de imagem
 *
 * @author Douglas Rafael
 */
public enum TransformacoesImagemEnum {
    NEGATIVO("Negativo"), GAMMA("Gamma"), LOG("Logaritmo");

    private final String titulo;

    TransformacoesImagemEnum(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }
}
