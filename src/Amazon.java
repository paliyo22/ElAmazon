import java.util.ArrayList;
import java.util.HashSet;

public class Amazon {
    private ArrayList<Product> productList;
    private HashSet<Account> accountList;

    public Amazon(ArrayList<Product> productList, HashSet<Account> accountList) {
        this.productList = productList;
        this.accountList = accountList;
    }
}
