/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW14;

import java.util.Arrays;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * {Class description here}.
 *
 * @author Boas Meier
 * @version JDK 12.0.2
 * @param <T>
 */
public class Sort<T> {

    private static final Logger LOG = LogManager.getLogger(Sort.class);

    /**
     * Sorts the int-Array ascending. Slow Version.
     *
     * @param a
     */
    public void insertionSort(final T[] a) {
        T elt;
        int j;
        for (int i = 1; i < a.length; i++) {
            elt = a[i];            // next elt for insert
            j = i;                 // a[0]..a[j-1] already sorted
            while ((j > 0) && (a[j - 1].hashCode() > elt.hashCode())) {
                a[j] = a[j - 1];   // shift right
                j--;               // go further left
            }
            a[j] = elt;            // insert elt
        }                          // a[0]...a[j] sorted
    }

    /**
     * Sortiert das int-Array aufsteigend, aber erst ab Feld a[1]! Fast version.
     *
     * @param a Zu sortierendes Array.
     */
    public void insertionSort2(final T[] a) {
        T elt;
        int j;
        for (int i = 2; i < a.length; i++) {
            elt = a[i];     // next elt for insert
            a[0] = elt;     // dummy-element
            j = i;          // a[1]..a[j-1] already sorted
            while (a[j - 1].hashCode() > elt.hashCode()) {
                a[j] = a[j - 1];  // shift right
                j--;             // go further left
            }
            a[j] = elt;          // insert elt
        }                        // a[1]...a[j] sorted
    }

    /**
     * Sorts the int-Array ascending. Fast Version without dummy element.
     *
     * @param a Zu sortierendes Array.
     */
    public void insertionSort3(final T[] a) {
        T elt;
        int j;

        for (int i = 1; i < a.length; i++) {
            elt = a[i];     // next elt for insert
            j = i;          // a[1]..a[j-1] already sorted

            // if elt smaller than first element move it to the front
            if (elt.hashCode() < a[0].hashCode()) {
                for (int k = i; k > 0; k--) {
                    a[k] = a[k - 1];
                }
                a[0] = elt;
            } else {
                while (a[j - 1].hashCode() > elt.hashCode()) {
                    a[j] = a[j - 1];  // shift right
                    j--;             // go further left
                }
                a[j] = elt;
            }
        }
    }

    /**
     * Sorts the int-Array ascending.Fast Version without dummy element.
     *
     * @param a Zu sortierendes Array.
     * @param left
     * @param right
     */
    public final void insertionSort3(final int[] a, int left, int right) {
        int elt;
        int j;

        for (int i = left + 1; i < right + 1; i++) {
            elt = a[i];     // next elt for insert
            j = i;          // a[1]..a[j-1] already sorted

            // if elt smaller than first element move it to the front
            if (elt < a[0]) {
                for (int k = i; k > 0; k--) {
                    a[k] = a[k - 1];
                }
                a[0] = elt;
            } else {
                while (a[j - 1] > elt) {
                    a[j] = a[j - 1];  // shift right
                    j--;             // go further left
                }
                a[j] = elt;
            }
        }
    }

    /**
     * Sorts the int-Array ascending. Fastest Version without dummy element and binary search.
     *
     * @param a Zu sortierendes Array.
     */
    public void insertionSort4(final T[] a) {
        T elt;
        int j;
        int left;
        int right;
        boolean found;

        for (int i = 1; i < a.length; i++) {
            elt = a[i];     // next elt for insert
            j = i / 2;          // mid where binary search starts
            left = 0;           // left limitation for binary search
            right = i;          // right limitation for binary search

            // if elt smaller than first element move it to the front
            if (elt.hashCode() < a[0].hashCode()) {
                for (int k = i; k > 0; k--) {
                    a[k] = a[k - 1];
                }
                a[0] = elt;
            } else if (elt.hashCode() >= a[i - 1].hashCode()) {
                // If element greater than last sorted element, don't move it.
            } else {

                // Binary Search
                found = false;
                while (!found) {
                    if (elt.hashCode() > a[j].hashCode()) {
                        left = j;   // limit binary search to upper half of previous limitation
                        if (elt.hashCode() <= a[j + 1].hashCode()) {
                            found = true;
                            j++;
                        } else {
                            j = (left + right) / 2; // calc new mid of upper half
                        }

                    } else if (elt.hashCode() < a[j].hashCode()) {
                        right = j;   // limit binary search to lower half of previous limitation
                        if (elt.hashCode() >= a[j - 1].hashCode()) {
                            found = true;
                        } else {
                            j = (left + right) / 2;     // calc new mid of lower half
                        }
                    } else {
                        found = true;
                    }
                }

                // Shift right and insert element
                for (int x = i; x > j; x--) {
                    a[x] = a[x - 1];  // shift right
                }
                a[j] = elt;
            }
        }
    }

