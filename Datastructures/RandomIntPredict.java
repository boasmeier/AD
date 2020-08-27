/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW07;

import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * {Class description here}.
 *
 * @author Boas Meier
 * @version JDK 12.0.2
 */
public class RandomIntPredict {

    private static final Logger LOG = LogManager.getLogger(RandomIntPredict.class);

    // implemented after https://docs.oracle.com/javase/7/docs/api/java/util/Random.html
    public static int next(long seed) {
        int bits = 32;
        long seed2 = (seed * 0x5DEECE66DL + 0xBL) & ((1L << 48) - 1);
        return (int) (seed2 >>> (48 - bits));
    }

    public static void main(String[] args) {
        System.out.println("Starting");
        long i1 = 1767252209L;
        long i2 = -1664600482L;
        long seed = 0;
        for (int i = 0; i < 65536; i++) {
            seed = i1 * 65536 + i;
            if (next(seed) == i2) {
                LOG.info("Seed found: " + seed);
                break;
            }
        }
        Random random = new Random((seed ^ 0x5DEECE66DL) & ((1L << 48) - 1));
        int o1 = random.nextInt();
        int o2 = random.nextInt();
        LOG.info("So we have that nextInt is: " + o1 + " and the third one is: " + o2 + " with seed: " + seed);
    }
}
