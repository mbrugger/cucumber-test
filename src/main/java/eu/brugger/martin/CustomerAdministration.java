package eu.brugger.martin;

import eu.brugger.martin.Customer;

public class CustomerAdministration {

    public Customer createCustomer(String customerName) {
        if (customerName.length() <= 3) {
            throw new IllegalArgumentException("Customer name has to be at least 3 characters");
        }
        Customer customer = new Customer();
        customer.setName(customerName);
        return customer;
    }
}
