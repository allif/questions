package br.ufrn.ceres.bsi.questions.beans;

import java.util.List;

import br.ufrn.ceres.bsi.questions.dao.AlternativaService;
import br.ufrn.ceres.bsi.questions.dao.QuestionService;
import br.ufrn.ceres.bsi.questions.dao.util.JPAUtil;
import br.ufrn.ceres.bsi.questions.model.Alternativa;
import br.ufrn.ceres.bsi.questions.model.Questao;

public class ManterQuestaoBean {
        

        private AlternativaService serviceAlt;
        private QuestionService service;
        
        private Questao questao;
        private Alternativa alternativa1;
        private Alternativa alternativa2;
        private Alternativa alternativa3;
        private Alternativa alternativa4;
        
        private List<Questao> questoes;
    
        public ManterQuestaoBean() {
                service = new QuestionService(JPAUtil.EMF);
                serviceAlt = new AlternativaService(JPAUtil.EMF);
                
                questao = new Questao();
                alternativa1 = new Alternativa();
                alternativa2 = new Alternativa();
                alternativa3 = new Alternativa();
                alternativa4= new Alternativa();
                
                this.preencherTabela();
        }
 
        public void inserir() {
                try {
                        serviceAlt.create(alternativa1);
                        serviceAlt.create(alternativa2);
                        serviceAlt.create(alternativa3);
                        serviceAlt.create(alternativa4);
                        
                        questao.addAlternativa(alternativa1);
                        questao.addAlternativa(alternativa2);
                        questao.addAlternativa(alternativa3);
                        questao.addAlternativa(alternativa4);
                        
                        service.create(questao);
                } catch(Exception e) {
                        e.printStackTrace();
                }
                
                this.limparConteudo();
                this.preencherTabela();
        }
        
        public void excluir(Questao q) {
                service.remove(q.getId());
                
                this.preencherTabela();
        }
        
        public void editar(Questao questao) {
                
        }
        
        public void preencherTabela() {
                questoes = service.findAll();
        }
        
        public void limparConteudo() {
                questao = new Questao();
                alternativa1 = new Alternativa();
                alternativa2 = new Alternativa();
                alternativa3 = new Alternativa();
                alternativa4 = new Alternativa();
        }
        
        public void mostarEdicao(Questao questao) {
                this.setQuestao(questao);
        }

        public void setQuestao(Questao questao) {
                this.questao = questao;
        }
        public Questao getQuestao() {
                return this.questao;
        }
        public void setAlternativa1(Alternativa alternativa){
                this.alternativa1 = alternativa;
        }
        public Alternativa getAlternativa1() {
                return this.alternativa1;
        }
        public void setAlternativa2(Alternativa alternativa){
                this.alternativa2 = alternativa;
        }
        public Alternativa getAlternativa2() {
                return this.alternativa2;
        }
        public void setAlternativa3(Alternativa alternativa){
                this.alternativa3 = alternativa;
        }
        public Alternativa getAlternativa3() {
                return this.alternativa3;
        }
        public void setAlternativa4(Alternativa alternativa){
                this.alternativa4 = alternativa;
        }
        public Alternativa getAlternativa4() {
                return this.alternativa4;
        }
        public void setQuestoes(List<Questao> questoes) {
                this.questoes = questoes;
        }
        public List<Questao> getQuestoes() {
                return this.questoes;
        }

        
}
