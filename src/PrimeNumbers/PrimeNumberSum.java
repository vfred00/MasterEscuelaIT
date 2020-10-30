package PrimeNumbers;

public class PrimeNumberSum {

    public static void main(String[] args) {

        PrimeNumber primeNumber = new PrimeNumber();
        int limit = 50;
        int sumFirst = 0;
        int sumUntil = -1;
        for (int i = 0; i <= limit; i++){
            sumFirst += primeNumber.next();
            if (primeNumber.isPrime(i)){
                sumUntil += i;
            }
        }
        System.out.println("La suma de los 50 primeros números primos: " + sumFirst);
        System.out.println("La suma de los números primos que hay entre los 50 primeros números: " + sumUntil);
    }
}