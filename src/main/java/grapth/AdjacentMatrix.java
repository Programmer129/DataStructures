package grapth;

import java.util.List;
import java.util.Set;

public class AdjacentMatrix<T> implements Graph<T> {

    @Override
    public boolean addEdge(T a, T b) {
        return false;
    }

    @Override
    public boolean removeVertex(T a) {
        return false;
    }

    @Override
    public boolean removeEdge(T a, T b) {
        return false;
    }

    @Override
    public Set<T> getChildren(T a) {
        return null;
    }

    @Override
    public void printGraph() { }

    @Override
    public List<Set<T>> getGraph() {
        return null;
    }

    @Override
    public void setInitialSize(int initialSize) {

    }
}
