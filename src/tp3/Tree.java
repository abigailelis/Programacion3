package tp3;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

public class Tree {
    private TreeNode root;

    public Tree() {
        this.root = null;
    }

    public void add(int value) {
        if (this.root == null)
            this.root = new TreeNode(value, null, null);
        else
            add(value, this.root);
    }

    /*
     * h es la altura del árbol
     * O(h) porque en el peor de los casos el nuevo valor pasa a ser mi hoja más lejana.
     */
    private void add(int value, TreeNode actual) {
        if (value < actual.getKey()) {
            if (actual.getLeft() == null)
                actual.setLeft(new TreeNode(value, null, null));
            else
                add(value, actual.getLeft());
        } else if (value > actual.getKey())
            if (actual.getRight() == null)
                actual.setRight(new TreeNode(value, null, null));
            else
                add(value, actual.getRight());
    }

    /*
     * O(1) porque solo debe acceder al atributo root y responder con un booleano si es null o no.
     */
    public boolean isEmpty() {
        return this.root == null;
    }

    public boolean hasElement(int value) {
        if (this.isEmpty())
            return false;
        return hasElement(value, this.root);
    }

    /*
     * h es la altura del árbol
     * O(h) porque en el peor de los casos el valor a buscar es mi hoja más lejana.
     */
    private boolean hasElement(int value, TreeNode actual) {
        if (actual != null) {
            if (value < actual.getKey())
                return hasElement(value, actual.getLeft());
            else if (value > actual.getKey())
                return hasElement(value, actual.getRight());
            return true;
        }
        return false;
    }

    public int getRoot() {
        return this.root.getKey();
    }

    public int getHeight() {
        if (this.isEmpty())
            return 0;
        else
            return getHeight(this.root) - 1;
    }

    /*
     * n es la cantidad de nodos.
     * O(n) porque debo recorrer todo mi árbol hasta encontrar la hoja mas lejana para calcular la altura.
     */
    private int getHeight(TreeNode actual) {
        if (actual != null) {
            int hLeft = getHeight(actual.getLeft());
            int hRight = getHeight(actual.getRight());

            return 1 + Math.max(hLeft, hRight);
        } else
            return 0;
    }

    public List<Integer> getLongestBranch() {
        return getLongestBranch(this.root);
    }

    /*
     *n es la cantidad de nodos.
     * O(n) porque debo recorrer todo el árbol para saber cuál es la rama más larga.
     */
    private List<Integer> getLongestBranch(TreeNode actual) {
        if (actual != null) {
            List<Integer> leftList = getLongestBranch(actual.getLeft());
            List<Integer> rightList = getLongestBranch(actual.getRight());
            if (leftList.size() > rightList.size()) {
                leftList.add(actual.getKey());
                return leftList;
            } else {
                rightList.add(actual.getKey());
                return rightList;
            }
        } else
            return new ArrayList<>();
    }

    public List<Integer> getBorder() {
        return getBorder(this.root);
    }

    /*
     *n es la cantidad de nodos.
     * O(n) porque debo recorrer todo el árbol para saber cuál es la rama más larga.
     */
    private List<Integer> getBorder(TreeNode actual) {
        if (actual == null)
            return new ArrayList<>();
        else if (actual.isLeaf()) {
            List<Integer> list = new ArrayList<>();
            list.add(actual.getKey());
            return list;
        } else {
            List<Integer> frontLeft = getBorder(actual.getLeft());
            List<Integer> frontRight = getBorder(actual.getRight());
            frontLeft.addAll(frontRight);
            return frontLeft;
        }
    }

    public int getMaxElem() {
        return getMaxElem(this.root);
    }

    /*
     * h es la altura del árbol
     * O(h) porque en el peor de los casos el valor a buscar es mi hoja más lejana.
     */
    private int getMaxElem(TreeNode actual) {
        if (actual.getRight() != null)
            return getMaxElem(actual.getRight());
        else
            return actual.getKey();
    }

    /*
     * h es la altura del árbol
     * O(h) porque en el peor de los casos el valor a buscar es mi hoja más lejana.
     */
    private TreeNode getNMISD(TreeNode actual) {
        if (actual.getLeft() != null)
            return getNMISD(actual.getLeft());
        else
            return actual;
    }

    private boolean IamLess(TreeNode son, TreeNode father) {
        return son.getKey() < father.getKey();
    }

    public void deleteElement(int element) {
        deleteElement(root, root, element);
    }

    /*
     * h es la altura del árbol
     * O(h) porque en el peor de los casos el valor a borrar es mi hoja más lejana o porque el elemento 
     * que reemplazaría al borrado sería la hoja más lejana.
     */
    private void deleteElement(TreeNode actual, TreeNode father, int element) {
        if (element < actual.getKey())
            deleteElement(actual.getLeft(), actual, element);
        else if (element > actual.getKey())
            deleteElement(actual.getRight(), actual, element);
        else {
            setChildren(actual, father);
        }
    }

