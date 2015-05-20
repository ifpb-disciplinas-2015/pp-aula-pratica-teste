/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loader;

import br.edu.ifpb.praticas.aula.pratica.teste.persistencia.DAOJPA;

/**
 *
 * @author Marcelo Augusto
 */
public class Principal {
    public static void main(String[] args) {
        DAOJPA dao = new DAOJPA("unidade02");
    }
}
