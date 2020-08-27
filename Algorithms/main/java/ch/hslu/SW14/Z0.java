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
public class Z0 implements SearchState {

    private static final Logger LOG = LogManager.getLogger(Z0.class);
    private final SearchMachine searchMachine;

    public Z0(SearchMachine searchMachine) {
        this.searchMachine = searchMachine;
    }

    /**
     *
     * @param c
     */
    @Override
    public void transition(char c) {
        if (c == 'A') {
            searchMachine.setSearchState(searchMachine.getZ1());
        } else {
            searchMachine.setSearchState(this);
        }
    }
}
