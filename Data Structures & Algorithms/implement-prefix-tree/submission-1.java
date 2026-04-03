public class Node{
    Node[] links= new Node[26];
    boolean isend=false;
}
class PrefixTree {
    private Node root;



    public PrefixTree() {
         root= new Node();
    }

    public void insert(String word) {
       Node node= root;
       for(int i=0;i<word.length();i++)
       {
        char c = word.charAt(i); 
        int j=c-'a';
        if(node.links[j]==null)
        {
            node.links[j]=new Node();
        }
        node=node.links[j];
       }
       node.isend=true;
    }

    public boolean search(String word) {
       Node node= root;
       for(int i=0;i<word.length();i++)
       {
        char c = word.charAt(i); 
        int j=c-'a';
        if( node.links[j]==null)
        {
            return false;
        }
         node= node.links[j];
       }
       return  node.isend;
    }

    public boolean startsWith(String prefix) {
      Node node= root;
       for(int i=0;i<prefix.length();i++)
       {
        char c = prefix.charAt(i); 
        int j=c-'a';
        if(node.links[j]==null)
        {
            return false;
        }
        node=node.links[j];
       }
       return true;
    }
}
