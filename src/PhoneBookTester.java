import java.util.*;
public class PhoneBookTester {

    public static void main(String[] args) {

        //test Contact class
        Contact c1 = new Contact("Peter", "92373827", "peter@gmail.com");
        Contact c2 = new Contact("Mary", "98372934", "sdsdsd.com");
        Contact c3 = new Contact("Jane", "12345672", "jane@hotmail.com");
        Contact c4 = new Contact("Helen", "99583270", "helenhello@mail.com");
        Contact c5 = new Contact("John", "92130987", "nothing@yahoo.com.sg");
        Contact c6 = new Contact("Robert", "92136400", "roberto@gmail.com");
        Contact c7 = new Contact("Angel", "93426911");
        Contact c8 = new Contact("Raymond", "63423422");
        Contact c9 = new Contact("Kenny", "90593051");
        Contact c10 = new Contact("Benard", "90238332");
        Contact c11 = new Contact("Benard", "92332933");
        Contact c12 = new Contact("Benard", "62399284");
        Contact c13 = new Contact("Jane.C", "62938745");
        Contact c14 = new Contact("Helen.L", "99583276");

        //Test addContact()

        PhoneBook p1 = new PhoneBook("Max Yeow");
        p1.addContact(c2);
        p1.addContact(c13);
        p1.addContact(c14);
        p1.addContact(c5);
        p1.printContacts();

        PhoneBook p2 = new PhoneBook("Peter Ho");
        p2.addContact(c1);
        p2.addContact(c2);
        p2.addContact(c3);
        p2.addContact(c4);
        p2.addContact(c5);
        p2.addContact(c6);
        p2.addContact(c7);
        p2.addContact(c8);
        p2.addContact(c9);
        p2.addContact(c10);
        p2.addContact(c11);
        p2.printContacts();

        //Test getList()
        Contact[] copy = p2.getList();
        copy[0].setPhone("99999999");
        System.out.println(copy[0]);
        System.out.println(p2.getList()[0]); //original contact will still be intact

        //Test removeContact()
        p2.removeContact("92373827");
        p2.printContacts();
        p2.removeContact("91111111");
        p2.printContacts();

        //Test importList()
        PhoneBook p3 = new PhoneBook("Mary Lin");
        p3.importList("list.txt");
        p3.printContacts();
    }
}
