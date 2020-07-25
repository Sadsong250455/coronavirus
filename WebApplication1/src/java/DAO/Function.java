package DAO;


import Model.Cas;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hanitriniaina
 */
public class Function {
    
    ArrayList<Cas> c = new ArrayList();
    Cas value = new Cas();
     
    //recuperer les donnees
    public ArrayList<Cas> findAllCas() throws Exception {
        try{
            c = value.donnees();
            c.stream().distinct().collect(Collectors.toList());
        }
        catch(Exception e)
        {
            throw e;
        }
        return c;
     }
    
    //ordonner
     public List<Cas> ordonnerCas() throws Exception {
        List <Cas> orderedCas = new ArrayList();
        try{
            c = value.donnees();
            orderedCas = c.stream().sorted(Comparator
                                            .comparing(Cas::getEntraitement)
                                            .thenComparing(Cas::getNouveau_cas)
                                            .thenComparing(Cas::getNombre_geuris)
                                            .reversed()).collect(Collectors.toList());
        }
        catch(Exception e){
            throw e;
        }
        return orderedCas;
     }
     
     //trier
     public List<Cas> trierCas(String valeur){
         List<Cas> sortedCas = new ArrayList();
         try{
            c = value.donnees();
            System.out.println(valeur);
            if(valeur.compareTo("ville") == 0){
                   sortedCas = c.stream().sorted(Comparator.comparing(Cas::getVille))
                                 .collect(Collectors.toList());
            }
            else if(valeur.compareTo("nombrecas") == 0){
                  sortedCas = c.stream().sorted(Comparator.comparing(Cas::getNouveau_cas))
                                .collect(Collectors.toList());
            }
            else if(valeur.compareTo("entraitement") == 0){
                 sortedCas = c.stream().sorted(Comparator.comparing(Cas::getEntraitement))
                               .collect(Collectors.toList());
            }
            else if(valeur.compareTo("gueris") == 0){
                sortedCas = c.stream().sorted(Comparator.comparing(Cas::getVille))
                              .collect(Collectors.toList());
            }
            else if(valeur.compareTo("formesgraves") == 0){
                sortedCas = c.stream().sorted(Comparator.comparing(Cas::getForme_grave))
                              .collect(Collectors.toList());
            }
            else if(valeur.compareTo("deces") == 0){
                sortedCas = c.stream().sorted(Comparator.comparing(Cas::getNombre_deces))
                              .collect(Collectors.toList());
            }
         }
         catch(Exception e){
             throw e;
         }
         return sortedCas;
     }
     
     //filtrer
     public List<Cas> filtrerCas(String nombrecas1,String nombrecas2){
         List<Cas> filteredCas = new ArrayList();
         try {
            int nb1 = Integer.parseInt(nombrecas1);
            int nb2 = Integer.parseInt(nombrecas2);
            c = value.donnees();
            filteredCas = c.stream()
                    .filter(cas -> nb1<=cas.getNouveau_cas() && nb2>=cas.getNouveau_cas())
                    .collect(Collectors.toList());
         } 
         catch (NumberFormatException e) {
             throw e;
         }
         return filteredCas;
     }
}
