/*******
 * Read input from System.in
 * Use System.out.println to ouput your result.
 * Use:
 *  IsoContestBase.localEcho( variable)
 * to display variable in a dedicated area.
 * ***/
package com.isograd.exercise;

import java.util.*;

public class IsoContestGants {

    public static void main( String[] argv ) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n_nbrgants = Integer.parseInt(sc.nextLine());

        Map<String, Integer> mapGants = new HashMap<>();

        int nbrPaire = 0;

        for(int i = 0; i<n_nbrgants; i++) {
            String couleurGant = sc.nextLine();

            int j = 0;
            if(mapGants.containsKey(couleurGant)) {
                j = mapGants.get(couleurGant);
            }
            j++;
            mapGants.put(couleurGant, j);

            if(mapGants.get(couleurGant)%2 == 0) {
                nbrPaire++;
            }

        }

        System.out.println(nbrPaire);
    }
}