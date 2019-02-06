package addressbook;

import addressbook.repository.AddressBookRepository;
import addressbook.repository.BuddyInfoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.thymeleaf.spring5.expression.Mvc;
import static org.junit.Assert.*;
import java.nio.charset.Charset;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    BuddyInfoRepository buddyRepo;

    @Autowired
    AddressBookRepository addressBookRepository;

    @Test
    public void addressBookShouldBeEmpty() throws Exception {
        String url = "/addressbook";
        this.mockMvc.perform(get(url))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/hal+json;charset=UTF-8"))
                .andExpect(jsonPath("_embedded.addressbook", hasSize(0)));

    }

    @Test
    public void createAddressBook() throws Exception {
        String url = "/addressbook";
        this.mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andDo(print())
                .andExpect(status().is(201));

        assertNotEquals(this.addressBookRepository.count(), 0);
    }

    @Test
    public void createNewBuddy() throws Exception {
        String url = "/buddy";
        MvcResult result = this.mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON).content("{\"name\": \"Smartpreet Grewal\",\n" +
                        "\t\"phoneNumber\": \"211-311-4111\"}"))
                .andDo(print())
                .andExpect(status().is(201))
                .andReturn();

        assertNotNull(this.buddyRepo.findByName("Smartpreet Grewal"));
    }
}
