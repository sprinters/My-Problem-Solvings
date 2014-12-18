package main.api.my.graph.edge;

/**
 * * @author sandeepandey
 */
public interface MyEdge {

    public int getSource();
    public int getDestination();
    public int getDistance();
    public long getCost();
    public MyEdge getReverseEdge();

}
