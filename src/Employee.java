import java.util.Objects;

class Employee {
    private static int nextId = 1;

    private final int id;
    private String fullName;
    private int department;
    private double salary;

    public Employee(String fullName, int department, double salary) {
        this.id = nextId++;
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        if (department >= 1 && department <= 5) {
            this.department = department;
        } else {
            throw new IllegalArgumentException("Отдел может быть от 1 до 5 включительно");
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary != 0) {
            this.salary = salary;
        } else {
            throw new IllegalArgumentException("Зарплата не может быть равной нулю");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                department == employee.department &&
                Double.compare(salary, employee.salary) == 0 &&
                Objects.equals(fullName, employee.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, department, salary);
    }

    @Override
    public String toString() {
        return "Сотрудник: " +
                "id = " + id +
                ", ФИО: " + fullName +
                ", Отдел: " + department +
                ", Зарплата: " + salary;
    }
}
