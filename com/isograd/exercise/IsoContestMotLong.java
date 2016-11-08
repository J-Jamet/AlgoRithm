/*******
 * Read input from System.in
 * Use System.out.println to ouput your result.
 * Use:
 *  IsoContestBase.localEcho( variable)
 * to display variable in a dedicated area.
 * ***/
package com.isograd.exercise;
import java.util.*;

public class IsoContestMotLong {
    public static void main( String[] argv ) throws Exception {
        String  line;
        Scanner sc = new Scanner(System.in);

        int n_nbrMots = Integer.parseInt(sc.nextLine());

        int max = 0;
        for(int i=0; i<n_nbrMots; i++) {
            String chaine = sc.nextLine();
            int lengthWord = chaine.length();
            if(max<lengthWord)
                max = lengthWord;
        }
        System.out.println(max);
	/* Vous pouvez aussi effectuer votre traitement une fois que vous avez lu toutes les données.*/
    }
}