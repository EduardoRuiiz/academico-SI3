package model;

//Classe que vai ser uma tabela no banco de dados
public class Destinatario {

    //Variaveis privadas que vão servir como colunas no banco de dados
    private int id;
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;

    //Método construtor para futuras instancias
    public Destinatario(int id, String nome, String cpf, String endereco, String telefone) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    //Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    //Método para visualização na criação
    @Override
    public String toString() {
        return nome + " - " + cpf;
    }

}
