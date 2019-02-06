//package addressbook;
//
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.concurrent.atomic.AtomicLong;
//
//import static org.springframework.web.bind.annotation.RequestMethod.POST;
//
//@RestController
//public class AddressBookController {
//
//    private final AtomicLong addressBookCounter = new AtomicLong();
//
//    @RequestMapping(method=POST, path = "/addressbook")
//    public AddressBook addressBook() {
//        AddressBook newBook = new AddressBook(addressBookCounter.incrementAndGet());
//        return newBook;
//    }
//
//    @RequestMapping(method=POST, path = "/addressbook/buddy")
//    public String addBuddyToAddressBook(@RequestParam(value = "name") String name,
//                                        @RequestParam(value="phoneNumber") String phoneNumber) {
//
//        return "";
//
//    }
//}
