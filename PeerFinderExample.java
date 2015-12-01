import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by President on 12/1/2015.
 */
public class PeerFinderExample {

    public static void main(String [] args) {

        ///// ------------Creating the Example Tree ------------/////
        GenericTree<String> tree = new GenericTree<>();
        GenericTreeNode<String> a = new GenericTreeNode<String>("A");
        tree.setRoot(a);

        GenericTreeNode<String> b = new GenericTreeNode<String>("B");
        GenericTreeNode<String> h = new GenericTreeNode<String>("H");
        GenericTreeNode<String> l = new GenericTreeNode<String>("L");

        a.addChild(b);
        a.addChild(h);
        a.addChild(l);

        GenericTreeNode<String> c = new GenericTreeNode<String>("C");
        GenericTreeNode<String> f = new GenericTreeNode<String>("F");
        GenericTreeNode<String> i = new GenericTreeNode<String>("I");
        GenericTreeNode<String> j = new GenericTreeNode<String>("J");
        GenericTreeNode<String> m = new GenericTreeNode<String>("M");
        GenericTreeNode<String> d = new GenericTreeNode<String>("D");
        GenericTreeNode<String> g = new GenericTreeNode<String>("G");
        GenericTreeNode<String> k = new GenericTreeNode<String>("K");
        GenericTreeNode<String> n = new GenericTreeNode<String>("N");
        GenericTreeNode<String> e = new GenericTreeNode<String>("E");
        GenericTreeNode<String> o = new GenericTreeNode<String>("O");

        b.addChild(c);
        b.addChild(f);

        c.addChild(d);
        d.addChild(e);

        f.addChild(g);

        h.addChild(i);
        h.addChild(j);

        j.addChild(k);

        l.addChild(m);
        m.addChild(n);
        n.addChild(o);

        //------------------------------------------------------------//


        List<GenericTreeNode> input = new ArrayList<>();
        input.addAll(Arrays.asList(c,d,f,j,k,e));

        tree.findPeerOf(input);


        /* Find peers of all the nodes

        System.out.println("\n\n\n\n\nPeers of all Nodes");
        Long startTime = System.currentTimeMillis();
        List<GenericTreeNode> allNodes = new ArrayList<>();
        allNodes.addAll(Arrays.asList(a,b,c,d,e,f,g,h,i,j,k,l,m,n));
        tree.findPeerOf(allNodes);
        Long endTime = System.currentTimeMillis();

        System.out.println(String.format("Total Time = " + (endTime - startTime)
                                         + "\nAvg Time (in millis) = : %.2f", (endTime - startTime) * 1.0/allNodes.size()));

        */

    }


}
