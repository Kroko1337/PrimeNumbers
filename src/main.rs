use std::env::var;
use std::alloc::System;
use std::time::SystemTime;
use std::collections::LinkedList;

fn main() {
    let primeNumberAmount = 50;

    let mut primeNumbers = LinkedList::new();
    let initTime = SystemTime::now();

    let mut current = 1;

    while primeNumbers.len() != primeNumberAmount {
        current += 1;
        let mut isPrimeNumber = true;
        let mut factors = 0;
        for i in 1 .. current {
            if current % i == 0 {
                factors += 1;
                if factors >= 2 {
                    isPrimeNumber = false;
                    break;
                }
            }
        }
        if isPrimeNumber {
            println!("{}", current);
            primeNumbers.push_front(current);
        }
    }
}

