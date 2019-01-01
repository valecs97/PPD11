public class PoliMult {

    public static int[] mult(int A[], int B[], int m, int n) {
        int[] prod = new int[m + n - 1];
        OpenClMulti openClMulti = new OpenClMulti();
        for (int i = 0; i < m + n - 1; i++)
            prod[i] = 0;
        for (int i = 0; i < m; i++) {
            openClMulti.execute(A,B,prod,i);
        }
        openClMulti.releaseProgram();
        return prod;
    }
}
