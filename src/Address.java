import java.util.Objects;

public class Address {
    private ECountry country;
    private Integer postCode;
    private String street;
    public Address(ECountry country, Integer postCode, String street) {
        this.country = country;
        this.postCode = postCode;
        this.street = street;
    }

    public ECountry getCountry() {
        return country;
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

    public void setCountry(ECountry country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return  "\nPais: " + country +
                "\nCodigo Postal: " + postCode +
                "\nCalle: " + street;


    }
}
