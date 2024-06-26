import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Amazon implements Serializable {
    private ArrayList<Product> productList;
    private HashSet<Account> accountList;

    public Amazon() {
        productList=new ArrayList<>();
        accountList=new HashSet<>();
    }
    public Amazon(ArrayList<Product> productList, HashSet<Account> accountList) {
        this.productList = productList;
        this.accountList = accountList;
    }
    public boolean addAccount(Account account){
        boolean aux;
        aux=accountList.add(account);
        return aux;
    }
    public boolean mailExist(String mail){
        boolean aux = false;
        for (Account account : accountList) {
            if (account.getMail().equals(mail)) {
                aux = true;
                break;
            }
        }
        return aux;
    }
}
