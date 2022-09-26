package com.carteiradevacinacao.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.JoinColumn;

@Entity
@Table
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="CODIGO")
    private int codigo;

    @Column(name="NOME", length = 100, nullable = false)
    private String nome;

    @Column(name="DATA_DE_NASCIMENTO", nullable = false)
    private java.sql.Date dataDeNascimento;

    @Column(name="EMAIL", length = 100, nullable = false)
    private String email;

    @Column(name="TELEFONE", length = 100)
    private int telefone;

    @Column(name="SEXO", length = 10, nullable = false)
    private String sexo;

    @ManyToMany
    @JoinTable(
        name="AnimaisTutores", 
        uniqueConstraints = @UniqueConstraint(columnNames = { "codigo_tutor", "id_animal" }),
        joinColumns        = @JoinColumn(name = "codigo_tutor" ),
        inverseJoinColumns = @JoinColumn(name = "id_animal")
    )
    private List<Animal> animais;

    @Override
    public String toString() {
        return "Tutor [codigo=" + codigo + ", nome=" + nome + "]";
    }


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public java.sql.Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(java.sql.Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public List<Animal> getAnimais() {
        return animais;
    }

    public void setAnimais(List<Animal> animais) {
        this.animais = animais;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }


}

