/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW14;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * {Class description here}.
 *
 * @author Boas Meier
 * @version JDK 12.0.2
 */
public class Quicksearch {

    private static final Logger LOG = LogManager.getLogger(Quicksearch.class);

    /**
     * * Durchsucht eine Zeichenkette mittels quickSearch.
     *
     * @param a Zeichenkette, die durchsucht wird.
     * @param p
     * @return Index der Fundstelle oder -1, falls Pattern in a nicht gefunden wurde.
     */
    public static int quickSearch(final String a, final String p) {
        final int n = a.length();
        final int m = p.length();
        final int range = 65536; // -> Unicode-Range (ASCII-Range = 256)
        final int[] shift = new int[range];
        // init shift-array
        for (int i = 0; i < range; i++) {
            shift[i] = m + 1;
        }
        // overwrite fields according pattern
        for (int i = 0; i < m; i++) {
            shift[p.charAt(i)] = m - i;
        }
        // search
        int i = 0;                    // index to string
        int j = 0;                    // index to pattern p
        do {
            if (a.charAt(i + j) == p.charAt(j)) {      // match
                j++;
            } else {                  // mismatch
                if ((i + m) < n) {    // a.charAt(i1+m) is not outside a
                    i += shift[a.charAt(i + m)];   // jump forward
                    j = 0;
                } else {
                    break;            // (mismatch) && (no shift is possible)
                }
            }
        } while ((j < m) && ((i + m) <= n)); // (pattern p not found) && (end of a not reached)
        if (j == m) {
            return i;                 // pattern found
        } else {
            return -1;                // pattern not found
        }
    }

    /**
     * * Durchsucht eine Zeichenkette mittels Optimal-Mismatch.
     *
     * @param a Zeichenkette, die durchsucht wird.
     * @param p
     * @return Index der Fundstelle oder -1, falls Pattern in a nicht gefunden wurde.
     */
    public static int optimalMismatchSearch(final String a, final String p) {
        final int n = a.length();
        final int m = p.length();
        final int range = 65536; // -> Unicode-Range (ASCII-Range = 256)
        final int[] shift = new int[range];

        // init shift-array
        for (int i = 0; i < range; i++) {
            shift[i] = m + 1;
        }

        // init p'
        Object[][] px = new Object[m][m];
        for (int y = 0; y < m; y++) {
            px[y][0] = p.charAt(y);
            px[y][1] = y;
        }

        // overwrite fields according pattern
        for (int i = 0; i < m; i++) {
            shift[p.charAt(i)] = m - i;
        }
        // search
        int i = 0;                    // index to string
        int j = 0;                    // index to pattern p
        do {
            if (a.charAt(i + (int) px[j][1]) == (char) px[j][0]) {      // match
                j++;
            } else {                  // mismatch
                if ((i + m) < n) {    // a.charAt(i1+m) is not outside a
                    i += shift[a.charAt(i + m)];   // jump forward
                    j = 0;

                    // move mismatch element one step more to the front
                    if (j > 0) {
                        var tmp = px[j - 1][0];
                        px[j - 1][0] = px[j][0];
                        px[j][0] = tmp;
                        tmp = px[j - 1][1];
                        px[j - 1][1] = px[j][1];
                        px[j][1] = tmp;
                    }
                } else {
                    break;            // (mismatch) && (no shift is possible)
                }
            }
        } while ((j < m) && ((i + m) <= n)); // (pattern p not found) && (end of a not reached)
        if (j == m) {
            return i;                 // pattern found
        } else {
            return -1;                // pattern not found
        }
    }
}
