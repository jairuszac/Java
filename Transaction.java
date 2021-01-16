import java.util.UUID;
import java.util.Date;

public class Transaction {
    public final UUID store_id;
    public final UUID transaction_id;
    public Date timestamp;
    public UUID account_id;
    public double amount;

    public Transaction(double fee) {
        transaction_id = UUID.randomUUID();
        store_id = UUID.randomUUID();
        timestamp = new Date();
        amount = fee;
    }
}