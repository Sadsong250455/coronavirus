/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Cas;
import Services.Service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Hanitriniaina
 */

@Controller
public class Controlleur {
    
   Service service = new Service();
   
   @RequestMapping(value = "index.htm")
   public String FindAll(ModelMap model) throws Exception {
        try{
             ArrayList<Cas> listecas = service.findAllCasService();
             model.addAttribute("message",listecas);
        }
        catch(Exception e){
            throw e;
        }
      return "index";
   }
   
 @RequestMapping(value = "sorted.htm")
   public String ordonnerController(ModelMap model) throws Exception {
        try{
             List<Cas> listecas = service.ordonnerCasService();
             model.addAttribute("message",listecas);
        }
        catch(Exception e){
            throw e;
        }
      return "sorted";
   }
   
    @RequestMapping(value = "tri.htm")
    public String trierCasController(ModelMap model,String valeur) throws Exception {
        try{
             List<Cas> listecas = service.trierCasService(valeur);
             model.addAttribute("message",listecas);
        }
        catch(Exception e){
            throw e;
        }
      return "tri";
    }
    
    @RequestMapping(value = "filtrer.htm")
    public String filtrerCasController(ModelMap model,String nb1,String nb2) throws Exception {
        try{
             List<Cas> listecas = service.filterCasService(nb1, nb2);
             model.addAttribute("message",listecas);
        }
        catch(Exception e){
            throw e;
        }
      return "filtrer";
    }
    
}
