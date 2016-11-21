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
    public static void main( String[] argv ) throws Exception {
        String  line;
        Scanner sc = new Scanner(System.in);

        int n_nbrCompo = Integer.parseInt(sc.nextLine());
        List<Integer> pNList = new ArrayList<>();

        String[] ligne2 = sc.nextLine().split(" ");
        for(int i = 0; i< n_nbrCompo; i++) {
            pNList.add(Integer.parseInt(ligne2[i]));
        }

        List<List<String>> listComposants = new ArrayList<>();
        for(int pN : pNList) {
            List<String> listElements = new ArrayList<>();
            for (int i = 0; i <pN; i++) {
                listElements.add(sc.nextLine());
            }
            listComposants.add(listElements);
        }

        int q_nbrPhraseAverifier = Integer.parseInt(sc.nextLine());

        List<String> phrases = new ArrayList<>();
        for(int i = 0; i< q_nbrPhraseAverifier; i++) {
            phrases.add(sc.nextLine());
        }

        int v_pipotrons = 0;

        for(String phrase : phrases) {
            if(elementPossible(phrase, listComposants)) {
                v_pipotrons++;
            }
        }

        System.out.println(v_pipotrons);
    }

    public static boolean elementPossible(String phrase, List<List<String>> listComposants) {

        if(phrase.startsWith(" "))
            phrase = phrase.substring(1);

        // point d'arrêt
        if(listComposants.isEmpty())
            return phrase.isEmpty();
        else {
            List<String> elementsComposant = listComposants.get(0);
            boolean matchElement = false;
            for(String element : elementsComposant) {
                if(phrase.startsWith(element)) {
                    // Tronquer le début de la phrase
                    String phraseTronquee = phrase.substring(element.length());
                    List<List<String>> listComposantsTronquee = new ArrayList<>(listComposants);
                    listComposantsTronquee.remove(0);
                    // Tronquer la liste des composants
                    if(elementPossible(phraseTronquee, listComposantsTronquee))
                        matchElement = true;
                }
            }
            return matchElement;
        }

    }
}