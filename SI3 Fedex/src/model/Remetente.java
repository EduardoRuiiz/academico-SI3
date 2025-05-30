package model;

//Classe que vai ser uma tabela no banco de dados
public class Remetente {

    //Variaveis privadas que vão servir como colunas no banco de dados
    private int id;
    private String nome;
    private String cnpj;
    private String endereco;
    private String telefone;

    //Método construtor para futuras instancias
    public Remetente(int id, String nome, String cnpj, String endereco, String telefone) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCpf(String cnpj) {
        this.cnpj = cnpj;
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
        return nome + "-" + cnpj;
    }

}
