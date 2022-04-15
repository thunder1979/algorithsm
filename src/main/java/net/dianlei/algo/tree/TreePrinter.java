package net.dianlei.algo.tree;

import java.util.*;

public class TreePrinter {

    public void printTree(List<GraphNode> gnodeList) {

        int height = gnodeList.get(gnodeList.size() - 1).height;
        int maxValue = gnodeList.stream().max((a, b) -> a.value - b.value).get().value;
        int wordWidth = ("" + maxValue).length() + 1;
        int wordSpaces = 1;
        int nodeSpaces = 1;
        int maxLevelCount = 1 << height;

        int lineWidth = wordWidth * maxLevelCount + maxLevelCount/2 * wordSpaces + (maxLevelCount/2 - 1) * nodeSpaces;
        // for debug to avoid out of index exception
        lineWidth = lineWidth + 1;
        char[] valueLine = new char[lineWidth];
        char[] pipeLine = new char[lineWidth];
        char[] hyphenLine = new char[lineWidth];
        initializeLines(valueLine, pipeLine, hyphenLine);
        int currentLevel = 0;
        int currentTotalCnt = 0;
        for (GraphNode gnode : gnodeList) {
            if(gnode.height > currentLevel) {
                if(gnode.height != 1) {
                    System.out.println(hyphenLine);
                }
                // System.out.println(pipeLine);
                System.out.println(valueLine);
                System.out.println(pipeLine);
                initializeLines(valueLine, pipeLine, hyphenLine);
                currentTotalCnt = currentTotalCnt + (1 <<  currentLevel);
                currentLevel = gnode.height;
            }
            int levelTotalCnt = 1 << gnode.height;
            int childrenCount = 1 << (height - gnode.height);
            int wordSpacesCount = childrenCount / 2;
            int nodeSpacesCount = wordSpacesCount - 1 > 0? wordSpacesCount - 1 : 0;
            int nodeWidth = childrenCount * wordWidth + wordSpacesCount * wordSpaces + nodeSpacesCount * nodeSpaces;
            int levelPos = gnode.pos - currentTotalCnt;
            int nodeStartPos = 0;
            String val = gnode.value + "";
            int wordPos = 0;
            int pipePos = 0;
            int hyphenPos = 0;
            int hyphenWidth = (nodeWidth + 1)/2 + (nodeSpaces + 1)/2;

            if(gnode.height == height) {
                // latest level
                if(levelPos == 0) {
                    nodeStartPos = 0;
                    pipePos = 0;
                    hyphenPos = 0;
                } else {
                    int wordCount  = levelPos;
                    wordSpacesCount = levelPos/2;
                    nodeSpacesCount = levelPos/2;
                    nodeStartPos = wordCount * wordWidth + wordSpaces * wordSpacesCount + nodeSpacesCount * nodeSpaces;
                    if(levelPos % 2 == 0) {
                        wordPos = nodeStartPos;
                        pipePos = nodeStartPos;
                        hyphenPos = nodeStartPos;
                    } else {
                        hyphenPos = nodeStartPos + (wordSpaces + 1)/2 -1;
                        wordPos = nodeStartPos + (wordSpaces + 1)/2 + wordWidth - val.length();
                        pipePos = nodeStartPos + (wordSpaces + 1)/2 + wordWidth -1;
                    }

                }
                hyphenWidth = wordWidth + (wordSpaces + 1)/2;
            } else {
                nodeStartPos = levelPos * nodeWidth + nodeSpaces * levelPos;
                if(levelPos % 2 == 0) {
                    // left node
                    wordPos = nodeStartPos + (nodeWidth + 1)/2 - 1;
                    hyphenPos = nodeStartPos + (nodeWidth + 1)/2 - 1;
                    pipePos = nodeStartPos + (nodeWidth + 1)/2 - 1;
                    hyphenWidth = (nodeWidth + 1)/2 + (nodeSpaces + 1)/2;
                } else {
                    // nodeStartPos = levelPos * nodeWidth + (nodeSpaces + 1)/2 - 1;
                    wordPos = nodeStartPos + (nodeWidth + 1)/2 - val.length();
                    pipePos = nodeStartPos + (nodeWidth + 1)/2 - 1;
                    hyphenPos = nodeStartPos;
                    hyphenWidth = (nodeWidth + 1)/2 + (nodeSpaces + 1)/2 -1;
                }
            }

            System.arraycopy(val.toCharArray(), 0, valueLine, wordPos, val.toCharArray().length );
            System.arraycopy(new char[] { '|' }, 0, pipeLine, pipePos, 1 );
            char[] hyphens = new char[hyphenWidth];
            Arrays.fill(hyphens, '-');
            System.arraycopy(hyphens, 0, hyphenLine, hyphenPos, hyphenWidth);
        }
        System.out.println(hyphenLine);
        System.out.println(pipeLine);
        System.out.println(valueLine);
    }

    private void initializeLines(char[] valueLine, char[] pipeLine, char[] hyphenLine) {
        Arrays.fill(valueLine, ' ');
        // valueLine[valueLine.length] = '\n';
        Arrays.fill(pipeLine, ' ');
        // pipeLine[pipeLine.length] = '\n';
        Arrays.fill(hyphenLine, ' ');
        // hyphenLine[hyphenLine.length] = '\n';
    }

    public List<List<Node>> printTreeInLevel(Node tree) {
        Queue<Node> queue = new LinkedList<>();
        List<List<Node>> treeLevels = new LinkedList<>();
        if(tree == null ) {
            return null;
        }
        // Node tmp = tree;
        queue.offer(tree);
        int currentLevelCount = 1;
        int nextLevelCount = 0;
        List<Node> level = new LinkedList<>();
        while (currentLevelCount > 0) {
            Node tmp =  queue.poll();
            level.add(tmp);
            if(tmp.left != null) {
                queue.offer(tmp.left);
                nextLevelCount ++;
            }
            if(tmp.right != null) {
                queue.offer(tmp.right);
                nextLevelCount ++;
            }
            currentLevelCount --;
            if(currentLevelCount == 0) {
                // current level is done, move to next level
                treeLevels.add(level);
                level = new LinkedList<>();
                currentLevelCount = nextLevelCount;
                nextLevelCount = 0;
            }
        }
        return treeLevels;
    }


}
