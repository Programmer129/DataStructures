package union_find;

import grapth.Constants;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class UnionFind<T extends Number> {

    private List<T> tree;
    private List<Integer> sizeOfTree;

    public UnionFind(int size) {
        this.tree = new ArrayList<>(size);
        this.sizeOfTree = new ArrayList<>(size);
        for (int i = 0; i< size; i++){
            this.tree.add((T)(Number)Constants.INITIAL_VALUE);
            this.sizeOfTree.add(Constants.INITIAL_POS_VALUE);
        }
    }

    private T root(T a){
        T i = a;
        while(!this.tree.get(i.intValue()).equals(-1)) {
            i = this.tree.get(i.intValue());
        }
        return i;
    }

    public boolean isConnected(T a, T b){
        return root(a).equals(root(b));
    }

    public void connect(T a, T b){
        T i = root(a);
        T j = root(b);
        if(this.sizeOfTree.get(i.intValue()) < this.sizeOfTree.get(j.intValue())){
            this.tree.set(i.intValue(), j);
            this.sizeOfTree.set(j.intValue(),this.sizeOfTree.get(j.intValue())+this.sizeOfTree.get(i.intValue()));
        }
        else{
            this.tree.set(j.intValue(), i);
            this.sizeOfTree.set(i.intValue(),this.sizeOfTree.get(i.intValue())+this.sizeOfTree.get(j.intValue()));
        }

    }
}
