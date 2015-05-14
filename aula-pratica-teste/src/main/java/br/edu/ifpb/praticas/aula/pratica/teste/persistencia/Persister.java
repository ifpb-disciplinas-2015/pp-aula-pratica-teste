package br.edu.ifpb.praticas.aula.pratica.teste.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author DouglasGabriel
 */
public class Persister {

    public static void salvar(Object object) {
        if (object != null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("desenvolvimento");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            try {
                em.persist(object);
                em.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
                em.getTransaction().rollback();
            } finally {
                em.close();
            }
        }
    }

    public static Object localizar(Class clazz, Object id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("desenvolvimento");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Object obj = null;
        try {
            obj = em.find(clazz, id);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return obj;
    }

}
