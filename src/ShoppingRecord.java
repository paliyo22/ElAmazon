import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class ShoppingRecord {
    private Instant date;
    private Instant deliver;
    private ArrayList<Product> shoppingList;
    public ShoppingRecord() {
        this.shoppingList = new ArrayList<>();
    }
    public ShoppingRecord(Instant date, Instant deliver, ArrayList<Product> shoppingList) {
        this.date = date;
        this.deliver = deliver;
        this.shoppingList = shoppingList;
    }

    /** SETTERS */
    private void setDate(){
        date=Instant.now();
    }
    private void setDeliver(Integer days) {
        this.deliver = date.plus(days, ChronoUnit.DAYS);
    }

    /** GETTERS */
    public String getDate() {
        return LocalDateTime.ofInstant(date,
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
    public Double total(){
        Double aux = (double) 0;
        for (Product i : shoppingList){
            aux+=i.getPrice();
        }
        return aux;
    }
    public void endPurchase(){
        setDate();
        int aux=0;
        for (Product i : shoppingList){
            if(i.getDaysToDeliver()>aux){
                aux=i.getDaysToDeliver();
            }
        }
        setDeliver(aux);
    }

    /** STRINGS PARA LOS PRINTEOS */
    public String productList(){
        StringBuilder aux= new StringBuilder();
        for (Product i: shoppingList){
            aux.append(i.toString());
        }
        return aux.toString();
    }
    @Override
    public String toString() {
        return "Fecha: "+ date +
                "\tEntrega: " + deliver +
                "\tTotal: " + this.total()+ "\n";
    }
}
