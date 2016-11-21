/*******
 * Read input from System.in
 * Use System.out.println to ouput your result.
 * Use:
 *  IsoContestBase.localEcho( variable)
 * to display variable in a dedicated area.
 * ***/
package com.isograd.exercise;

import java.util.*;

public class IsoContestFlocon {

    public static void main( String[] argv ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        doFirsts(n);
    }

    public static void doFirsts(int n) {
        List<String> snow = new ArrayList<>();
        for(int j = 0; j<n/2; j++) {
            String line = "";
            int nbrPoints = n / 2;
            for (int i = 1; i <= nbrPoints -j; i++) {
                line = line + ".";
            }
            line = line + "*";
            for(int k = 0; k<j; k++) {
                line = line + "**";
            }
            for (int i = 1; i <= nbrPoints -j; i++) {
                line = line + ".";
            }
            System.out.println(line);
            snow.add(line);
        }

        String middle = "";
        for(int i = 0; i<n; i++) {
            middle += "*";
        }
        System.out.println(middle);

        Collections.reverse(snow);
        for(String lineR : snow) {
            System.out.println(lineR);
        }
    }

}