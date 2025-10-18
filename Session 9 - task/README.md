## 🧩 UML Class Diagram

```text
+---------------------------------------+
|              Employee                 |
+---------------------------------------+
| - username: String                    |
| - email: String                       |
| - password: String                    |
| - confirmPassword: String             |
+---------------------------------------+
| + getUsername(): String               |
| + setUsername(String): void           |
| + getEmail(): String                  |
| + setEmail(String): void              |
| + getPassword(): String               |
| + setPassword(String): void           |
| + getConfirmPassword(): String        |
| + setConfirmPassword(String): void    |
+---------------------------------------+

                ▲
                |
                |
+---------------------------------------+
|            EmployeeDAO                |
+---------------------------------------+
| - url: String                         |
| - username: String                    |
| - password: String                    |
| - dbDriver: String                    |
| - connection: Connection               |
+---------------------------------------+
| + connectToDatabase(): void           |
| + disconnectFromDatabase(): void      |
| + save(emp: Employee): void           |
+---------------------------------------+

                ▲
                |
                |
+---------------------------------------+
|           EmployeeService             |
+---------------------------------------+
| - employeeDAO: EmployeeDAO            |
+---------------------------------------+
| + registerEmployee(emp: Employee): void |
+---------------------------------------+

                ▲
                |
                |
+---------------------------------------+
|         EmployeeController            |
+---------------------------------------+
| - service: EmployeeService            |
+---------------------------------------+
| + showForm(model: Model): String      |
| + submitForm(employee: Employee, result: BindingResult, model: Model): String |
+---------------------------------------+