    private void setChildren(TreeNode father, TreeNode left, TreeNode right, boolean less) {
        if (less)
            father.setLeft(left);
        else
            father.setRight(right);
    }

    private void setChildren(TreeNode actual, TreeNode father) {
        boolean less = IamLess(actual, father);

        if (actual.isLeaf())
            setChildren(father, null, null, less);

        else if (actual.hasTwoChildren()) {
            TreeNode newSon = getNMISD(actual.getRight());
            actual.setKey(newSon.getKey());
            deleteElement(actual.getRight(), actual, newSon.getKey());
            
        } else {
            if (actual.getLeft() != null)
                setChildren(father, actual.getLeft(), actual.getLeft(), less);
            else
                setChildren(father, actual.getRight(), actual.getRight(), less);
        }
    }

    public List<Integer> getElemAtLevel(int level) {
        List<Integer> list = new ArrayList<>();

        if (!this.isEmpty())
            getElemAtLevel(level, list, 0, this.root);
        return list;
    }

    /*
     * n es la cantidad de nodos del árbol.
     * O(n) porque en el peor de los casos quiero obtener los elementos del nivel más lejano.
     */
    private void getElemAtLevel(int level, List<Integer> list, int cont, TreeNode actual) {
        if (cont < level) {
            getElemAtLevel(level, list, cont + 1, actual.getLeft());
            getElemAtLevel(level, list, cont + 1, actual.getRight());
        }
        if (level == cont && actual != null)
            list.add(actual.getKey());
    }

    public int getSumInternos(){
        int sum = 0;
        if(!this.isEmpty())
            sum = getSumInternos(this.root);
        return sum;
    }
    /**
     * n es la cantidad de nodos.
     * O(n) porque debo recorrer todo el árbol para calcular la suma. 
     */
    private int getSumInternos(TreeNode actual){
        int sum = 0;
        if(actual != null && !actual.isLeaf()){
            int sumL = getSumInternos(actual.getLeft());
            int sumR = getSumInternos(actual.getRight());
            sum = actual.getKey();
            sum = sum + sumL + sumR;
        }
        return sum;
    }

    public List<Integer> getLeavesGreaterThan(int k){
        List<Integer> list = new ArrayList<Integer>();
        if(!this.isEmpty())
            getLeavesGreaterThan(k, list, this.root);
        return list;
    }

    /**
     * n es la cantidad de nodos.
     * O(n) porque debo recorrer todo el árbol para obtener la lista de hojas mayores a k. 
     */
    private void getLeavesGreaterThan(int k, List<Integer> list, TreeNode actual){
        if(actual != null){
            if(actual.isLeaf() && actual.getKey() > k)
                list.add(actual.getKey());
            else{
                getLeavesGreaterThan(k, list, actual.getLeft());
                getLeavesGreaterThan(k, list, actual.getRight());
            }
        }
    }


    /** EJERCICIO N° 4
     * 
    public void completeTree(){
        completeTree(this.root);
    }

    private int completeTree(TreeNode actual){
        if(actual == null)
            return 0;
        if(actual.getKey() == null){
            int left = completeTree(actual.getLeft());
            int right = completeTree(actual.getRight());
            actual.setKey(right-left);
            return actual.getKey();
        }
        else
            return actual.getKey();
    }
    */

     EJERCICIO N° 5
     
    public List<String> searchWords(int n){
        List<String> list = new ArrayList<>();
        searchWords(this.root, list, n, "", 0);
        return list;
    }

    private void searchWords(TreeNode actual, List<String> list, int n, String word, int cont){
        if(actual != null){
            String let = actual.getKey();
            if(let == "a" || let == "e" || let == "i" || let == "o" || let == "u")
                cont = cont + 1;
            word = word + let;
            searchWords(actual.getLeft(), list, n, word, cont);
            searchWords(actual.getRight(), list, n, word, cont);
            if(actual.isLeaf() && cont == n)
                list.add(word);
        }
    }
    

    public void printInOrder() {
        printInOrder(this.root);
    }

    private void printInOrder(TreeNode node) {
        if (node == null)
            return;
        printInOrder(node.getLeft());
        System.out.print(node.getKey() + " ");
        printInOrder(node.getRight());
        //System.out.print(" - ");
    }

    public void printPreOrder() {
        printPreOrder(this.root);
    }

    private void printPreOrder(TreeNode node) {
        if (node == null)
            return;
        System.out.print(node.getKey() + " ");
        printInOrder(node.getLeft());
        printInOrder(node.getRight());
        System.out.print(" - ");
    }

    public void printPostOrder() {
        printPostOrder(this.root);
    }

    private void printPostOrder(TreeNode node) {
        if (node == null)
            return;
        printInOrder(node.getLeft());
        printInOrder(node.getRight());
        System.out.print(node.getKey() + " ");
        System.out.print(" - ");
    }
}
