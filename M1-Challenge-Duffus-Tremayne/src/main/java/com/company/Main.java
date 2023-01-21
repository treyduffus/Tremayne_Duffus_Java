package com.company;

import java.util.*;

public class Main {

    private static List<String[]> customerData = Arrays.asList(
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","-7500","01-10-2022"},
            new String[] {"1","Wayne Enterprises","18000","12-22-2021"},
            new String[] {"3","Ace Chemical","-48000","01-10-2022"},
            new String[] {"3","Ace Chemical","-95000","12-15-2021"},
            new String[] {"1","Wayne Enterprises","175000","01-01-2022"},
            new String[] {"1","Wayne Enterprises","-35000","12-09-2021"},
            new String[] {"1","Wayne Enterprises","-64000","01-17-2022"},
            new String[] {"3","Ace Chemical","70000","12-29-2022"},
            new String[] {"2","Daily Planet","56000","12-13-2022"},
            new String[] {"2","Daily Planet","-33000","01-07-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","33000","01-17-2022"},
            new String[] {"3","Ace Chemical","140000","01-25-2022"},
            new String[] {"2","Daily Planet","5000","12-12-2022"},
            new String[] {"3","Ace Chemical","-82000","01-03-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"}
    );
/*
iterate through list
match based on id
*/
    public static void main(String[] args) {
        //Update this
        Set<Integer> ids_Seen = new HashSet<Integer>();
        List<Customer> customers = new ArrayList<Customer>();

        //NEED TO ADD UNIT TESTING

        for (int i = 0; i < customerData.size(); i++){
           if (!ids_Seen.contains(Integer.parseInt(customerData.get(i)[0]))) {
               //make new customer object
               Customer temp = new Customer();
               temp.setId(Integer.parseInt(customerData.get(i)[0]));
               temp.setName(customerData.get(i)[1]);

               //instantiate account record class and add info

               AccountRecord tempC = new AccountRecord();
               tempC.setCharge(Integer.parseInt(customerData.get(i)[2]));
               tempC.setChargeDate(customerData.get(i)[3]);
               temp.addCharge(tempC);
               customers.add(temp);

               //add id to seen
               ids_Seen.add(Integer.parseInt(customerData.get(i)[0]));

               }
           else{// for accounts already seen make new charges
               for (Customer curr : customers){
                   if (curr.getId() == Integer.parseInt(customerData.get(0)[0])){
                       AccountRecord tempC = new AccountRecord();
                       tempC.setCharge(Integer.parseInt(customerData.get(i)[2]));
                       tempC.setChargeDate(customerData.get(i)[3]);
                       curr.addCharge(tempC);
                   }
               }
           }
        }
        System.out.println("\nPositive accounts:");
        for (Customer curr : customers){
           if (curr.getBalance() > 0){
               System.out.println(curr.getName());
           }
        }
        System.out.println("\nNegative accounts:");
        for (Customer curr : customers){
            if (curr.getBalance() < 0){
                System.out.println(curr.getName());
            }
        }
    }
}
