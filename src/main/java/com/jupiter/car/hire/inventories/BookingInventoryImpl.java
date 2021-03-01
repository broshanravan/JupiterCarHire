package com.jupiter.car.hire.inventories;

import com.jupiter.car.hire.beans.Address;
import com.jupiter.car.hire.beans.Booking;
import com.jupiter.car.hire.beans.Customer;
import com.jupiter.car.hire.enums.CustomerType;

import java.sql.*;

public class BookingInventoryImpl implements BookingInventory{

    private static Connection con;
    private boolean hasData = false;
    AddressInventory addressInventory = new AddressInventoryImpl();
    SystemAndNetworkProperties systemAndNetworkProperties = SystemAndNetworkProperties.getInstance();

    /**
     * usef bookingNumber to
     * find existing booking
     * @param bookingReference
     * @return
     */
    public Booking retrieveBookingByRefNumber(long bookingReference){
        Booking booking = new Booking();

        if (!isConnectionValid()){
            getConnection();
        }
        try {
            String findQuery ="SELECT * FROM BOOKING b WHERE b.BOOKING_ID  = '" + bookingReference + "'";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(findQuery);
            while (rs.next()) {
                booking.setBookingId(rs.getInt(1));
                booking.setCustomerId(rs.getInt(2));
                booking.setVehicleId(rs.getInt(3));
                booking.setStartDate(rs.getDate(5));
                booking.setEndDate(rs.getDate(5));
                booking.setDeposit(rs.getDouble(6));
                booking.setTotalPrice(rs.getDouble(7));
                boolean damaged =false;
                int damagedFlag = rs.getInt(8);
                if(damagedFlag ==1){
                    damaged =true;
                }

                boolean closed =false;
                int closedFlag = rs.getInt(9);
                if(damagedFlag ==1){
                    closed=true;
                }
                booking.setVehicleDamaged(damaged);
                booking.setClosed(closed);

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


        return booking;
    }

    /**
     * Retrieves bookingDetails
     * from DB using the vehicle Registration
     * @param carReg
     * @return
     */
    public Booking retrieveBookingByCarReg(String carReg){
        Booking booking = new Booking();


        return booking;
    }


    /**
     * creates new booking
     * @param booking
     * @return
     */
    public long createNewBooking(Booking booking){

        long bookingRef = 0;

        if (!isConnectionValid()){
            getConnection();
        }

        try {

            String saveQuery ="Insert into  BOOKINGS(" +
                            " CUSTOMER_ID," +
                            " VEHICLE_ID," +
                            " START_DATE," +
                            " DEPOSIT," +
                            " DAMAGED " +
                            ")"+
                    " TEL_NUM) values(?,?,?,?,?);";
            PreparedStatement preparedStatement = con.prepareStatement(saveQuery, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setLong(1, booking.getCustomerId());
            preparedStatement.setLong(2, booking.getVehicleId());
            long millis=System.currentTimeMillis();
            preparedStatement.setDate(3, new java.sql.Date(millis));
            preparedStatement.setDouble(4, booking.getDeposit());
            int damaged = 0;
            if(booking.isVehicleDamaged()){
                damaged = 1;
            }

            preparedStatement.setLong(6, damaged);

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                bookingRef =  rs.getInt(1);
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


        return bookingRef;

    }

    /**
     * closes booking after payment is completed
     * @param booking
     */
    public void closeBooking (Booking booking){
        if (!isConnectionValid()){
            getConnection();
        }
        try {

            String closeQuery = "UPDATE  BOOKINGS set(" +
                            " CLOSED =?," +
                            " END_DATE =?" +
                            ") where  BOOKING_ID =" + booking.getBookingId() + ";";
            PreparedStatement preparedStatement = con.prepareStatement(closeQuery, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setLong(1, 1);

            long millis=System.currentTimeMillis();
            preparedStatement.setDate(2, new java.sql.Date(millis));

            preparedStatement.executeUpdate();

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
     * updates booking details
     * @param booking
     */
    public void updateNewBooking(Booking booking){
        if (!isConnectionValid()){
            getConnection();
        }

        try {
            String saveQuery ="UPDATE  BOOKINGS set(" +

                    " VEHICLE_ID = ?," +
                    " START_DATE =?," +
                    " DEPOSIT = ?," +
                    " TOTAL_PRICE = ?," +
                    " DAMAGED = ? " +
                    ") where  BOOKING_ID =" + booking.getBookingId() + ";";
            PreparedStatement preparedStatement = con.prepareStatement(saveQuery, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setLong(1, booking.getVehicleId());
            long millis=System.currentTimeMillis();
            preparedStatement.setDate(2, new java.sql.Date(millis));
            preparedStatement.setDouble(3, booking.getDeposit());
            preparedStatement.setDouble(4, booking.getTotalPrice());

            int damaged = 0;
            if(booking.isVehicleDamaged()){
                damaged = 1;
            }

            preparedStatement.setLong(5, damaged);

            preparedStatement.executeUpdate();

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
                    String createCustomerTableSQL = "CREATE TABLE BOOKINGS(" +
                            " BOOKING_ID INTEGER," +
                            " CUSTOMER_D INTEGER," +
                            " VEHICLE_ID INTEGER," +
                            " START_DATE DATE," +
                            " END_DATE DATE," +
                            " DEPOSIT DECIMAL," +
                            " TOTAL_PRICE DECIMAL," +
                            " DAMAGED INTEGER" +
                            " CLOSED INTEGER" +
                            " PRIMARY KEY (BOOKING_ID)"+
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
