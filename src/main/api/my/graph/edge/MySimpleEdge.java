package main.api.my.graph.edge;

/**
 * * @author sandeepandey
 */
public class MySimpleEdge implements MyEdge {

    protected int source;
    protected int destination;
    protected int distance;
    protected long cost;

    public MySimpleEdge(int source,int destination,int distance,int cost) {
        this.source =   source;
        this.destination    =   destination;
        this.distance         =   distance;
        this.cost       =   cost;
    }

    @Override
    public int getSource() {
        return source;
    }

    @Override
    public int getDestination() {
        return destination;
    }

    @Override
    public int getDistance() {
        return distance;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public long getCost() {
        return cost;  //To change body of implemented methods use File | Settings | File Templates.
    }


    @Override
    public MyEdge getReverseEdge() {
        throw new UnsupportedOperationException();
    }
}
