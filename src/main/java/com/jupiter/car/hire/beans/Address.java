package com.jupiter.car.hire.beans;

public class Address {
    private long addressId;
    private String houseName;
    private String houseNumber;
    private String address1;
    private String address2;
    private String town;
    private String postcode;


    public Address(String houseName, String houseNumber, String address1, String address2, String town, String postcode) {
        this.houseName = houseName;
        this.houseNumber = houseNumber;
        this.address1 = address1;
        this.address2 = address2;
        this.town = town;
        this.postcode = postcode;
    }

    /**
     * retrieves address ID
     * @return
     */
    public long getAddressId() {
        return addressId;
    }

    /**
     * Address ID to be set
     * @param addressId
     */
    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    /**
     * retrieves house number
     * @return
     */
    public String getHouseName() {
        return houseName;
    }

    /**
     * house numjber to be set
     * @param houseName
     */
    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    /**
     * retrieves house name
     * @return
     */
    public String getHouseNumber() {
        return houseNumber;
    }

    /**
     * house name to be set
     * @param houseNumber
     */
    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    /**
     *
     * @return
     */
    public String getAddress1() {
        return address1;
    }

    /**
     *
     * @param address1
     */
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    /**
     *
     * @return
     */
    public String getAddress2() {
        return address2;
    }

    /**
     *
     * @param address2
     */
    public void setAddress2(String address2) {
        this.address2 = address2;
    }


    /**
     *
     * @return
     */
    public String getTown() {
        return town;
    }

    /**
     *
     * @param town
     */
    public void setTown(String town) {
        this.town = town;
    }

    /**
     *
     * @return
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     *
     * @param postcode
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}
