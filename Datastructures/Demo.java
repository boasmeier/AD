/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW07;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * {Class description here}.
 *
 * @author Boas Meier
 * @version JDK 12.0.2
 */
public class Demo {

    private static final Logger LOG = LogManager.getLogger(Demo.class);
    private static int aufrufe;
    private static int ackAufrufe = 0;

    // Datastructure to store all the intermediate results.
    private final static Map<Integer, Integer> results = new HashMap<>();

    public static void main(String[] args) {
        int arrayElements = 100000;
        long start = System.currentTimeMillis();
        Integer[] array = Demo.createArray(arrayElements);
        long end = System.currentTimeMillis();
        long elapsedTime = end - start;
        LOG.info("Elapsed time for create array with " + arrayElements + " : " + elapsedTime);

        Demo.timeStackStatic(array, arrayElements);
        Demo.timeStackDynamic(array, arrayElements);
        Demo.timeStackOwn(array, arrayElements);
        Demo.timeDeque(array, arrayElements);
    }

    public final static Integer[] createArray(final int n) {
        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
        return array;
    }

    public final static long timeStackDynamic(Integer[] array, long arrayElements) {
        Stack<Integer> stack = new Stack<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < arrayElements; i++) {
            stack.push(array[i]);
        }
        long end = System.currentTimeMillis();
        long elapsedTime = end - start;
        LOG.info("Elapsed time to fill stack with " + arrayElements + " Elements : " + elapsedTime);
        return elapsedTime;
    }

    public final static long timeStackStatic(Integer[] array, int arrayElements) {
        Stack<Integer> stack2 = new Stack<>();
        stack2.ensureCapacity(arrayElements);
        long start = System.currentTimeMillis();
        for (int i = 0; i < arrayElements; i++) {
            stack2.push(array[i]);
        }
        long end = System.currentTimeMillis();
        long elapsedTime = end - start;
        LOG.info("Elapsed time to fill fix sized stack with " + arrayElements + " Elements : " + elapsedTime);
        return elapsedTime;
    }

    public final static long timeStackOwn(Integer[] array, int arrayElements) {
        StackOwn<Integer> stackOwn = new StackOwn<>(arrayElements);
        long start = System.currentTimeMillis();
        for (int i = 0; i < arrayElements; i++) {
            stackOwn.push(array[i]);
        }
        long end = System.currentTimeMillis();
        long elapsedTime = end - start;
        LOG.info("Elapsed time to fill fix sized own stack with " + arrayElements + " Elements : " + elapsedTime);
        return elapsedTime;
    }

    public final static long timeDeque(Integer[] array, int arrayElements) {
        Deque<Integer> deque = new ArrayDeque<>(arrayElements);
        long start = System.currentTimeMillis();
        for (int i = 0; i < arrayElements; i++) {
            deque.push(array[i]);
        }
        long end = System.currentTimeMillis();
        long elapsedTime = end - start;
        LOG.info("Elapsed time to fill fix sized deque with " + arrayElements + " Elements : " + elapsedTime);
        return elapsedTime;
    }

    public static void task(final int n) {
        task1();
        task1();
        task1();
        task1();     // T ~ 4
        aufrufe += 4;
        for (int i = 0; i < n; i++) {           // äussere Schleife: n-mal
            task2();
            task2();
            task2();          // T ~ n · 3
            aufrufe += 3;
            for (int j = 0; j < n; j++) {       // innerer Schleife: n-mal
                task3();
                task3();               // T ~ n · n· 2
                aufrufe += 2;
            }
        }
        LOG.info("Anzahl Aufrufe: " + aufrufe);
    }

    public static void task1() {
    }

    public static void task2() {
    }

    public static void task3() {
    }

    public static int factorialRec(final int n) {
        if ((n == 0) || (n == 1)) {            // Rekursionsbasis
            return 1;                          // Rekursionsbasis
        } else {                               // Rek'Vorschrift
            return (n * factorialRec(n - 1));  // Rek'Vorschrift
        }
    }

    /**
     * Calculates the fibonacci-number of an arbitrary index n.
     *
     * @param n
     * @return
     */
    public static int fiboRec1(final int n) {
        if (n >= 2) {                                   // Rekursionsvorschrift
            return fiboRec1(n - 1) + fiboRec1(n - 2);   // Rekursionsvorschrift
        } else if (n == 1) {                            // Rekursionsbasis is 1 or 0
            return 1;                                   // Rekursionsbasis is 1 or 0
        } else {                                        // Rekursionsbasis is 1 or 0
            return 0;                                   // Rekursionsbasis is 1 or 0
        }
    }

    /**
     * Calculates the fibonacci-number of an arbitrary index n.
     *
     * @param n
     * @return
     */
    public static int fiboRec2(final int n) {
        if (n >= 2) {                                                       // Rekursionsvorschrift
            if (results.containsKey(n)) {
                return results.get(n);
            } else {
                results.put(n, fiboRec2(n - 1) + fiboRec2(n - 2));
                return results.get(n);
            }                                                               // Rekursionsvorschrift
        } else if (n == 1) {                                                // Rekursionsbasis is 1 or 0
            return 1;                                       // Rekursionsbasis is 1 or 0
        } else {                                            // Rekursionsbasis is 1 or 0
            return 0;                                       // Rekursionsbasis is 1 or 0
        }
    }

    public static final int fiboIter1(final int n) {
        int fibo1 = 1;
        int fibo2 = 0;
        int result = 0;
        for (int i = 1; i <= n - 1; i++) {
            result = fibo1 + fibo2;
            fibo2 = fibo1;
            fibo1 = result;
        }
        return result;
    }

    public static final long ack(final long n, final long m) {
        ackAufrufe++;
        if (n == 0 && m >= 1) {
            return m + 1;
        } else if (n >= 1 && m == 0) {
            return ack(n - 1, 1);
        } else {
            return ack(n - 1, ack(n, m - 1));
        }
    }
}
