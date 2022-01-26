package com.example.BddSpringboot.cucumber;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class UserStepdefs {

    @Autowired
    private UserController userController;
    @Autowired
    private UserRepository userRepository;
    private  User expectedUser=new User();
    private User actualUser;
    Integer uId;

    @Given(": user wants to create an user record with the following attribute")
    public void userWantsToCreateAnUserRecordWithTheFollowingAttribute(DataTable dataTable) {
        List<List<String>> list =dataTable.cells();
        System.out.println("data Table: "+dataTable);

        expectedUser.setName(list.get(1).get(0));
        expectedUser.setAddress(list.get(1).get(1));
        expectedUser.setPhone(list.get(1).get(2));
        expectedUser.setGender(list.get(1).get(3));

        System.out.println("Expected user: "+expectedUser);
    }

    @When("user object is created saved it into database")
    public void userObjectIsCreatedSavedItIntoDatabase() {
        actualUser=userController.saveUser(expectedUser);
        Assertions.assertNotNull(actualUser);
    }

    @Then("validate the saved user object")
    public void validateTheSavedUserObject() {
        Assertions.assertEquals(expectedUser.getName(),actualUser.getName());
    }

    @When("user gives an user {string} to search user object")
    public void userGivesAnUserToSearchUserObject(String id) throws RecordNotFound {
        uId= Integer.valueOf(id);
       actualUser= userController.fetchAnUser(uId);
    }

    @Then("then validate the return object")
    public void thenValidateTheReturnObject() {
        Assertions.assertEquals(uId,actualUser.getUId());
    }

    @Given("User provides an user id")
    public void userProvidesAnUserId(DataTable table) {
        List<List<String>> list= table.cells();
        uId= Integer.valueOf(list.get(1).get(0));
        Optional<User> userOptional=userRepository.findById(uId);
        if(userOptional.isPresent()){
            actualUser=userOptional.get();
        }

    }

    @When("User set the new values for user object")
    public void userSetTheNewValuesForUserObject(DataTable dataTable) {
            List<List<String>> list=dataTable.cells();
            expectedUser.setUId(uId);
            expectedUser.setName(list.get(1).get(0));
            expectedUser.setAddress(list.get(1).get(1));
            expectedUser.setPhone(list.get(1).get(2));
            expectedUser.setGender(list.get(1).get(3));
    }

    @Then("update the user object and persist the user")
    public void updateTheUserObjectAndPersistTheUser() throws RecordNotFound {
        userController.updateStudent(expectedUser);
        Assertions.assertEquals(actualUser.getUId(),expectedUser.getUId());
    }

    @Then("user object is deleted from the database")
    public void userObjectIsDeletedFromTheDatabase() throws RecordNotFound {
//    userController.deleteUserById(uId);
    Assertions.assertTrue(Boolean.parseBoolean("true"),userController.deleteUserById(uId));
    }
}
