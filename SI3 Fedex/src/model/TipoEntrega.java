package model;

public enum TipoEntrega {
    AEREO(1),
    RODOVIARIO(2);

    private final int codigo;

    TipoEntrega(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public static TipoEntrega fromCodigo(int codigo) {
        for (TipoEntrega tipo : TipoEntrega.values()) {
            if (tipo.getCodigo() == codigo) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Código de TipoEntrega inválido: " + codigo);
    }
}
