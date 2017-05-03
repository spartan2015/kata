package app;

public class DbTransactionLog implements TransactionLog {
    public void log(String value) {
        System.out.println("log: " + value);
    }
}
