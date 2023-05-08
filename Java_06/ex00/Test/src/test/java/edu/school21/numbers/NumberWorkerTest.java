package edu.school21.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;


public class NumberWorkerTest {

    NumberWorker work;

    @BeforeEach
    public void beforeEachMethod() {
        work = new NumberWorker();
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 113, 97})
    void isPrimeForPrimes(int number) {
        Assertions.assertTrue(work.isPrime(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {22232, 1215, 1110004, 1001})
    void isPrimeForNotPrimes(int number) {
        Assertions.assertFalse(work.isPrime(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, -5, 0})
    void isPrimeForIncorrectNumbers(int number) {
        Assertions.assertThrows(NumberWorker.IllegalNumberException.class, () -> work.isPrime(number));
    }

    @ParameterizedTest
    @CsvFileSource(resources = {"/data.csv"}, delimiter = ',')
    void digitsSum(int x, int y) {
        Assertions.assertEquals(work.digitsSum(x), y);
    }

}
