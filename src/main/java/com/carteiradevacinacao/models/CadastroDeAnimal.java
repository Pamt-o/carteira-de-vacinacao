package com.carteiradevacinacao.models;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cadastro")
public class CadastroDeAnimal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private int id;

    @Column(name="Nome", length = 100, nullable = false)
    private String nome;

    @Column(name="Data de nascimento", nullable = false)
    private Date dataDeNascimento;

    @Column(name="Espécie", length = 8, nullable = false)
    private String especie;

    @Column(name="Cor da pelagem", length = 100)
    private String corDaPelagem;

    @Column(name="Raça", length = 100, nullable = false)
    private String raça;

    @Column(name="Sexo", length = 5, nullable = false)
    private String sexo;

    @Column(name="Número do microhip", length = 100)
    private int numeracaoMicroChip;

    @Column(name = "Registro geral do Animal (RGA)", length = 100)
    private int registroGeralDoAnimal;

    
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

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
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

    public String getRaça() {
        return raça;
    }

    public void setRaça(String raça) {
        this.raça = raça;
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



}
