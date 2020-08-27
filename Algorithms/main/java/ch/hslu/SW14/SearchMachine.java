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
public class SearchMachine {

    private static final Logger LOG = LogManager.getLogger(SearchMachine.class);

    private final SearchState z0;
    private final SearchState z1;
    private final SearchState z2;
    private final SearchState z3;
    private final SearchState z4;
    private final SearchState z5;
    private final SearchState z6;

    private SearchState searchState;

    private final String pattern = "ANANAS";
    private final int m = pattern.length();

    public SearchMachine() {
        z0 = new Z0(this);
        z1 = new Z1(this);
        z2 = new Z2(this);
        z3 = new Z3(this);
        z4 = new Z4(this);
        z5 = new Z5(this);
        z6 = new Z6(this);

        searchState = z0;
    }

    public int isWordLanguage(final String s) {
        char[] a = s.toCharArray();
        int i = 0;

        for (char c : a) {
            searchState.transition(c);
            i++;
            if (searchState.equals(z6)) {
                return i - m;
            }
        }
        return -1;
    }

    public SearchState setSearchState(SearchState newSearchState) {
        searchState = newSearchState;
        return searchState;
    }

    public SearchState getZ0() {
        return z0;
    }

    public SearchState getZ1() {
        return z1;
    }

    public SearchState getZ2() {
        return z2;
    }

    public SearchState getZ3() {
        return z3;
    }

    public SearchState getZ4() {
        return z4;
    }

    public SearchState getZ5() {
        return z5;
    }

    public SearchState getZ6() {
        return z6;
    }
}
