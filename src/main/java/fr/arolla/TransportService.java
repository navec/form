package fr.arolla;

import com.ibm.mainframe.WdkRefCustContainerRoot;
import com.ibm.mainframe.WdkRefCustInformations;

/**
 *
 */
public class TransportService {

    private WdkRefCustContainerRoot wdkRefCustContainerRoot;

    public TransportService(){
        this.wdkRefCustContainerRoot = WdkRefCustContainerRoot.getInstance();
    }

    public Journey receive(Journey journey) {

        WdkRefCustInformations info = this.wdkRefCustContainerRoot.get(journey.getId());
        Price travelPrice = new Price(9999);

        if(journey.getType().equals("1")){
            travelPrice.setCents(110);
        }
        if(journey.getType().equals("2")){
            travelPrice.setCents(125);
        }
        if(journey.getType().equals("3")){
            travelPrice.setCents(130);
        }
        if(journey.getType().equals("4")){
            travelPrice.setCents(240);
        }
        if(journey.getType().equals("5")){
            travelPrice.setCents(650);
        }
        if(journey.getType().equals("6")){
            travelPrice.setCents(800);
        }

        if(travelPrice.getCents()==9999){
            throw new IllegalArgumentException("invalid journey type");
        }

        journey.setPrice(travelPrice);
        setDiscount(info,journey,travelPrice);
        return journey;
    }


    private void setDiscount(WdkRefCustInformations info, Journey journey, Price travelPrice) {
        if(info.getField03().equals("P4")){
            travelPrice.setCents(travelPrice.getCents()-travelPrice.getCents()*10/100);
        }
        if(info.getField03().equals("P3")){
            travelPrice.setCents(travelPrice.getCents()-travelPrice.getCents()*5/100);
        }
        if(info.getField03().equals("P2")){
            travelPrice.setCents(travelPrice.getCents()-travelPrice.getCents()*3/100);
        }
        if(info.getField03().equals("P1")){
            travelPrice.setCents(travelPrice.getCents());
        }
        journey.setBillablePrice(travelPrice);
    }

}
