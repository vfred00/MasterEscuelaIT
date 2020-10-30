package PrimeNumbers;

public class PrimeNumber {

    private int number;

    public PrimeNumber(){
        this.number = 2;
    }

    public static boolean isPrime (int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int next (){
        this.number++;
        do {
           if (!isPrime(this.number)) {
               this.number++;
           }
        }while (!isPrime(this.number));
        return this.number;
    }
}