use std::env::var;
use std::alloc::System;
use std::time::SystemTime;
use std::collections::LinkedList;

fn main() {
    let prime_number_amount = 50;

    let mut prime_numbers = LinkedList::new();
    let init_time = SystemTime::now();

    let mut current = 1;

    while prime_numbers.len() != prime_number_amount {
        current += 1;
        let mut is_prime_number = true;
        let mut factors = 0;
        for i in 1 .. current {
            if current % i == 0 {
                factors += 1;
                if factors >= 2 {
                    is_prime_number = false;
                    break;
                }
            }
        }
        if is_prime_number {
            println!("{}", current);
            prime_numbers.push_front(current);
        }
    }
}

