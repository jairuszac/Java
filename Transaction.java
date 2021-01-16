import java.util.UUID;
import java.util.Date;

public class Transaction {
    final UUID store_id;
    final UUID transaction_id;
    Date timestamp;
    UUID account_id;
    double amount;

    public Transaction(double fee) {
        transaction_id = UUID.randomUUID();
        store_id = UUID.randomUUID();
        timestamp = new Date();
        amount = fee;
    }
}