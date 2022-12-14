package com.carteiradevacinacao.models;

import java.util.List;

import javax.persistence.CascadeType;
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

    @Column(name="NOME", length = 100)
    private String nome;

    @Column(name="DATA_DE_NASCIMENTO")
   
    private java.sql.Date dataNascimento;

    

    @Column(name="EMAIL", length = 50)
    private String email;

    @Column(name="TELEFONE", length = 20)
    private String telefone;

    @Column(name="SEXO", length = 10)
    private String sexo;


    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
        name="AnimaisTutores", 
        uniqueConstraints = @UniqueConstraint(columnNames = { "codigo_tutor", "id_animal" }),
        joinColumns        = @JoinColumn(name = "codigo_tutor" ),
        inverseJoinColumns = @JoinColumn(name = "id_animal")
    ) 
    private List<Animal> animais;


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


    public java.sql.Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(java.sql.Date dataNascimento) {
        this.dataNascimento = dataNascimento;
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

    @Override
    public String toString() {
        return "Tutor [codigo=" + codigo + ", nome=" + nome + "]";
    }

}

