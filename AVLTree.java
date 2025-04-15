import java.util.*;
import java.io.*;

class AVLNode{
    int key;
    AVLNode left,right;
    int height;
    AVLNode(int key)
    {
        this.key=key;
        left=right=null;
        height=0;
    }
}

public class AVLTree
{
    public static int height(AVLNode node)
    {
        return node==null?-1:node.height;
    }
    public static AVLNode rwlc(AVLNode k2)
    {
        AVLNode k1=k2.left;
        k2.left=k1.right;
        k1.right=k2;
        k2.height=Math.max(height(k2.left),height(k2.right))+1;
        k1.height=Math.max(height(k1.left),k2.height)+1;
        return k1;
    }
    public static AVLNode rwrc(AVLNode k1)
    {
        AVLNode k2=k1.right;
        k1.right=k2.left;
        k2.left=k1;
        k1.height=Math.max(height(k1.left),height(k1.right))+1;
        k2.height=Math.max(k1.height,height(k2.right))+1;
        return k2;
    }
    public static AVLNode drwlc(AVLNode k3)
    {
        k3.left=rwrc(k3.left);
        return rwlc(k3);
    }
    public static AVLNode drwrc(AVLNode k1)
    {
        k1.right=rwlc(k1.right);
        return rwrc(k1);
    }
    public static AVLNode insert(int key,AVLNode node)
    {
        if(node==null) return new AVLNode(key);
        else if(key<node.key)
        {
            node.left=insert(key,node.left);
            if(height(node.left)-height(node.right)==2)
            {
                if(key<node.left.key)
                {
                    node=rwlc(node);
                }
                else{
                    node=drwlc(node);
                }
            }
        }
        else if(key>node.key)
        {
            node.right=insert(key,node.right);
            if(height(node.right)-height(node.left)==2)
            {
                if(key>node.right.key)
                {
                    node=rwrc(node);
                }
                else{
                    node=drwrc(node);
                }
            }
        }
        node.height=Math.max(height(node.left),height(node.right))+1;
        return node;
    }
    public static AVLNode findMin(AVLNode node)
    {
        if(node==null || node.left==null)
        {
            return node;
        }
        return findMin(node.left);
    }
    public static AVLNode delete(int key,AVLNode node)
    {
        if(node==null) return null;
        if(key<node.key)
        {
            node.left=delete(key,node.left);
        }
        else if(key>node.key)
        {
            node.right=delete(key,node.right);
        }
        else
        {
            if(node.left!=null && node.right!=null)
            {
                AVLNode minNode=findMin(node.right);
                node.key=minNode.key;
                node.right=delete(minNode.key,node.right);
            }
            else{
                node=node.left!=null?node.left:node.right;
            }
        }
        if(node!=null)
        {
            node.height=Math.max(height(node.left),height(node.right))+1;
            if(height(node.left)-height(node.right)==2)
            {
                if(height(node.left.left)>=height(node.left.right))
                {
                    node=rwlc(node);
                }
                else{
                    node=drwlc(node);
                }
            }
            if(height(node.right)-height(node.left)==2)
            {
                if(height(node.right.right)>=height(node.right.left))
                {
                    node=rwrc(node);
                }
                else{
                    node=drwrc(node);
                }
            }
        }
        return node;
    }
    public static void inOrder(AVLNode node,BufferedWriter writer) throws IOException{
        if(node!=null)
        {
            inOrder(node.left,writer);
            writer.write(node.key+" ");
            inOrder(node.right,writer);
        }
    }
    public static void main(String[] args)
    {
        AVLNode root=null;
        String inputFileName="input.txt";
        String outputFileName="output.txt";
        try{
            File file=new File(inputFileName);
            Scanner sc=new Scanner(file);
            System.out.println("Reading data from File!...");
            while(sc.hasNextInt())
            {
                int num=sc.nextInt();
                root=insert(num,root);
            }
            System.out.println("AVLTree constructed from given data...");
            sc.close();
            root=delete(13,root);
            System.out.println("Deleted 13 from AVLTree...");
            BufferedWriter writer=new BufferedWriter(new FileWriter(outputFileName));
            inOrder(root,writer);
            writer.close();
            System.out.println("InOrder Traversal is written into File- "+outputFileName);
        }
        catch(Exception e)
        {
            System.out.println("Error: "+e.getMessage());
        }
    }
}

/*  OUTPUT 
 * 
 *
  Reading data from File!...
AVLTree constructed from given data...
Deleted 13 from AVLTree...
InOrder Traversal is written into File- output.txt

 */


 /*
 INPUT File
  * 
  3 2 1 4 5 6 7 16 15 14 13 12 11 10 8 9
  */


  /*
   * 
   * OUTPUT File
   * 
   * 1 2 3 4 5 6 7 8 9 10 11 12 14 15 16 
   * 
   */