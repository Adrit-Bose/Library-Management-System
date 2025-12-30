import java.util.ArrayList;
import java.util.Scanner;

// Contact Class
class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static Contact createContact(String name, String phoneNumber) {
        return new Contact(name, phoneNumber);
    }

    @Override
    public String toString() {
        return name + " -> " + phoneNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Contact contact = (Contact) obj;
        return name.equals(contact.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}

// MobilePhone Class
class MobilePhone {
    private final ArrayList<Contact> contacts = new ArrayList<>();

    public boolean addNewContact(Contact contact) {
        if (findContact(contact.getName()) >= 0) {
            System.out.println("Contact already exists.");
            return false;
        }
        contacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int position = findContact(oldContact);
        if (position < 0) {
            System.out.println(oldContact.getName() + " was not found.");
            return false;
        }
        contacts.set(position, newContact);
        System.out.println("Successfully updated: " + oldContact.getName() + " -> " + newContact.getName());
        return true;
    }

    public boolean removeContact(Contact contact) {
        int position = findContact(contact);
        if (position < 0) {
            System.out.println(contact.getName() + " was not found.");
            return false;
        }
        contacts.remove(position);
        System.out.println(contact.getName() + " was deleted.");
        return true;
    }

    private int findContact(Contact contact) {
        return contacts.indexOf(contact);
    }

    private int findContact(String contactName) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public Contact queryContact(String name) {
        int position = findContact(name);
        if (position >= 0) {
            return contacts.get(position);
        }
        return null;
    }

    public void printContacts() {
        System.out.println("Contact List:");
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println((i + 1) + ". " + contacts.get(i));
        }
    }
}

// Main Class
public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final MobilePhone mobilePhone = new MobilePhone();

    // Constants for menu options
    private static final int SHUTDOWN = 0;
    private static final int PRINT_CONTACTS = 1;
    private static final int ADD_CONTACT = 2;
    private static final int UPDATE_CONTACT = 3;
    private static final int REMOVE_CONTACT = 4;
    private static final int QUERY_CONTACT = 5;
    private static final int PRINT_ACTIONS = 6;

    public static void main(String[] args) {
        boolean quit = false;
        startPhone();
        printActions();

        while (!quit) {
            System.out.print("\nEnter action (6 to show available actions): ");
            int action = getIntInput();

            switch (action) {
                case SHUTDOWN:
                    System.out.println("\nShutting down...");
                    quit = true;
                    break;
                case PRINT_CONTACTS:
                    mobilePhone.printContacts();
                    break;
                case ADD_CONTACT:
                    addNewContact();
                    break;
                case UPDATE_CONTACT:
                    updateContact();
                    break;
                case REMOVE_CONTACT:
                    removeContact();
                    break;
                case QUERY_CONTACT:
                    queryContact();
                    break;
                case PRINT_ACTIONS:
                    printActions();
                    break;
                default:
                    System.out.println("Invalid action. Please choose again.");
            }
        }
        scanner.close(); // Close Scanner
    }

    private static void addNewContact() {
        System.out.print("Enter new contact name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();
        Contact newContact = Contact.createContact(name, phone);
        if (mobilePhone.addNewContact(newContact)) {
            System.out.println("New contact added: " + newContact);
        }
    }

    private static void updateContact() {
        System.out.print("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found.");
            return;
        }
        System.out.print("Enter new contact name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter new contact phone number: ");
        String newNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newName, newNumber);
        if (mobilePhone.updateContact(existingContactRecord, newContact)) {
            System.out.println("Successfully updated record.");
        }
    }

    private static void removeContact() {
        System.out.print("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found.");
            return;
        }
        mobilePhone.removeContact(existingContactRecord);
    }

    private static void queryContact() {
        System.out.print("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found.");
        } else {
            System.out.println("Found: " + existingContactRecord);
        }
    }

    private static void startPhone() {
        System.out.println("Starting phone...");
    }

    private static void printActions() {
        System.out.println("\nAvailable actions:");
        System.out.println(SHUTDOWN + " - Shutdown");
        System.out.println(PRINT_CONTACTS + " - Print contacts");
        System.out.println(ADD_CONTACT + " - Add a new contact");
        System.out.println(UPDATE_CONTACT + " - Update an existing contact");
        System.out.println(REMOVE_CONTACT + " - Remove an existing contact");
        System.out.println(QUERY_CONTACT + " - Query if a contact exists");
        System.out.println(PRINT_ACTIONS + " - Print available actions");
    }

    private static int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine();
        }
        int input = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        return input;
    }
}
