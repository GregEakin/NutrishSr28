/*
 * Copyright (c) 2018. Greg Eakin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package info.gdbtech.dao.primes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrimeTests {

    public static LazyList<Integer> from(int n) {
        return new LazyList<Integer>(n, () -> from(n + 1));
    }

    public static MyList<Integer> primes(MyList<Integer> numbers) {
        return new LazyList<>(
                numbers.head(), () -> {
            return primes(
                    numbers.tail().filter(n -> {
                        return n % numbers.head() != 0;
                    })
            );
        }
        );
    }

    @Test
    public void LazyListTest() {
        LazyList<Integer> numbers = from(2);
        Assertions.assertEquals(2, numbers.head().intValue());
        Assertions.assertEquals(3, numbers.tail().head().intValue());
        Assertions.assertEquals(4, numbers.tail().tail().head().intValue());
    }

    @Test
    public void PrimeTest() {
        LazyList<Integer> numbers = from(2);
        Assertions.assertEquals(2, primes(numbers).head().intValue());
        Assertions.assertEquals(3, primes(numbers).tail().head().intValue());
        Assertions.assertEquals(5, primes(numbers).tail().tail().head().intValue());
    }

    @Test
    public void PrintPrimes() {
        MyList<Integer> numbers = primes(from(2));
        for (int i = 0; i < 20; i++) {
            System.out.println(numbers.head());
            numbers = numbers.tail();
        }
    }
}
