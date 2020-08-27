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
public class KMPSearchMachine {

    private static final Logger LOG = LogManager.getLogger(KMPSearchMachine.class);

    public static int kmpSearch(final String a, final String p) {
        final int n = a.length();
        final int m = p.length();
        int i = 0;          // index to string a
        int j = 0;          // index to pattern p respectively state

        // 1. generate next
        int[] next = initNext(p);
        // 2. search for p
        do {
            if ((j == -1) || (a.charAt(i) == p.charAt(j))) {   // (j == -1) first! Otherwise ArrayOutOfBoundException
                i++;    // process next character
                j++;
            } else {
                j = next[j];    // go to next state
            }
        } while ((j < m) && (i < n));

        if (j == m) {
            return (i - m);         // pattern found: index to position in a
        } else {
            return -1;              // pattern not found
        }
    }

    private static int[] initNext(final String p) {
        final int m = p.length();
        final int[] next = new int[m];
        int i = 0;
        int j = -1;             // Special value! (-1 = no reference to a following state)
        next[0] = -1;
        do {
            if ((j == -1) || (p.charAt(i) == p.charAt(j))) {
                // (j == -1) must be first operand!
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        } while (i < (m - 1));
        return next;
    }
}
