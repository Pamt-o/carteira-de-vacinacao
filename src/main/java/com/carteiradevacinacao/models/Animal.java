package com.carteiradevacinacao.models;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;
import javax.persistence.Table;

@Entity
@Table
public class Animal{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private int id;

    @Column(name="NOME", length = 100, nullable = false)
    private String nome;

    @Column(name="DATA_DE_NASCIMENTO", nullable = false)
    private java.sql.Date dataDeNascimento;

    @Column(name="ESPECIE", length = 8, nullable = false)
    private String especie;

    @Column(name="COR_DA_PELAGEM", length = 100)
    private String corDaPelagem;

    @Column(name="RAÇA", length = 100, nullable = false)
    private String raca;

    @Column(name="SEXO", length = 5, nullable = false)
    private String sexo;


    @Column(name="NÚMERO_DO_MICROSHIP", length = 100)
    private int numeracaoMicroChip;

    @Column(name = "REGISTRO_GERAL_DO_ANIMAL", length = 100)
    private int registroGeralDoAnimal;

    @OneToMany
    @JoinColumn(name = "ID_ANIMAL")
    private List<Veterinario> veterinarios;

    @ManyToMany
    @JoinTable(
        name="AnimaisTutores", 
        uniqueConstraints = @UniqueConstraint(columnNames = { "codigo_tutor", "id_animal" }),
        joinColumns        = @JoinColumn(name = "id_animal"), 
        inverseJoinColumns = @JoinColumn(name = "codigo_tutor")
    )
    private List<Tutor> tutores;



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

    public java.sql.Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(java.sql.Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getCorDaPelagem() {
        return corDaPelagem;
    }

    public void setCorDaPelagem(String corDaPelagem) {
        this.corDaPelagem = corDaPelagem;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getNumeracaoMicroChip() {
        return numeracaoMicroChip;
    }

    public void setNumeracaoMicroChip(int numeracaoMicroChip) {
        this.numeracaoMicroChip = numeracaoMicroChip;
    }

    public int getRegistroGeralDoAnimal() {
        return registroGeralDoAnimal;
    }

    public void setRegistroGeralDoAnimal(int registroGeralDoAnimal) {
        this.registroGeralDoAnimal = registroGeralDoAnimal;
    }

    public List<Tutor> getTutores() {
        return tutores;
    }

    public void setTutores(List<Tutor> tutores) {
        this.tutores = tutores;
    }

    @Override
    public String toString() {
        return "Animal [corDaPelagem=" + corDaPelagem + ", dataDeNascimento=" + dataDeNascimento + ", especie="
                + especie + ", id=" + id + ", nome=" + nome + ", numeracaoMicroChip=" + numeracaoMicroChip + ", raca="
                + raca + ", registroGeralDoAnimal=" + registroGeralDoAnimal + ", sexo=" + sexo + "]";
    }

}
