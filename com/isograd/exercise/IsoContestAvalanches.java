/*******
 * Read input from System.in
 * Use System.out.println to ouput your result.
 * Use:
 *  IsoContestBase.localEcho( variable)
 * to display variable in a dedicated area.
 * ***/
package com.isograd.exercise;

import java.util.*;

public class IsoContestAvalanches {

    private static Map<Integer, Map<Integer, Double>> matrice;
    private static Map<Integer, Double> probasPasDAvalanche;

    public static void main( String[] argv ) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n_Pistes = Integer.parseInt(sc.nextLine());

        String[] ab = sc.nextLine().split(" ");
        int a = Integer.parseInt(ab[0]);
        int b = Integer.parseInt(ab[1]);

        matrice = new HashMap<>();
        probasPasDAvalanche = new HashMap<>();

        for(int i = 0; i < n_Pistes; i++) {
            String[] line = sc.nextLine().split(" ");
            Map<Integer, Double> matrice2 = new HashMap<>();
            for(int j = 0; j < n_Pistes; j++) {
                if(i!=j)
                matrice2.put(j, Double.parseDouble(line[j]));
            }
            matrice.put(i, matrice2);

            // Initialisation
            probasPasDAvalanche.put(i, 1.0);
        }

        System.out.println(matrice);

        List<Integer> sommetsSupprime = new ArrayList<>();

        // Création de l'ensemble Q
        int sommet1 = 0;
        while(sommetsSupprime.size() < n_Pistes) {
            Map<Integer, Double> sommetsVoisins = matrice.get(sommet1);
            sommet1 = trouverMin(sommetsSupprime, sommetsVoisins);
            for(int sommet2 = 0; sommet2 < sommetsVoisins.size(); sommet2++) {
                if(sommet1!=sommet2) {
                    majProbas(sommet1, sommet2);
                    System.out.println(probasPasDAvalanche);
                }
            }
            sommetsSupprime.add(sommet1);
        }

        // Calcule du plus court chemin inutile

        // Calcule d'au moins une avalanche
        Collection<Double> collectionProbas = probasPasDAvalanche.values();
        Double minProba = 1.0;
        for(double proba : collectionProbas) {
            if(proba < minProba)
                minProba = proba;
        }

        System.out.println(1-minProba);
        // Affichage de la sortie
        /*
        String[] arrondi = minProba.toString().split(".");
        String decimal = arrondi[1].substring(0, 3);
        System.out.println(arrondi[0]+"."+decimal);
        */
    }

    public static int trouverMin(List<Integer> sommetsSupprimes, Map<Integer, Double> pistesPossibles) {
        int sommetMini = 0;
        double minProbaPiste = 1;
        System.out.println("Liste possibles " + pistesPossibles);
        for (Map.Entry<Integer, Double> entry : pistesPossibles.entrySet()) {
            if(!sommetsSupprimes.contains(entry.getKey())) {
                double probaPiste = entry.getValue();
                if (minProbaPiste > probaPiste) {
                    minProbaPiste = probaPiste;
                    sommetMini = entry.getKey();
                    System.out.println("SommetMini " + sommetMini + " avec proba " + minProbaPiste);
                }
            }
        }
        return sommetMini;
    }

    public static void majProbas(int sommet1, int sommet2) {
        System.out.println("Somets " + sommet1 + " " + sommet2);
        if(probasPasDAvalanche.get(sommet2) < probasPasDAvalanche.get(sommet1) * (1-matrice.get(sommet1).get(sommet2)));
        {
            probasPasDAvalanche.put(sommet2, probasPasDAvalanche.get(sommet1) * (1-matrice.get(sommet1).get(sommet2)));
            // Pas besoin d'ajouter le prédécésseur car l'historique des sommets est intutile
        }
    }

    public static double auMoinsUNeAvalanche(List<Integer> liste) {
        double risque = 1;
        for(int risqueAvalanche : liste) {
            risque = risque * (1-risqueAvalanche);
        }
        return 1-risque;
    }

}