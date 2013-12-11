package br.ufrn.ceres.bsi.questions;

import br.ufrn.ceres.bsi.questions.dao.*;
import br.ufrn.ceres.bsi.questions.dao.util.JPAUtil;
import br.ufrn.ceres.bsi.questions.model.*;


public class Main {

    /**
     * Método main para testar os conceitos.
     * @param args
     */
    public static void main(String[] args) {

        Endereco endereco = new Endereco();
        endereco.setCity("Caicó");
        endereco.setCountry("Brasil");
        endereco.setStreet("Presidente Kennedy");
        endereco.setSuburb("Acampamento");

        Usuario user1 = new Usuario();
        user1.setUsername("tacianosilva");
        user1.setFirstname("Taciano");
        user1.setLastname("Silva");
        user1.setEmail("tacianosilva@gmail.com");
        user1.setPassword("12345");
        user1.setAddress(endereco);

        Usuario user2 = new Usuario();
        user2.setUsername("xuxa");
        user2.setFirstname("Xuxa");
        user2.setLastname("????");
        user2.setEmail("xuxa@gmail.com");
        user2.setPassword("12345");
        user2.setAddress(endereco);

        UserService service = new UserService(JPAUtil.EMF);
        service.create(user1);
        service.create(user2);

        System.out.println(service.find(user1.getId()));
        System.out.println(service.find(user2.getId()));

        service.delete(user1.getId());

        System.out.println(service.find(user1.getId()));
        System.out.println(service.find(user2.getId()));
        
  
        
        QuestionService service2 = new QuestionService(JPAUtil.EMF);
        AlternativaService service3 = new AlternativaService(JPAUtil.EMF);
        Questao questao1;
        Questao questao2;
        Alternativa alt1;
        Alternativa alt2;
        Alternativa alt3;
        Alternativa alt4;
        Alternativa alt5;
        Alternativa alt6;
        
        alt1 = new Alternativa("Sim");
        alt2 = new Alternativa("Não");

        questao1 = new Questao();
        questao1.setDescricao("Você gosta de Caicó?");
        questao1.addAlternativa(alt1);
        questao1.addAlternativa(alt2);
    

        alt3 = new Alternativa("Ótimo");
        alt4 = new Alternativa("Bom");
        alt5 = new Alternativa("Regular");
        alt6 = new Alternativa("Ruim");

        questao2 = new Questao();
        questao2.setDescricao("Qual seu nível de programador?");
        questao2.addAlternativa(alt3);
        questao2.addAlternativa(alt4);
        questao2.addAlternativa(alt5);
        questao2.addAlternativa(alt6);
    
        
        service3.create(alt1);
        service3.create(alt2);
        service3.create(alt3);
        service3.create(alt4);
        service3.create(alt5);
        service3.create(alt6);

        service2.create(questao1);
        service2.create(questao2);

        System.out.println(service2.find(questao1.getId()));
        System.out.println(service2.find(questao2.getId()));

        service2.remove(questao1.getId());

        System.out.println(service2.find(questao1.getId()));
        System.out.println(service2.find(questao2.getId()));
    }
}
