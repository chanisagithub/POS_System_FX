package dao;

import dao.custom.LoginDAO;
import dao.custom.impl.ItemDAOImpl;
import dao.custom.impl.LoginDAOImpl;

import java.sql.PreparedStatement;

public class DAOFactory {
    private static DAOFactory daoFactory;

    public enum DAOTypes{
        LOGIN,
        ITEM
    }


    public static DAOFactory getDaoFactory(){
        if(daoFactory==null){
            return daoFactory=new DAOFactory();
        }else{
            return daoFactory;
        }
    }

    public SuperDAO getDAO(DAOTypes daoTypes){
        switch (daoTypes){
            case LOGIN:
                return new LoginDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
            default:
                return null;
        }
    }
    private DAOFactory(){}
}