    public void selectionSort(final T[] a) {
        T elt;
        T buffer;
        for (int i = 0; i < a.length; i++) {
            elt = a[i];
            buffer = a[i];
            for (int x = i; x < a.length; x++) {
                if (elt.hashCode() > a[x].hashCode()) {
                    elt = a[x];
                    a[x] = buffer;
                    buffer = elt;
                }
            }
            a[i] = elt;
        }
    }

    public void bubbleSort(final T[] a) {
        T buffer;
        int length = a.length;
        int j = 0;
        while (length > 1) {
            while (j + 1 < length) {
                if (a[j].hashCode() > a[j + 1].hashCode()) {
                    buffer = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = buffer;
                }
                j++;
            }
            j = 0;
            length--;
        }
    }

    public void bubbleSort2(final T[] a) {
        T buffer;
        int length = a.length;
        int j = 0;
        boolean finish = false;
        while (!finish) {
            finish = true;
            while (j + 1 < length) {
                if (a[j].hashCode() > a[j + 1].hashCode()) {
                    buffer = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = buffer;
                    finish = false;
                }
                j++;
            }
            j = 0;
            length--;
        }
    }

    public void shellSort(final int[] a) {
        int length = a.length;
        double diff = 0;
        int k = 0;
        int hibbard = 0;

        // find stepsize for first rough sorting
        do {
            k++;
            hibbard = (int) (Math.pow(2, k) - 1);
            diff = length / hibbard;
        } while (diff > 2);
        k -= 1;

        for (int x = k; x > 0; x--) {
            hibbard = (int) (Math.pow(2, x) - 1);
            for (int i = 0; i < hibbard; i++) {
                int y = i;
                int j = i + hibbard;
                while (j < length) {
                    if (a[y] > a[j]) {
                        var tmp = a[y];
                        a[y] = a[j];
                        a[j] = tmp;
                    }
                    y = j;
                    j += hibbard;
                }
            }
        }
        insertionSort3(a, 0, length - 1);

    }

    private void quickSort(final char[] a, final int left, final int right) {
        int up = left;                  // Linke Grenze
        int down = right - 1;           // Rechte Grenze (ohne Trennelement)
        char t = a[right];              // rechtes Element als Trennelement
        boolean allChecked = false;
        do {
            while (a[up] < t) {
                up++;                   // suche grösseres (>=) Element von links an
            }
            while ((a[down] > t) && (down > up)) {
                down--;                 // suche echt kleineres (<) Element von rechts an
            }
            if (down > up) {             // solange keine Überschneidung
                exchange(a, up, down);
                up++;                   // linke Grenze verschieben
                down--;                 // rechte Grenze verschieben
            } else {
                allChecked = true;      // Austauschen beendet
            }
        } while (!allChecked);
        exchange(a, up, right);         // Trennelement an endgültige Position (a[up])
        if (left < (up - 1)) {
            quickSort(a, left, (up - 1)); // linke Hälfte
        }
        if ((up + 1) < right) {
            quickSort(a, (up + 1), right);  // rechte Hälfte, ohne T’Elt.
        }
    }

