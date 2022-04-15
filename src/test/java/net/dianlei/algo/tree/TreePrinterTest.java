package net.dianlei.algo.tree;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import net.dianlei.algo.tree.TreeUtil;

public class TreePrinterTest {

    @Test
    public void testPrintTree() {
        Node node = TreeUtil.buildTree();
        BinarySearchTree tree = new BinarySearchTree();
        List<GraphNode> graphNodeList = tree.buildGraphNode(node);
        TreePrinter printer = new TreePrinter();
        printer.printTree(graphNodeList);
    }


    //.................1
    //................/.\
    //.............../...\
    //............../.....\
    //............./.......\
    //............/.........\
    //.........../...........\
    //........../.............\
    //........./.............. \
    //........2.................3
    //......./.\.............../.\
    //....../...\............./...\
    //.....4.....5...........6.....7
    //..../.\.../.\........./.\.../.\
    //...8...9.10.11.......12..13.14.15
    //....../.\....................\
    //.....16..17...................18

    @Test
    public void testPrintTreeInLevel() {
        Node tree = TreeUtil.buildTree();
        TreePrinter treePrinter = new TreePrinter();
        List<List<Node>> treeLevels = treePrinter.printTreeInLevel(tree);
        List<List<Integer>> treeValueLevels = treeLevels.stream().map(
                level -> level.stream().map( node -> node.value).collect(Collectors.toList())
        ).collect(Collectors.toList());

        List<List<Integer>> expectedTreeValue = new ArrayList<>();
        List<Integer> expectedLevel = Arrays.asList( new Integer[] {1});
        expectedTreeValue.add(expectedLevel);
        expectedLevel = Arrays.asList( new Integer[] {2,3});
        expectedTreeValue.add(expectedLevel);
        expectedLevel = Arrays.asList( new Integer[] {4,5,6,7});
        expectedTreeValue.add(expectedLevel);
        expectedLevel = Arrays.asList( new Integer[] {8,9,10,11,12,13,14,15,});
        expectedTreeValue.add(expectedLevel);
        expectedLevel = Arrays.asList( new Integer[] {16,17,18});
        expectedTreeValue.add(expectedLevel);
        for (int i = 0; i < expectedTreeValue.size(); i ++) {
            Integer[] expectedLevelValue = expectedTreeValue.get(i).toArray(new Integer[0]);
            Integer[] levelValue = treeValueLevels.get(i).toArray(new Integer[0]);
            Assert.assertEquals(expectedLevelValue, levelValue);
        }
        treeValueLevels.forEach( valueLevel -> {
                        valueLevel.forEach(value -> System.out.print(value + ","));
                        System.out.println();
                    });
    }
}
