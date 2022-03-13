package com.dio_class.devweek.Entity;

import javax.persistence.*;

@Entity
public class Regiao {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String regiao;
    private Integer qtd_exames;

    public Regiao(String regiao, Integer qtd_exames) {
        this.regiao = regiao;
        this.qtd_exames = qtd_exames;
    }

    public Regiao() { }

    public Long getId() {
        return id;
    }

    public String getRegiao() { return regiao; }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public Integer getQtd_exames() {
        return qtd_exames;
    }

    public void setQtd_exames(Integer qtd_exames) {
        this.qtd_exames = qtd_exames;
    }
}

