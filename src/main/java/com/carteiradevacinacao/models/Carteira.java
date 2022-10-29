package com.carteiradevacinacao.models;

import java.util.List;

import javax.persistence.*;



@Entity
@Table
public class Carteira {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private int idCarteira;
    private String nome;
    private java.sql.Date dataDeNascimento;
    private String raca;
    private String especie;


    @OneToMany(cascade = {CascadeType.ALL})
    @JoinTable(
        name="AnimaisCarteiras", 
        uniqueConstraints = @UniqueConstraint(columnNames = { "id_carteira", "id_animal" }),
        joinColumns        = @JoinColumn(name = "id_carteira"),
        inverseJoinColumns = @JoinColumn(name = "id_animal")
    ) 
    private List<Animal> animais;

    public List<Animal> getAnimais() {
        return animais;
    }


    public void setAnimais(List<Animal> animais) {
        this.animais = animais;
    }


    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "CARTEIRA_ID")
    private List<Vacina> vacinas;



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


    public String getRaca() {
        return raca;
    }


    public void setRaca(String raca) {
        this.raca = raca;
    }


    public String getEspecie() {
        return especie;
    }


    public void setEspecie(String especie) {
        this.especie = especie;
    }


    public int getIdCarteira() {
        return idCarteira;
    }


    public void setIdCarteira(int idCarteira) {
        this.idCarteira = idCarteira;
    }


    public List<Vacina> getVacinas() {
        return vacinas;
    }


    public void setVacinas(List<Vacina> vacinas) {
        this.vacinas = vacinas;
    }

 
   
}
