package conditioner.dao;

import conditioner.model.Conditioners;

import java.util.ArrayList;
import java.util.List;

public interface DaoConditioners {

    void getStatusConditioners();
    List<Conditioners<String>> setTemperature(ArrayList<Integer> index, ArrayList<Integer> temp);
    List<Conditioners<String>> turnOn(int indexOn);
    List<Conditioners<String>> turnOff(int indexOff);
    void show();

}
