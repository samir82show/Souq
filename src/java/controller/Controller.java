package controller;

import entity.Customer;
import entity.CustomerFacade;
import java.io.Serializable;
import javax.inject.Named;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

@Named(value = "controller")
@SessionScoped
public class Controller implements Serializable{

    @EJB
    private CustomerFacade customerFacade;
    @Inject
    private Customer customer;
    private String status;

    public Customer getCustomer() {
        return customer;
    }

    public String getStatus() {
        return status;
    }

    public void createCustomer() {
        System.out.println("customer data: " + customer.toString());
        customerFacade.create(customer);
        status = "Customer " + customer.getName() + " created.";
    }

}
