/*
Класс для построения бинарного дерева поиска.
Это не "красно-чёрное" дерево. Окрас не добавлен в структуру.
 */
package TaskSix;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class BinaryTreeFind<D, K extends Integer> {

    private Node root;

    private class Node{
        private D data;
        private K key;
        private Node leftChild;
        private Node rightChild;

        public Node(K key, D data) {
            this.key = key;
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", key=" + key +
                    '}';
        }
    }

    /**
     * Поиск Node по цифровому значению key
     * @param key ключ объекта
     * @return возвращает Node по ключу
     */
    private Node find(K key){
        Node current = this.root;
        while (current.key != key){
            if (current.key.compareTo(key) > 0){    //если введённое число меньше внутреннего
                current = current.leftChild;        //двигаемся налево
            } else {
                current = current.rightChild;
            }
            if (current == null){
                return null;
            }
        }
        return current;
    }

    /**
     * Вставка в дерево нового объекта, с включённым запретом на дублирование ключа.
     * @param key ключ объекта
     * @param data непосредственно сам объект
     */
    public void insert(K key, D data) {
        Node localNode = new Node(key, data);
        if (this.root == null) {
            this.root = localNode;
        } else {
            if (find(key) == null) {
                Node current = this.root;
                Node parent;
                while (true) {
                    parent = current;
                    if (key.compareTo(current.key) < 0) {
                        current = current.leftChild;
                        if (current == null) {
                            parent.leftChild = localNode;
                            return;
                        }
                    } else {
                        current = current.rightChild;
                        if (current == null) {
                            parent.rightChild = localNode;
                            return;
                        }
                    }
                }
            }
        }
    }
    //поиск минимального Node в дереве
    private Node minNode(){
        Node last = null;
        for (Node current = this.root; current != null; current = current.leftChild) {
            last = current;
        }
        return last;
    }

    public D min(){
        return minNode().data;
    }

    public D max(){
        return maxNode().data;
    }

    //поиск максимального Node в дереве
    private Node maxNode(){
        Node last = null;
        for (Node current = this.root; current != null; current = current.rightChild) {
            last = current;
        }
        return last;
    }

    //метод-обёртка для симметричного обхода дерева, на вход ждёт требуемых действий над объектом, не над Node
    public void inOrder(Consumer<D> consumer){
        inOrder(this.root, consumer);
    }

    /**
     * метод рекурсивного обхода дерева
     * @param localRoot непосредственно середина дерева
     * @param consumer действия над объектом
     */
    private void inOrder(Node localRoot, Consumer<D> consumer){
        if (localRoot != null){
            inOrder(localRoot.leftChild, consumer);
            consumer.accept(localRoot.data);
            inOrder(localRoot.rightChild, consumer);
        }
    }

    //обход дерева рекурсивно, левое плечо
    private void inOrderLeft(Node sideShoulder, Consumer<Node> consumer){
        if (sideShoulder != null){
            inOrderLeft(sideShoulder.leftChild, consumer);
            consumer.accept(sideShoulder);
            inOrderLeft(sideShoulder.rightChild, consumer);
        }
    }

    //обход дерева рекурсивно, правое плечо
    private void inOrderRight(Node sideShoulder, Consumer<Node> consumer){
        if (sideShoulder != null){
            inOrderRight(sideShoulder.rightChild, consumer);
            consumer.accept(sideShoulder);
            inOrderRight(sideShoulder.leftChild, consumer);
        }
    }

    /**
     * проверка дерева на "зеркальность" - т.е. право плечо зеркально отражает левое.
     * формирование листов обхода правого и левого плеча с последующим сравнением Node
     * каждого из плечей.
     * @return true при полной зеркальности, false при отсутствии таковой
     */
    public boolean isMirrorTree(){
        List<Node> left = new ArrayList<>();
        List<Node> right = new ArrayList<>();

        inOrderLeft(root.leftChild, left::add);
        inOrderRight(root.rightChild, right::add);

        if (left.size() != right.size()) {
            return false;
        }

        for (int i = 0; i < left.size(); i++) {
            if (!mirrorEquals(left.get(i), right.get(i))){
                return false;
            }
        }
        return true;
    }

    /**
     * проверка на симметричность дерева.
     * Формирование двух List при обходе правого и левого плечей.
     * В отличие от "зеркальной" проверки - Node могут просто иметь потомка, неважно с какой стороны
     * @return если дерево симетрично - true, в противном случае - false
     */
    public boolean isSymmetricTree(){
        List<Node> left = new ArrayList<>();
        List<Node> right = new ArrayList<>();

        inOrderLeft(root.leftChild, left::add);
        inOrderRight(root.rightChild, right::add);

        if (left.size() != right.size()) {
            return false;
        }

        for (int i = 0; i < left.size(); i++) {
            if (isLeaf(left.get(i)) && !isLeaf(right.get(i))){
                return false;
            }
            if (isParent(left.get(i)) && !isParent(right.get(i))){
                return false;
            }
            if (isParentTwoChild(left.get(i)) && !isParentTwoChild(right.get(i))){
                return false;
            }
        }
        return true;
    }

    //Если поддеревья зеркальны
    private boolean mirrorEquals(Node n1, Node n2){
        if (isLeaf(n1) == isLeaf(n2)) return true;
        if (isParentTwoChild(n1) == isParentTwoChild(n2)) return true;
        if ((n1.leftChild != null && n2.rightChild != null) ||
                (n1.rightChild != null && n2.leftChild != null)) return true;
        return false;
    }

    //проверка узла - является ли он "листом" дерева
    private boolean isLeaf(Node node){
        if (node.leftChild == null && node.rightChild == null){
            return true;
        } else {
            return false;
        }
    }

    //проверка узла на обоих потомков
    private boolean isParentTwoChild(Node node){
        if (node.rightChild != null && node.leftChild != null){
            return true;
        } else {
            return false;
        }
    }

    //проверка узла на наличие потомка
    private boolean isParent(Node node){
        if (node.leftChild != null || node.rightChild != null){
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(K key) {
        Node current = this.root;
        Node parent = this.root;
        boolean isLeftChild = true;

        while (current.key != key) {
            parent = current;
            if (key.compareTo(current.key) < 0) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
        }

        if (isLeaf(current)) {
            if (current == this.root) {
                this.root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else {
            if (current.rightChild == null) {
                if (current == this.root){
                    this.root = current.leftChild;
                } else {
                    if (isLeftChild){
                        parent.leftChild = current.leftChild;
                    } else {
                        parent.rightChild = current.leftChild;
                    }
                }
            } else {
                if (current.leftChild == null){
                    if (current == this.root){
                        this.root = current.rightChild;
                    } else {
                        if (isLeftChild){
                            parent.leftChild = current.rightChild;
                        } else {
                            parent.rightChild = current.rightChild;
                        }
                    }
                } else {
                    //поиск приемника для удаляемого узла
                    Node successor = getSuccessor(current);
                    if (current == this.root){
                        this.root = successor;
                    } else {
                        if (isLeftChild){
                            parent.leftChild = successor;
                        } else {
                            parent.rightChild = successor;
                        }
                    }
                    successor.leftChild = current.leftChild;
                }
            }

        }
        return true;
    }

    private Node getSuccessor(Node delNode){
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild; //проход через правое плечо для поиска преемника
        while (current != null){
            successorParent = successor;
            successor = current;
            current = current.leftChild;    //проход к левому потомку - поиск наименьшего, среди больших
        }
        if (successor != delNode.rightChild){
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }

    public void show(){
        inOrder(System.out::println);
    }

}

