package com.jupiter.car.hire.inventories;

import com.jupiter.car.hire.beans.Address;
import com.jupiter.car.hire.beans.Customer;
import com.jupiter.car.hire.enums.CustomerType;

import java.sql.*;

public class CustomerInventoryImpl implements CustomerInventory{
    private static Connection con;
    private boolean hasData = false;
    AddressInventory addressInventory = new AddressInventoryImpl();
    SystemAndNetworkProperties systemAndNetworkProperties = SystemAndNetworkProperties.getInstance();

    public CustomerInventoryImpl(){

    }


    public Customer retrieveCustomerByEmail(String customerEmail){

        Customer customer = new Customer();
        if (!isConnectionValid()){
            getConnection();
        }
        try {
            String findQuery ="SELECT * FROM CUSTOMER_INVENTORY c WHERE c.CUSTOMER_EMAIL = '" + customerEmail + "'";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(findQuery);
            while (rs.next()) {
                customer.setCustomerId(rs.getInt(1));
                customer.setFirstName(rs.getString(2));
                customer.setSurname(rs.getString(3));
                customer.setCompanyName(rs.getString(4));
                customer.setCustomerType(CustomerType.valueOf(rs.getString(5)));
                customer.setEmail(rs.getString(5));
                long addressId = rs.getLong(6);
                Address address = addressInventory.getAddressById(addressId);
                customer.setAddress(address);

            }
        }catch(java.sql.SQLException jse){
            jse.printStackTrace();
        } finally {
            try {
                con.close();
            } catch(java.sql.SQLException jse){
                jse.printStackTrace();
            }
        }

        return customer;
    }

    /**
     * insert new customer details to the customer table
     * @param customer
     * @return
     */
    public long createNewCustomer(Customer customer){
        long customerId =0;
        if (!isConnectionValid()){
            getConnection();
        }
        long addressId = addressInventory.saveAddress(customer.getAddress() );

        try {

            String saveQuery ="Insert into CUSTOMER_INVENTORY (" +
                    " FIRST_NAME," +
                    " SURNAME," +
                    " COMPANY_NAME," +
                    " CUSTOMER_TYPE," +
                    " EMAIL" +
                    " ADDRESS_ID" +
                    " TEL_NUM) values(?,?,?,?,?,?);";
            PreparedStatement preparedStatement = con.prepareStatement(saveQuery, Statement.RETURN_GENERATED_KEYS);


            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2, customer.getSurname());
            preparedStatement.setString(3, customer.getCompanyName());
            preparedStatement.setString(5, customer.getCustomerType().toString());
            preparedStatement.setString(4, customer.getEmail());
            preparedStatement.setLong(6, addressId);

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                customerId =  rs.getInt(1);
            }

        }catch(java.sql.SQLException jse){
            jse.printStackTrace();
        } finally {
            try {
                con.close();
            } catch(java.sql.SQLException jse){
                jse.printStackTrace();
            }
        }
        return customerId;

    }

    /**
     * to update the detaild of
     * an existing customer
     * @param customer
     */
    public void updateCustomerDetails(Customer customer){
        if (!isConnectionValid()){
            getConnection();
        }
        try {
            String updateQuery =  "Insert into CUSTOMER_INVENTORY (" +
                    " FIRST_NAME," +
                    " SURNAME," +
                    " COMPANY_NAME," +
                    " CUSTOMER_TYPE," +
                    " EMAIL" +
                    " ADDRESS_ID" +
                    " TEL_NUM) values(?,?,?,?,?,?,?)  WHERE CUSTOMER_ID = " + customer.getCustomerId();
            PreparedStatement preparedStatement = con.prepareStatement(updateQuery);

            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2, customer.getSurname());
            preparedStatement.setString(3, customer.getCompanyName());
            preparedStatement.setString(5, customer.getCustomerType().toString());
            preparedStatement.setString(4, customer.getEmail());
            preparedStatement.executeUpdate();

            addressInventory.updateAddress(customer.getAddress());


        }catch(java.sql.SQLException jse){
            jse.printStackTrace();
        }finally {
            try {
                con.close();
            } catch(java.sql.SQLException jse){
                jse.printStackTrace();
            }
        }
    }





    /**
     * to find out if the customer
     * with email exists
     * @param email
     * @return
     */
    public boolean customerExists(String email){
        if (!isConnectionValid()){
            getConnection();
        }
        boolean exists = false;
        try {
            String findQuery ="SELECT * FROM CUSTOMER_INVENTORY c WHERE c.CUSTOMER_EMAIL = '" + email + "'";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(findQuery);
            if (rs.next()) {
                exists = true;
            }
        }catch(java.sql.SQLException jse){
            jse.printStackTrace();
            exists = true;
        }finally {
            try {
                con.close();
            } catch(java.sql.SQLException jse){
                jse.printStackTrace();
            }
        }


        return exists;

    }



    private void getConnection(){
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("JDBC:sqlite:" + systemAndNetworkProperties.getDBFileLocation());
            initialize();
        }catch(ClassNotFoundException cnfx){
            cnfx.printStackTrace();
        }catch(java.sql.SQLException jse){
            jse.printStackTrace();
        }

    }

    private boolean isConnectionValid() {

        if (con == null) {
            return false;
        } else {
            try {
                if (con.isClosed()) {
                    return false;
                }
            } catch (SQLException sqle) {
                return false;
            }
        }
        return true;
    }

    private void initialize(){

        if (con == null){
            getConnection();
        }
        if(!hasData){

            System.out.println("First time initialization of DB");
            try {
                String customerInitQuery = "SELECT name FROM sqlite_master WHERE type ='table' and NAME = 'CUSTOMER_INVENTORY'";
                Statement statement = con.createStatement();
                ResultSet rs = statement.executeQuery(customerInitQuery);
                if (!rs.next()) {
                    String createCustomerTableSQL = "CREATE TABLE CUSTOMER_INVENTORY (" +
                            " CUSTOMER_ID INTEGER," +
                            " FIRST_NAME varchar2(20)," +
                            " SURNAME varchar2(20)," +
                            " COMPANY_NAME varchar2(20)," +
                            " EMAIL varchar2(20)," +
                            " ADDRESS_ID INTEGER," +
                            " PRIMARY KEY (CUSTOMER_ID)" +
                            ");";
                    Statement statement_2 = con.createStatement();
                    statement_2.execute(createCustomerTableSQL);

                    hasData = true;
                }

            }catch(java.sql.SQLException jse){
                jse.printStackTrace();
            }
        }

    }

}
