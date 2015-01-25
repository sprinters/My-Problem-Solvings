package main.api.my.tree.segment.advanced;

import main.api.my.tree.segment.api.AdvancedSegmentTree;

/**
 * * @author sandeepandey
 */
public abstract class LazyBasedAdvancedSegmentTree<V,D> implements AdvancedSegmentTree<V,D> {

    protected V[] valueAt ;
    protected D[] deltaAt ;
    protected int size;

    public LazyBasedAdvancedSegmentTree(int size) {

        this.size = size;
        int nodeCount = Math.max(1,Integer.highestOneBit(size) << 2);
        valueAt = (V[]) new Object[nodeCount << 1];
        deltaAt = (D[]) new Object[nodeCount << 1];

    }

    public abstract V joinValue(V left,V right);
    public abstract V collectValue(V previousValue,D deltaToBeApplied,int length);
    public abstract V neutralValue();
    public abstract D neutralDelta();
    public abstract V defaultValue();
    public abstract V getValueAt(int at);
    public abstract boolean shouldDebug();
    public abstract D getDeltaAt(int at);
    public abstract D joinDelta(D left,D right);


    public void initTree() {
        init(0,0,size-1);

    }

    private void init(int root, int left, int right) {

        if(left == right) {

            if(shouldDebug()) {
                System.out.println("("+root+","+left+","+right+")");
            }

            valueAt[root] = getValueAt(left);
            if(shouldDebug()) {
                System.out.println("[Value At ["+root+"] is :"+ valueAt[root]);
            }
            deltaAt[root] = getDeltaAt(left);
            return;
        }

        int middle = (left + right) >> 1;
        init(2*root + 1,left,middle);
        init(2*root + 2,middle + 1,right);
        valueAt[root] = joinValue(valueAt[2*root + 1],valueAt[2*root + 2]);
        deltaAt[root] = joinDelta(deltaAt[2*root + 1],deltaAt[2*root + 2]);
    }

    public void update(int from,int to,D withDelta) {
        if(shouldDebug()) {
            System.out.println("[Going for update operation.]");
        }
        update(0,0,size-1,from,to,withDelta);
    }

    private void update(int root, int left, int right, int from, int to, D withDelta) {

        if(left > to || right < from) {
            if(shouldDebug()) {
                System.out.println("[Outside Boundry]:"+"("+left+","+right+")");
            }
            return;
        }

        if(left >= from && right <= to)  {

            this.deltaAt[root] = joinDelta(withDelta,this.deltaAt[root]);
            this.valueAt[root] = collectValue(this.valueAt[root],withDelta, right - left + 1);
            if(shouldDebug()) {
                System.out.println("[Range have been found.] "+"("+left+","+right+") for root :("+root+")");
                System.out.println("[Value at root is] "+this.valueAt[root]);
            }
            return;
        }

        this.deltaAt[2*root + 1] = joinDelta(this.deltaAt[2*root + 1],this.deltaAt[root]);
        this.deltaAt[2*root + 2] = joinDelta(this.deltaAt[2*root + 2],this.deltaAt[root]);
        int middle = (left + right) >> 1;
        this.valueAt[2*root + 1] =  collectValue(this.valueAt[2*root + 1],this.deltaAt[root],middle-left+1);
        this.valueAt[2*root + 2] =  collectValue(this.valueAt[2*root + 2],this.deltaAt[root],right - middle);

        this.deltaAt[root] = neutralDelta();

        if(shouldDebug()) {
            System.out.println("[Going to update range for ] "+"("+left+","+middle+")");
        }
        update(2*root + 1,left,middle,from,to,withDelta);

        if(shouldDebug()) {
            System.out.println("[Going to update range for ] "+"("+ (middle + 1)+","+right+")");
        }
        update(2*root + 2,middle + 1,right ,from,to,withDelta);

        this.valueAt[root] = joinValue(this.valueAt[2*root + 1],this.valueAt[2*root + 2]);
        if(shouldDebug()) {
            System.out.println("[Value Joined At " + root+" is] "+this.valueAt[root]);
        }
    }


    public V query(int from , int to) {
        if(shouldDebug()) {
            System.out.println("[Going for query operation] "+"("+from+","+to+")");
        }
        return query(0,0,size-1,from,to);
    }

    private V query(int root, int left, int right, int from, int to) {

        if(shouldDebug()) {
            System.out.println("("+root+","+left+","+right+","+from+","+to);
        }


        if(left > to || right < from) {
            return neutralValue();
        }

        if(left >= from && right <= to) {
            if(shouldDebug()) {
                System.out.println("[Range have been found.]"+"("+left+","+right+")");
                System.out.println("Queried Result is::"+this.valueAt[root]);
            }
            return this.valueAt[root];
        }

        this.deltaAt[2*root + 1] = joinDelta(this.deltaAt[2*root + 1],this.deltaAt[root]);
        this.deltaAt[2*root + 2] = joinDelta(this.deltaAt[2*root + 2],this.deltaAt[root]);

        int middle = (left + right) >> 1;

        this.valueAt[2*root + 1] = collectValue(this.valueAt[2*root +1],this.deltaAt[root],middle-left+1);
        this.valueAt[2*root + 2] = collectValue(this.valueAt[2*root + 2],this.deltaAt[root],right - middle);
        this.deltaAt[root] = neutralDelta();

        V leftValue = query(2*root + 1,left,middle,from,to);
        V rightValue = query(2*root + 2,middle + 1,right,from,to);

        if(shouldDebug()) {

            System.out.println("Left Value is :"+leftValue);
            System.out.println("Right Value is:"+rightValue);
        }
        return joinValue(leftValue,rightValue);
    }

    public V getValueAtRoot() {
        return this.valueAt[0];
    }

}
