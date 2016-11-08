/*******
 * Read input from System.in
 * Use System.out.println to ouput your result.
 * Use:
 *  IsoContestBase.localEcho( variable)
 * to display variable in a dedicated area.
 * ***/
package com.isograd.exercise;
import java.util.*;

public class IsoContestMap {
    public static void main( String[] argv ) throws Exception {
        String  line;
        Scanner sc = new Scanner(System.in);

        String[] intiTab = sc.nextLine().split(" ");
        float from_lat = Float.parseFloat(intiTab[0]); //Latitude mini
        float from_lng = Float.parseFloat(intiTab[1]); //longitude mini
        float to_lat = Float.parseFloat(intiTab[2]); //latitude max
        float to_lng = Float.parseFloat(intiTab[3]); //long max

        int nbr_pers = Integer.parseInt(sc.nextLine());
        int j = 0;
        for(int i = 0; i<nbr_pers; i++) {
            String[] latLng = sc.nextLine().split(" ");
            float lat = Float.parseFloat(latLng[0]);
            float lng = Float.parseFloat(latLng[1]);

            if(from_lat <= lat && to_lat >= lat
                    && from_lng <= lng && to_lng >= lng) {
                j++;
            }
        }
        System.out.println(j);
    /*You can also perform the calculations once you have read all the data.*/
    }
}
