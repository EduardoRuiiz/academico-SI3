package model;

// Declaração de um enum chamado TipoEntrega
public enum TipoEntrega {
    // Constantes do enum representando os tipos de entrega com seus respectivos códigos
    AEREO(1, "AEREO"),
    RODOVIARIO(2, "RODOVIARIO");

    // Campo privado que armazena o código associado ao tipo de entrega
    private final int codigo;
    private final String descricao;

    // Construtor do enum que recebe o código como parâmetro
    TipoEntrega(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    // Método getter que retorna o código do tipo de entrega
    public int getCodigo() {
        return codigo;
    }

    // Método getter que retorna a descrição do tipo de entrega
    public String getDescricao() {
        return descricao;
    }

    // Método estático que retorna o tipo de entrega com base em um código fornecido
    public static TipoEntrega fromDescricao(String descricao) {
        for (TipoEntrega tipo : TipoEntrega.values()) {
            if (tipo.getDescricao().equalsIgnoreCase(descricao)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Descrição de TipoEntrega inválida: " + descricao);
    }

    @Override
    public String toString() {
        return descricao; // Para exibir de forma amigável no combo e etiquetas
    }
}
