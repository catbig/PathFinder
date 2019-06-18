/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myconfident.pathfinder;

import com.myconfident.pathfinder.object.Matrix;
import com.myconfident.pathfinder.object.Node;
import com.myconfident.pathfinder.object.Path;
import com.myconfident.pathfinder.parser.Parser;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author catur.nugroho
 */
public class PathFinder {

    private int[][] map = null;
    private boolean[][] explored = new boolean[1000][1000];
    private int sizeX = 0;
    private int sizeY = 0;
    private List<Node> endList = new ArrayList<Node>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Parser parser = new Parser();
        Matrix matrix = parser.parse(new File("E:\\personal\\test\\redmart\\map.txt"));
        PathFinder pathFinder = new PathFinder();
        pathFinder.explore(matrix);
    }

    private void explore(Matrix matrix) {
        sizeX = matrix.getX();
        sizeY = matrix.getY();
        map = matrix.getMap();
        List<Node> nodeList = new ArrayList();
        for (int i = 0; i < matrix.getY(); i++) {
            for (int j = 0; j < matrix.getX(); j++) {
//                if (!explored[i][j]) {
//                    continue;
//                }
                Node node = new Node();
                node.setY(i);
                node.setX(j);
                node.setValue(map[i][j]);
                node.setRoot(node);
                explore(node);
//                printNode(node);
                nodeList.add(node);
//                System.out.println("==================");
                explored[i][j] = true;
            }
        }
        findLongestPath(endList);
    }

    private void findLongestPath(List<Node> nodeList) {
        List<Path> pathList = new ArrayList<Path>();
        for (int i = 0; i < nodeList.size(); i++) {
            Node node = nodeList.get(i);
            Path path = new Path();
            path.setEndNode(node);
            getPath(path.getValues(), node);
            pathList.add(path);
        }

//        printPath(pathList);
        int maxLength = 0;
        int maxDepth = 0;
        Path longestPath = new Path();
        for (int i = 0; i < pathList.size(); i++) {
            Path path = pathList.get(i);
            List<Integer> values = path.getValues();
            if (maxLength < values.size()) {
                maxLength = values.size();
                longestPath = path;
                maxDepth = values.get(values.size() - 1) - values.get(0);
            } else if (maxLength == values.size()) {
                int depth = values.get(values.size() - 1) - values.get(0);
                if (maxDepth < depth) {
                    longestPath = path;
                    maxDepth = depth;
                }
            }
        }

        System.out.println(longestPath.getEndNode().toString());
        for (int j = longestPath.getValues().size() - 1; j > -1; j--) {
            Integer val = longestPath.getValues().get(j);
            System.out.print(val + ",");
        }
        System.out.println("");
        System.out.println(maxLength + "" + maxDepth + "@redmart.com");
    }

    private void getPath(List<Integer> path, Node node) {
        if (node == null) {
            return;
        }
        path.add(node.getValue());
        getPath(path, node.getParent());
    }

    // for debugging
    private void printNode(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.getY() + "," + node.getX() + ":" + node.getValue());
        printNode(node.getUp());
        printNode(node.getDown());
        printNode(node.getLeft());
        printNode(node.getRight());
    }

    // for debugging
    private void printPath(List<Path> pathList) {
        for (int i = 0; i < pathList.size(); i++) {
            List<Integer> path = pathList.get(i).getValues();
            for (int j = path.size() - 1; j > -1; j--) {
                Integer val = path.get(j);
                System.out.print(val + ",");
            }
            System.out.println("");
        }
    }

    private Node getNextNode(Node node, int x, int y, int value) {
        Node next = null;
        if (value > 0 && node.getValue() > value) {
            next = new Node();
            next.setX(x);
            next.setY(y);
            next.setValue(value);
            next.setParent(node);
            next.setRoot(node.getRoot());
        }
        explored[y][x] = true;
        return next;
    }

    private void explore(Node node) {
        if (node == null) {
            return;
        }
        up(node);
        down(node);
        left(node);
        right(node);
        if (node.getUp() == null && node.getDown() == null
                && node.getLeft() == null && node.getRight() == null) {
            node.setIsEnd(true);
            endList.add(node);
        }
    }

    private void up(Node node) {
        if (node.getUp() != null) {
            return;
        }
        int x = node.getX();
        int y = node.getY() - 1;
        if (y > 0) {
            int value = map[y][x];
            Node next = getNextNode(node, x, y, value);
            explore(next);
            node.setUp(next);
        }
    }

    private void down(Node node) {
        if (node.getDown() != null) {
            return;
        }
        int x = node.getX();
        int y = node.getY() + 1;
        if (y < sizeY) {
            int value = map[y][x];
            Node next = getNextNode(node, x, y, value);
            explore(next);
            node.setDown(next);
        }
    }

    private void left(Node node) {
        if (node.getLeft() != null) {
            return;
        }
        int x = node.getX() - 1;
        int y = node.getY();
        if (x > 0) {
            int value = map[y][x];
            Node next = getNextNode(node, x, y, value);
            explore(next);
            node.setLeft(next);
        }
    }

    private void right(Node node) {
        if (node.getRight() != null) {
            return;
        }
        int x = node.getX() + 1;
        int y = node.getY();
        if (x < sizeX) {
            int value = map[y][x];
            Node next = getNextNode(node, x, y, value);
            explore(next);
            node.setRight(next);
        }
    }

}
