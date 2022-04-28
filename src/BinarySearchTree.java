public class BinarySearchTree<Key extends Comparable<Key>, Value> {

    public Node<Key, Value> root;
    private int count=0;
    private int size=0;

    public BinarySearchTree() {
    }

    public int size() {
        int size=0;
        size(root);
        return size;
    }

    //use Node's recursive size
    private int size(Node x) {
        boolean r=false;
        boolean l=false;
        if(x.getRight()!=null){
            size+=x.getRight().getSize();
            r=true;
        }
        if(x.getLeft()!=null){
            size+=x.getLeft().getSize();
            l=true;
        }
        if(r&&l)
            return size(x.getRight()) + size(x.getLeft());


        if(r)
            return size(x.getRight());

        if(l)
            return size(x.getLeft());

        return 0;

    }

    public boolean isEmpty() {
        boolean tmp1=true ,tmp2 = true;
        if(root.getLeft()==null && root.getRight()==null){
            tmp1=false;
        }
        if(root.getKey()==null && root.getValue()==null){
            tmp2=false;
        }
        if(!tmp1 && !tmp2){
            return true;
        }
        return false;

    }

    //recursive put wrapper
    public void put(Key key, Value value) {
        if(count==0){
            root.setValue(value);
            count++;
        }
        put(root,key,value);
        count++;
    }

    //recursive put
    //sets left/right or creates a new node appropriately, returns the
    //modified node n
    private Node<Key, Value> put(Node<Key, Value> n, Key key, Value val){
        int nodeKey = (int)n.getKey();
        int inpKey = (int)key;

        //compare the key to the key int of the current node and that is how you determine if the value goes to the left or the right
        if(nodeKey<inpKey){
            if(n.getRight()==null){
                Node tmpNode = new Node(key, val, 1);
                n.setRight(tmpNode);
                return tmpNode;
            } else {
                return put(n.getRight(),key,val);
            }
        }
        if(nodeKey>inpKey){
            if(n.getLeft()==null){
                Node tmpNode = new Node(key, val, 1);
                n.setLeft(tmpNode);
                return tmpNode;
            } else {
                return put(n.getLeft(),key,val);
            }
        }
        return null;
    }

    //recursive get wrapper
    public Value get(Key key) {

        return get(root, key);
    }

    //recursive get
    //returns null if the key does not exist
    private Value get(Node<Key, Value> n, Key key) {

    }

    public boolean contains(Key key) {

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
        if(n.getLeft()!=null){
            return min(n.getLeft());
        }
        return n;
    }

    public Key max() {
        return max(root).getKey();
    }

    //returns the node at the right most right branch of n
    private Node<Key, Value> max(Node<Key, Value> n) {
        if(n.getRight()!=null){
            return min(n.getRight());
        }
        return n;
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