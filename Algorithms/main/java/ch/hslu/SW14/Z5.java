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
public class Z5 implements SearchState {

    private static final Logger LOG = LogManager.getLogger(Z5.class);
    private SearchMachine searchMachine;

    public Z5(SearchMachine searchMachine) {
        this.searchMachine = searchMachine;
    }

    @Override
    public void transition(char c) {
        if (c == 'S') {
            searchMachine.setSearchState(searchMachine.getZ6());
        } else {
            searchMachine.setSearchState(searchMachine.getZ3()).transition(c);
        }
    }
}
