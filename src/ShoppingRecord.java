import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class ShoppingRecord {
    private Instant purchase;
    private Instant deliver;
    private ArrayList<Product> shoppingList;
    public ShoppingRecord() {
        this.shoppingList = new ArrayList<>();
    }
    public ShoppingRecord(Instant purchase, Instant deliver, ArrayList<Product> shoppingList) {
        this.purchase = purchase;
        this.deliver = deliver;
        this.shoppingList = shoppingList;
    }

    /** SETTERS */
    private void setPurchase(){
        purchase=Instant.now();
    }
    private void setDeliver(Integer days) {
        this.deliver = purchase.plus(days, ChronoUnit.DAYS);
    }

    /** GETTERS */
    public String getPurchase() {
        return LocalDateTime.ofInstant(purchase,
                ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss"));
    }
    public String getDeliver() {
        return LocalDateTime.ofInstant(deliver,
                ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss"));
    }
    public ArrayList<Product> getShoppingList() {
        return shoppingList;
    }

    /** METODOS */
    public void addProduct(Product product){
        shoppingList.add(product);
    }
    public void deleteProduct(int i){ /*ver si cambiarlo a recibir producto*/
        shoppingList.remove(i);
    }

}
