package com.company;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class CustomerTest{

    @Test
    public void shouldCalculateBalance(){
        Customer customer = new Customer();
        //List<AccountRecord> customerAccounts = new ArrayList<>(); //might need to be customer types
        AccountRecord accountRecord = new AccountRecord();
        AccountRecord accountRecord2 = new AccountRecord();

        customer.setId(5);
        customer.setName("Comp 123");

        accountRecord.setCharge(27000);

        accountRecord2.setCharge(-15000);

        customer.addCharge(accountRecord);
        customer.addCharge(accountRecord2);

        assertEquals(12000, customer.getBalance());
    }
    @Test
    public void shouldDisplayToString(){
        Customer customer = new Customer();

        customer.setId(5);
        customer.setName("Comp 123");

        assertEquals("id:5 Comp 123 has a balance of 0",customer.toString());
    }

}