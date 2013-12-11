package br.ufrn.ceres.bsi.questions.dao;

import javax.persistence.*;
import java.util.*;

import br.ufrn.ceres.bsi.questions.model.Questao;

public class QuestionService {

 
    private EntityManagerFactory emf = null;

    public QuestionService(EntityManagerFactory emf) {
        this.emf = emf;

    }

    public EntityManager getEntityManager() {
        return this.emf.createEntityManager();
    }

    public Questao create(Questao questao) {
        EntityManager em = null;

        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(questao);
            em.flush();
            em.refresh(questao);
            em.getTransaction().commit();

        } catch(Exception e) {
            e.printStackTrace();
        }finally {
            if (em != null) {
                em.close();
            }
        }
        
        return questao;
    }
    public Questao find(Integer id) {

        EntityManager em = getEntityManager();
        try {
            return em.find(Questao.class, id);
        } finally {
            em.close();
        }

    }

    public List<Questao> findAll() {
        List<Questao> resultado = null;
        EntityManager em = null;

        try {
            em = this.getEntityManager();
            em.getTransaction().begin();
            resultado = em.createNamedQuery("Questao.findALL")
                    .getResultList();
            em.getTransaction().commit();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(em != null) {
                em.close();
            }
        }

        return resultado;
    }

    public void update(Questao questao) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(questao);
            em.getTransaction().commit();

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(em != null) {
                em.close();
            }
        }

    }

    public void remove(Integer id){
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Questao questao = new Questao();
            try {
                questao = em.getReference(Questao.class, id);
                questao.getId();
            } catch (EntityNotFoundException enfe) {
            }
            em.remove(questao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void setEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public EntityManagerFactory getEntityManagerFactory() {
        return this.emf;
    }


}
