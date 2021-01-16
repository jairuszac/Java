public class BuyLoad extends Transaction {
    String msisdn;

    public BuyLoad(String mobileNumber, double amount) {
        super(amount);
        msisdn = mobileNumber;
    }
}