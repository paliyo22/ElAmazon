import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class Business extends Account{
    private LinkedHashSet<Product> productList;
    /* Se puede agregar un registro de ventas analizar */

    public Business(String name, String password, Address address, String mail, Long number) {
        super(name, password, address, mail, number);
        this.productList=new LinkedHashSet<>();

    }
    public Business(Long id,String name, String username, Address address, String mail, Long number,
                    Boolean status,LinkedHashSet<Product> productList) {
        super(name, username, address, mail, number, status,id);
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
