package com.example.quartoandar.entities;

import com.example.quartoandar.entities.enums.EstateType;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_estate")
public class Estate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private EstateType estateType;
    private String cidade;
    private int diaria;

    public Estate() {
    }

    public Estate(Long id ,String nome, EstateType estateType, String cidade, int diaria) {
        this.id = id;
        this.nome = nome;
        this.estateType = estateType;
        this.cidade = cidade;
        this.diaria = diaria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public EstateType getEstateType() {
        return estateType;
    }

    public void setEstateType(EstateType estateType) {
        this.estateType = estateType;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getDiaria() {
        return diaria;
    }

    public void setDiaria(int diaria) {
        this.diaria = diaria;
    }
}
