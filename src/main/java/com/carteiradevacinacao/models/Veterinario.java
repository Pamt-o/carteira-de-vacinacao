package com.carteiradevacinacao.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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

    @Column(name="EMAIL", length = 8, nullable = false)
    private String email;

    @Column(name="TELEFONE", length = 100)
    private int telefone;

    @Column(name="CRMV", length = 20)
    private int crmv;

    @ManyToOne
    @JoinColumn(name="ID_ANIMAL")
    private Animal animal;


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

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public int getCrmv() {
        return crmv;
    }

    public void setCrmv(int crmv) {
        this.crmv = crmv;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    @Override
    public String toString() {
        return "Veterinario [animal=" + animal.getNome() + ", matricula=" + matricula + ", nome=" + nome + "]";
    }
    
}
