/**
 * Created by President on 12/1/2015.
 */
import java.util.ArrayList;
import java.util.List;

public class GenericTreeNode<T> {

    public T data;
    public List<GenericTreeNode<T>> children;
    private int level;

    public GenericTreeNode() {
        super();
        children = new ArrayList<>();
    }

    public GenericTreeNode(T data) {
        this();
        setData(data);
    }

    public List<GenericTreeNode<T>> getChildren() {
        return this.children;
    }

    public int getNumberOfChildren() {
        return getChildren().size();
    }

    public boolean hasChildren() {
        return (getNumberOfChildren() > 0);
    }

    public void setChildren(List<GenericTreeNode<T>> children) {
        for (GenericTreeNode gnt : children) {
            gnt.setLevel(getLevel() + 1);
        }

        this.children = children;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void addChild(GenericTreeNode<T> child) {
        child.setLevel(getLevel() + 1);
        children.add(child);
    }

    public void addChildAt(int index, GenericTreeNode<T> child) throws IndexOutOfBoundsException {
        child.setLevel(getLevel() + 1);
        children.add(index, child);
    }

    public void removeChildren() {
        this.children = new ArrayList<GenericTreeNode<T>>();
    }

    public void removeChildAt(int index) throws IndexOutOfBoundsException {
        children.remove(index);
    }

    public GenericTreeNode<T> getChildAt(int index) throws IndexOutOfBoundsException {
        return children.get(index);
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String toString() {
        return getData().toString();
    }

    public boolean equals(GenericTreeNode<T> node) {
        return node.getData().equals(getData());
    }

    public int hashCode() {
        return getData().hashCode();
    }

}
