package net.dianlei.algo.tree;

public class GraphNode {

    public GraphNode(int height) {
        this.height = height;
    }
    public GraphNode left;
    public GraphNode right;
    public boolean isLeft;
    public int value = Integer.MIN_VALUE; // MIN_VALUE means empty node
    public int height;
    public int pos; // position of the node in the full complete tree

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }
}
