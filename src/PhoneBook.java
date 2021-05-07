import java.io.*;
import java.util.ArrayList;

public class PhoneBook {
    //Some class attributes are given. DO NOT EDIT
    private final int MAX_CONTACT = 10;//size of contact list
    private Contact[] list;
    private String ownerName;
    private int count;//stores number of contacts in list

    // (e)	Complete the constructor below as specified in the question
    public PhoneBook(String ownerName){
        //add your code below
        this.ownerName = ownerName;
        list = new Contact[MAX_CONTACT];
        count = 0;
    }

    // (f)	getList() will return a deep copy of the contact list in this phonebook.
    public Contact[] getList(){
        //add your code below
        Contact[] dc = new Contact[list.length];
        for (int i=0;i<count;i++) {
            dc[i] = new Contact(list[i]);
        } return dc;
    }

    // (g)	Add newContact into list as specified in the question.
    public void addContact(Contact newContact){
        //add your code below
        boolean added = false;
        for (int i=0;i<list.length;i++) {
            if (list[i] == null) {
                list[i] = new Contact(newContact);
                added = true;
                System.out.println("Contact " + newContact.getName() + " added successfully");
                count++;
                break;
            }
        } if (!added) {
            System.out.println("Contact list full! New contact not added");
        }
    }

    // (h)	Remove contact with phone number indicated by num from list.
    // Complete the method as specified in the question.
    public void removeContact(String num){
        //add your code below
        int index = -1;
        for (int i=0;i<list.length;i++) {
            if (list[i] != null)
                if (list[i].getPhone() == num) {
                    index = i;
                }
        } if (index == -1) System.out.println("Contact not found. Deletion failed");
        else {
            Contact[] lc = list;
            list = new Contact[MAX_CONTACT];
            for (int i=0;i<index;i++) {
                list[i] = lc[i];
            } for (int i=index+1;i<lc.length;i++) {
                list[i-1] = lc[i];
            }
            System.out.println("Contact " + num + " removed successfully");
            count--;
        }
    }


    // (i)	importList() will import contacts stated in filename into the list in PhoneBook
    public void importList(String filename){
        //add your code below
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String s;
            do {
                s = br.readLine();
                if (s != null) {
                    String[] tokens = s.split("\\|");
                    addContact(new Contact(tokens[0], tokens[1], tokens[2]));
                }
            } while (s != null);
            br.close();
        } catch (Exception e) {
        }
    }


    //Methods provided. DO NOT EDIT!
    public String getOwnerName(){
        return ownerName;
    }

    public int getTotalContacts(){
        return count;
    }

    public void printContacts(){
        System.out.println("--------------- Contact list of " + ownerName + " ---------------");
        for(int i=0; i<count; i++) {
            System.out.println(list[i]);
        }
        System.out.println("Total contacts in phone book: " + count);
        System.out.println("----------------------------------------------------------------");
        System.out.println();
    }

}