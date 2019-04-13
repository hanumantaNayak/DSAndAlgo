package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VerticalTreePrinting {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.addNode(3);
        bt.addNode(-6);
        bt.addNode(-7);
        bt.addNode(2);
        bt.addNode(9);
        bt.addNode(6);
        bt.addNode(11);
        bt.addNode(13);
        bt.addNode(12);
        // bt.display();
        VerticalTreePrinting vtp = new VerticalTreePrinting();
        vtp.printvertical(bt.getRoot());
    }

    public void printvertical(Node root) {
        Map<Integer, List<Node>> map = new HashMap<>();
        populateMap(root, map, 0);
        printLevel(map);

    }

    private void populateMap(Node root, Map<Integer, List<Node>> map, int level) {
        if (root == null) {
            return;
        }
        List<Node> listNodes = null;
        if (map.containsKey(level))
            listNodes = map.get(level);
        else {
            listNodes = new ArrayList<>();
            map.put(level, listNodes);
        }
        listNodes.add(root);
        populateMap(root.getLeft(), map, level - 1);
        populateMap(root.getRight(), map, level + 1);
    }

    private void printLevel(Map<Integer, List<Node>> map) {
        if (map == null) {
            System.out.println(" Tree is empty");
            return;
        }
        for (Integer key : map.keySet()) {
            List<Node> lisNodes = map.get(key);
            for (Node n : lisNodes) {
                System.out.print(n.getData() + " ");
            }
            System.out.println();
        }
    }
}
