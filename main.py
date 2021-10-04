primeNumberSize = int(input("How mush prime numbers do you want?\n"))
print("Generate", primeNumberSize, "prime numbers:\n")
primeNumbers = []
current = 1
while len(primeNumbers) < primeNumberSize:
    current += 1
    primeNumber = True
    factors = 0
    for x in range(1, current + 1):
        if current % x == 0:
            factors += 1
            if factors > 2:
                primeNumber = False
                break
    if primeNumber:
        print(current)
        primeNumbers.append(current)
