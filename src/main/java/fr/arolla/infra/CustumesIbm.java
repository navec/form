package fr.arolla.infra;

import com.ibm.mainframe.WdkRefCustContainerRoot;
import com.ibm.mainframe.WdkRefCustInformations;
import fr.arolla.core.Custumer;
import fr.arolla.core.Custumers;
import fr.arolla.core.ProfileCustomer;

/**
 * Created by lenovo_9 on 10/04/2018.
 */
public class CustumesIbm implements Custumers {

    private WdkRefCustContainerRoot wdkRefCustContainerRoot;

    public CustumesIbm(){
        this.wdkRefCustContainerRoot = WdkRefCustContainerRoot.getInstance();
    }
    public Custumer get(String cardNumber) {
        WdkRefCustInformations info = this.wdkRefCustContainerRoot.get(cardNumber);
        ProfileCustomer profileCustomer = ProfileCustomer.form(info.getField03());
        return new Custumer(info.getField01(), info.getField02(), profileCustomer, info.getField04());
    }
}
