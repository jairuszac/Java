public class MoneyTransfer extends Transaction {
    String recipient;

    public MoneyTransfer(String name, double remittance) {
        super(remittance);
        recipient = name;
    }
}