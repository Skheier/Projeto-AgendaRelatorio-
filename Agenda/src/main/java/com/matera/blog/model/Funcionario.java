package com.matera.blog.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Funcionario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String telefone;
    private String email;
    @ManyToOne
    private Endereco endereco;
    private Double salario;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Endereco getEndereco() {return endereco; }
    public void setEndereco(Endereco endereco) { this.endereco = endereco; }

    public Double getSalario() { return salario; }
    public void setSalario(Double salario) { this.salario = salario; }
}
