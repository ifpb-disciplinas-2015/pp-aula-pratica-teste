/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.praticas.aula.pratica.teste.persistencia;

/**
 *
 * @author Rafael
 */
public interface DAO<T> {
    public boolean salvar(T obj);
    
    public boolean atualizar(T obj);
    
    public boolean excluir(T obj);
    
    public T buscar(Object chave, Class<T> entidade);
}
