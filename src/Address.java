public class Address {
    private ECountry country;
    private String state;
    private Integer postCode;
    private String street;
    private String floor;
    public Address(ECountry country, String state, Integer postCode, String street, String floor) {
        this.country = country;
        this.state = state;
        this.postCode = postCode;
        this.street = street;
        this.floor = floor;
    }

    public ECountry getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public Integer getPostCode() {
        return postCode;
    }

    public void setPostCode(Integer postCode) {
        this.postCode = postCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public void setCountry(ECountry country) {
        this.country = country;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Address:" +
                "\n\tcountry: " + country +
                "\n\tstate: " + state +
                "\n\tpostCode: " + postCode +
                "\n\tstreet: " + street +
                "\n\tfloor: " + floor;
    }
}
