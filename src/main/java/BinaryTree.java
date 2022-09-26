import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.List;
public class BinaryTree <Type extends Comparable> {
    private class Node<Type> {
        public Type value;
        public int height = 0;
        public Node<Type> rightNode = null;
        public Node<Type> leftNode = null;
        public Node<Type> parentNode = null;
        public Node(Type value){ this.value = value;}
        @Override
        public String toString(){return value.toString();}

    }
    private Node<Type> root = new Node<>(null);
    private final List<Object> EMPTY_LIST = new ArrayList<>().subList(0,0);
    public BinaryTree(){
    }
    public BinaryTree(Type value){
        this.root.value = value;
    }
    public BinaryTree(Type @NotNull ... vars){
        this.root.value = vars[0];
        for(int i = 1; i < vars.length; i++)
            this.insert(vars[i]);
    }
    // TODO: change while on if!
    public void insert(Type value) throws IllegalArgumentException{
        if(value == null)
            throw new IllegalArgumentException();
        Node<Type> node = createNode(value);
        changeHeight(node);
        while(!isBalancedTree(node))
            balanceTree(node);
    }
    public ArrayList<Type> symmetricOrderArray(){
        ArrayList<Node<Type>> list = symmetricOrder(this.root);
        ArrayList<Type> result = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            result.add(list.get(i).value);
        }
        return result;
    }
    private Node<Type> createNode(Type value){
        Node<Type> parentNode = this.root;
        Node<Type> newNode = null;
        while(newNode == null){
            switch(value.compareTo(parentNode.value)){
                case -1:{
                    if(parentNode.leftNode == null){
                        newNode = new Node<>(value);
                        newNode.parentNode = parentNode;
                        parentNode.leftNode = newNode;
                    } else
                        parentNode = parentNode.leftNode;
                    break;
                }
                case 1: {
                    if (parentNode.rightNode == null) {
                        newNode = new Node<>(value);
                        newNode.parentNode = parentNode;
                        parentNode.rightNode = newNode;
                    } else
                        parentNode = parentNode.rightNode;
                    break;
                }
                case 0:{
                    if(parentNode.leftNode == null){
                        newNode = new Node<>(value);
                        newNode.parentNode = parentNode;
                        parentNode.leftNode = newNode;
                    }
                    else{
                        newNode = new Node<>(value);
                        newNode.parentNode = parentNode;
                        newNode.leftNode = parentNode.leftNode;
                        parentNode.leftNode = newNode;
                    }
                    break;
                }
            }
        }
        return newNode;
    }
    private void changeHeight(Node<Type> node){
        node.height = 1 + Math.max((node.leftNode != null)? node.leftNode.height : 0 ,
                (node.rightNode != null)? node.rightNode.height :  0);
        if(node.parentNode != null)
            changeHeight(node.parentNode);
    }
    private boolean isBalancedTree(Node<Type> node){
        if(node == null)
            return true;
        if(Math.abs(((node.leftNode != null)? node.leftNode.height : 0 ) -
                ((node.rightNode != null)? node.rightNode.height :  0)) < 2)
            return isBalancedTree(node.parentNode);
        else
            return false;
    }
    private ArrayList<Node<Type>> symmetricOrder(Node<Type> root){
        ArrayList<Node<Type>> list = new ArrayList<>();
        addToListSO(root, list);
        return list;
    }
    private void addToListSO(Node<Type> root, ArrayList<Node<Type>> list){
        if(root == null)
            return;
        addToListSO(root.leftNode, list);
        list.add(root);
        addToListSO(root.rightNode, list);
    }
    // TODO: change ArrayList to List
    private Node<Type> buildTree(List<Node<Type>> list){
        if(list.equals(EMPTY_LIST))
            return null;
        Node<Type> root = list.get(list.size()/2);
        root.leftNode = buildTree(list.subList(0, list.size()/2));
        if(root.leftNode != null)
            root.leftNode.parentNode = root;
        root.rightNode = buildTree(list.subList(list.size()/2+1, list.size()));
        if(root.rightNode != null)
            root.rightNode.parentNode = root;
        root.height = 1 + Math.max((root.leftNode != null)? root.leftNode.height : 0 ,
                (root.rightNode != null)? root.rightNode.height :  0);
        return root;
    }

    /**
     * @param node is sheet which consist in unbalanced tree
     */
    private void balanceTree(Node<Type> node){
        Node<Type> root = node.parentNode;
        while(Math.abs(((root.leftNode != null)? root.leftNode.height : 0 ) -
                ((root.rightNode != null)? root.rightNode.height :  0)) < 2)
            root = root.parentNode;
        Node<Type> parentOfRoot = root.parentNode;
        Node<Type> tmp = root;
        ArrayList<Node<Type>> list = this.symmetricOrder(root);
        root = buildTree(list);
        if(parentOfRoot != null){
            if(parentOfRoot.leftNode == tmp)
                parentOfRoot.leftNode = root;
            else
                parentOfRoot.rightNode = root;
        } else
            this.root = root;
        root.parentNode = parentOfRoot;
        changeHeight(root);
    }

    public boolean search(Type value){
        Node<Type> parentNode = this.root;
        while(parentNode != null){
            switch(value.compareTo(parentNode.value)){
                case -1:{
                    parentNode = parentNode.leftNode;
                    break;
                }
                case 1: {
                    parentNode = parentNode.rightNode;
                    break;
                }
                case 0:{
                    return true;
                }
            }
        }
        return false;
    }
}
