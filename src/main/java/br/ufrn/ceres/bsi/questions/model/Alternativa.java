package br.ufrn.ceres.bsi.questions.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Alternativa extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column
    private String descricao;

    public Alternativa(String alternativa) {
        this.setDescricao(alternativa);
    }

    public Alternativa() {

    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
