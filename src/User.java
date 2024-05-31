import java.util.LinkedList;

public class User extends Account{
    private static long autoInc=0;
    private final Long id;
    private final Integer dni;
    private Double maxExpense; /*la compra no puede ser mayor, se puede cambiar*/
    private Double money; /*plata que todavia puede gastar se reinicia cada mes*/
    private LinkedList<ShoppingRecord> shoppingList;

    /* Creacion de Cuenta*/
    public User(String name, Address address, String mail, String number,
                Integer dni, Double maxExpense) {
        super(name, address, mail, number);
        this.id = autoInc;
        this.dni = dni;
        this.maxExpense = maxExpense;
        this.money = maxExpense;
        this.shoppingList = new LinkedList<>();
        autoInc++;
    }
    /* Cargar Cuenta Desde Archivo*/
    public User(String name, Address address, String mail, String number, Boolean status,
                Long id, Integer dni, Double maxExpense, Double money,
                LinkedList<ShoppingRecord> shoppingList) {
        super(name, address, mail, number, status);
        this.id = id;
        this.dni = dni;
        this.maxExpense = maxExpense;
        this.money = money;
        this.shoppingList = shoppingList;
        if(id>=autoInc){
            autoInc=++id;
        }
    }
}
