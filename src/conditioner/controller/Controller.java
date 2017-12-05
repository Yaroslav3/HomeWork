package conditioner.controller;

import conditioner.dao.DaoConditioners;
import conditioner.dao.impl.DaoConditionersImpl;

public class Controller {
    public static void main(String[] args) {
        DaoConditioners dao = new DaoConditionersImpl();
        dao.show();
    }
}
