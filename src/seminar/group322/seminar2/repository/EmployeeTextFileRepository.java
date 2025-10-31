package seminar.group322.seminar2.repository;

import seminar.group322.seminar2.domain.Employee;
import seminar.group322.seminar2.domain.Person;
import seminar.group322.seminar2.domain.RepositoryException;

import java.io.*;

public class EmployeeTextFileRepository extends Repository<Employee> {
    protected String fileName;

    public EmployeeTextFileRepository(String fileName) {
        this.fileName = fileName;
        try {
            loadFile();
        } catch (IOException e) {
            // Pornim un fisier nou de intrare
        } catch (RepositoryException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadFile() throws IOException, RepositoryException {
        BufferedReader br = new BufferedReader(new FileReader(this.fileName));
        String line = br.readLine();
        while (line != null) {
            // 1000, Popescu Marcel, 12345
            String[] tokens = line.split(",");
            int employee_id = Integer.parseInt(tokens[0].strip());
            String employee_name = tokens[1].strip();
            int employee_salary = Integer.parseInt(tokens[2].strip());
            add(new Employee(employee_id, employee_name, employee_salary));
            line = br.readLine();
        }
        br.close();
    }

    @Override
    public void add(Employee p) throws RepositoryException {
        super.add(p);
        try {
            saveFile();
        } catch (IOException e) {
            throw new RepositoryException(e);
        }
    }

    private void saveFile() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(this.fileName));
        for (Employee e : dataList) {
            bw.write(e.getId() + "," + e.getName() + "," + e.getSalary() + "\r\n");
        }
        bw.close();
    }

}
