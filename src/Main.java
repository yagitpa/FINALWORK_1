public class Main {

    public static void main(String[] args) {

        EmployeeBook book = new EmployeeBook(10);

        book.addEmployee(new Employee("Иванов Александр Алексеевич", 1, 45_000));
        book.addEmployee(new Employee("Петров Сергей Анатольевич", 2, 50_000));
        book.addEmployee(new Employee("Сидоров Владислав Николаевич", 3, 48_000));
        book.addEmployee(new Employee("Кузнецов Николай Тимофеевич", 4, 55_000));
        book.addEmployee(new Employee("Васильев Мирон Александрович", 5, 74_000));
        book.addEmployee(new Employee("Васильева Тамара Александровна", 4, 80_000));
        book.addEmployee(new Employee("Мажурная Ольга Николаевна", 2, 150_000));
        book.addEmployee(new Employee("Харина Василиса Яковлевна", 3, 100_000));
        book.addEmployee(new Employee("Раскольников Федор Михайлович", 1, 35_000));
        book.addEmployee(new Employee("Раскольникова Лариса Михайловна", 5, 37_000));

        separator();
        System.out.println("Полная информация по сотрудникам:");
        book.printAllEmployees();

        separator();
        System.out.println("Сумма расходов на зарплату: " + book.calculateTotalSalary());

        separator();
        System.out.println("Минимальная зарплата: " + book.findMinSalaryEmployee());

        separator();
        System.out.println("Максимальная зарплата: " + book.findMaxSalaryEmployee());

        separator();
        System.out.printf("Средняя зарплата: %.2f", book.calculateAverageSalary());
        System.out.println();

        separator();
        System.out.println("Список ФИО сотрудников:");
        book.printNamesOnly();

        separator();
        double percent = 8;
        book.indexSalary(percent);
        System.out.printf("Зарплаты сотрудников после общей индексации на %s процентов:", percent);
        System.out.println();
        book.printAllEmployees();

        separator();
        int dept = 3;
        double percentIncreaseDept = 7.5;
        System.out.printf("Индексируем зарплаты в отделе %s на %s процентов:", dept, percentIncreaseDept);
        System.out.println();
        book.indexSalaryByDepartment(dept, percentIncreaseDept);
        System.out.println("Зарплаты сотрудников после индексации в отделе " + dept);
        book.printAllEmployees();

        separator();
        int dept2 = 2;
        System.out.println("Сотрудник с минимальной зарплатой в отделе " + dept2);
        System.out.println(book.findMinSalaryByDepartment(dept2));

        separator();
        int dept3 = 5;
        System.out.println("Сотрудник с максимальной зарплатой в отделе " + dept3);
        System.out.println(book.findMaxSalaryByDepartment(dept3));

        separator();
        int dept4 = 4;
        System.out.println("Сумма зарплат в отделе " + dept4 + ": " + book.calculateSumSalaryByDepartment(dept4));

        separator();
        int dept5 = 1;
        System.out.println("Средняя зарплата по отделу " + dept5 + " составляет " + book.calculateAverageSalaryByDepartment(dept5));

        separator();
        int dept6 = 2;
        System.out.println("Список сотрудников отдела " + dept6 + " (без указания отдела):");
        book.printEmployeesWithoutDepartment(dept6);

        separator();
        double threshold = 75_000;
        System.out.println("Список сотрудников с зарплатой меньше " + threshold + " рублей:");
        book.printEmployeesBelowSalary(threshold);

        separator();
        System.out.println("Список сотрудников с зарплатой от " + threshold + " рублей и выше:");
        book.printEmployeesAboveSalary(threshold);
    }

    public static void separator() {
        System.out.println(
                "==========================================================================================");
    }
}