    private void quickSort(final int[] a, final int left, final int right) {
        int up = left;                  // Linke Grenze
        int down = right - 1;           // Rechte Grenze (ohne Trennelement)
        int t = a[right];              // rechtes Element als Trennelement
        boolean allChecked = false;
        do {
            while (a[up] < t) {
                up++;                   // suche grösseres (>=) Element von links an
            }
            while ((a[down] > t) && (down > up)) {
                down--;                 // suche echt kleineres (<) Element von rechts an
            }
            if (down > up) {             // solange keine Überschneidung
                exchange(a, up, down);
                up++;                   // linke Grenze verschieben
                down--;                 // rechte Grenze verschieben
            } else {
                allChecked = true;      // Austauschen beendet
            }
        } while (!allChecked);
        exchange(a, up, right);         // Trennelement an endgültige Position (a[up])
        if (left < (up - 1)) {
            quickSort(a, left, (up - 1)); // linke Hälfte
        }
        if ((up + 1) < right) {
            quickSort(a, (up + 1), right);  // rechte Hälfte, ohne T’Elt.
        }
    }

    public final void quickSort(final char[] a) {
        int size = a.length;
        int left = 0;
        int right = size - 1;
        int up = left;                  // Linke Grenze
        int down = right - 1;           // Rechte Grenze (ohne Trennelement)
        char t = a[right];              // rechtes Element als Trennelement
        boolean allChecked = false;
        do {
            while (a[up] < t) {
                up++;                   // suche grösseres (>=) Element von links an
            }
            while ((a[down] > t) && (down > up)) {
                down--;                 // suche echt kleineres (<) Element von rechts an
            }
            if (down > up) {             // solange keine Überschneidung
                exchange(a, up, down);
                up++;                   // linke Grenze verschieben
                down--;                 // rechte Grenze verschieben
            } else {
                allChecked = true;      // Austauschen beendet
            }
        } while (!allChecked);
        exchange(a, up, right);         // Trennelement an endgültige Position (a[up])
        if (left < (up - 1)) {
            quickSort(a, left, (up - 1)); // linke Hälfte
        }
        if ((up + 1) < right) {
            quickSort(a, (up + 1), right);  // rechte Hälfte, ohne T’Elt.
        }
    }

    public final void quickSort(final int[] a) {
        int size = a.length;
        int left = 0;
        int right = size - 1;
        int up = left;                  // Linke Grenze
        int down = right - 1;           // Rechte Grenze (ohne Trennelement)
        int t = a[right];              // rechtes Element als Trennelement
        boolean allChecked = false;
        do {
            while (a[up] < t) {
                up++;                   // suche grösseres (>=) Element von links an
            }
            while ((a[down] > t) && (down > up)) {
                down--;                 // suche echt kleineres (<) Element von rechts an

            }
            if (down > up) {             // solange keine Überschneidung
                exchange(a, up, down);
                up++;                   // linke Grenze verschieben
                down--;                 // rechte Grenze verschieben
            } else {
                allChecked = true;      // Austauschen beendet
            }
        } while (!allChecked);
        exchange(a, up, right);         // Trennelement an endgültige Position (a[up])
        if (left < (up - 1)) {
            quickSort(a, left, (up - 1)); // linke Hälfte
        }
        if ((up + 1) < right) {
            quickSort(a, (up + 1), right);  // rechte Hälfte, ohne T’Elt.
        }

    }

    // QuickInsertionSort with M = 25
    private void quickInsertionSort(final int[] a, final int left, final int right) {
        int up = left;                  // Linke Grenze
        int down = right - 1;           // Rechte Grenze (ohne Trennelement)
        int t = a[right];              // rechtes Element als Trennelement
        boolean allChecked = false;
        do {
            while (a[up] < t) {
                up++;                   // suche grösseres (>=) Element von links an
            }
            while ((a[down] > t) && (down > up)) {
                down--;                 // suche echt kleineres (<) Element von rechts an
            }
            if (down > up) {             // solange keine Überschneidung
                exchange(a, up, down);
                up++;                   // linke Grenze verschieben
                down--;                 // rechte Grenze verschieben
            } else {
                allChecked = true;      // Austauschen beendet
            }
        } while (!allChecked);
        exchange(a, up, right);         // Trennelement an endgültige Position (a[up])
        if (left < (up - 1)) {
            if (up - 1 < 26) {
                insertionSort3(a, left, (up - 1));
            } else {
                quickInsertionSort(a, left, (up - 1)); // linke Hälfte
            }
        }
        if ((up + 1) < right) {
            if (right - (up + 1) < 26) {
                insertionSort3(a, (up + 1), right);
            } else {
                quickInsertionSort(a, (up + 1), right);  // rechte Hälfte, ohne T’Elt.
            }
        }
    }

