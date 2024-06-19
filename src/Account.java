import java.util.HashSet;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Account {
    private static long autoInc=0;
    private final Long id;
    private String name;
    private Address address;
    private String mail;
    private String number;
    private Boolean status;

    public Account(String name, Address address, String mail, String number) {
        this.id=autoInc;
        this.name = name;
        this.address = address;
        this.mail = mail;
        this.number = number;
        this.status=true;
        autoInc++;
    }

    public Account(String name, Address address, String mail, String number, Boolean status,Long id) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.mail = mail;
        this.number = number;
        this.status = status;
        if(id>=autoInc){
            autoInc=++id;
        }
    }

    /** GETTERS */
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getMail() {
        return mail;
    }
    public String getNumber() {
        return number;
    }
    public Boolean getStatus() {
        return status;
    }
    public Address getAddress(){
        return address;
    }

    /** SETTERS */
    public void setName(String name) {
        this.name = name;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public void setAddress(Address address){
        this.address=address;
    }

    /** METODOS */
    public void changeStatus() {
        status = !status;
    }
    /* vailda email*/
    public Boolean emailValidation (String email) {
        Pattern pattern = Pattern.compile("^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account account)) return false;
        return Objects.equals(id, account.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
