package conditioner.data;

import conditioner.model.Conditioners;

import java.util.ArrayList;
import java.util.List;

public class Database {


    public static List<Conditioners<String>> getAllConditions() {
        List<Conditioners<String>>list = new ArrayList<>();
        list.add(new Conditioners<>("[Off]","Toshiba"));
        list.add(new Conditioners<>("[Off]","LG"));
        list.add(new Conditioners<>("[Off]","Cooper&Hunter"));
        list.add(new Conditioners<>("[Off]","Toshiba"));
        list.add(new Conditioners<>("[Off]","Samsung"));
        list.add(new Conditioners<>("[Off]","Cooper&Hunter"));
        list.add(new Conditioners<>("[Off]","LG"));
        list.add(new Conditioners<>("[Off]","Samsung"));
        list.add(new Conditioners<>("[Off]","LG"));
        list.add(new Conditioners<>("[Off]","Cooper&Hunter"));
        list.add(new Conditioners<>("[Off]","Samsung"));
        list.add(new Conditioners<>("[Off]","Cooper&Hunter"));
        list.add(new Conditioners<>("[Off]","LG"));
        return list;

    }
}
