/**
 * BinarySearchTree
 * a BST model
 * Author: August Penny
 * Collaborator(s): The names of anyone you collaborated with here
 * Collaboration: Describe the collaboration that took place
 * Date: 5/11/21
 **/

public class BinarySearchTree<Key extends Comparable<Key>, Value> {

    public Node<Key, Value> root;
    private int count=0;
    private int size=0;

    public BinarySearchTree() {
        root=new Node<>();
    }

    public int size() {//returns sum of sizes of array
        return size(root);
    }

    //use Node's recursive size
    private int size(Node x) {
        if(x== null){
            return 0;//returns 0 when it gets to bottom of tree
        }
        return x.getSize()+size(x.getLeft())+size(x.getRight());

    }

    public boolean isEmpty() {//checks if the BST has any values in it
        boolean tmp1=true ,tmp2 = true;
        if(root.getLeft()==null && root.getRight()==null){
            tmp1=false;//checks if the root node has any children
        }
        if(root.getKey()==null && root.getValue()==null){
            tmp2=false;//cehcks if the root node has key or value
        }
        if(!tmp1 && !tmp2){
            return true;//returns true only if both root is emoty and if it has no kids
        }
        return false;

    }

    //recursive put wrapper
    public void put(Key key, Value value) {
        if(count==0) {//if it is the first node to be added, sets the values to root node
            root.setValue(value);
            root.setSize(1);
            root.setKey(key);
            count++;

            return;

        }
        root = put(root,key,value);

    }


    private Node<Key, Value> put(Node<Key, Value> n, Key key, Value val){

        if(n==null){//if reached the end of the tree then it is in the right place
            n=new Node<>(key,val,1);
            return n;
        }

        int compVal=key.compareTo(n.getKey());


        if(compVal==-1){//goes right if the current node is less thjan the key
            n.setLeft(put(n.getLeft(),key,val));
        }
        if(compVal==1){//goes left if the current node is more than the key
            n.setRight(put(n.getRight(),key,val));
        }

        return n;
    }

    //recursive get wrapper
    public Value get(Key key) {
        if(root.getKey()==null){//if the array is empty then returns null
            return null;
        }


        return get(root, key);
    }

    //recursive get
    //returns null if the key does not exist
    private Value get(Node<Key, Value> n, Key key) {
        if(n==null)//returns null if it reached the end of the tree
            return null;
        int k = key.compareTo(n.getKey());
        if(k==1){//sends the search to the right
            if(n.getRight()!=null)
                return get(n.getRight(),key);
        }
        if(k==-1){//sends the sesrch left
            if(n.getLeft()!=null)
                return get(n.getLeft(),key);
        }
        if(k==0)//returns value of n if it equals the key
            return n.getValue();

        return null;

    }

    public boolean contains(Key key) {
        if(get(key)==null){
            return false;
        }
        return true;
    }



    public Value remove(Key key) {
        Value v = get(key);
        root = remove(root, key);
        return v;
    }

    private Node remove(Node<Key, Value> n, Key key) {
        if (n == null) return null;
        int i = key.compareTo(n.getKey());
        if (i < 0) {
            n.setLeft(remove(n.getLeft(), key));
        } else if (i > 0) {
            n.setRight(remove(n.getRight(), key));
        } else {
            if (n.getRight() == null) return n.getLeft();
            if (n.getLeft() == null) return n.getRight();
            Node min = min(n.getRight());
            min.setLeft(n.getLeft());
            n = n.getRight();
        }
        n.setSize(size(n.getRight()) + size(n.getLeft()) + 1);
        return n;
    }

    public Key min() {
        return min(root).getKey();
    }

    //returns the node at the left most left branch of n
    private Node<Key, Value> min(Node<Key, Value> n) {
        if(n.getLeft()==null){//if no more nodes below n on the left, returns n
            return n;
        }
        return min(n.getLeft());
    }

    public Key max() {
        return max(root).getKey();
    }

    //returns the node at the right most right branch of n
    private Node<Key, Value> max(Node<Key, Value> n) {//if no nodes above n on the right, returns n
        if(n.getRight()==null){
            return n;
        }
        return max(n.getRight());
    }

    public String toString() {
        String temp = toString(root);
        temp = temp.substring(0, temp.length() - 2);
        return "{" + temp + "}";
    }

    private String toString(Node<Key, Value> n) {
        if (n == null) return "";
        return toString(n.getLeft()) +
                n.getKey() + "=" + n.getValue() + ", " +
                toString(n.getRight());

    }
}