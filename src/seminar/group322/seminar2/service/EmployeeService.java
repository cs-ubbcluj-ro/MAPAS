package seminar.group322.seminar2.service;

import seminar.group322.seminar2.domain.Employee;
import seminar.group322.seminar2.domain.RepositoryException;
import seminar.group322.seminar2.repository.Repository;

public class EmployeeService {
    private final Repository repo;

    public EmployeeService(Repository repo) {
        this.repo = repo;
    }

    public void addEmployee(Employee e) throws RepositoryException {
        this.repo.add(e);
    }

    public Employee getEmployee(int id) {
        return (Employee) repo.find(id);
    }

    @Override
    public String toString() {
        return "EmployeeService{" +
                "repo=" + repo +
                '}';
    }
}
