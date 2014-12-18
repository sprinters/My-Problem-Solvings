package main.practice.dp.lis;

public abstract class LISHelper {

    private LisSolver lisSolver  =   null;

    public void setSuitableLisSolver(LisSolver lisSolver) {

        this.lisSolver  =   lisSolver;
    }

    public LisSolver getLisSolver() {
        return lisSolver;
    }

    public int performOperation(int[] array) {
        return getLisSolver().solveLIS(array);
    }

    public abstract void abstractLisSolver();
}
