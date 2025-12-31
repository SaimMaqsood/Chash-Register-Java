# Chash-Register-Java
Simple object-oriented console program that works like a basic cash register.

What it does:
- Lets you enter multiple item prices
- Accepts payment with coins (penny, nickel, dime, quarter, dollar)
- Counts coins and calculates total paid
- Shows a receipt and gives correct change
- Stops you if you try to pay too little

Features added:
- Checks for wrong coin names
- Asks for number of coins properly
- Shows "still owed" if not enough money
- Prints nice receipt with totals
- Resets after each customer

How to run it:
1. Have Java installed
2. In the folder with the files, open terminal/command prompt
3. Compile:  
   javac *.java
4. Run:  
  CashRegisterTester

Then:
- Type prices one by one (type 0 when finished adding items)
- When paying: type coin name (penny/nickel/dime/quarter/dollar) or F to finish
- Type how many of that coin
- At the end you see receipt + change

Files:
- CashRegister.java     → main logic
- Coin.java             → coin with value and name
- CashRegisterTester    → the program you run

Made as a learning project in Java – December 2025.
