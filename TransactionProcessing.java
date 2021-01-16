import java.util.ArrayList;
import java.util.HashMap;

public class TransactionProcessing {

    //use for billsPayment and checkDuplicateBills
    static final String[] billers = {
        "Manila Water",
        "Meralco",
        "Converge",
        "Sky Cable",
        "Maynilad",
        "PLDT",
        "Globe"
    };

    private static ArrayList<Transaction> transactions = new ArrayList<Transaction>();

    private static void init() {
        HashMap<String, Integer> recipients = new HashMap<String, Integer>();
        recipients.put("John Doe", 5000);
        recipients.put("Douglas McArthur", 1000);
        recipients.put("Ben Tyler", 2000);
        recipients.put("John Cena", 1200);
        recipients.put("Johnny Bravo", 1500);

        // create 5 money transfer transactions
        for (String recipient: recipients.keySet()) {
            MoneyTransfer moneyTransfer = new MoneyTransfer(recipient, recipients.get(recipient));
            transactions.add(moneyTransfer);
        }

        double[][] billsAmount = {
            {500, 700, 300},    // Manila Water
            {2000, 1200},       // Meralco
            {1500, 3000},       // Converge
            {800},              // Sky Cable
            {600},              // Maynilad
            {1500},             // PLDT
            {999}               // Globe
        };

        //create bills payment transaction
        for (int i = 0; i < billsAmount.length; i++) {
            for (int j = 0; j < billsAmount[i].length; j++) {
                Bill bill = new Bill(billers[i], billsAmount[i][j]);
                transactions.add(bill);
            }
        }

        // HashMap<String, Integer> utilities = new HashMap<String, Integer>();
        // utilities.put("Manila Water", 500);
        // utilities.put("Manila Water", 700);
        // utilities.put("Manila Water", 300);
        // utilities.put("Meralco", 2000);
        // utilities.put("Meralco", 1200);
        // utilities.put("Converge", 1500);
        // utilities.put("Converge", 3000);
        // utilities.put("Sky Cable", 800);
        // utilities.put("Maynilad", 600);
        // utilities.put("PLDT", 1500);
        // utilities.put("Globe", 999);

        // create 3 bills payment transaction
        // for (String company: utilities.keySet()) {
        //     Bill bill = new Bill(company, utilities.get(company));
        //     transactions.add(bill);
        // }

        HashMap<String, Integer> mobileNumbers = new HashMap<String, Integer>();
        mobileNumbers.put("09396369781", 300);
        mobileNumbers.put("09759006616", 20);
        mobileNumbers.put("09215331595", 10);
        mobileNumbers.put("09998301666", 15);
        mobileNumbers.put("09399191122", 50);

        // create 5 buy load transactions
        for (String mobileNumber: mobileNumbers.keySet()) {
            BuyLoad buyLoad = new BuyLoad(mobileNumber, mobileNumbers.get(mobileNumber));
            transactions.add(buyLoad);
        }

        // create 2 add account credits transaction
        int i = 0;
        for (String mobileNumber: mobileNumbers.keySet()) {
            if (i == 2) {
                break;
            }
            AddAccountCredit addAccountCredit = new AddAccountCredit(mobileNumber, mobileNumbers.get(mobileNumber));
            transactions.add(addAccountCredit);
            i++;
        }

        HashMap<String, Integer> gameCredits = new HashMap<String, Integer>();
        gameCredits.put("Garena", 300);
        gameCredits.put("Steam", 200);
        gameCredits.put("MobileLegends", 150);
        gameCredits.put("Ragnarok", 150);
        gameCredits.put("Razer", 50);
        
        // create 5 add game credit transactions
        for (String gameCredit: gameCredits.keySet()) {
            AddGameCredit addGameCredit = new AddGameCredit(gameCredit, gameCredits.get(gameCredit));
            transactions.add(addGameCredit);
        }
    }

    public static void showAllTransactions() {
        for (Transaction transaction: transactions) {
            System.out.println(transaction);
        }
    }

    public static void showSpecifiedTransactions(String type) {
        // allowed input:
        // MONEY_TRANSFER
        // BILLS_PAYMENT
        // BUY_LOAD
        // ADD_ACCOUNT_CREDITS
        // ADD_GAME_CREDITS

        TransactionType value = TransactionType.valueOf(type);

        System.out.println(value);

        switch (value) {
            case MONEY_TRANSFER:
                for (Transaction transaction: transactions) {
                    if (transaction instanceof MoneyTransfer) {
                        System.out.println(transaction);
                    }
                }
                break;
            case BILLS_PAYMENT:
                for (Transaction transaction: transactions) {
                    if (transaction instanceof Bill) {
                        System.out.println(transaction);
                    }
                }
                break;
            case BUY_LOAD:
                for (Transaction transaction: transactions) {
                    if (transaction instanceof BuyLoad) {
                        System.out.println(transaction);
                    }
                }
                break;
            case ADD_ACCOUNT_CREDITS:
                for (Transaction transaction: transactions) {
                    if (transaction instanceof AddAccountCredit) {
                        System.out.println(transaction);
                    }
                }
                break;
            case ADD_GAME_CREDITS:
                for (Transaction transaction: transactions) {
                    if (transaction instanceof AddGameCredit) {
                        System.out.println(transaction);
                    }
                }
                break;
        }
    }

    public static void checkDuplicateBills() {

        ArrayList<Transaction> bills = new ArrayList<Transaction>();
        
        for (Transaction transaction: transactions) {
            if (transaction instanceof Bill) {
                bills.add(transaction);
            }
        }

        for (int i = 0; i < billers.length; i++) {
            int duplicate = 0;

            for (int j = 0; j < bills.size(); j++) {
                Bill bill = (Bill) bills.get(j);
                if (billers[i] == bill.company_name) {
                    duplicate++;
                } else {
                    continue;
                }
            }

            System.out.println(billers[i] + ": " + duplicate);
        }
    }
    
    public static void main(String[] args) {
        init();

        showAllTransactions();

        try {
            showSpecifiedTransactions("BILLS_PAYMENT");
        } catch (Exception err) {
            throw err;
        }

        checkDuplicateBills();
    }
}