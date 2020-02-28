/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpeg;

/**
 *
 * @author DELL
 */
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Comparator;

// node class is the basic structure 
// of each node present in the Huffman - tree. 
class HuffmanNode {

    int data;
    String c;

    HuffmanNode left;
    HuffmanNode right;
}

// comparator class helps to compare the node 
// on the basis of one of its attribute. 
// Here we will be compared 
// on the basis of data values of the nodes. 
class MyComparator implements Comparator<HuffmanNode> {

    public int compare(HuffmanNode x , HuffmanNode y) {

        return x.data - y.data;
    }
}

public class Huffman {
    ArrayList<String> tags = new ArrayList<String>();
    ArrayList<Integer> probs = new ArrayList<Integer>();
    
    ArrayList<String> codes = new ArrayList<String>();
    ArrayList<String> modifiedTags = new ArrayList<String>();
    
    PriorityQueue<HuffmanNode> q = null;

    public Huffman(ArrayList<String> t , ArrayList<Integer> p) {
        tags = t;
        probs = p;
        q = new PriorityQueue<HuffmanNode>(tags.size() , new MyComparator());
    }

    public ArrayList<String> getCodes(){
        return codes;
    }
    
    public ArrayList<String> getTags(){
        return modifiedTags;
    }
    
    public void printCode(HuffmanNode root , String s) { 
        if (root.left == null && root.right == null) {
            codes.add(s);
            modifiedTags.add(root.c);
            System.out.println(root.c + ":" + s);

            return;
        }

        
        printCode(root.right , s + "0");
        printCode(root.left , s + "1");
    }

    public void findCodes() {
        for (int i = 0; i < tags.size(); i++) {
            HuffmanNode hn = new HuffmanNode();

            hn.c = tags.get(i);
            hn.data = probs.get(i);

            hn.left = null;
            hn.right = null;
            
            q.add(hn);
        }
        
        HuffmanNode root = null;

        while (q.size() > 1) {

            // first min extract. 
            HuffmanNode x = q.peek();
            q.poll();

            // second min extarct. 
            HuffmanNode y = q.peek();
            q.poll();

            // new node f which is equal 
            HuffmanNode f = new HuffmanNode();

            // to the sum of the frequency of the two nodes 
            // assigning values to the f node. 
            f.data = x.data + y.data;
            f.c = "-";

            // first extracted node as left child. 
            f.left = x;

            // second extracted node as the right child. 
            f.right = y;

            // marking the f node as the root node. 
            root = f;

            // add this node to the priority-queue. 
            q.add(f);
        }

        // print the codes by traversing the tree 
        printCode(root , "");
    }
} 
