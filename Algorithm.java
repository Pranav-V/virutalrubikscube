import java.util.*;
import java.io.*;

public class Algorithm implements Cloneable
{
    public static List<String> sol = new ArrayList<>();
    public static Cube current = new Cube();

    public static void main(String[] args) throws Exception
    {
        List<String[][]> cube = new ArrayList<>();
        Scanner sc = new Scanner(new File("src/Positions.dat"));
        String[][] B = {sc.nextLine().split(" "),sc.nextLine().split(" "), sc.nextLine().split(" ")};
        sc.nextLine();
        cube.add(B);
        String[][] L = {sc.nextLine().split(" "),sc.nextLine().split(" "), sc.nextLine().split(" ")};
        sc.nextLine();
        cube.add(L);
        String[][] U = {sc.nextLine().split(" "),sc.nextLine().split(" "), sc.nextLine().split(" ")};
        sc.nextLine();
        cube.add(U);
        String[][] R = {sc.nextLine().split(" "),sc.nextLine().split(" "), sc.nextLine().split(" ")};
        sc.nextLine();
        cube.add(R);
        String[][] D = {sc.nextLine().split(" "),sc.nextLine().split(" "), sc.nextLine().split(" ")};
        sc.nextLine();
        cube.add(D);
        String[][] F = {sc.nextLine().split(" "),sc.nextLine().split(" "), sc.nextLine().split(" ")};
        cube.add(F);

        System.out.print("Algorithm: ");
        Scanner scan = new Scanner(System.in);
        String movements = scan.nextLine();
        String[] directional;
        if(movements.indexOf(" ")>0)
        {
            directional = movements.split(" ");
        }
        directional = movements.split("");

        for(int i=0; i<directional.length; i++)
        {
            String c = directional[i];
            int number = numberOf(directional, i);
            boolean prime = isPrime(directional, i, number);
            if(c.equals("L") || c.equals("M") || c.equals("R"))
            {
                String possible = "LMR";
                for(int j=0; j<number; j++)
                {
                    current.Y(possible.indexOf(c), cube, prime);
                }
            }
            if(c.equals("U") || c.equals("E") || c.equals("D"))
            {
                String possible = "UED";
                for(int j=0; j<number; j++)
                {
                    current.X(possible.indexOf(c), cube, prime);
                }
            }
            if(c.equals("F") || c.equals("S") || c.equals("B"))
            {
                String possible = "FSB";
                for(int j=0; j<number; j++)
                {
                    current.Z(possible.indexOf(c), cube, prime);
                }
            }
        }

        System.out.println("Post-Algorithm: ");
        System.out.println();
        current.printAll(cube);
        System.out.println();
        if(current.isSolved(cube))
        {
            System.out.println("Cube is Solved");
        }

    }

    public static int numberOf(String[] direction, int curr)
    {
        int number=1;
        if(curr<direction.length-1)
        {
            try
            {
                number=Integer.parseInt(direction[curr+1]);
            }
            catch(NumberFormatException e)
            {
            }
        }
        return number;
    }
    public static boolean isPrime(String[] direction, int curr, int num)
    {
        boolean prime = false;
        if(curr<direction.length-1)
        {
            if(num==1 && direction[curr+1].equals("'"))
            {
                prime=true;
            }
            else if(num>1 && direction[curr+2].equals("'"))
            {
                prime=true;
            }
        }
        return prime;
    }


}
