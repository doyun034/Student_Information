package hansung.information.service;

import hansung.information.dao.RegisterDao;
import hansung.information.model.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterService {

    //service -> dao
    @Autowired
    private RegisterDao registerDao;

    public List<Register> getAllRegisters() {
        return registerDao.getRegisters();
    }

    public void insert(Register register) {
        registerDao.insert(register);
    }
}
