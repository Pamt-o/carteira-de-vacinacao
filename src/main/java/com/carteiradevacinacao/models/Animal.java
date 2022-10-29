package com.carteiradevacinacao.models;


import java.util.List;

// import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.*;
import javax.persistence.UniqueConstraint;


import javax.persistence.Table;

@Entity
@Table
public class Animal{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private int id;

    @Column(name="NOME", length = 100)
    private String nome;

    
    @Column(name="DATA_DE_NASCIMENTO")
    private java.sql.Date dataDeNascimento;

    @Column(name="ESPECIE", length = 8)
    private String especie;

    @Column(name="COR_DA_PELAGEM")
    private String corDaPelagem;

    @Column(name="RAÇA", length = 50)
    private String raca;

    @Column(name="SEXO", length = 5)
    private String sexo;

    @Column(name="NUMERO_DO_MICROSHIP", length = 20)
    private int numeracaoMicroChip;

    @Column(name = "REGISTRO_GERAL_DO_ANIMAL", length = 20)
    private int registroGeralDoAnimal;

    @ManyToMany
    @JoinTable(
        name="AnimaisTutores", 
        uniqueConstraints = @UniqueConstraint(columnNames = { "codigo_tutor", "id_animal" }),
        joinColumns        = @JoinColumn(name = "id_animal"), 
        inverseJoinColumns = @JoinColumn(name = "codigo_tutor")
    )
    private List<Tutor> tutores;

    @ManyToMany
    @JoinTable(
        name="AnimaisVeterinarios", 
        uniqueConstraints = @UniqueConstraint(columnNames = { "matricula_veterinario", "id_animal" }),
        joinColumns        = @JoinColumn(name = "id_animal"), 
        inverseJoinColumns = @JoinColumn(name = "matricula_veterinario")
    )
    private List<Veterinario> veterinarios;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinTable(
        name="AnimaisCarteiras", 
        uniqueConstraints = @UniqueConstraint(columnNames = { "id_carteira", "id_animal" }),
        joinColumns        = @JoinColumn(name = "id_animal"),
        inverseJoinColumns = @JoinColumn(name = "id_carteira")
    ) 
    private List<Carteira> carteiras;


    public List<Carteira> getCarteiras() {
        return carteiras;
    }

    public void setCarteiras(List<Carteira> carteiras) {
        this.carteiras = carteiras;
    }

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
    public List<Veterinario> getVeterinarios() {
        return veterinarios;
    }

    public void setVeterinarios(List<Veterinario> veterinarios) {
        this.veterinarios = veterinarios;
    }


    @Override
    public String toString() {
        return "Animal [corDaPelagem=" + corDaPelagem + ", dataDeNascimento=" + dataDeNascimento + ", especie="
                + especie + ", id=" + id + ", nome=" + nome + ", numeracaoMicroChip=" + numeracaoMicroChip + ", raca="
                + raca + ", registroGeralDoAnimal=" + registroGeralDoAnimal + ", sexo=" + sexo + "]";
    }

 

}
