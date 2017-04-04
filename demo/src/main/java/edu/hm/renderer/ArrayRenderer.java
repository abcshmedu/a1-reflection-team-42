package edu.hm.renderer;

import java.util.Arrays;

/**
 * 
 * @author Markus Krahl
 *
 */
public class ArrayRenderer {

    /**
     * 
     * @param arr 
     * @return String
     */
    public String render(int[] arr) {
        String res = "";
        res = Arrays.toString(arr);
        return res;
    }

}
