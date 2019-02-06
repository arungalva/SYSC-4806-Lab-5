package addressbook; /**
 * Author: Arun Galva
 * Lab: Lab 3
 * Class: addressbook.addressbook.AddressBook
 * Description: addressbook.addressbook.AddressBook class that contains a list of buddies
 */

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "addressBook")
    private List<BuddyInfo> buddies;

    public AddressBook(Long id) {
        this.id = id;
        this.buddies = new ArrayList<BuddyInfo>();
    }

    public AddressBook(){
        this(null);
    }

    public void setBuddies(List<BuddyInfo> buddies) {
        this.buddies = buddies;
    }

    /**
     * Add a buddy to the list
     * @param buddy Buddy to be added to the list of buddies
     */

    public void addBuddy(BuddyInfo buddy) {
        this.buddies.add(buddy);
    }

    /**
     *
     * @return buddies. List of all the buddies in the address book
     */
    public List<BuddyInfo> getBuddies(){
        return buddies;
    }

    /**
     *
     * @param buddy Name of the buddy to be removed from the list of buddies
     * @return true if the buddy is removed and flase if the buddy isn't in the list
     */

    public Boolean removeBuddy(BuddyInfo buddy) {
        return this.buddies.remove(buddy);
    }

    /**
     *
     * @param name Name of the buddy you would like to access
     * @return The buddy matching the provided name
     */

    public BuddyInfo getBuddy(String name) {
        for (BuddyInfo buddy: buddies) {
            if (buddy.getName().equals(name)) return buddy;
        }
        return null;
    }

    @Override
    public String toString() {
        String returnValue = "";
        for (BuddyInfo buddy: buddies) {
            returnValue += buddy.toString() + "\n";
        }
        return returnValue;
    }

    public Long getId() {
        return id;
    }
}
