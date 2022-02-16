package com.example.BddSpringboot.cucumber;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserStepDef {

    private User actualUser= new User();
    private User expectedUser= new User();
    @Autowired
    private UserController userController;


    @Given("user creates an user record with the following attribute")
    public void userCreatesAnUserRecordWithTheFollowingAttribute(DataTable dataTable) {
        System.out.println("This is datatable: "+dataTable);

        List<List<String>> dataLists= dataTable.cells();

        actualUser.setName(dataLists.get(1).get(0));
        actualUser.setAddress(dataLists.get(1).get(1));
        actualUser.setPhone(Long.valueOf(dataLists.get(1).get(2)));
        actualUser.setGender(dataLists.get(1).get(3));

        System.out.println("This is user details without id: "+actualUser);

    }

    @When("Save the user data into the database")
    public void saveTheUserDataIntoTheDatabase() {
        expectedUser= userController.saveUser(actualUser);
        System.out.println("USer object is saved into the database.");
    }

    @Then("Verify the saved user object")
    public void verifyTheSavedUserObject() {
        System.out.println("User object is verifying here...");
        Assert.assertEquals(expectedUser.getAddress(),actualUser.getAddress());
    }

    @And("User gives a phone number to search an user object")
    public void userGivesANumberToSearchAnUserObject(DataTable phoneDataTable) {

        List<List<String>> phoneList=phoneDataTable.cells();

        Long phoneNumber= Long.valueOf(phoneList.get(1).get(0));
        expectedUser=userController.findUserByPhone(phoneNumber);
    }

    @Then("validate the return object")
    public void thenValidateTheReturnObject() {
        Assert.assertEquals(expectedUser.getPhone(),actualUser.getPhone());
    }

    @And("User set the new values for user object")
    public void userSetTheNewValuesForUserObject(DataTable dataTable) {

        List<List<String >>list=dataTable.cells();

        expectedUser.setName(list.get(1).get(0));
        expectedUser.setAddress(list.get(1).get(1));
        expectedUser.setPhone(Long.valueOf(list.get(1).get(2)));
        expectedUser.setGender(list.get(1).get(3));
    }

    @And("Save the updated values of user")
    public void saveTheUpdatedValuesOfUser() throws RecordNotFound {
        actualUser=userController.updateStudent(expectedUser);

    }

    @Then("Validate the updated user details")
    public void validateTheUpdatedUserDetails() {
        Assert.assertEquals(expectedUser.getName(),actualUser.getName());
    }

    @Then("user object is deleted from the database")
    public void userObjectIsDeleted() throws RecordNotFound {
        Assertions.assertTrue(Boolean.parseBoolean("true"),userController.deleteUserById(expectedUser.getUId()));
    }
}
