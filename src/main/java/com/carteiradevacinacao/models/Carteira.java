package com.carteiradevacinacao.models;

import java.util.List;

import javax.persistence.*;



@Entity
public class Carteira {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private int id;

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinTable(
        name="AnimaisCarteiras", 
        uniqueConstraints = @UniqueConstraint(columnNames = { "id_carteira", "id_animal" }),
        joinColumns        = @JoinColumn(name = "id_carteira"),
        inverseJoinColumns = @JoinColumn(name = "id_animal")
    ) 
    private List<Animal> animais;

    @OneToMany
    @JoinTable(
        name="CarteirasVacinas", 
        uniqueConstraints = @UniqueConstraint(columnNames = { "id_carteira", "idVacina" }),
        joinColumns        = @JoinColumn(name = "id_carteira" ),
        inverseJoinColumns = @JoinColumn(name = "idVacina")
    ) 
    private List<Vacina> vacinas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Animal> getAnimais(){
        return animais;
    }

    public void setAnimais(List<Animal> animais) {
        this.animais = animais;
    }

    public List<Vacina> getVacinas() {
        return vacinas;
    }

    public void setVacinas(List<Vacina> vacinas) {
        this.vacinas = vacinas;
    }

    

  

  
   
}
