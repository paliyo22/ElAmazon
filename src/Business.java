import java.util.HashSet;
import java.util.List;

public class Business extends Account{
    private static long autoInc=0;
    private final Long id;
    private HashSet<Product> productList;
    private HashSet<Warehouse> warehouseList;
    /* Se puede agregar un registro de ventas analizar */

    public Business(String name, Address address, String mail, String number) {
        super(name, address, mail, number);
        this.id=autoInc;
        this.productList=new HashSet<>();
        this.warehouseList=new HashSet<>();
        autoInc++;
    }
    public Business(Long id,String name, Address address, String mail, String number,
                    Boolean status,HashSet<Product> productList,HashSet<Warehouse> warehouseList ) {
        super(name, address, mail, number, status);
        this.id = id;
        this.productList=productList;
        this.warehouseList=warehouseList;
        if(id>=autoInc){
            autoInc=++id;
        }
    }
    public Long getId() {
        return id;
    }
    public void addProduct(Product product){
        this.productList.add(product);
    }
    public void addWarehouse(Warehouse warehouse){
        this.warehouseList.add(warehouse);
    }
    public HashSet<Product> getProductList(){
        return productList;
    }
    /**
     * hacer una clase generica de hash set asi no creo el traspaso en todos lados
     */
}
