package model;

import java.math.BigDecimal;
import java.sql.Date;

//Classe que vai ser uma tabela no banco de dados
public class Envio {

    //Variaveis privadas que vão servir como colunas no banco de dados
    private int id;
    private Destinatario destinatario;
    private Remetente remetente;
    private TipoEntrega tipoEntrega;
    private BigDecimal peso;
    private Date dataEnvio;
    private String codigoRastreamento = gerarCodigoRastreamento();
    private String status;

    //Método construtor para futuras instancias
    public Envio(String codigoRastreamento, Destinatario destinatario, Remetente remetente, TipoEntrega tipoEntrega, BigDecimal peso, Date dataEnvio, String status) {
        this.codigoRastreamento = codigoRastreamento;
        this.destinatario = destinatario;
        this.remetente = remetente;
        this.tipoEntrega = tipoEntrega;
        this.peso = peso;
        this.dataEnvio = dataEnvio;
        this.status = status;
    }

    //Método construtor para futuras instancias
    public Envio(int id, Destinatario destinatario, Remetente remetente, TipoEntrega tipoEntrega, BigDecimal peso,
            Date dataEnvio, String status) {
        this.id = id;
        this.destinatario = destinatario;
        this.remetente = remetente;
        this.tipoEntrega = tipoEntrega;
        this.peso = peso;
        this.dataEnvio = dataEnvio;
        this.status = status;
    }

    //Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Destinatario getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Destinatario destinatario) {
        this.destinatario = destinatario;
    }

    public Remetente getRemetente() {
        return remetente;
    }

    public void setRemetente(Remetente remetente) {
        this.remetente = remetente;
    }

    public TipoEntrega getTipoEntrega() {
        return tipoEntrega;
    }

    public void setTipoEntrega(TipoEntrega tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public Date getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(Date dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public String getCodigoRastreamento() {
        return codigoRastreamento;
    }

    public void setCodigoRastreamento(String codigoRastreamento) {
        this.codigoRastreamento = codigoRastreamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    //Método que retorna um código aleatório com alguns padrões
    private static String gerarCodigoRastreamento() {
        String prefixo = "FDX";
        String data = java.time.LocalDate.now().toString().replace("-", "");
        int numero = (int) (Math.random() * 1000);
        return prefixo + data + String.format("-%04d", numero);
    }

}
