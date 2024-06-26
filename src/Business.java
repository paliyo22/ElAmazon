import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class Business extends Account{
    private LinkedHashSet<Product> productList;
    /* Se puede agregar un registro de ventas analizar */

    public Business(String name, String username, String password, Address address, String mail, String number) {
        super(name, username, password, address, mail, number);
        this.productList=new LinkedHashSet<>();

    }
    public Business(Long id,String name, String username, String password, Address address, String mail, String number,
                    Boolean status,LinkedHashSet<Product> productList) {
        super(name, username, password, address, mail, number, status,id);
        this.productList=productList;
    }
    public void addProduct(Product product){
        this.productList.add(product);
    }
    public LinkedHashSet<Product> getProductList(){
        return productList;
    }
    public Product getProduct(int i){
        Iterator<Product> it=productList.iterator();
        int aux=1;
        while (aux!=i){
            aux++;
            it.next();
        }
        return it.next();
    }

    /**
     * hacer una clase generica de hash set asi no creo el traspaso en todos lados
     */
}
