package com.example.BddSpringboot.cucumber;

import com.example.BddSpringboot.calculator.Calculator;
import com.example.BddSpringboot.calculator.CalculatorController;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class CalculatorStepdefs {

    @Autowired
    private CalculatorController calculatorController;
    int first_number=0;
    int second_number=0;
    Calculator calculator;
    int result=0;

    @Given("User provides first number")
    public void userProvidesFirstNumber(DataTable dataTable) {
        List<List<String>> list =dataTable.cells();
        first_number= Integer.parseInt(list.get(1).get(0));
    }

    @And("User provides second number")
    public void userProvidesSecondNumber(DataTable dataTable) {
        List<List<String>> list =dataTable.cells();
        second_number= Integer.parseInt(list.get(1).get(0));
    }

    @When("Adding these two number")
    public void addingTheseTwoNumber() {
        calculator=calculatorController.add(first_number,second_number);
        result= calculator.getResult();
    }

    @Then("Verify the addition result")
    public void verifyTheAdditionResult() {
        Assert.assertEquals(result,first_number+second_number);
    }

    @When("Subtracting these two number")
    public void subtractingTheseTwoNumber() {
        calculator=calculatorController.sub(first_number,second_number);
        result= calculator.getResult();
    }

    @Then("Verify the subtract result")
    public void verifyTheSubtractResult() {
        Assert.assertEquals(result,first_number-second_number);
    }

    @When("Multiply these two number")
    public void multiplyTheseTwoNumber() {
        calculator=calculatorController.mul(first_number,second_number);
        result= calculator.getResult();
    }

    @Then("Verify the multiplied result")
    public void verifyTheMultipliedResult() {
        Assert.assertEquals(result,first_number*second_number);
    }

    @When("Divide these two number")
    public void divideTheseTwoNumber() {
        calculator=calculatorController.div(first_number,second_number);
        result= calculator.getResult();
    }

    @Then("Verify the divide result")
    public void verifyTheDivideResult() {
        Assert.assertEquals(result,first_number/second_number);
    }
}
