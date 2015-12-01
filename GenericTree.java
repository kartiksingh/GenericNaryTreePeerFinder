import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * Created by President on 12/1/2015.
 */



public class GenericTree<T> {

    private GenericTreeNode<T> root;

    public static final GenericTreeNode<String> NO_PEER = new GenericTreeNode<>("NO_PEER");

    public GenericTree() {
        super();
    }

    public GenericTreeNode<T> getRoot() {
        return this.root;
    }

    public void setRoot(GenericTreeNode<T> root) {
        root.setLevel(0);
        this.root = root;
    }


    //Find the peer next to current node
    public ArrayList<GenericTreeNode> levelOrderTraversal() {
        Queue q = new LinkedList<GenericTreeNode>();
        ArrayList<GenericTreeNode> result = new ArrayList<>();

        if (root == null) {
            return null;
        }

        q.add(root);
        result.add(root);

        while (!q.isEmpty()) {
            GenericTreeNode n = (GenericTreeNode) q.remove();

//            System.out.println(" " + n.data + " level: " + n.getLevel());

            //add all the children in the queue
            List<GenericTreeNode> childrenOfN = n.getChildren();
            if (childrenOfN != null && childrenOfN.size() > 0) {
                q.addAll(childrenOfN); //-- break into an one by one addition
                result.addAll(childrenOfN);
            }
        }

        return result;
    }

    /*
    * peer is defined as right sibling
    * the one where no no right sibling exists,
    * */
    public GenericTreeNode findPeerOf(GenericTreeNode<T> currentNode) {
        List<GenericTreeNode> list = levelOrderTraversal();

        for (int i = 0; i < list.size() - 1; i ++) {
            GenericTreeNode gtn = list.get(i);
            if (gtn.equals(currentNode)) {
                GenericTreeNode peerSuspect = list.get(i + 1);
                return  (peerSuspect.getLevel() == currentNode.getLevel()) ? peerSuspect : NO_PEER;

            }
        }

        return NO_PEER;
    }

    public List<GenericTreeNode> findPeerOf(List<GenericTreeNode> nodes) {
        List<GenericTreeNode> result = new ArrayList<>();
        List<GenericTreeNode> list = levelOrderTraversal();

        for (GenericTreeNode currentNode : nodes) {
            GenericTreeNode peer = NO_PEER;
            for (int i = 0; i < list.size() - 1; i ++) {
                GenericTreeNode gtn = list.get(i);
                if (gtn.equals(currentNode)) {
                    GenericTreeNode peerSuspect = list.get(i + 1);
                    peer = peerSuspect.getLevel() == currentNode.getLevel() ? peerSuspect : NO_PEER;
                }

            }

            System.out.println(currentNode.getData() +" -> " + peer.getData());
            result.add(peer);
        }

        return result;
    }
}

