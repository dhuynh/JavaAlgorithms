import java.util.ArrayList;
 
public class BasicDecryption {
       
        public static void primeList(ArrayList<Integer> primes, int n)
        {
                Boolean flag = false;
                for(int i=1; i< n; i++){
                        flag=true;
                       
                        // check to see if the number is prime
                        for(int j=2; j <= Math.sqrt(i); j++)
                        {
                                if(i%j==0)
                                {
                                        flag=false;
                                        break;
                                }
                        }
                       
                        if(flag==true)
                        {
                                primes.add(i);
                        }
                }
        }
       
        public static int nGen (int pkey1, int pkey2)
        {
                return(pkey1*pkey2);           
        }
       
        public static int phiGen (int pkey1, int pkey2)
        {
                return((pkey1-1)*(pkey2-1));
        }
       
        public static int eGen (int phi, Integer[] primes)
        {
                int i = 1;
                while(phi%primes[i]==0 && primes[i]<phi)
                {
                        i++;
                }
                return primes[i];
        }
       
        public static int dGen (int e, int phi)
        {
                int i = 1;
                while(((i*e)%phi)!=1)
                {
                        i++;
                }
                return i;
        }
       
        public static long encrypt (int e, int n, long letter)
        {
                //return (long) (Math.pow(letter, e)%n);
                return (long) exp((int) letter, e, n);
        }
       
        public static long decrypt (int d, int n, long letter)
        {
                //return (long) (Math.pow(letter, d)%n);
                return (long) exp((int)letter, d, n);
        }
       
        public static long exp(int base, int power, int modulo) {
                long modPower = base % modulo;
                for(int i=1; i<power; i++){
                        modPower = (modPower * base) % modulo;
                }
                return modPower;
        }
       
       
        public static void findPQ(int n, Integer[] primes)
        {
                for (int i=0; i<999; i++)
                {
                        if(primes[i] * primes[i+1] == n)
                        {
                                System.out.print("Prime 1: " + primes[i] + " Prime 2: " + primes[i+1] + " ");
                                break;
                        }
                }
        }
       
       
        public static void main(String[] args)
        {
                int pkey1 = 571;
                int pkey2 = 577;
                int n = nGen(pkey1, pkey2);
                System.out.println("n = "+n);
                int phi = phiGen(pkey1, pkey2);
                System.out.println("phi = "+phi);
 
               
               
               
                ArrayList<Integer> a1 = new ArrayList<Integer>();
                primeList(a1, 999);
               
                Integer[] primes = a1.toArray(new Integer[0]);
                findPQ(329467, primes);
               
 
               
               
                int e = 17;
               
                int d = dGen(e, phi);
                System.out.println("d = " + d);
 
                long code = 193024;
                int input = 329467;
                long decode = decrypt(d, input, code);
                System.out.println("Decrypted = " +decode);
                
                int code4 = 242798;
                long decode2 = decrypt(d, input, code4);
                System.out.println("Decrypted = " +decode2);
                
                int code2 = 41304;
                long decode3 = decrypt(d, input, code2);
                System.out.println("Decrypted = " +decode3);
                
                int code3 = 65142;
                long decode4 = decrypt(d, input, code3);
                System.out.println("Decrypted = " +decode4);
               
               
               
                System.out.println(a1);
               
        }
 
}