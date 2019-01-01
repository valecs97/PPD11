import static org.jocl.CL.*;

import org.jocl.*;

import java.math.BigInteger;
import java.util.Random;

/**
 * A small JOCL sample.
 */
public class Main
{
    public static void main(String args[])
    {
        poli(100,100);

        //OpenClKaratsuba openClKaratsuba = new OpenClKaratsuba();
        //openClKaratsuba.execute(BigInteger.TEN,new int[]{1,2},new int[]{1,2},3);
        //openClKaratsuba.releaseProgram();
    }

    private static void poli(int n,int m){
        long start, stop;
        int[] a = fill(n);
        int[] b = fill(m);
        start = System.currentTimeMillis();
        int[] res = PoliMult.mult(a,b,n,m);
        stop = System.currentTimeMillis();
        System.out.println((stop - start)/10 + " ms");
        for (int i=0;i<a.length;i++)
            System.out.print(a[i] + " ");
        System.out.println();
        for (int i=0;i<b.length;i++)
            System.out.print(b[i] + " ");
        System.out.println();
        for (int i=0;i<res.length;i++)
            System.out.print(res[i] + " ");
    }

    private static int[] fill(int n){
        int[] a = new int[n];
        Random random = new Random();
        for (int i=0;i<n;i++)
            a[i] = random.nextInt(10);
        return a;
    }
}