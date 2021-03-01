package com.jupiter.car.hire.inventories;

import com.jupiter.car.hire.beans.Address;
import com.jupiter.car.hire.beans.Customer;
import com.jupiter.car.hire.beans.Vehicle;
import com.jupiter.car.hire.enums.CustomerType;
import com.jupiter.car.hire.enums.VehicleType;

import java.sql.*;

public class VehicleInventoryImpl implements VehicleInventory {

    private static Connection con;
    private boolean hasData = false;
    AddressInventory addressInventory = new AddressInventoryImpl();
    SystemAndNetworkProperties systemAndNetworkProperties = SystemAndNetworkProperties.getInstance();

    /**
     * Retrieves vehicle details
     * using its registration number
     * @param registrationNum
     * @return
     */
    public Vehicle retrieveVehicleByReg(String registrationNum){
        Vehicle vehicle = new Vehicle();

        if (!isConnectionValid()){
            getConnection();
        }
        try {
            String findQuery ="SELECT * FROM VEHICLE v  WHERE v.REGISTRATION = '" + registrationNum + "'";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(findQuery);
            while (rs.next()) {
                vehicle.setVehicleId(rs.getInt(1));
                vehicle.setRegistration(rs.getString(2));
                vehicle.setEngineSize(rs.getInt(3));
                String type = rs.getString(4);
                vehicle.setVehicleType(VehicleType.valueOf(type));
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

        return vehicle;
    }


    /**
     * Inserts a new vehicle details
     * into the Database
     * @param vehicle
     */
    public void addNewVehicle(Vehicle vehicle){
        if (!isConnectionValid()){
            getConnection();
        }

        try {

            String saveQuery ="Insert into VEHICLE v (" +
                    " v.ENGINE_SIZE," +
                    " a.HOUSE_NAME," +
                    " a.ADDRESS_1," +
                    " a.ADDRESS_1," +
                    " a.POST_TOWN," +
                    " a.POST_CODE" +
                    " ) values(?,?,?,?,?,?);";
            PreparedStatement preparedStatement = con.prepareStatement(saveQuery, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setLong(1, vehicle.getEngineSize());
            preparedStatement.setString(2, vehicle.getRegistration());
            preparedStatement.setString(3, vehicle.getVehicleType().toString());

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

    /**
     * update the details of
     * an existing vehicle
     */
    public void updateVehicleDetail(Vehicle vehicle){
        if (!isConnectionValid()){
            getConnection();
        }

        try {

            String saveQuery ="UPDATE VEHICLE v SET (" +
                    " v.REGISTRATION = ?," +
                    " v.ENGINE_SIZE = ?"  +
                    " v.VEHICLE_TYPE = ?" +
                    " WHERE VEHICLE_ID ="+ vehicle.getVehicleId() +");";
            PreparedStatement preparedStatement = con.prepareStatement(saveQuery, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, vehicle.getRegistration());
            preparedStatement.setLong(2, vehicle.getEngineSize());;
            preparedStatement.setString(3, vehicle.getVehicleType().toString());

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

    /**
     * retrieves vehicle details
     * using its database it
     * @param vehicleId
     * @return
     */
    public Vehicle retrieveVehicleById(long vehicleId){
        Vehicle vehicle = new Vehicle();
        if (!isConnectionValid()){
            getConnection();
        }
        try {
            String findQuery ="SELECT * FROM VEHICLE v  WHERE v.VEHICLE_ID =" + vehicleId;
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(findQuery);
            while (rs.next()) {
                vehicle.setVehicleId(rs.getInt(1));
                vehicle.setRegistration(rs.getString(2));
                vehicle.setEngineSize(rs.getInt(3));
                String type = rs.getString(4);
                vehicle.setVehicleType(VehicleType.valueOf(type));
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

        return vehicle;
    }


    /**
     * creates connection to the local
     * database
     */
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
                String customerInitQuery = "SELECT name FROM sqlite_master WHERE type ='table' and NAME = 'VEHICLE'";
                Statement statement = con.createStatement();
                ResultSet rs = statement.executeQuery(customerInitQuery);
                if (!rs.next()) {
                    String createCustomerTableSQL = "CREATE TABLE VEHICLE(" +
                            " VEHICLE_ID INTEGER," +
                            " REGISTRATION varchar2(20)," +
                            " ENGINE_SIZE INTEGER," +
                            " VEHICLE_TYPE varchar2(20)," +
                            " PRIMARY KEY (VEHICLE_ID)" +
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
