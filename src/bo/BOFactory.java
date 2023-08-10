package bo;

import bo.custom.impl.ItemBoImpl;
import bo.custom.impl.LoginBoImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){}

    public static BOFactory gertBoFactory(){
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
            default:
                return null;
        }
    }
    public enum BoTypes{
        LOGIN,ITEM
    }
}
