package br.ufrn.ceres.bsi.questions.model;

import java.util.*;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedQueries({
    @NamedQuery(name="Questao.findALL", query="SELECT q FROM Questao q")
})
public class Questao extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column
    private String descricao;
	@OneToMany(targetEntity = Alternativa.class, cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private List<Alternativa> alternativas;
	

    public Questao() {
    	alternativas = new ArrayList<Alternativa>();
    	
    }

    public void addAlternativa(Alternativa alternativa) {
        alternativas.add(alternativa);
    }


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
