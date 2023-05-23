
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Log {
    private static final String ADMIN_LOG_FILE_PATH= "admin_log.txt";
    public static void adminLoginAttempt(String username, boolean isValid) throws IOException {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String adminLog ="";
        if (!isValid)
            adminLog = String.format("[%s]Admin User '%s' attempted to log in with a wrong password.%n", timestamp, AdminLoginPageController.adminUsername);
        else
            adminLog = String.format("[%s]Admin User '%s' logged in, successfully.%n", timestamp, AdminLoginPageController.adminUsername);
        appendAdminLog(adminLog);
    }

    private static void appendAdminLog(String adminLog) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ADMIN_LOG_FILE_PATH, true))) {
            writer.write(adminLog);
        }
    }
    
    
    
    
    private static final String EMPLOYEE_LOG_FILE_PATH= "emloyee_log.txt";
    public static void employeeLoginAttempt(String username, boolean isValid) throws IOException {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String employeeLog ="";
        if (!isValid)
            employeeLog = String.format("[%s]Employee User '%s' attempted to log in with a wrong password.%n", timestamp, EmployeeLoginPageController.employeeUsername);
        else
             employeeLog = String.format("[%s]Employee User '%s' logged in, successfully.%n", timestamp, EmployeeLoginPageController.employeeUsername);
        appendEmployeeLog(employeeLog);
    }

    private static void appendEmployeeLog(String employeeLog) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(EMPLOYEE_LOG_FILE_PATH, true))) {
            writer.write(employeeLog);
        }
    }
    
    
    
    private static final String CUSTOMER_LOG_FILE_PATH= "customer_log.txt";
    public static void CustomerLoginAttempt(String username, boolean isValid) throws IOException {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String customerLog = "";
        if(!isValid)
            customerLog = String.format("[%s]Customer User '%s' attempted to log in with a wrong password.%n", timestamp, CustomerLoginPageController.customerUsername);
        else
            customerLog = String.format("[%s]Customer User '%s' logged in, successfully.%n", timestamp, CustomerLoginPageController.customerUsername);
        appendCustomerLog(customerLog);
    }

    private static void appendCustomerLog(String customerLog) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CUSTOMER_LOG_FILE_PATH, true))) {
            writer.write(customerLog);
        }
    }
}