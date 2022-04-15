package net.dianlei.algo.tree;


import java.util.*;
import java.util.stream.Collectors;

public class BinarySearchTree {
    private Node root;

    /**
     * insert the node to the tree
     *
     * @param node
     * @return parent node or null if the tree is empty;
     */
    public Node insert(Node node) {

        if (root == null) {
            root = node;
            return null;
        }
        Node parent = root;
        Node tmp = null;
        do {
            tmp = parent.value >= node.value ? parent.left : parent.right;
        } while (tmp != null);
        if (parent.value >= node.value) {
            parent.left = node;
        } else {
            parent.right = node;
        }
        return parent;
    }

    public static BinarySearchTree build(int[] a) {
        BinarySearchTree tree = new BinarySearchTree();
        for (int i = 0; i < a.length; i++) {
            Node tmp = new Node(a[i]);
            tree.insert(tmp);
        }
        return tree;
    }

    public int height() {
        int h;
        if (root == null) {
            return 0;
        }
        return height(root, 1);
    }

    private int height(Node node, int h) {
        if (node != null) {
            h = h + 1;
            int lh = height(node.left, h);
            int rh = height(node.right, h);
            return Math.max(lh, rh);
        }
        return h;
    }

    /**
     * Build a corresponding full&complete binary tree with height h
     * populated with dummy GraphNode, will replace the dummy node with real node.
     *
     * @param height
     */
    public GraphNode buildFullAndCompleteBinaryTree(GraphNode gnode, int height) {
        if (height > 0) {
            GraphNode left = new GraphNode(gnode.height + 1);
            GraphNode right = new GraphNode(gnode.height + 1);
            gnode.left = left;
            gnode.right = right;
            buildFullAndCompleteBinaryTree(left, height - 1);
            buildFullAndCompleteBinaryTree(right, height - 1);
        }
        return gnode;
    }

    /**
     * Build a corresponding full&complete binary tree for printing
     * Fill the null node with dummy GraphNode
     * When printing, print spaces for dummy GraphNode as placeholder
     *
     * @return graph node for printing
     */

    public GraphNode buildGraphTree() {
        int height = height();
        GraphNode gnode = new GraphNode(1);
        gnode = buildFullAndCompleteBinaryTree(gnode, height);
        return gnode;
    }

    public List<GraphNode> buildGraphNode(Node node) {
        List<GraphNode> gnodeList = new ArrayList<>();
        buildGraphNodes(node, 0, 0, gnodeList);
        return gnodeList.stream().sorted(Comparator.comparing(GraphNode::getPos)).collect(Collectors.toList());
    }

    private void buildGraphNodes(Node node, int height, int pos, List<GraphNode> gnodeList) {
        if (node == null) {
            return;
        }
        GraphNode gnode = new GraphNode(height);
        gnode.value = node.value;
        gnode.pos = pos;
        gnodeList.add(gnode);
        buildGraphNodes(node.left, height + 1, pos * 2 + 1, gnodeList);
        buildGraphNodes(node.right, height + 1, pos * 2 + 2, gnodeList);
    }

    public void printTree(List<GraphNode> gnodeList) {

        int height = gnodeList.get(gnodeList.size() - 1).height;
        int maxValue = gnodeList.stream().max((a, b) -> a.value - b.value).get().value;
        int wordWidth = ("" + maxValue).length() + 3;
        int lineWidth = wordWidth * (1 << height);
        char[] valueLine = new char[lineWidth];
        char[] pipeLine = new char[lineWidth];
        char[] hyphenLine = new char[lineWidth];
        initializeLines(valueLine, pipeLine, hyphenLine);
        int currentLevel = 0;
        int currentTotalCnt = 0;
        for (GraphNode gnode : gnodeList) {
            if(gnode.height > currentLevel) {
                System.out.println(hyphenLine);
                System.out.println(pipeLine);
                System.out.println(valueLine);
                System.out.println(pipeLine);
                initializeLines(valueLine, pipeLine, hyphenLine);
                currentTotalCnt = currentTotalCnt + (1 <<  currentLevel);
                currentLevel = gnode.height;
            }
            int levelTotalCnt = 1 << gnode.height;
            int nodeWidth = 1 << (height - gnode.height);
            // int indent = nodeWidth / 2;
            int levelPos = gnode.pos - currentTotalCnt;
            // int nodeStartPos = lineWidth + nodeWidth * levelPos;
            int nodeStartPos = nodeWidth * levelPos;
            String val = gnode.value + "";
            int wordStartPos;
            int pipePos;
            int hyphonePos =0;
            if(currentLevel == 0) {
                // root node, align = center
                nodeStartPos = 0;
                wordStartPos = lineWidth/2;
                pipePos = lineWidth / 2;
            } else if(levelPos % 2 == 0 ) {
                // left node, align = left
                wordStartPos = (nodeStartPos + nodeWidth/2) * wordWidth;
                pipePos = (nodeStartPos + nodeWidth/2) * wordWidth;
                hyphonePos = (nodeStartPos + nodeWidth/2) * wordWidth;
            } else {
                wordStartPos = (nodeStartPos + nodeWidth/2) * wordWidth;
                pipePos = (nodeStartPos + nodeWidth/2) * wordWidth;
                hyphonePos = nodeStartPos * wordWidth; //nodeWidth/2;
            }

            System.arraycopy(val.toCharArray(), 0, valueLine, wordStartPos, val.toCharArray().length );
            System.arraycopy(new char[] { '|' }, 0, pipeLine, pipePos, 1 );
            char[] hyphens = new char[nodeWidth * wordWidth / 2];
            Arrays.fill(hyphens, '-');
            System.arraycopy(hyphens, 0, hyphenLine, hyphonePos, nodeWidth * wordWidth / 2 );
        }
        System.out.println(hyphenLine);
        System.out.println(pipeLine);
        System.out.println(valueLine);
        System.out.println(pipeLine);
    }

    private void initializeLines(char[] valueLine, char[] pipeLine, char[] hyphenLine) {
        Arrays.fill(valueLine, ' ');
        // valueLine[valueLine.length] = '\n';
        Arrays.fill(pipeLine, ' ');
        // pipeLine[pipeLine.length] = '\n';
        Arrays.fill(hyphenLine, ' ');
       // hyphenLine[hyphenLine.length] = '\n';
    }

    public String pad(int value, int width) {
        String val = "" + value;
        int left = (width - val.length()) / 2;
        char valPadded[] = new char[width];
        System.arraycopy(val.toCharArray(), 0, valPadded, left, val.length());
        return val;
    }
}