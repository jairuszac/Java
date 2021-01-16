public class AddGameCredit extends Transaction {
    String company_name;

    public AddGameCredit(String companyName, double amount) {
        super(amount);
        company_name = companyName;
    }
}