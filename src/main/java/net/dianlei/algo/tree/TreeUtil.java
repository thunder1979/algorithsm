package net.dianlei.algo.tree;

public class TreeUtil {
    public static Node buildTree() {
        Node t1 = new Node(1);
        Node t2 = new Node(2);
        Node t3 = new Node(3);
        Node t4 = new Node(4);
        Node t5 = new Node(5);
        Node t6 = new Node(6);
        Node t7 = new Node(7);
        Node t8 = new Node(8);
        Node t9 = new Node(9);
        Node t10 = new Node(10);
        Node t11 = new Node(11);
        Node t12 = new Node(12);
        Node t13 = new Node(13);
        Node t14 = new Node(14);
        Node t15 = new Node(15);
        Node t16 = new Node(16);
        Node t17 = new Node(17);
        Node t18 = new Node(18);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        t4.left = t8;
        t4.right = t9;
        t5.left = t10;
        t5.right = t11;
        t6.left = t12;
        t6.right = t13;
        t7.left = t14;
        t7.right = t15;
        t9.left = t16;
        t9.right = t17;
        t14.right = t18;

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
        return t1;
    }

    public static  Node buildCompleteFullTree() {
        Node node1 = new Node(1);

        Node node2 = new Node(2);
        Node node3 = new Node(3);

        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        Node node11 = new Node(11);
        Node node12 = new Node(12);
        Node node13 = new Node(13);
        Node node14 = new Node(14);
        Node node15 = new Node(15);

        Node node16 = new Node(16);
        Node node17 = new Node(17);
        Node node18 = new Node(18);
        Node node19 = new Node(19);
        Node node20 = new Node(20);
        Node node21 = new Node(21);
        Node node22 = new Node(22);
        Node node23 = new Node(23);
        Node node24 = new Node(24);
        Node node25 = new Node(25);
        Node node26 = new Node(26);
        Node node27 = new Node(27);
        Node node28 = new Node(28);
        Node node29 = new Node(29);
        Node node30 = new Node(30);
        Node node31 = new Node(31);
        Node node32 = new Node(32);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        node4.left = node8;
        node4.right = node9;
        node5.left = node10;
        node5.right = node11;
        node6.left = node12;
        node6.right = node13;
        node7.left = node14;
        node7.right = node15;

        node8.left = node16;
        node8.right = node17;
        node9.left = node18;
        node9.right = node19;
        node10.left = node20;
        node10.right = node21;
        node11.left = node22;
        node11.right = node23;
        node12.left = node24;
        node12.right = node25;
        node13.left = node26;
        node13.right = node27;
        node14.left = node28;
        node14.right = node29;
        node15.left = node30;
        node15.right = node31;

        return node1;
    }
}
