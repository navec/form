package fr.arolla.jour2;

import com.ibm.mainframe.WdkRefCustContainerRoot;
import java.util.Optional;

/**
 *
 */
public class Customers {

    public Customer retrieveByCardNumber(String cardNumber){
        return Optional.ofNullable(WdkRefCustContainerRoot.getInstance().get(cardNumber))
                .map(c -> new Customer(c.getField01(),c.getField02(),c.getField03(),c.getField04()))
                .get();
    }
}
