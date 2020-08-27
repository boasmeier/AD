/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW15;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * {Class description here}.
 *
 * @author Boas Meier
 * @version JDK 12.0.2
 */
public class RailwayNet1 {

    private static final Logger LOG = LogManager.getLogger(RailwayNet1.class);

    private int noOfNodes;
    private String[] nodeName;
    private int[][] adjaMx;

    public RailwayNet1(final String[] nodeName, final int[][] adjaMx) {
        this.noOfNodes = nodeName.length;
        this.nodeName = nodeName;
        this.adjaMx = adjaMx;
    }

    public boolean isNodeInGraph(final String name) {
        for (String n : nodeName) {
            if (n.equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void addNode(final String name) {
        nodeName[noOfNodes - 1] = name;
        for (int i = 0; i < noOfNodes; i++) {
            adjaMx[i][noOfNodes - 1] = Integer.MAX_VALUE;
            adjaMx[noOfNodes - 1][i] = Integer.MAX_VALUE;
        }
    }

    public String getNodeName(final int k) {
        return nodeName[k];
    }

    public int getNoOfNodes() {
        return noOfNodes;
    }

    public boolean isEdgeInGraph(final int i, final int j) {
        return adjaMx[i][j] != Integer.MAX_VALUE;
    }

    public int getTimeOfEdge(final int i, final int j) {
        return adjaMx[i][j];
    }

    public void addEdge(final int i, final int j, final int time) {
        adjaMx[i][j] = time;
    }

    public int getNoOfEdges() {
        int no = 0;
        for (int i = 0; i < noOfNodes; i++) {
            for (int j = 0; j < noOfNodes; j++) {
                if (adjaMx[i][j] != Integer.MAX_VALUE) {
                    no++;
                }
            }
        }
        return no / 2;
    }

    public int[] getAllAdjaNodes(final int j) {
        int[] allAdjaNodes = new int[noOfNodes];
        for (int i = 0; i < noOfNodes; i++) {
            allAdjaNodes[i] = adjaMx[i][j];
        }
        return allAdjaNodes;
    }

    /**
     * Returns the length of the shortest path from node s to node z
     *
     * @param s
     * @param z
     * @return
     */
    public int shortPathDijkstra(final int s, final int z) {  // einfach implementiert,
        boolean[] setT = new boolean[noOfNodes]; // nicht optimiert!
        int[][] adjaMxb = adjaMx;
        for (int i = 0; i < noOfNodes; i++) {
            setT[i] = false;
        }
        setT[s] = true;
        int[] minEntf = new int[noOfNodes];
        minEntf[s] = 0;
        while (!setT[z]) {  // terminiert, wenn Ziel z erreicht
            int min = Integer.MAX_VALUE;
            int kNeu = 0;
            for (int k = 0; k < noOfNodes; k++) {
                if (setT[k]) {
                    for (int nk = 0; nk < noOfNodes; nk++) {
                        if (!setT[nk] && (adjaMxb[k][nk] < Integer.MAX_VALUE)) {
                            int kNeuEntf = minEntf[k] + adjaMxb[k][nk];
                            if (kNeuEntf < min) {
                                min = kNeuEntf;
                                kNeu = nk;
                            }
                        }
                    }
                }
            }
            setT[kNeu] = true; // kNeu wird in T aufgenommen
            minEntf[kNeu] = min;
        }
        LOG.info(Arrays.toString(minEntf));
        return minEntf[z];
    }

    /**
     * Returns a sorted map, which contains the shortest path to every node from node s.
     *
     * @param s
     * @return
     */
    public Map<String, Integer> shortPathDijkstra(final int s) {  // einfach implementiert,
        boolean[] setT = new boolean[noOfNodes]; // nicht optimiert!
        for (int i = 0; i < noOfNodes; i++) {
            setT[i] = false;
        }
        setT[s] = true;
        int[] minEntf = new int[noOfNodes];
        minEntf[s] = 0;
        for (int i = 0; i < noOfNodes; i++) {  // terminiert, wenn alle Nodes im setT bzw. abgearbeitet.
            int min = Integer.MAX_VALUE;
            int kNeu = 0;
            for (int k = 0; k < noOfNodes; k++) {
                if (setT[k]) {
                    for (int nk = 0; nk < noOfNodes; nk++) {
                        if (!setT[nk] && (adjaMx[k][nk] < Integer.MAX_VALUE)) {
                            int kNeuEntf = minEntf[k] + adjaMx[k][nk];
                            if (kNeuEntf < min) {
                                min = kNeuEntf;
                                kNeu = nk;
                            }
                        }
                    }
                }
            }
            setT[kNeu] = true; // kNeu wird in T aufgenommen
            minEntf[kNeu] = min;
        }
        minEntf[s] = 0;
        LOG.info(Arrays.toString(minEntf));

        // Map the shortest path to its nodename (destination) in a TreeMap. TreeMaps provide natural order.
        Map<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < noOfNodes; i++) {
            map.put(getNodeName(i), minEntf[i]);
        }
        LOG.info(map.toString());
        return map;
    }

}
