/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.praticas.aula.pratica.teste.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Rafael
 */
public class DAOJPA<T> implements DAO<T>{

    private EntityManager entityManager;
    
    public DAOJPA(){
        this("desenvolvimento");
    }
    
    public DAOJPA(String unidadePersistencia){
        entityManager=Persistence.createEntityManagerFactory(unidadePersistencia).createEntityManager();
        
    }
    
    @Override
    public boolean salvar(T obj) {
        EntityTransaction transacao=entityManager.getTransaction();
        
        try{
           transacao.begin();
           entityManager.persist(obj);
           transacao.commit();   
           return true;
        }catch(Exception ex){
            if(transacao.isActive())
               transacao.rollback();
            return false;
        }
        
    }

    @Override
    public boolean atualizar(T obj) {
        EntityTransaction transacao=entityManager.getTransaction();
        
        try{
           transacao.begin();
           entityManager.merge(obj);
           transacao.commit();   
           return true;
        }catch(Exception ex){
            if(transacao.isActive())
               transacao.rollback();
            return false;
        }
    }

    @Override
    public boolean excluir(T obj) {
        EntityTransaction transacao=entityManager.getTransaction();
        
        try{
           transacao.begin();
           entityManager.remove(obj);
           transacao.commit();   
           return true;
        }catch(Exception ex){
            if(transacao.isActive())
               transacao.rollback();
            return false;
        }
    }
 
     

    @Override
    public T buscar(Object chave, Class<T> entidade) {
        return entityManager.find(entidade, chave);
    }
    
}
