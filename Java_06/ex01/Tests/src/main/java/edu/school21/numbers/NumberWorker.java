package edu.school21.numbers;

public class NumberWorker {

    public class IllegalNumberException extends RuntimeException {
        public IllegalNumberException() {
            super("IllegalNumberException");
        }
    }

    public boolean isPrime(int num) throws IllegalNumberException {
        if (num <= 1) {
            throw new IllegalNumberException();
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int digitsSum(int c) {
        int k = 0;
        while (c > 0) {
            k += c % 10;
            c = c / 10;
        }
        return k;
    }
}
