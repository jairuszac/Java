import java.util.UUID;
import java.util.Date;

public class Account {
    UUID id = UUID.randomUUID();
    String first_name;
    String last_name;
    Date date_created = new Date();
    boolean is_active = true; //default value 

    public static Account createAccount(String first_name, String last_name) {
        Account account = new Account();
        account.first_name = first_name;
        account.last_name = last_name;
        String message = String.format(
            "Account created!\n" + 
            "Account ID: %s\n" +
            "Name: %s %s\n" +
            "Date created: %s\n" +
            "Active: %s", 
            account.id, 
            account.first_name, 
            account.last_name, 
            account.date_created,
            account.is_active 
        );

        System.out.println(message);
        return account;
    }
    public static void main(String[] args) {
        createAccount("Jairus", "Zacarias");
    }
}