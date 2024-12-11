package com.matera.blog.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Entity
public class Agenda implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id private Long id;
    private String descricao;
    @ManyToOne private Servico servico;
    @DateTimeFormat(pattern = "yyyy-MM-dd") private Date data;
    @ManyToOne private Funcionario funcionario;
    @ManyToOne private Cliente cliente;
    //@ManyToOne private Usuario usuario;
    private boolean status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Servico getServico() { return servico; }
    public void setServico(Servico servico) { this.servico = servico; }

    public Date getData() { return data; }
    public void setData(Date data) { this.data = data; }

    public Funcionario getFuncionario() { return funcionario; }
    public void setFuncionario(Funcionario funcionario) { this.funcionario = funcionario; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    //public Usuario getUsuario() { return usuario; }
    //public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public boolean getStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }
}
