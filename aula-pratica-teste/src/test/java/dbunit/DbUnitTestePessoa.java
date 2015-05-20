/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbunit;


import br.edu.ifpb.praticas.aula.pratica.teste.entidades.Pessoa;
import br.edu.ifpb.praticas.aula.pratica.teste.persistencia.DAO;
import br.edu.ifpb.praticas.aula.pratica.teste.persistencia.DAOJPA;
import org.junit.After;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Marcelo Augusto
 */

public class DbUnitTestePessoa {
    
    private static DBUnitHelper dbUnitHelp;
    private DAO<Pessoa> daoJpa;
    
    public DbUnitTestePessoa() {
        daoJpa=new DAOJPA("unidade02");
        dbUnitHelp.insert("/tabelas/Pessoa.xml");
        
    }
    
    @BeforeClass
    public static void setUpClass() {
        dbUnitHelp=new DBUnitHelper();
    }
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void testeBanco(){
        Pessoa pessoa=daoJpa.buscar(new Long(1), Pessoa.class);
        assertNotNull(pessoa);
    }
    
    @After
    public void setDown(){
//        dbUnitHelp.execute(DatabaseOperation.DELETE_ALL);
    }
}
