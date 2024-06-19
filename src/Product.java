import java.util.Objects;

public class Product {
    private static long autoInc=0;
    private final Long id;
    private final Long businessId;
    private String name;
    private Integer Stock;
    private Double price;
    private final EDepartment department;
    private Integer daysToDeliver;
    private Boolean status;

    public Product(Long businessId, String name, Integer stock, Double price,
                   EDepartment department, Integer daysToDeliver, Boolean status) {
        this.id=autoInc;
        this.businessId = businessId;
        this.name = name;
        Stock = stock;
        this.price = price;
        this.department = department;
        this.daysToDeliver = daysToDeliver;
        this.status = status;
        autoInc++;
    }

    public Product(Long id, Long businessId, String name, Integer stock, Double price,
                   EDepartment department, Integer daysToDeliver, Boolean status) {
        this.id = id;
        this.businessId = businessId;
        this.name = name;
        Stock = stock;
        this.price = price;
        this.department = department;
        this.daysToDeliver = daysToDeliver;
        this.status = status;
        if(id>=autoInc){
            autoInc=++id;
        }
    }

    /** GETTERS */

    /** SETTERS */
    public void setName(String name) {
        this.name = name;
    }
    public void setStock(Integer stock) {
        Stock = stock;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public void setDaysToDeliver(Integer daysToDeliver) {
        this.daysToDeliver = daysToDeliver;
    }
    /** METODOS */
    public void changeStatus() {
        status = !status;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return Objects.equals(id, product.id) && Objects.equals(businessId, product.businessId);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, businessId);
    }
}
