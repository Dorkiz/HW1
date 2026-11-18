public class Assignment01Q03 {
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        System.out.println("The first " + x + " Fibonacci numbers are:");

        ////////////////////////////////////////////////////////////////
        // TODO: Replace this code with the correct Fibonacci sequence
        ////////////////////////////////////////////////////////////////
        /// ...
        int prev1 = 1;
        int prev2 = 0;
        int middle = 0;
        int numOdd = 0;
        for (int i = 0; i < x; i++) {
            if (i==0){System.out.print("1 "); numOdd++;}
            else{
                System.out.print(prev1 + prev2);
                if ((prev2 + prev1)%2 == 1) { 
                    numOdd++;
                }
                if (i < x - 1) 
                    System.out.print(" "); // Make sure we don't print a trailing space
                middle = prev1 + prev2;
                prev2 = prev1;
                prev1 = middle;    
            }        
        }
        System.out.println();
        
        ////////////////////////////////////////////////////////////////
        
        System.out.println("The number of odd numbers is: " + numOdd);
    }
}
