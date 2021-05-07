public class Contact {
    //Some class attributes are given. DO NOT EDIT
    private String name;
    private String phone;
    private String email;

    //You may add additional attributes below if required.
    private static int numberOfContactsCreated;

    // (a) 	Complete the constructor below as specified in the question
    public Contact(String name, String phone) {
        //add your code below
        this.name = name;
        boolean phoneValid = true;
        if (phone.length() != 8) phoneValid = false;
        try {
            int temp = Integer.parseInt(phone);
            temp = phone.charAt(7);
            if (phone.charAt(0) != '6' && phone.charAt(0) != '9') phoneValid = false;
        } catch (Exception e) {
            phoneValid = false;
        }
        if (phoneValid) this.phone = phone;
        else { this.phone = "00000000";
            System.out.println("Invalid phone"); }
        numberOfContactsCreated++;
        email = "nhs" + numberOfContactsCreated + "@avatar.edu.sg";
    }

    // (b)	Complete the constructor below as specified in the question
    public Contact(String name, String phone, String email) {
        //add your code below
        this(name, phone);
        this.email = email;
    }

    // (c) 	Complete the copy constructor below as specified in the question
    public Contact(Contact c) {
        //add your code below
        this(c.getName(),c.getPhone(),c.getEmail());
    }


    // (d)	Complete the toString() method below where the return is as specified in the question and sample output
    public String toString(){
        //add your code below
        return String.format("%-20s%-15s%-20s", name, phone, email);
    }

    //accessor & mutator methods. Given. DO NOT EDIT
    public String getName(){
        return name;
    }

    public String getPhone(){
        return phone;
    }

    public String getEmail(){
        return email;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public void setEmail(String email){
        this.email = email;
    }
}