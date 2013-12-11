package br.ufrn.ceres.bsi.questions.model;

import java.util.*;

public class Questionario {

  
    private List<Questao> questoes = new ArrayList<Questao>();

    public Questionario() {

    }

    public void addQuestao(Questao questao) {
        this.questoes.add(questao);
    }
 
    public void setQuestoes(List<Questao> questoes) {
        this.questoes = questoes;
    }
    public List<Questao> getQuestoes() {
        return this.questoes;
    }


}
