import java.util.Scanner;

// Create an abstract base class called "Contact"
abstract class Contact {
    private String name;
    private String number;

    public Contact(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public abstract boolean isNameAvailable(String name);
}

// Create a subclass called "ContactList" that extends the base class "Contact"
class ContactList extends Contact {
    public ContactList(String name, String number) {
        super(name, number);
    }

    @Override
    public boolean isNameAvailable(String name) {
        return getName().equalsIgnoreCase(name);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of contacts: ");
        int n = scanner.nextInt();
        ContactList[] contacts = new ContactList[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter contact name: ");
            String name = scanner.next();
            System.out.println("Enter contact number: ");
            String number = scanner.next();
            contacts[i] = new ContactList(name, number);
        }

        System.out.println("Enter name to search: ");
        String searchName = scanner.next();
        boolean isAvailable = false;

        for (ContactList contact : contacts) {
            if (contact.isNameAvailable(searchName)) {
                isAvailable = true;
                break;
            }
        }

        if (isAvailable) {
            System.out.println(searchName + " is available in the list.");
        } else {
            System.out.println(searchName + " is not available in the list.");
        }
    }
}