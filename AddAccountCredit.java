public class AddAccountCredit extends Transaction {
    String msisdn;

    public AddAccountCredit(String mobileNumber, double amount) {
        super(amount);
        msisdn = mobileNumber;
    }
}