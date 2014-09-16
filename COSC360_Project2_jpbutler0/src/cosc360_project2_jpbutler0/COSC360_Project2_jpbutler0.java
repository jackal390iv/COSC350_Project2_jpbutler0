package cosc360_project2_jpbutler0;

import java.util.Random;

/**
 *
 * @author Reaper
 */
public class COSC360_Project2_jpbutler0 {

    public static void main(String[] args) {

        AVL_Tree avlTree = new AVL_Tree();
        Splay_Tree splayTree = new Splay_Tree();
        long startTime;
        long endTime;
        Random generator = new Random(20120404);

        avlTree.insert(1);
        avlTree.insert(5);
        avlTree.insert(4);
        avlTree.insert(13);
        avlTree.insert(25);

        avlTree.inOrderTraversal();

        /*
         System.out.println("Now inseting 5000 integers into a AVL Tree... ");		
         startTime=System.currentTimeMillis();
         for (int i = 0; i < 5000; i++) {
         avlTree.insert(generator.nextInt()% 10000);
         }
         endTime=System.currentTimeMillis();		
         System.out.println("Inseting completed within: "+(endTime-startTime) +" milliseconds");
		
         for(int j=2500;j<=2505;j++){
         avlTree.insert(j);
         }				
         for(int j=7500;j<=7505;j++){
         avlTree.insert(j);
         }		
		
         avlTree.remove(2501);
         avlTree.remove(2503);
         avlTree.remove(2505);
         avlTree.remove(2501);
         avlTree.remove(2503);
         avlTree.remove(2505);
		
         avlTree.print_Children(2502);
         avlTree.print_Children(7502);
		
         //------------------------------------------------------------------------------------------------------------------
         /*
         System.out.println("Now inseting 5000 integers into a Splay Tree... ");		
         startTime=System.currentTimeMillis();
         for (int i = 0; i < 5000; i++) {
         splayTree.insert(generator.nextInt()% 10000);
         }
         endTime=System.currentTimeMillis();		
         System.out.println("Inseting completed within: "+(endTime-startTime) +" milliseconds");
		
         for(int j=2500;j<=2505;j++){
         splayTree.insert(j);
         }				
         for(int j=7500;j<=7505;j++){
         splayTree.insert(j);
         }	
		
         splayTree.remove(2501);
         splayTree.remove(2503);
         splayTree.remove(2505);
         splayTree.remove(2501);
         splayTree.remove(2503);
         splayTree.remove(2505);
		
         splayTree.print_Children(2502);
         splayTree.print_Children(7502);
		
		
         */
    }
}
