/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW15;

import java.util.Objects;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * {Class description here}.
 *
 * @author Boas Meier
 * @version JDK 12.0.2
 */
public class Node {

    private static final Logger LOG = LogManager.getLogger(Node.class);

    private String name;
    private Color color;

    public Node(final String name) {
        this.name = name;
        this.color = Color.WHITE;
    }

    public void setColor(final Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Node)) {
            return false;
        }

        final Node other = (Node) obj;
        return Objects.equals(this.name, other.getName());
    }

}
