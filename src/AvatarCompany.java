import java.io.*;
import java.util.*;

public class AvatarCompany {
    //Some class attributes are given. DO NOT EDIT
    private ArrayList<PhoneBook> directory;

    // (j)	Complete the constructor below as specified in the question
    public AvatarCompany(){
        //add your code below
        directory = new ArrayList<PhoneBook>();
    }

    // (k)	Add a PhoneBook p into the directory with an appropriate message output
    //as specified in the question
    public void addPhoneBook(PhoneBook p){
        //add your code below
        directory.add(p);
        System.out.println(p.getOwnerName() + "'s PhoneBook successfully added.");
    }

    // (l)	Remove a PhoneBook belonging to ownerName from the directory with appropriate
    //message output(s) as specified in the question
    public PhoneBook removePhoneBook(String ownerName){
        //add your code below
        if (directory == null) {
            System.out.println("Directory is empty!");
            return null;
        } int index = -1;
        for (int i=0;i<directory.size();i++) {
            if (directory.get(i).getOwnerName().equals(ownerName)) index = i;
        } if (index == -1) {
            System.out.println("No such owner found...");
            return null;
        } else {
            PhoneBook temp = directory.get(index);
            directory.remove(index);
            System.out.println(temp.getOwnerName() + "'s PhoneBook successfully removed");
            return temp;
        }
    }

    // (m) Backup the PhoneBook belonging to ownerName into a text file with specifications
    // as specified in the question
    public void backupPhoneBook(String ownerName){
        //add your code below
        try {
            int index = -1;
            for (int i=0;i<directory.size();i++) {
                if (directory.get(i).getOwnerName().equals(ownerName)) index = i;
            } String filename = "backup_" + ownerName + ".txt";
            File file = new File(filename);
            PrintWriter pw = new PrintWriter(new FileWriter(file, false));
            for (Contact i : directory.get(index).getList()) {
                if (i != null) pw.println(i.getName() + "|" + i.getPhone() + "|" + i.getEmail());
            }
            pw.close();
            System.out.println("Backup created successfully in " + filename);
        } catch (Exception e) {
            System.out.println("Error creating backup");
            e.printStackTrace();
        }
    }

    //Methods provided. Do not modify.
    public ArrayList<PhoneBook> getDirectory(){
        return directory;
    }
}
