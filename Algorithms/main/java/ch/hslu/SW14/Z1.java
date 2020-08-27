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
public class Z1 implements SearchState {

    private static final Logger LOG = LogManager.getLogger(Z1.class);
    private final SearchMachine searchMachine;

    public Z1(SearchMachine searchMachine) {
        this.searchMachine = searchMachine;
    }

    @Override
    public void transition(char c) {
        if (c == 'N') {
            searchMachine.setSearchState(searchMachine.getZ2());
        } else {
            searchMachine.setSearchState(searchMachine.getZ0()).transition(c);
        }
    }
}
