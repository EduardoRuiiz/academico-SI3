package model;

// Declaração de um enum chamado TipoEntrega
public enum TipoEntrega {
    // Constantes do enum representando os tipos de entrega com seus respectivos códigos
    AEREO(1),
    RODOVIARIO(2);

    // Campo privado que armazena o código associado ao tipo de entrega
    private final int codigo;

    // Construtor do enum que recebe o código como parâmetro
    TipoEntrega(int codigo) {
        this.codigo = codigo;
    }

    // Método getter que retorna o código do tipo de entrega
    public int getCodigo() {
        return codigo;
    }

    // Método estático que retorna o tipo de entrega com base em um código fornecido
    public static TipoEntrega fromCodigo(int codigo) {
        // Percorre todos os valores possíveis do enum TipoEntrega
        for (TipoEntrega tipo : TipoEntrega.values()) {
            // Verifica se o código do tipo atual é igual ao código fornecido
            if (tipo.getCodigo() == codigo) {
                return tipo; // Retorna o tipo correspondente
            }
        }
        // Se nenhum tipo for encontrado com o código fornecido, lança uma exceção
        throw new IllegalArgumentException("Código de TipoEntrega inválido: " + codigo);
    }
}
