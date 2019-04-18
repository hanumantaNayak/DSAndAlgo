package tree;

import java.util.Objects;

public class SerializeDeserializeBinaryTree {
    public String serialize(Node root) {
        StringBuffer buffer = new StringBuffer();
        serializeUtil(root, buffer);
        return buffer.toString();
    }

    private void serializeUtil(Node root, StringBuffer buffer) {
        if (Objects.isNull(root)) {
            buffer.append("%,");
            return;
        }
        buffer.append(root.getData()).append(",");
        if (root.getLeft() != null || root.getRight() != null)
            buffer.append("$,");
        serializeUtil(root.getLeft(), buffer);
        serializeUtil(root.getRight(), buffer);
    }

    public Node deSerialize(String buffer) {
        String[] inputs = buffer.split(",");
        return deSerializeUtil(inputs);
    }

    int index = 0;

    private Node deSerializeUtil(String[] inputs) {
        if (index >= inputs.length)
            return null;
        if (inputs[index].equals("%"))
            return null;
        Node node = new Node();
        node.setData(Integer.parseInt(inputs[index]));
        if (index < inputs.length - 1) {
            index++;
            if (inputs[index].equals("$"))
                index++;
            node.setLeft(deSerializeUtil(inputs));
            index++;
            node.setRight(deSerializeUtil(inputs));
        }
        return node;
    }
// Time complexity O(n)
// Space complexity O(n)
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.addNode(3);
        bt.addNode(2);
        bt.addNode(1);
        bt.addNode(4);
        bt.addNode(5);
        System.out.println("Original tree");
        TreeTraversalLevelByLevel levelByLevel = new TreeTraversalLevelByLevel();
        levelByLevel.treeTraversalLevelByLevel(bt.getRoot());
        System.out.println("\nSerialized tree");
        SerializeDeserializeBinaryTree sdt = new SerializeDeserializeBinaryTree();
        String serialize = sdt.serialize(bt.getRoot());
        System.out.println(serialize);
        System.out.println("De-serialized tree");
        Node node = sdt.deSerialize(serialize);
        levelByLevel.treeTraversalLevelByLevel(node);
    }
}
