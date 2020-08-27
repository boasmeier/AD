/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW15;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * {Class description here}.
 *
 * @author Boas Meier
 * @version JDK 12.0.2
 */
public class RailwayNet2 {

    private static final Logger LOG = LogManager.getLogger(RailwayNet2.class);

    private final Map<Node, Map<Node, Integer>> map;

    public RailwayNet2() {
        map = new HashMap<>();
    }

    public boolean isNodeInGraph(final Node node) {
        return map.containsKey(node);
    }

    public boolean addNode(final Node node) {
        if (!isNodeInGraph(node)) {
            map.put(node, new HashMap<>());
            return true;
        } else {
            return false;
        }
    }

    public boolean isEdgeInGraph(final Node from, final Node to) {
        if (isNodeInGraph(from)) {
            return map.get(from).containsKey(to);
        } else {
            return false;
        }
    }

    public int getTimeOfEdge(final Node from, final Node to) {
        if (!isEdgeInGraph(from, to)) {
            throw new IllegalArgumentException("There is no edge.");
        }
        return map.get(from).get(to);
    }

    public boolean addEdge(final Node from, final Node to, final int time) {
        if (isNodeInGraph(from) && isNodeInGraph(to)) {
            if (!isEdgeInGraph(from, to)) {
                map.get(from).put(to, time);
                map.get(to).put(from, time);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public int getNoOfNodes() {
        return map.size();
    }

    public int getNoOfEdges() {
        int noOfEdges = 0;
        final Iterator<Entry<Node, Map<Node, Integer>>> iter;
        iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Node, Map<Node, Integer>> hs = iter.next();
            noOfEdges += hs.getValue().size();
        }
        return noOfEdges / 2;
    }

    public Map<Node, Integer> getAllAdjaNodes(final Node node) {
        if (isNodeInGraph(node)) {
            return map.get(node);
        } else {
            return new HashMap<>();
        }
    }
}
