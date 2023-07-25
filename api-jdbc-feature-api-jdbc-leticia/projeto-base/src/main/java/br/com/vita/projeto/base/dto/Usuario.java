package br.com.vita.projeto.base.dto;

public class Usuario {

    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String endereco;

    public Usuario(){
    }

    public Usuario(String nome, String cpf, String email, String telefone, String endereco) {

        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("\nNome: %s\nCPF: %s\nE-mail: %s\nTelefone: %s\nEndereço: %s\n",
                nome, cpf, email, telefone, endereco);
    }
}
