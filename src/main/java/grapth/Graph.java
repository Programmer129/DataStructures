package grapth;

import java.util.Set;

public interface Graph<T> {

    boolean addEdge(T a, T b);

    boolean removeEdge(T a, T b);

    Set<T> getChildren(T a);

}
