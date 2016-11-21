/*******
 * Read input from System.in
 * Use System.out.println to ouput your result.
 * Use:
 *  IsoContestBase.localEcho( variable)
 * to display variable in a dedicated area.
 * ***/
package com.isograd.exercise;
import java.util.*;

public class IsoContestBanderoles {

    private static List<Integer> listeHauteurPoteaux = new ArrayList<>();
    public static void main( String[] argv ) throws Exception {
        String  line;

        Scanner sc = new Scanner(System.in);
        int n_nbrPoteaux = Integer.parseInt(sc.nextLine());

        Map<Integer, List<Integer>> mapPoteauxMemeHauteur = new HashMap<>();

        listeHauteurPoteaux = new ArrayList<>();
        for(int i = 0; i<n_nbrPoteaux; i++) {
            int hauteur = Integer.parseInt(sc.nextLine());
            listeHauteurPoteaux.add(hauteur);
            List<Integer> listePoteauxMemeHauteur;
            if(mapPoteauxMemeHauteur.containsKey(hauteur)) {
                listePoteauxMemeHauteur = mapPoteauxMemeHauteur.get(hauteur);
            } else {
                listePoteauxMemeHauteur = new ArrayList<>();
            }
            listePoteauxMemeHauteur.add(i);
            mapPoteauxMemeHauteur.put(hauteur, listePoteauxMemeHauteur);
        }

        long longueurTotaleBanderole = 0;

        for(Map.Entry<Integer, List<Integer>> entreeMap : mapPoteauxMemeHauteur.entrySet()) {
            List<Integer> listePositions = entreeMap.getValue();

            while(listePositions.size() >= 2) {
                int positionA = listePositions.get(0);
                int positionB = listePositions.get(1);
                if (peutMettreBanderole(entreeMap.getKey(), positionA, positionB)) {
                    longueurTotaleBanderole += positionB - positionA;
                }
                listePositions.remove(0);
            }
        }



        System.out.println(longueurTotaleBanderole);
    /* Vous pouvez aussi effectuer votre traitement une fois que vous avez lu toutes les données.*/
    }

    public static boolean peutMettreBanderole(int hauteur, int positionA, int positionB) {
        for(int i = positionA +1 ; i<positionB; i++) {
            if(listeHauteurPoteaux.get(i) > hauteur)
                return false;
        }
        return true;
    }
}