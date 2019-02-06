package addressbook.repository;

import addressbook.AddressBook;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "addressbook", path = "addressbook")
public interface AddressBookRepository extends PagingAndSortingRepository<AddressBook, Long> {

    List<AddressBook> findAddressBookById(@Param("id") Long id);

}
