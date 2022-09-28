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
    public boolean search(@NotNull Type value){
        if(getNode(value) != null)
            return true;
        else
            return false;
    }
    public void insert(@NotNull Type value){
        Node<Type> node = createNode(value);
        if(node != this.root){
            changeSubTree(node);
        }
    }
    public boolean isBalancedTree(){
        ArrayList<Node<Type>> list = symmetricOrder(this.root);
        for(Node<Type> node: list) {
            if (Math.abs(((node.leftNode != null) ? node.leftNode.height : 0) -
                    ((node.rightNode != null) ? node.rightNode.height : 0)) < 2) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
    public ArrayList<Type> symmetricOrderArray(){
        ArrayList<Node<Type>> list = symmetricOrder(this.root);
        ArrayList<Type> result = new ArrayList<>();
        for (Node<Type> node : list) {
            result.add(node.value);
        }
        return result;
    }
    public void deleteValue(@NotNull Type value){
        Node<Type> node = getNode(value);
        if(node.parentNode != null) {
            if(node.parentNode.leftNode == node)
                node.parentNode.leftNode = null;
            else
                node.parentNode.rightNode = null;
        }
        else
            this.root = new Node<>(null);
        node.parentNode = null;
        ArrayList<Node<Type>> nodes = symmetricOrder(node);
        nodes.remove(node);
        for(Node<Type> val : nodes)
            this.insert(val.value);
    }
    public void deleteAll(){
        this.root = new Node<>(null);
    }
    public int getHeight(@NotNull  Type value){
        return getNode(value).height;
    }
    //TODO: Equals and HashCode
    private Node<Type> createNode(Type value){
        Node<Type> parentNode = this.root;
        if(this.root.value == null){
            this.root.value = value;
            return this.root;
        }
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
    private void changeSubTree(Node<Type> node){
        if(node == null)
            return;
        if(Math.abs(((node.leftNode != null)? node.leftNode.height : 0 ) -
                ((node.rightNode != null)? node.rightNode.height :  0)) < 2){
            node.height = 1 + Math.max((node.leftNode != null)? node.leftNode.height : 0 ,
                    (node.rightNode != null)? node.rightNode.height :  0);
            changeSubTree(node.parentNode);
        }
        else{
            node = balanceTree(node);
            changeSubTree(node);
        }
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
    private Node<Type> balanceTree(Node<Type> node){
        Node<Type> root = node;
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
        return root;
    }
    private Node<Type> getNode(Type value){
        Node<Type> node = this.root;
        if(this.root.value == null)
            return null;
        while(node != null){
            switch(value.compareTo(node.value)){
                case -1:{
                    node = node.leftNode;
                    break;
                }
                case 1: {
                    node = node.rightNode;
                    break;
                }
                case 0:{
                    return node;
                }
            }
        }
        return null;
    }
}
