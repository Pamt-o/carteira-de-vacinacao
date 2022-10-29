package com.carteiradevacinacao.models;



import javax.persistence.*;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Table
public class Vacina {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private int idVacina;

    @Column(name="NOME", length = 100)
    private String nomeVacina;

    @Column(name="DATA_DE_VENCIMENTO_LOTE")
    private java.sql.Date dataVencimentoLote;

    @Column(name="Marca", length = 30)
    private String marcaVacina;

    @Column(name="DATA_APLICACAO")
    private java.sql.Date dataAplicacao;

    @Column(name="PROXIMA_DOSE")
    private java.sql.Date proximaDose;


    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "CARTEIRA_ID")
    private Carteira carteira;

    public Vacina(){
        
    }

    public Vacina(Carteira carteira) {
        this.carteira = carteira;
    }


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


    public java.sql.Date getProximaDose() {
        return proximaDose;
    }


    public void setProximaDose(java.sql.Date proximaDose) {
        this.proximaDose = proximaDose;
    }


    public Carteira getCarteira() {
        return carteira;
    }


    public void setCarteira(Carteira carteira) {
        this.carteira = carteira;
    }
    

    

   



}
