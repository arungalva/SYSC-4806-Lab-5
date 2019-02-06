package addressbook;

import javax.persistence.*;

/**
 * Author: Arun Galva
 * Lab: Lab 3
 * Class: addressbook.addressbook.BuddyInfo
 * Description: addressbook.addressbook.BuddyInfo class that contains the name and phone number of a buddy
 */
@Entity
public class BuddyInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "addressbookId")
    private AddressBook addressBook;

    protected BuddyInfo(){
        this(null, null);
    }

    public BuddyInfo(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Create a buddy without a phone number
     * @param name Name of the buddy
     */

    public BuddyInfo(String name){
        this(name, null);
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        String value = "";
        value += "Name: " + this.name;

        if(this.phoneNumber != null) value += ", Phone Number: " + this.phoneNumber;

        return value;
    }

    public void setAddressBook(AddressBook addressBook) {
        this.addressBook = addressBook;
    }
}
