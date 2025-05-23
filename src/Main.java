public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[10];

        employees[0] = new Employee("Иванов Александр Алексеевич", 1, 45_000);
        employees[1] = new Employee("Петров Сергей Анатольевич", 2, 50_000);
        employees[2] = new Employee("Сидоров Владислав Николаевич", 3, 48_000);
        employees[3] = new Employee("Кузнецов Николай Тимофеевич", 4, 55_000);
        employees[4] = new Employee("Васильев Мирон Александрович", 5, 74_000);
        employees[5] = new Employee("Васильева Тамара Александровна", 4, 80_000);
        employees[6] = new Employee("Мажурная Ольга Николаевна", 2, 150_000);
        employees[7] = new Employee("Харина Василиса Яковлевна", 3, 100_000);
        employees[8] = new Employee("Раскольников Федор Михайлович", 1, 35_000);
        employees[9] = new Employee("Раскольникова Лариса Михайловна", 5, 37_000);

        separator();
        System.out.println("Полная информация по сотрудникам:");
        printAllEmployees(employees);

        separator();
        System.out.println("Сумма расходов на зарплату: " + calculateTotalSalary(employees));

        separator();
        System.out.println("Минимальная зарплата: " + findMinSalaryEmployee(employees));

        separator();
        System.out.println("Максимальная зарплата: " + findMaxSalaryEmployee(employees));

        separator();
        System.out.printf("Средняя зарплата: %.2f", calculateAverageSalary(employees));
        System.out.println();

        separator();
        System.out.println("Список ФИО сотрудников:");
        printNamesOnly(employees);

        separator();
        double percent = 8;
        indexSalary(employees, percent);
        System.out.printf("Зарплаты сотрудников после общей индексации на %s процентов:", percent);
        System.out.println();
        printAllEmployees(employees);

        separator();
        int dept = 3;
        double percentIncreaseDept = 7.5;
        System.out.printf("Индексируем зарплаты в отделе %s на %s процентов:", dept, percentIncreaseDept);
        System.out.println();
        indexSalaryByDepartment(employees, dept, percentIncreaseDept);
        System.out.println("Зарплаты сотрудников после индексации в отделе " + dept);
        printAllEmployees(employees);

        separator();
        int dept2 = 2;
        System.out.println("Сотрудник с минимальной зарплатой в отделе " + dept2);
        System.out.println(findMinSalaryByDepartment(employees, dept2));

        separator();
        int dept3 = 5;
        System.out.println("Сотрудник с максимальной зарплатой в отделе " + dept3);
        System.out.println(findMaxSalaryByDepartment(employees, dept3));

        separator();
        int dept4 = 4;
        System.out.println("Сумма зарплат в отделе " + dept4 + ": " + calculateSumSalaryByDepartment(employees, dept4));

        separator();
        int dept5 = 1;
        System.out.println("Средняя зарплата по отделу " + dept5 + " составляет " + calculateAverageSalaryByDepartment(employees, dept5));

        separator();
        int dept6 = 2;
        System.out.println("Список сотрудников отдела " + dept6 + " (без указания отдела):");
        printEmployeesWithoutDepartment(employees, dept6);

        separator();
        double threshold = 75_000;
        System.out.println("Список сотрудников с зарплатой меньше " + threshold + " рублей:");
        printEmployeesBelowSalary(employees, threshold);

        separator();
        System.out.println("Список сотрудников с зарплатой от " + threshold + " рублей и выше:");
        printEmployeesAboveSalary(employees, threshold);
    }

    public static void separator() {
        System.out.println(
                "==========================================================================================");
    }

    public static void printAllEmployees(Employee[] empArray) {
        for (int i = 0; i < empArray.length; i++) {
            if (empArray[i] != null) {
                System.out.println(empArray[i]);
            }
        }
    }

    public static double calculateTotalSalary(Employee[] empArray) {
        double total = 0;
        for (int i = 0; i < empArray.length; i++) {
            if (empArray[i] != null) {
                total += empArray[i].getSalary();
            }
        }
        return total;
    }

    public static void indexSalary(Employee[] empArray, double percentIncrease) {
        for (int i = 0; i < empArray.length; i++) {
            if (empArray[i] != null) {
                empArray[i].setSalary(empArray[i].getSalary() * (1 + percentIncrease / 100));
            }
        }
    }

    public static void indexSalaryByDepartment(Employee[] empArray, int departmentNumber, double percentIncrease) {
        for (int i = 0; i < empArray.length; i++) {
            if (empArray[i] != null && empArray[i].getDepartment() == departmentNumber) {
                empArray[i].setSalary(empArray[i].getSalary() * (1 + percentIncrease / 100));
            }
        }
    }

    public static Employee findMinSalaryByDepartment(Employee[] empArray, int departmentNumber) {
        Employee minSalary = null;
        for (int i = 0; i < empArray.length; i++) {
            if ((empArray[i] != null && empArray[i].getDepartment() == departmentNumber) &&
                    (minSalary == null || empArray[i].getSalary() < minSalary.getSalary())) {
                minSalary = empArray[i];
            }
        }
        return minSalary;
    }

    public static Employee findMaxSalaryByDepartment(Employee[] empArray, int departmentNumber) {
        Employee maxSalary = null;
        for (int i = 0; i < empArray.length; i++) {
            if ((empArray[i] != null && empArray[i].getDepartment() == departmentNumber) &&
                    (maxSalary == null || empArray[i].getSalary() > maxSalary.getSalary())) {
                maxSalary = empArray[i];
            }
        }
        return maxSalary;
    }

    public static double calculateSumSalaryByDepartment(Employee[] empArray, int departmentNumber) {
        double sumSalary = 0;
        for (int i = 0; i < empArray.length; i++) {
            if (empArray[i] != null && empArray[i].getDepartment() == departmentNumber) {
                sumSalary += empArray[i].getSalary();
            }
        }
        return sumSalary;
    }

    public static double calculateAverageSalaryByDepartment(Employee[] empArray, int departmentNumber) {
        double sum = 0;
        int count = 0;
        for (int i = 0; i < empArray.length; i++) {
            if (empArray[i] != null && empArray[i].getDepartment() == departmentNumber) {
                sum += empArray[i].getSalary();
                count++;
            }
        }
        return count > 0 ? sum / count : 0;
    }

    public static Employee findMinSalaryEmployee(Employee[] empArray) {
        Employee minSalary = null;
        for (int i = 0; i < empArray.length; i++) {
            if (empArray[i] != null) {
                if (minSalary == null || empArray[i].getSalary() < minSalary.getSalary()) {
                    minSalary = empArray[i];
                }
            }
        }
        return minSalary;
    }

    public static Employee findMaxSalaryEmployee(Employee[] empArray) {
        Employee maxSalary = null;
        for (int i = 0; i < empArray.length; i++) {
            if (empArray[i] != null) {
                if (maxSalary == null || empArray[i].getSalary() > maxSalary.getSalary()) {
                    maxSalary = empArray[i];
                }
            }
        }
        return maxSalary;
    }

    public static double calculateAverageSalary(Employee[] empArray) {
        double sum = calculateTotalSalary(empArray);
        int count = 0;
        for (int i = 0; i < empArray.length; i++) {
            if (empArray[i] != null) {
                count++;
            }
        }
        return sum / count;
    }

    public static void printNamesOnly(Employee[] empArray) {
        for (int i = 0; i < empArray.length; i++) {
            if (empArray[i] != null) {
                System.out.println(empArray[i].getFullName());
            }
        }
    }

    public static void printEmployeesWithoutDepartment(Employee[] empArray, int departmentNumber) {
        for (int i = 0; i < empArray.length; i++) {
            if (empArray[i] != null && empArray[i].getDepartment() == departmentNumber) {
                System.out.println("ID: " + empArray[i].getId() + ", ФИО: " + empArray[i].getFullName() + ", " +
                        "Зарплата: " + empArray[i].getSalary());
            }
        }
    }

    public static void printEmployeesBelowSalary(Employee[] empArray, double salaryThreshold) {
        for (int i = 0; i < empArray.length; i++) {
            if (empArray[i] != null && empArray[i].getSalary() < salaryThreshold) {
                System.out.println("ID: " + empArray[i].getId() + ", ФИО: " + empArray[i].getFullName() + ", " +
                        "Зарплата: " + empArray[i].getSalary());
            }
        }
    }

    public static void printEmployeesAboveSalary(Employee[] empArray, double salaryThreshold) {
        for (int i = 0; i < empArray.length; i++) {
            if (empArray[i] != null && empArray[i].getSalary() >= salaryThreshold) {
                System.out.println("ID: " + empArray[i].getId() + ", ФИО: " + empArray[i].getFullName() + ", " +
                        "Зарплата: " + empArray[i].getSalary());
            }
        }
    }
}
