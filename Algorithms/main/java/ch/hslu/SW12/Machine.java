/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW12;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * {Class description here}.
 *
 * @author Boas Meier
 * @version JDK 12.0.2
 */
public class Machine {

    private static final Logger LOG = LogManager.getLogger(Machine.class);

    public static boolean isWordLanguage(final String string) {
        State state = State.Z0;
        int length = string.length();

        for (int i = 0; i < length; i++) {
            switch (state) {
                case Z0:
                    // Transition
                    if (string.charAt(i) == '0') {
                        state = State.Z1;
                    } else {
                        return false;
                    }
                    break;

                case Z1:
                    // Transition
                    if (string.charAt(i) == '1') {
                        state = State.Z2;
                    } else {
                        return false;
                    }
                    break;

                case Z2:
                    // Transition
                    if (string.charAt(i) == '1') {
                        state = State.Z3;
                    } else if (string.charAt(i) == '0') {
                        state = State.Z4;
                    } else {
                        return false;
                    }
                    break;

                case Z3:
                    // Transition
                    if (string.charAt(i) == '1') {
                        state = State.Z2;
                    } else {
                        return false;
                    }
                    break;

                case Z4:
                    // Transition
                    if (string.charAt(i) == '1') {
                        state = State.Z2;
                    } else {
                        return false;
                    }
                    break;
            }
        }
        return string.charAt(length - 1) == '0';

    }
}