    public final void quickInsertionSort(final int[] a) {
        int size = a.length;
        int left = 0;
        int right = size - 1;
        int up = left;                  // Linke Grenze
        int down = right - 1;           // Rechte Grenze (ohne Trennelement)
        int t = a[right];              // rechtes Element als Trennelement
        boolean allChecked = false;
        do {
            while (a[up] < t) {
                up++;                   // suche grösseres (>=) Element von links an
            }
            while ((a[down] > t) && (down > up)) {
                down--;                 // suche echt kleineres (<) Element von rechts an

            }
            if (down > up) {             // solange keine Überschneidung
                exchange(a, up, down);
                up++;                   // linke Grenze verschieben
                down--;                 // rechte Grenze verschieben
            } else {
                allChecked = true;      // Austauschen beendet
            }
        } while (!allChecked);
        exchange(a, up, right);         // Trennelement an endgültige Position (a[up])
        if (left < (up - 1)) {
            if (up - 1 < 26) {
                insertionSort3(a, left, (up - 1));
            } else {
                quickInsertionSort(a, left, (up - 1)); // linke Hälfte
            }

        }
        if ((up + 1) < right) {
            if (right - (up + 1) < 26) {
                insertionSort3(a, (up + 1), right);
            } else {
                quickInsertionSort(a, (up + 1), right);  // rechte Hälfte, ohne T’Elt.
            }
        }
    }

    /**
     * Vertauscht zwei bestimmte Zeichen im Array.
     *
     * @param a Zeichen-Array
     * @param firstIndex Index des ersten Zeichens
     * @param secondIndex Index des zweiten Zeichens
     */
    private static void exchange(final char[] a, final int firstIndex, final int secondIndex) {
        char tmp = a[firstIndex];
        a[firstIndex] = a[secondIndex];
        a[secondIndex] = tmp;
    }

    /**
     * Vertauscht zwei bestimmte Zahlen im Array.
     *
     * @param a Zeichen-Array
     * @param firstIndex Index des ersten Zeichens
     * @param secondIndex Index des zweiten Zeichens
     */
    private static void exchange(final int[] a, final int firstIndex, final int secondIndex) {
        int tmp = a[firstIndex];
        a[firstIndex] = a[secondIndex];
        a[secondIndex] = tmp;
    }

    public static char[] randomChars(final int length) {
        char[] array = new char[length];
        for (int i = 0; i < length; i++) {
            array[i] = (char) ((char) new Random().nextInt(26) + 'a');
        }
        return array;
    }

    public static char[] reversedChars(final int length) {
        char[] array = new char[length];
        for (int i = 0; i < length; i++) {
            array[i] = (char) ((char) new Random().nextInt(26) + 'a');
        }
        Arrays.sort(array);

        // Invert the array
        for (int i = 0; i < array.length / 2; i++) {
            char temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        return array;
    }

    public static char[] sortedChars(final int length) {
        char[] array = new char[length];
        for (int i = 0; i < length; i++) {
            array[i] = (char) ((char) new Random().nextInt(26) + 'a');
        }
        Arrays.sort(array);
        return array;
    }

    public static Integer[] randomInts(final int length) {
        Integer[] array = new Integer[length];
        for (int i = 0; i < length; i++) {
            array[i] = new Random().nextInt(length);
        }
        return array;
    }

    public static Integer[] reversedInts(final int length) {
        int x = length;
        Integer[] array = new Integer[length];
        for (int i = 0; i < length; i++) {
            array[i] = x;
            x--;
        }
        return array;
    }

    public static Integer[] sortedInts(final int length) {
        Integer[] array = new Integer[length];
        for (int i = 0; i < length; i++) {
            array[i] = i;
        }
        return array;
    }

    public static int[] randomInts2(final int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = new Random().nextInt(length);
        }
        return array;
    }

    public static int[] reversedInts2(final int length) {
        int x = length;
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = x;
            x--;
        }
        return array;
    }

    public static int[] sortedInts2(final int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = i;
        }
        return array;
    }
}
