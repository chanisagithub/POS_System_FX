package bo;

import bo.custom.impl.CustomerBoImpl;
import bo.custom.impl.ItemBoImpl;
import bo.custom.impl.LoginBoImpl;
import bo.custom.impl.OrderbBoImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){}

    public static BOFactory getBoFactory(){
        if(boFactory==null){
            return boFactory=new BOFactory();
        }else{
            return boFactory;
        }
    }

    public SuperBO getBo(BoTypes boTypes){
        switch(boTypes){
            case LOGIN:
                return new LoginBoImpl();
            case ITEM:
                return new ItemBoImpl();
            case CUSTOMER:
                return new CustomerBoImpl();
            case ORDER:
                return new OrderbBoImpl();
            default:
                return null;
        }
    }
    public enum BoTypes{
        LOGIN,ITEM,CUSTOMER,ORDER
    }
}
