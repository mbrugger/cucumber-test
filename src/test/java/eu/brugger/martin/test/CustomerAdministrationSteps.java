package eu.brugger.martin.test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import eu.brugger.martin.Customer;
import eu.brugger.martin.CustomerAdministration;
import org.junit.Assert;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;


public class CustomerAdministrationSteps {
    private String customerName;
    private Customer customer;
    private Exception exception;

    @Given("^a customer name (.*)$")
    public void a_customer_name(String customerName) throws Throwable {
        this.customerName = customerName;
    }

    @When("^I create the customer$")
    public void i_create_the_customer() {
        CustomerAdministration customerAdministration = new CustomerAdministration();
        try {
            this.customer = customerAdministration.createCustomer(customerName);
        } catch (Exception e) {
            this.exception = e;
        }
    }

    @Then("^the customer is created successfully with the name (.*)$")
    public void the_customer_is_created_successfully(String expectedName) {
        assertThat(this.customer, notNullValue());
        assertThat(this.customer.getName(), is(expectedName));
    }

    @Then("^the customer creation fails$")
    public void the_customer_creation_fails() throws Throwable {
        assertThat(this.exception, notNullValue());
    }

}
