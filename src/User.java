import java.util.ArrayList;
import java.util.LinkedList;

public class User extends Account{
    private final Integer dni;
    private ArrayList<ShoppingRecord> purchaseList;

    /* Creacion de Cuenta*/
    public User(String name, String password, Address address, String mail, Long number,
                Integer dni) {
        super(name, password, address, mail, number);
        this.dni = dni;
        this.purchaseList = new ArrayList<>();
    }
    /* Cargar Cuenta Desde Archivo*/
    public User(String name, String password, Address address, String mail, Long number, Boolean status,
                Long id, Integer dni, ArrayList<ShoppingRecord> shoppingList) {
        super(name, password, address, mail, number, status,id);
        this.dni = dni;
        this.purchaseList = shoppingList;
    }
    public void addPurchase(ShoppingRecord shopping){
        purchaseList.addFirst(shopping);
    }
    public String getPurchaseList(){
        StringBuilder aux= new StringBuilder();
        for (ShoppingRecord i: purchaseList){
            aux.append(i.toString());
        }
        return aux.toString();
    }
    public String getShoppingRecord(int number){
        number-=1;
        return purchaseList.get(number).productList();
    }

    @Override
    public String toString() {
        return  "Dni: " + dni +
                super.toString();

    }
}
