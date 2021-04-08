package Arboles;

/**
 * @author Maximiliano Maglio, Guido Molaro and Juan Manuel Pérez Menéndez on 4/6/2021.
 * @project TPS3
 */

public class Ejercicio15 {
    public static void main(String[] args) {
        TreeApi ita = new TreeApi();
        BinaryTree<Character> t = new BinaryTree<>('T');
        BinaryTree<Character> w = new BinaryTree<>('W');
        BinaryTree<Character> x = new BinaryTree<>('X');
        BinaryTree<Character> v = new BinaryTree<>('V');
        BinaryTree<Character> sw = new BinaryTree<Character>('S',w,new BinaryTree<>());
        BinaryTree<Character> ux = new BinaryTree<Character>('U',x,new BinaryTree<>());
        BinaryTree<Character> qst = new BinaryTree<>('Q',sw,t);
        BinaryTree<Character> ruv = new BinaryTree<>('R',ux,v);
        BinaryTree<Character> tree = new BinaryTree<>('P',qst,ruv); //Respuesta 15a)
        ita.inorden(tree);


    }
}
