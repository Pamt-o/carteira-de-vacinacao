package com.carteiradevacinacao.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Vacina {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private int idVacina;

    @Column(name="NOME", length = 100, nullable = false)
    private String nomeVacina;

    @Column(name="DATA_DE_VENCIMENTO_LOTE", nullable = false)
    private java.sql.Date dataVencimentoLote;

    @Column(name="Marca", length = 30, nullable = false)
    private String marcaVacina;

    @Column(name="DATA_APLICACAO", nullable = false)
    private java.sql.Date dataAplicacao;

    @OneToMany
    private List<Veterinario> veterinarios;

    public int getIdVacina() {
        return idVacina;
    }

    public void setIdVacina(int idVacina) {
        this.idVacina = idVacina;
    }

    public String getNomeVacina() {
        return nomeVacina;
    }

    public void setNomeVacina(String nomeVacina) {
        this.nomeVacina = nomeVacina;
    }

    public java.sql.Date getDataVencimentoLote() {
        return dataVencimentoLote;
    }

    public void setDataVencimentoLote(java.sql.Date dataVencimentoLote) {
        this.dataVencimentoLote = dataVencimentoLote;
    }

    public String getMarcaVacina() {
        return marcaVacina;
    }

    public void setMarcaVacina(String marcaVacina) {
        this.marcaVacina = marcaVacina;
    }

    public java.sql.Date getDataAplicacao() {
        return dataAplicacao;
    }

    public void setDataAplicacao(java.sql.Date dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }

    public List<Veterinario> getVeterinarios() {
        return veterinarios;
    }

    public void setVeterinarios(List<Veterinario> veterinarios) {
        this.veterinarios = veterinarios;
    }

}
