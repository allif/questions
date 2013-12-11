package br.ufrn.ceres.bsi.questions.dao;

import br.ufrn.ceres.bsi.questions.model.*;

import javax.persistence.*;

public class UserService {


    private EntityManagerFactory emf = null;

    public UserService(EntityManagerFactory emf) {
        this.emf = emf;

    }

    public void create(Usuario user) {
        EntityManager em = null;

        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(user);
            em.flush();
            em.refresh(user);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    public Usuario find(Integer id) {

        EntityManager em = getEntityManager();
        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }

    }

    public void delete(Integer id){
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario usuario = new Usuario();
            try {
                usuario = em.getReference(Usuario.class, id);
                usuario.getId();
            } catch (EntityNotFoundException enfe) {
                
            }
            em.remove(usuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }


    public EntityManager getEntityManager() {
        return this.emf.createEntityManager();
    }

}
