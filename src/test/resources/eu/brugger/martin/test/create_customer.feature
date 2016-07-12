Feature: Create customer
    To create a customer, at least a name with more than 3 characters has to be provided

    Scenario: create a customer successuflly
        Given a customer name Martin
        When I create the customer
        Then the customer is created successfully with the name Martin

    Scenario: create a customer should fail with invalid name
        Given a customer name Ma
        When I create the customer
        Then the customer creation fails