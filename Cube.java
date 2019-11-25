import java.util.*;
import java.io.*;

public class Cube
{

    public static void printAll(List<String[][]> thing)
    {
        String[] names = {"Back", "Left", "Up", "Right", "Down", "Front"};
        for(int i =0; i<thing.size(); i++)
        {
            System.out.println(names[i]);
            String[][] direction = thing.get(i);
            for (int r = 0; r < direction.length; r++)
            {
                for (int c = 0; c < direction.length; c++)
                {
                    System.out.print(direction[r][c] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static List<String[][]> Y(int layer, List<String[][]> cube, boolean prime)
    {
        String[][] B = cube.get(0);
        String[][] L = cube.get(1);
        String[][] U = cube.get(2);
        String[][] R = cube.get(3);
        String[][] D = cube.get(4);
        String[][] F = cube.get(5);

        if(prime)
        {
            if(layer==2)
            {
                for (int i = 0; i < 3; i++)
                {
                    String[] current = {F[i][layer], U[i][layer], B[2 - i][2 - layer], D[i][layer]};
                    U[i][layer] = current[2];
                    B[2 - i][2 - layer] = current[3];
                    D[i][layer] = current[0];
                    F[i][layer] = current[1];
                }
            }
            else
            {
                for (int i = 0; i < 3; i++)
                {
                    String[] current = {F[i][layer], U[i][layer], B[2 - i][2 - layer], D[i][layer]};
                    U[i][layer] = current[0];
                    B[2 - i][2 - layer] = current[1];
                    D[i][layer] = current[2];
                    F[i][layer] = current[3];
                }
            }

            if (layer == 2)
            {
                String[][] temp = new String[3][3];
                for (int r = 0; r < R.length; r++)
                {
                    for (int c = 0; c < R[0].length; c++)
                    {
                        temp[r][c] = R[r][c];
                    }
                }
                String[] row1 = temp[0];
                String[] row2 = temp[1];
                String[] row3 = temp[2];
                for (int r = 0; r < R.length; r++)
                {
                    R[r][0] = row1[2-r];
                    R[r][1] = row2[2-r];
                    R[r][2] = row3[2-r];
                }
            }
            else if (layer == 0)
            {
                String[][] temp = new String[3][3];
                for (int r = 0; r < L.length; r++)
                {
                    for (int c = 0; c < L[0].length; c++)
                    {
                        temp[r][c] = L[r][c];
                    }
                }
                String[] row1 = temp[0];
                String[] row2 = temp[1];
                String[] row3 = temp[2];
                for (int r = 0; r < L.length; r++)
                {
                    L[r][0] = row1[2-r];
                    L[r][1] = row2[2-r];
                    L[r][2] = row3[2-r];
                }
            }
        }
        else
        {
            if(layer==2)
            {
                for (int i = 0; i < 3; i++)
                {
                    String[] current = {F[i][layer], U[i][layer], B[2 - i][2 - layer], D[i][layer]};
                    U[i][layer] = current[0];
                    B[2 - i][2 - layer] = current[1];
                    D[i][layer] = current[2];
                    F[i][layer] = current[3];
                }
            }

            else
            {
                for (int i = 0; i < 3; i++)
                {
                    String[] current = {F[i][layer], U[i][layer], B[2 - i][2 - layer], D[i][layer]};
                    U[i][layer] = current[2];
                    B[2 - i][2 - layer] = current[3];
                    D[i][layer] = current[0];
                    F[i][layer] = current[1];
                }
            }
            if (layer == 2)
            {
                String[][] temp = new String[3][3];
                for (int r = 0; r < R.length; r++)
                {
                    for (int c = 0; c < R[0].length; c++)
                    {
                        temp[r][c] = R[r][c];
                    }
                }
                String[] row1 = temp[0];
                String[] row2 = temp[1];
                String[] row3 = temp[2];
                for (int r = 0; r < R.length; r++)
                {
                    R[r][0] = row3[r];
                    R[r][1] = row2[r];
                    R[r][2] = row1[r];
                }
            }
            else if (layer == 0)
            {
                String[][] temp = new String[3][3];
                for (int r = 0; r < L.length; r++)
                {
                    for (int c = 0; c < L[0].length; c++)
                    {
                        temp[r][c] = L[r][c];
                    }
                }
                String[] row1 = temp[0];
                String[] row2 = temp[1];
                String[] row3 = temp[2];
                for (int r = 0; r < R.length; r++)
                {
                    L[r][0] = row3[r];
                    L[r][1] = row2[r];
                    L[r][2] = row1[r];
                }
            }
        }
        return cube;
    }

    public static List<String[][]> X(int layer, List<String[][]> cube, boolean prime)
    {
        String[][] B = cube.get(0);
        String[][] L = cube.get(1);
        String[][] U = cube.get(2);
        String[][] R = cube.get(3);
        String[][] D = cube.get(4);
        String[][] F = cube.get(5);

        if(prime)
        {
            if(layer==0)
            {
                for (int i = 0; i < 3; i++)
                {
                    String[] current = {F[layer][i], R[layer][i], B[layer][i], L[layer][i]};
                    F[layer][i] = current[3];
                    R[layer][i] = current[0];
                    B[layer][i] = current[1];
                    L[layer][i] = current[2];
                }
            }
            else
            {
                for (int i = 0; i < 3; i++)
                {
                    String[] current = {F[layer][i], R[layer][i], B[layer][i], L[layer][i]};
                    F[layer][i] = current[1];
                    R[layer][i] = current[2];
                    B[layer][i] = current[3];
                    L[layer][i] = current[0];
                }
            }
            if (layer == 0)
            {
                String[][] temp = new String[3][3];
                for(int r=0; r<U.length; r++)
                {
                    for(int c=0; c<U[0].length; c++)
                    {
                        temp[r][c] = U[r][c];
                    }
                }
                String[] row1 = temp[0];
                String[] row2 = temp[1];
                String[] row3 = temp[2];
                for (int r = 0; r < U.length; r++)
                {
                    U[r][0] = row1[2-r];
                    U[r][1] = row2[2-r];
                    U[r][2] = row3[2-r];
                }
            }
            else if (layer == 2)
            {
                String[][] temp = new String[3][3];
                for(int r=0; r<D.length; r++)
                {
                    for(int c=0; c<D[0].length; c++)
                    {
                        temp[r][c] = D[r][c];
                    }
                }
                String[] row1 = temp[0];
                String[] row2 = temp[1];
                String[] row3 = temp[2];
                for (int r = 0; r < D.length; r++)
                {
                    D[r][0] = row1[2-r];
                    D[r][1] = row2[2-r];
                    D[r][2] = row3[2-r];
                }
            }
        }
        else
        {
            if(layer==0)
            {
                for (int i = 0; i < 3; i++)
                {
                    String[] current = {F[layer][i], R[layer][i], B[layer][i], L[layer][i]};
                    F[layer][i] = current[1];
                    R[layer][i] = current[2];
                    B[layer][i] = current[3];
                    L[layer][i] = current[0];
                }
            }
            else
            {
                for (int i = 0; i < 3; i++)
                {
                    String[] current = {F[layer][i], R[layer][i], B[layer][i], L[layer][i]};
                    F[layer][i] = current[3];
                    R[layer][i] = current[0];
                    B[layer][i] = current[1];
                    L[layer][i] = current[2];
                }
            }
            if (layer == 0)
            {
                String[][] temp = new String[3][3];
                for (int r = 0; r < U.length; r++)
                {
                    for (int c = 0; c < U[0].length; c++)
                    {
                        temp[r][c] = U[r][c];
                    }
                }
                String[] row1 = temp[0];
                String[] row2 = temp[1];
                String[] row3 = temp[2];
                for (int r = 0; r < U.length; r++) {
                    U[r][0] = row3[r];
                    U[r][1] = row2[r];
                    U[r][2] = row1[r];
                }
            }
            else if (layer == 2)
            {
                String[][] temp = new String[3][3];
                for (int r = 0; r < D.length; r++)
                {
                    for (int c = 0; c < D[0].length; c++)
                    {
                        temp[r][c] = D[r][c];
                    }
                }
                String[] row1 = temp[0];
                String[] row2 = temp[1];
                String[] row3 = temp[2];
                for (int r = 0; r < D.length; r++) {
                    D[r][0] = row3[r];
                    D[r][1] = row2[r];
                    D[r][2] = row1[r];
                }
            }
        }
        return cube;
    }
    public static List<String[][]> Z(int layer, List<String[][]> cube, boolean prime)
    {
        String[][] B = cube.get(0);
        String[][] L = cube.get(1);
        String[][] U = cube.get(2);
        String[][] R = cube.get(3);
        String[][] D = cube.get(4);
        String[][] F = cube.get(5);

        if(prime)
        {
            if(layer==2)
            {
                for (int i = 0; i < 3; i++)
                {
                    String[] current = {U[2 - layer][i], D[layer][2 - i], L[2 - i][2 - layer], R[i][layer]};
                    U[2 - layer][i] = current[2];
                    R[i][layer] = current[0];
                    D[layer][2 - i] = current[3];
                    L[2 - i][2 - layer] = current[1];
                }
            }
            else
            {
                for (int i = 0; i < 3; i++)
                {
                    String[] current = {U[2 - layer][i], D[layer][2 - i], L[2 - i][2 - layer], R[i][layer]};
                    U[2 - layer][i] = current[3];
                    R[i][layer] = current[1];
                    D[layer][2 - i] = current[2];
                    L[2 - i][2 - layer] = current[0];
                }
            }

            if (layer == 0)
            {
                String[][] temp = new String[3][3];
                for(int r=0; r<F.length; r++)
                {
                    for(int c=0; c<F[0].length; c++)
                    {
                        temp[r][c] = F[r][c];
                    }
                }
                String[] row1 = temp[0];
                String[] row2 = temp[1];
                String[] row3 = temp[2];
                for (int r = 0; r < R.length; r++)
                {
                    F[r][0] = row1[2-r];
                    F[r][1] = row2[2-r];
                    F[r][2] = row3[2-r];
                }
            }
            else if (layer == 2)
            {
                String[][] temp = new String[3][3];
                for(int r=0; r<B.length; r++)
                {
                    for(int c=0; c<B[0].length; c++)
                    {
                        temp[r][c] = B[r][c];
                    }
                }
                String[] row1 = temp[0];
                String[] row2 = temp[1];
                String[] row3 = temp[2];
                for (int r = 0; r < B.length; r++)
                {
                    B[r][0] = row1[2-r];
                    B[r][1] = row2[2-r];
                    B[r][2] = row3[2-r];
                }
            }
        }
        else
        {
            if(layer==2)
            {
                for (int i = 0; i < 3; i++)
                {
                    String[] current = {U[2 - layer][i], D[layer][2 - i], L[2 - i][2 - layer], R[i][layer]};
                    U[2 - layer][i] = current[3];
                    R[i][layer] = current[1];
                    D[layer][2 - i] = current[2];
                    L[2 - i][2 - layer] = current[0];
                }
            }
            else
            {
                for (int i = 0; i < 3; i++)
                {
                    String[] current = {U[2 - layer][i], D[layer][2 - i], L[2 - i][2 - layer], R[i][layer]};
                    U[2 - layer][i] = current[2];
                    R[i][layer] = current[0];
                    D[layer][2 - i] = current[3];
                    L[2 - i][2 - layer] = current[1];
                }
            }

            if (layer == 0)
            {
                String[][] temp = new String[3][3];
                for (int r = 0; r < F.length; r++)
                {
                    for (int c = 0; c < F[0].length; c++)
                    {
                        temp[r][c] = F[r][c];
                    }
                }
                String[] row1 = temp[0];
                String[] row2 = temp[1];
                String[] row3 = temp[2];
                for (int r = 0; r < R.length; r++)
                {
                    F[r][0] = row3[r];
                    F[r][1] = row2[r];
                    F[r][2] = row1[r];
                }
            }
            else if (layer == 2)
            {
                String[][] temp = new String[3][3];
                for (int r = 0; r < B.length; r++)
                {
                    for (int c = 0; c < B[0].length; c++)
                    {
                        temp[r][c] = B[r][c];
                    }
                }
                String[] row1 = temp[0];
                String[] row2 = temp[1];
                String[] row3 = temp[2];
                for (int r = 0; r < B.length; r++) {
                    B[r][0] = row3[r];
                    B[r][1] = row2[r];
                    B[r][2] = row1[r];
                }
            }
        }
        return cube;
    }

    public static boolean isSolved(List<String[][]> cube)
    {
        String[][] B = cube.get(0);
        String[][] L = cube.get(1);
        String[][] U = cube.get(2);
        String[][] R = cube.get(3);
        String[][] D = cube.get(4);
        String[][] F = cube.get(5);

        for(int r=0; r<F.length; r++)
        {
            for(int c=0; c<F[0].length; c++) {
                String t = F[r][c];
                if (t.equals(U[r][c]) || t.equals(B[r][c]) || t.equals(D[r][c]) || t.equals(R[r][c]) || t.equals(L[r][c]))
                {
                    return false;
                }
                String u = U[r][c];
                if (u.equals(B[r][c]) || u.equals(D[r][c]) || u.equals(R[r][c]) || u.equals(L[r][c]))
                {
                    return false;
                }
                String b = B[r][c];
                if (b.equals(D[r][c]) || b.equals(R[r][c]) || b.equals(L[r][c]))
                {
                    return false;
                }
                String d = D[r][c];
                if (d.equals(R[r][c]) || d.equals(L[r][c]))
                {
                    return false;
                }
                String s = R[r][c];
                if (s.equals(L[r][c]))
                {
                    return false;
                }

            }
        }
        return true;
    }


}
