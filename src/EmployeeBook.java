class EmployeeBook {
    private Employee[] employees;
    private int size;

    public EmployeeBook(int capacity) {
        this.employees = new Employee[capacity];
        this.size = 0;
    }

    public boolean addEmployee(Employee employee) {
        if (size >= employees.length) {
            System.out.println("Нет места");
            return false;
        }
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                size++;
                return true;
            }
        }
        return false;
    }

    public boolean deleteEmployee(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getId() == id) {
                employees[i] = null;
                size--;
                return true;
            }
        }
        return false;
    }

    public Employee getEmployeeById(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getId() == id) {
                return employees[i];
            }
        }
        return null;
    }

    public void printAllEmployees() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i]);
            }
        }
    }

    public double calculateTotalSalary() {
        double total = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                total += employees[i].getSalary();
            }
        }
        return total;
    }

    public void indexSalary(double percentIncrease) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                employees[i].setSalary(employees[i].getSalary() * (1 + percentIncrease / 100));
            }
        }
    }

    public void indexSalaryByDepartment(int departmentNumber, double percentIncrease) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == departmentNumber) {
                employees[i].setSalary(employees[i].getSalary() * (1 + percentIncrease / 100));
            }
        }
    }

    public Employee findMinSalaryByDepartment(int departmentNumber) {
        Employee minSalary = null;
        for (int i = 0; i < employees.length; i++) {
            if ((employees[i] != null && employees[i].getDepartment() == departmentNumber) &&
                    (minSalary == null || employees[i].getSalary() < minSalary.getSalary())) {
                minSalary = employees[i];
            }
        }
        return minSalary;
    }

    public Employee findMaxSalaryByDepartment(int departmentNumber) {
        Employee maxSalary = null;
        for (int i = 0; i < employees.length; i++) {
            if ((employees[i] != null && employees[i].getDepartment() == departmentNumber) &&
                    (maxSalary == null || employees[i].getSalary() > maxSalary.getSalary())) {
                maxSalary = employees[i];
            }
        }
        return maxSalary;
    }

    public double calculateSumSalaryByDepartment(int departmentNumber) {
        double sumSalary = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == departmentNumber) {
                sumSalary += employees[i].getSalary();
            }
        }
        return sumSalary;
    }

    public double calculateAverageSalaryByDepartment(int departmentNumber) {
        double sum = 0;
        int count = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == departmentNumber) {
                sum += employees[i].getSalary();
                count++;
            }
        }
        return count > 0 ? sum / count : 0;
    }

    public Employee findMinSalaryEmployee() {
        Employee minSalary = null;
        for (int i = 0; i < employees.length; i++) {
            if ((employees[i] != null) && (minSalary == null || employees[i].getSalary() < minSalary.getSalary())) {
                minSalary = employees[i];
                }
            }
        return minSalary;
    }

    public Employee findMaxSalaryEmployee() {
        Employee maxSalary = null;
        for (int i = 0; i < employees.length; i++) {
            if ((employees[i] != null) && (maxSalary == null || employees[i].getSalary() > maxSalary.getSalary())) {
               maxSalary = employees[i];
            }
        }
        return maxSalary;
    }

    public double calculateAverageSalary() {
        double sum = calculateTotalSalary();
        int count = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                count++;
            }
        }
        return sum / count;
    }

    public void printNamesOnly() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i].getFullName());
            }
        }
    }

    public void printEmployeesWithoutDepartment(int departmentNumber) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == departmentNumber) {
                System.out.println("ID: " + employees[i].getId() + ", ФИО: " + employees[i].getFullName() + ", " +
                        "Зарплата: " + employees[i].getSalary());
            }
        }
    }

    public void printEmployeesBelowSalary(double salaryThreshold) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < salaryThreshold) {
                System.out.println("ID: " + employees[i].getId() + ", ФИО: " + employees[i].getFullName() + ", " +
                        "Зарплата: " + employees[i].getSalary());
            }
        }
    }

    public void printEmployeesAboveSalary(double salaryThreshold) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() >= salaryThreshold) {
                System.out.println("ID: " + employees[i].getId() + ", ФИО: " + employees[i].getFullName() + ", " +
                        "Зарплата: " + employees[i].getSalary());
            }
        }
    }
}
