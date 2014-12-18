package main.geeksforgeek.linklist.singlelinklist.reverse;

import main.geeksforgeek.linklist.singlelinklist.SingleLinkList;

public abstract  class ReverseHelper {

    private Reverse reverseSolver   =   null;

    public void setRecursiveSolver(Reverse solver) {
        this.reverseSolver  =   solver;


    }


    public void setIterativeSolver(Reverse solver) {
        this.reverseSolver  =   solver;
    }

    public Reverse getAbstractSolver() {
        return this.reverseSolver;
    }

    public SingleLinkList performOperation(SingleLinkList head) {
        return getAbstractSolver().reverse(head) ;

    }
}
