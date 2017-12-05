package conditioner.service.impl;

import conditioner.model.Conditioners;
import conditioner.service.ServiceConditioners;

import java.util.List;

public class ServiceConditionersImpl implements ServiceConditioners {
    @Override
    public List<Conditioners> getAllConditioners() {
        ServiceConditioners serviceConditioners = new ServiceConditionersImpl();
        return serviceConditioners.getAllConditioners();
    }
}
