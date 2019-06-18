/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myconfident.pathfinder.object;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author catur.nugroho
 */
public class Path {
    private int length = 0;
    private int depth = 0;
    private List<Integer> values = new ArrayList();
    private Node endNode = null;

    /**
     * @return the length
     */
    public int getLength() {
        return length;
    }

    /**
     * @param length the length to set
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * @return the depth
     */
    public int getDepth() {
        return depth;
    }

    /**
     * @param depth the depth to set
     */
    public void setDepth(int depth) {
        this.depth = depth;
    }

    /**
     * @return the values
     */
    public List<Integer> getValues() {
        return values;
    }

    /**
     * @param values the values to set
     */
    public void setPath(List<Integer> values) {
        this.values = values;
    }

    /**
     * @return the endNode
     */
    public Node getEndNode() {
        return endNode;
    }

    /**
     * @param endNode the endNode to set
     */
    public void setEndNode(Node endNode) {
        this.endNode = endNode;
    }
}
