package br.ufrn.ceres.bsi.questions.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;

import br.ufrn.ceres.bsi.questions.model.Alternativa;

public class AlternativaService {


    private EntityManagerFactory emf = null;

    public AlternativaService(EntityManagerFactory emf) {
        this.emf = emf;

    }
 
    public EntityManager getEntityManager() {
        return this.emf.createEntityManager();
    }

    public Alternativa create(Alternativa alternativa) {
        EntityManager em = null;

        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(alternativa);
            em.flush();
            em.refresh(alternativa);
            em.getTransaction().commit();

        } catch(Exception e) {
            e.printStackTrace();
        }finally {
            if (em != null) {
                em.close();
            }
        }
        
        return alternativa;
    }
    public Alternativa find(Integer id) {

        EntityManager em = getEntityManager();
        try {
            return em.find(Alternativa.class, id);
        } finally {
            em.close();
        }

    }


    public void update(Alternativa alternativa) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(alternativa);
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
            Alternativa questao = new Alternativa();
            try {
                questao = em.getReference(Alternativa.class, id);
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
