package com.jupiter.car.hire.inventories;

import com.jupiter.car.hire.beans.Address;
import com.jupiter.car.hire.beans.Customer;
import com.jupiter.car.hire.enums.CustomerType;

import java.sql.*;

public class AddressInventoryImpl implements AddressInventory{

    private static Connection con;
    private boolean hasData = false;
    SystemAndNetworkProperties systemAndNetworkProperties = SystemAndNetworkProperties.getInstance();

    public Address getAddressById(long addressId){
        Address address = new Address();
        Customer customer = new Customer();
        if (!isConnectionValid()){
            getConnection();
        }
        try {
            String findQuery ="SELECT * FROM ADDRESS a WHERE a.ADDRESS_ID = "+ addressId;
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(findQuery);
            while (rs.next()) {
                address.setAddressId(rs.getInt(1));
                address.setHouseNumber(rs.getString(2));
                address.setHouseName(rs.getString(3));
                address.setAddress1(rs.getString(4));
                address.setAddress2(rs.getString(5));
                customer.setCustomerType(CustomerType.valueOf(rs.getString(5)));
                address.setTown(rs.getString(6));
                address.setPostcode(rs.getString(7));

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

        return address;
    }

    public long saveAddress(Address address){
        long addressId =0;

        if (!isConnectionValid()){
            getConnection();
        }

        try {

            String saveQuery ="Insert into ADDRESS_INVENTORY a (" +
                    " a.HOUSE_NUMBER," +
                    " a.HOUSE_NAME," +
                    " a.ADDRESS_1," +
                    " a.ADDRESS_1," +
                    " a.POST_TOWN," +
                    " a.POST_CODE" +
                    " ) values(?,?,?,?,?,?);";
            PreparedStatement preparedStatement = con.prepareStatement(saveQuery, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, address.getHouseNumber());
            preparedStatement.setString(2, address.getHouseName());
            preparedStatement.setString(3, address.getAddress1());
            preparedStatement.setString(4, address.getAddress2());
            preparedStatement.setString(5, address.getTown());
            preparedStatement.setString(6, address.getPostcode());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                addressId =  rs.getInt(1);
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
        return addressId;

    }

    public void updateAddress(Address address){
        if (!isConnectionValid()){
            getConnection();
        }

        try {

            String saveQuery ="Insert into ADDRESS_INVENTORY a (" +
                    " a.HOUSE_NUMBER =?," +
                    " a.HOUSE_NAME = ?," +
                    " a.ADDRESS_1 = ?," +
                    " a.ADDRESS_2 = ?," +
                    " a.POST_TOWN =?," +
                    " a.POST_CODE =?" +
                    " WHERE a.ADDRESS_ID = " + address.getAddressId() + ";";
            PreparedStatement preparedStatement = con.prepareStatement(saveQuery);

            preparedStatement.setString(1, address.getHouseNumber());
            preparedStatement.setString(2, address.getHouseName());
            preparedStatement.setString(3, address.getAddress1());
            preparedStatement.setString(4, address.getAddress2());
            preparedStatement.setString(5, address.getTown());
            preparedStatement.setString(6, address.getPostcode());

            preparedStatement.execute();

        }catch(java.sql.SQLException jse){
            jse.printStackTrace();
        } finally {
            try {
                con.close();
            } catch(java.sql.SQLException jse){
                jse.printStackTrace();
            }
        }


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
                String addressInitQuery = "SELECT name FROM sqlite_master WHERE type ='table' and NAME = 'ADDRESS_INVENTORY'";
                Statement statement = con.createStatement();
                ResultSet rs = statement.executeQuery(addressInitQuery);
                if (!rs.next()) {
                    String createCustomerTableSQL = "CREATE TABLE ADDRESS_INVENTORY (" +
                            " ADDRESS_ID INTEGER," +
                            " HOUSE_NUMBER varchar2(20),"+
                            " HOUSE_NAME varchar2(20)," +
                            " ADDRESS_1 varchar2(20)," +
                            " ADDRESS_2 varchar2(20)," +
                            " POST_TOWN varchar2(20)," +
                            " POST_TOWN varchar2(20)," +
                            " POST_CODE varchar2(20)," +
                            " ADDRESS_ID INTEGER," +
                            " PRIMARY KEY (ADDRESS_ID)" +
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
