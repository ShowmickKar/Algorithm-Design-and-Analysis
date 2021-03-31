/* 
Practice Link: https://practice.geeksforgeeks.org/problems/sieve-of-eratosthenes5242/1 
Explanation: https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes  
*/

class SieveOfEratosthenes{
    static ArrayList<Integer> sieveOfEratosthenes(int n){
        ArrayList<Integer> primes = new ArrayList<Integer>();
        int[] store = new int[n + 1];
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (store[i] < 1) {
                for (int m = 2; m * i <= n; m++) {
                    store[m * i]++;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (store[i] < 1) {
                primes.add(i);
            }
        }
        return primes;
    }
}
