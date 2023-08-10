package bo;

public class BoFactory {
    private static BoFactory boFactory;

    private BoFactory(){}

    public static BoFactory gertBoFactory(){
        if(boFactory==null){
            return boFactory=new BoFactory();
        }else{
            return boFactory;
        }
    }

    public SuperBO getBo(BoTypes boTypes){
        switch(boTypes){
            case LOGIN:
                return new LoginBoImpl();
            case ITEM:
                return new ItemBoimpl();
            default:
                return null;
        }
    }
    public enum BoTypes{
        LOGIN,ITEM
    }
}
