/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myconfident.pathfinder.object;

/**
 *
 * @author catur.nugroho
 */
public class Node {

    private int x = -1;
    private int y = -1;
    private int value = -1;
    private boolean isEnd = false;
    private Node root = null;
    private Node parent = null;
    private Node up = null;
    private Node down = null;
    private Node right = null;
    private Node left = null;

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * @return the isEnd
     */
    public boolean isIsEnd() {
        return isEnd;
    }

    /**
     * @param isEnd the isEnd to set
     */
    public void setIsEnd(boolean isEnd) {
        this.isEnd = isEnd;
    }

    /**
     * @return the root
     */
    public Node getRoot() {
        return root;
    }

    /**
     * @param root the root to set
     */
    public void setRoot(Node root) {
        this.root = root;
    }

    /**
     * @return the parent
     */
    public Node getParent() {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(Node parent) {
        this.parent = parent;
    }

    /**
     * @return the up
     */
    public Node getUp() {
        return up;
    }

    /**
     * @param up the up to set
     */
    public void setUp(Node up) {
        this.up = up;
    }

    /**
     * @return the down
     */
    public Node getDown() {
        return down;
    }

    /**
     * @param down the down to set
     */
    public void setDown(Node down) {
        this.down = down;
    }

    /**
     * @return the right
     */
    public Node getRight() {
        return right;
    }

    /**
     * @param right the right to set
     */
    public void setRight(Node right) {
        this.right = right;
    }

    /**
     * @return the left
     */
    public Node getLeft() {
        return left;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(Node left) {
        this.left = left;
    }
    
    public String toString() {
        String s = "root [" + root.getX() + "," + root.getY() + "] : " + root.getValue();
        s += "\nend [" + x + "," + y + "] : " + value;
        return s;
    }
}
