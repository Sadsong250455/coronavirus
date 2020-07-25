/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

/**
 *
 * @author Hanitriniaina
 */
import DAO.Function;
import Model.Cas;
import java.util.ArrayList;
import java.util.List;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hanitriniaina
 */
public class Service {  
    
    Function dao = new Function();
    
    //recuperer
    public ArrayList <Cas> findAllCasService() throws Exception{
      return dao.findAllCas();
    }
    
    //ordonner
    public List <Cas> ordonnerCasService() throws Exception{
      return dao.ordonnerCas();
    }
    
    //trier
    public List<Cas> trierCasService(String valeur) throws Exception{
        return dao.trierCas(valeur);
    }
    
    //filtrer
    public List<Cas> filterCasService(String nb1,String nb2) throws Exception{
        return dao.filtrerCas(nb1, nb2);
    }
}

