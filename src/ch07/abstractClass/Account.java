package ch07.abstractClass;

// abstract: 추상
// 추상 클래스
public abstract class Account {
    String accountNumber;
    double balance;

    Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println(amount + " deposited. New balance: " + balance);
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn. New balance: " + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    // 추상메서드
    // 메서드 구현 내용이 없습니다.
    // 상속 받는 클래스에서 개별로 구현해라...
    abstract void endOfMonth(); // 추상 메소드: 매월 말에 실행되는 작업
}