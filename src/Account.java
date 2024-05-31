import java.util.HashSet;

public abstract class Account {
    private String name;
    private Address address;
    private String mail;
    private String number;
    private Boolean status;

    public Account(String name, Address address, String mail, String number) {
        this.name = name;
        this.address = address;
        this.mail = mail;
        this.number = number;
        this.status=true;
    }

    public Account(String name, Address address, String mail, String number, Boolean status) {
        this.name = name;
        this.address = address;
        this.mail = mail;
        this.number = number;
        this.status = status;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    /**
     * Falta getter y setter de Address
     */
}
