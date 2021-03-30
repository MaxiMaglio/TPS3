package Arboles;

import java.util.ArrayList;

/**
 * @author Maximiliano Maglio, Guido Molaro and Juan Manuel Pérez Menéndez on 3/30/2021.
 * @project TPS3
 */
public class Tester {

    public static void main(String[] args) {
        Book l1 = new Book(12, "Hamlet", 230);
        Book l2 = new Book(25, "Muerte en las nubes", 321);
        Book l3 = new Book(22, "El precio de la intriga", 530);
        Book l4 = new Book(75, "Romeo y Julieta", 199);
        Book l5 = new Book(56, "La isla del tesoro", 452);
        Book l6 = new Book(64, "El anillo", 520);
        Book l7 = new Book(44, "El doctor Zhivago", 930);

        TreeApi<Book> a = new TreeApi<Book>();
        BinaryTree <Book>    t1 = new BinaryTree<Book>(l7);
        BinaryTree <Book>    t2 = new BinaryTree<Book>(l5);
        BinaryTree <Book>    t3 = new BinaryTree(l6,t1,new BinaryTree<Book>());
        BinaryTree <Book>    t4 = new BinaryTree<Book>( l4, t3,t2);
        BinaryTree <Book>    t5 = new BinaryTree<Book>(l2,t4,new BinaryTree<Book>());
        BinaryTree <Book>    t6 = new BinaryTree<Book>(l3,new BinaryTree<Book>(),t2);
        BinaryTree <Book>    t7 = new BinaryTree<Book>(l1,t5,t6);


        System.out.println(a.size(t7));
        System.out.println("__________");
        a.inorden(t7)	;
        System.out.println("__________");
        System.out.println(a.ocurrencias(t7, l5));
        System.out.println(a.ocurrencias(t7, new Book(100, "zzz", 200)));
        ArrayList<Book> books = new ArrayList<Book>();
        a.inorden(t7, books);
        for (int i= 0; i < books.size();i++)
            System.out.println(books.get(i).getCode()+ "  "+ books.get(i).getTitle());

        System.out.println("Number of leaves: " + a.leafCount(t7));

        System.out.println("NUmber of elements by level: " + a.elementosPorNivel(t7, 3));
    }

}

