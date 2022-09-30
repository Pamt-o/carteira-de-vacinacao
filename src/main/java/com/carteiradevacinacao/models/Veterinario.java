package com.carteiradevacinacao.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;



@Entity
@Table
public class Veterinario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="MATRICULA")
    private int matricula;

    @Column(name="NOME", length = 100, nullable = false)
    private String nome;

    @Column(name="DATA_DE_NASCIMENTO", nullable = false)
    private java.sql.Date dataDeNascimento;

    @Column(name="EMAIL", length = 30, nullable = false)
    private String email;

    @Column(name="TELEFONE", length = 100)
    private long telefone;

    @Column(name="CRMV", length = 20)
    private int crmv;

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(
        name="AnimaisVeterinarios", 
        uniqueConstraints = @UniqueConstraint(columnNames = { "matricula_veterinario", "id_animal" }),
        joinColumns        = @JoinColumn(name = "matricula_veterinario" ),
        inverseJoinColumns = @JoinColumn(name = "id_animal")
    )
    private List<Animal> animais;


    public List<Animal> getAnimais() {
        return animais;
    }

    public void setAnimais(List<Animal> animais) {
        this.animais = animais;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
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

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public int getCrmv() {
        return crmv;
    }

    public void setCrmv(int crmv) {
        this.crmv = crmv;
    }

 

    @Override
    public String toString() {
        return "Veterinario [ matricula=" + matricula + ", nome=" + nome + "]";
    }
    
}
