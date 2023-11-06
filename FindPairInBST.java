import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class FindPairInBST {
    Node root;

    // Method to find a pair of nodes in the BST with the given sum
    public void findPairWithSum(Node node, int target) {
        HashSet<Integer> set = new HashSet<>(); // To store encountered values
        Stack<Node> stack = new Stack<>(); // To perform in-order traversal

        // In-order traversal to visit nodes in sorted order
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop(); // Pop a node from the stack
            int complement = target - node.data;

            if (set.contains(complement)) {
                // If the complement is in the set, we found a pair
                System.out.println("Pair is (" + complement + "," + node.data + ")");
                return;
            }

            set.add(node.data); // Add the current node's data to the set
            node = node.right; // Move to the right child
        }

        // If no pair is found after traversing the entire tree
        System.out.println("Nodes are not found");
    }

    public static void main(String[] args) {
        FindPairInBST tree = new FindPairInBST();
        tree.root = new Node(60);
        tree.root.left = new Node(40);
        tree.root.right = new Node(70);
        tree.root.left.left = new Node(20);
        tree.root.left.right = new Node(50);
        tree.root.right.left = new Node(65);
        tree.root.right.right = new Node(80);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the target sum: ");
        int sum = scanner.nextInt();
        scanner.close();

        tree.findPairWithSum(tree.root, sum); // Call the method to find the pair
    }
}
