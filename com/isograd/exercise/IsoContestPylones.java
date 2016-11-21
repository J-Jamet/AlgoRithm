/*******
 * Read input from System.in
 * Use System.out.println to ouput your result.
 * Use:
 *  IsoContestBase.localEcho( variable)
 * to display variable in a dedicated area.
 * ***/
package com.isograd.exercise;
import java.util.*;

public class IsoContestPylones {
    private static List<Integer> listeHauteurPylones = new ArrayList<>();
    public static void main( String[] argv ) throws Exception {
        String  line;
        Scanner sc = new Scanner(System.in);

        int n_nbrPylones = Integer.parseInt(sc.nextLine());

        for(int i=0; i<n_nbrPylones; i++) {
            listeHauteurPylones.add(Integer.parseInt(sc.nextLine()));
        }

        List<Integer> nbrPylonesVisibles = new ArrayList<>();
        for(int i =0; i<n_nbrPylones;i++) {
            int nbrPylonesVisiblesDepuisA = 0;
            for(int j=0; j<n_nbrPylones; j++)  {
                List<Integer> listeHauteurPylonesClone = new ArrayList<>(listeHauteurPylones);
                if(pyloneAVoitPyloneB(listeHauteurPylonesClone, i, j)) {
                    nbrPylonesVisiblesDepuisA++;
                }
            }
            nbrPylonesVisibles.add(nbrPylonesVisiblesDepuisA);
        }

        String sortie = "";
        for(int nbrPylonesVisible : nbrPylonesVisibles) {
            sortie += nbrPylonesVisible + " ";
        }
        sortie = sortie.substring(0, sortie.length()-1);
        System.out.println(sortie);
    }

    public static boolean pyloneAVoitPyloneB(List<Integer> listePylones, int pyloneA, int pyloneB) {
        if(pyloneA == pyloneB) {
            return false;
        }
        else if(pyloneA+1 == pyloneB || pyloneA == (pyloneB+1)) {
            return true;
        }

        List<Integer> sousListe = listPylonesEntreAEtB(listePylones, pyloneA, pyloneB);
        if(sousListe.size() >= 1) {
            for(int hauteurPylone : sousListe) {
                if(hauteurPylone >= listeHauteurPylones.get(pyloneB))
                    return false;
            }
        }
        return true;
    }

    public static List<Integer> listPylonesEntreAEtB(List<Integer> listPylones, int pyloneA, int pyloneB) {
        List<Integer> sousListePylones = new ArrayList<>();
        if(pyloneA < pyloneB) {
            sousListePylones = listPylones.subList(pyloneA, pyloneB);
            sousListePylones.remove(0);

        } else if(pyloneB < pyloneA) {
            sousListePylones = listPylones.subList(pyloneB, pyloneA);
            sousListePylones.remove(0);
        }
        return sousListePylones;
    }

}