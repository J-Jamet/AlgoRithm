/*******
 * Read input from System.in
 * Use System.out.println to ouput your result.
 * Use:
 *  IsoContestBase.localEcho( variable)
 * to display variable in a dedicated area.
 * ***/
package com.isograd.exercise;

import java.util.*;

public class IsoContestPipotron {

    private static List<String> lastGoodSplitPhrase;

    public static void main( String[] argv ) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n_nbrComposants = Integer.parseInt(sc.nextLine());

        String ligne2 = sc.nextLine();
        String[] n_tabString = ligne2.split(" ");
        List<Integer> pNList = new ArrayList<>();

        int t_sommePN = 0;
        for (int i = 0; i < n_nbrComposants; i++) {
            int pN = Integer.parseInt(n_tabString[i]);
            pNList.add(pN);
            t_sommePN += pN;
        }

        List<List<String>> possiblePhrases = new ArrayList<>();
        for (int pN : pNList) {
            List<String> listElement = new ArrayList<>();
            for (int i = 0; i < pN; i++) {
                listElement.add(sc.nextLine());
            }
            possiblePhrases.add(listElement);
        }

        int q_nbrPhraseAVerifier = Integer.parseInt(sc.nextLine());

        List<String> phrases = new ArrayList<>();
        for (int i = 0; i < q_nbrPhraseAVerifier; i++) {
            String phrase = sc.nextLine();
            phrases.add(phrase);
        }

        int nbrPipotrons = 0;


        for (String phrase : phrases) {
            if(matchWithOnePossibleInColumn(phrase, possiblePhrases)) {
                nbrPipotrons++;
            }
        }

        System.out.println(nbrPipotrons);
    }


    public static boolean matchWithOnePossibleInColumn(String phrase, List<List<String>> listPossibleElements) {

        if (phrase.startsWith(" "))
            phrase = phrase.substring(1);

        if(listPossibleElements.isEmpty()) {
            return phrase.isEmpty();
        } else {
            List<String> listComposants = listPossibleElements.get(0);
            boolean matchElement = false;
            for (String possible : listComposants) {
                if (phrase.startsWith(possible)) {
                    String newPhrase = phrase.substring(possible.length());

                    List<List<String>> newListPossibleElements = new ArrayList<>();
                    newListPossibleElements.addAll(listPossibleElements);
                    newListPossibleElements.remove(0);
                    if(matchWithOnePossibleInColumn(newPhrase, newListPossibleElements))
                        matchElement = true;
                }
            }
            return matchElement;
        }
    }

    /*

    3
    2 3 4
    je suis venu
    je suis parti de
    chez toi
    chez moi
    a la maison
    en voiture.
    en train.
    en metro.
    a cheval.
    4
    je suis venu chez toi en train.
    je suis venu a cheval. a la maison
    je suis venu en train
    je suis parti de chez moi en metro.

    useful
    http://stackoverflow.com/questions/1075656/simple-way-to-find-if-two-different-lists-contain-exactly-the-same-elements

     */
}