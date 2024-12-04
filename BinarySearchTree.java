class BinarySearchTree {
   public Node root = null;

   public void put(int key) {
      root = putHelper(root, key);
   }

   private Node putHelper(Node n, int key) {
      if (n == null)
         return new Node(key);
      if (key < n.key)
         n.left = putHelper(n.left, key);
      else if (key > n.key)
         n.right = putHelper(n.right, key);
      // do nothing for equality
      return n;
   }

   public boolean searchRecursive(int key) {
      return searchHelper(root, key);
   }

   public boolean searchHelper(Node n, int key) {

      if (n == null)
         return false;
      if (n.key == key)
         return true;
      if (n.left != null && key < n.key)
         return searchHelper(n.left, key);
      if (n.left != null && key > n.key)
         return searchHelper(n.right, key);
      else
         return false;

   }

   public int countNodes() {

      return countHelper(root);

   }

   public int countHelper(Node n) {

      if (n == null)
         return 0;
      return 1 + countHelper(n.left) + countHelper(n.right);
   }
   // you will implement this method
   // you can write additional helper methods
   // HINT: think about using a TRAVERSAL

   public void deleteMinimum() {
    if (root == null) {
        return; 
    }

    if (root.left == null) {
        root = root.right; 
        return;
    }

    Node parent = null;
    Node n = root;

    while (n.left != null) {
        parent = n;
        n = n.left;
    }

   
    if (n.right != null) {
        parent.left = n.right;
    } else {
        parent.left = null;
    }
}

   public static void main(String[] args) {
      // a tree for testing
      BinarySearchTree tree = new BinarySearchTree();
      tree.put(5);
      tree.put(3);
      tree.put(1);
      tree.put(4);
      tree.put(7);
      tree.put(6);
      tree.put(8);
      System.out.println(tree.searchRecursive(2)); // prints false
      System.out.println(tree.searchRecursive(0)); // prints false
      System.out.println(tree.searchRecursive(8)); // prints true
      System.out.println(tree.searchRecursive(4)); // prints true
      System.out.println(tree.countNodes()); // prints 7
      tree.deleteMinimum(); // check if 1 is deleted
      System.out.println(tree.searchRecursive(1));
      // root.left.left should be null
      tree.deleteMinimum(); // check if 3 is deleted
      System.out.println(tree.searchRecursive(4));
      // root.left should be 4
   }
}

class Node {
   int key;
   Node left, right;

   public Node(int key) {
      this.key = key;
      this.left = null;
      this.right = null;
   }
}