/**
 * BinarySearchTree test
 * a BST testing program
 * Author: August Penny
 * Collaborator(s): The names of anyone you collaborated with here
 * Collaboration: Describe the collaboration that took place
 * Date: 5/11/21
 **/
public class BSTtest {
    public static void main(String[] args) {
        BinarySearchTree b = new BinarySearchTree();
        System.out.println(b.size());//checks size. should be 0
        System.out.println(b.isEmpty());//checks if empty. should be true
        b.put(2,"Mareks");
        b.put(6, "Kevin");
        b.put(4,"August");
        b.put(1,"Ishan");
        b.put(3,"trent");
        System.out.println("should return kevin: "+b.get(6));
        System.out.println("should return august: "+b.get(4));
        System.out.println("should return trent: "+b.get(3));
        System.out.println("checks size. should be 5: "+b.size());
        System.out.println("checks if empty. should be false: "+b.isEmpty());
        System.out.println("checks if 6 is used. should print true: "+b.contains(6));
        System.out.println("checks if 11 is used. should print false: "+b.contains(11));
        b.remove(3);
        b.remove(1);
        System.out.println("Checks if contains key 1. (retuen false because just removed): "+b.contains(1));
        System.out.println("Checks if contains key 3. (retuen false because just removed): "+b.contains(3));
        System.out.println("min value: "+b.min());
        System.out.println("Max value: "+b.max());
        System.out.println(b.toString());


    }
}
