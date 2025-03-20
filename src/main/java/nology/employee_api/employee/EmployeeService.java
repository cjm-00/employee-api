package nology.employee_api.employee;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;
    private ModelMapper mapper;

    public EmployeeService(EmployeeRepository repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public List<Employee> getAll() {
        return this.repo.findAll();
    }

    public Optional<Employee> getById(Long id) {
        return this.repo.findById(id);
    }

    public Employee createEmployee(CreateEmployeeDTO data) {
        Employee newEmployee = mapper.map(data, Employee.class);
        return this.repo.save(newEmployee);
    }
}
