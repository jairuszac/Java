public class Bill extends Transaction {
    public String company_name;
    public double bills_charge;

    public Bill(String companyName, double billsCharge) {
        super(billsCharge);
        company_name = companyName;
        bills_charge = billsCharge;
    }
}