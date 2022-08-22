package utils;

public class Query {
    public static final String list_customer = "SELECT customer.id,customer.`name` cn,birthday,gender,id_card,phone,email,address,type_customer.`name` tcn " +
            "FROM customer INNER JOIN type_customer " +
            "ON type_customer.id = customer.type_customer_id order by customer.id asc limit ? offset ?";
    public static final String list_contract = "select contract.id, start_date, end_date, deposit, total_money, employee.`name` en, customer.`name` cn, service.`name` sn from contract " +
            "inner join customer on customer.id = contract.customer_id " +
            "inner join employee on employee.id = contract.employee_id " +
            "inner join service on service.id = contract.service_id order by contract.id asc";
    public static final String search_contract_to_show_info = "select contract.id, start_date, end_date, deposit, total_money, employee.`name` en, customer.`name` cn, service.`name` sn from contract " +
            " inner join customer on customer.id = contract.customer_id  and  contract.id = ? " +
            " inner join employee on employee.id = contract.employee_id " +
            " inner join service on service.id = contract.service_id ";
    public static final String list_employee = "select employee.id, employee.`name`, birthday, id_card, salary, phone, email, address, positions.`name` pn, education_degree.`name` edn,division.`name` dn from employee " +
            "inner join positions on employee.position_id = positions.id " +
            "inner join education_degree on employee.education_degree_id = education_degree.id " +
            "inner join division on employee.division_id = division.id order by employee.id asc ";
    public static final String list_service = "SELECT service.id,service.`name` sn,area,service_cost,max_people,standard_room,description_other_convenience,pool_area,number_of_floors,facility_text,rent_type.`name` rtn,service_type.`name` stn " +
            "FROM service INNER JOIN service_type ON service_type.id = service.service_type_id " +
            "INNER JOIN rent_type ON rent_type.id = service.rent_type_id order by service.id asc";
    public static final String all_customer = "select count(*) from customer";
    public static final String list_customer_use_contract = "select customer.id,customer.`name` cn,birthday,gender,id_card,phone,email,address,type_customer.`name` tcn  from customer inner join contract on contract.customer_id = customer.id inner join type_customer on customer.type_customer_id = type_customer.id order by customer.id limit ? offset ?";
    public static final String all_customer_use_contract = "select count(*) from customer inner join contract on contract.customer_id = customer.id inner join type_customer on customer.type_customer_id = type_customer.id order by customer.id";
    public static final String list_service_to_Contract = "select * from service";
    public static final String list_customer_to_Contract = "select * from customer";
    public static final String list_employee_to_Contract = "select * from employee";
    public static final String list_type = "SELECT * FROM ";
    public static final String insert_customer = "INSERT INTO customer (`id`, `type_customer_id`, `name`, `birthday`, `id_card`, `gender`, `phone`, `email`, `address`) " +
            "VALUES (?,?,?,?,?,?,?,?,?)";
    public static final String insert_service = "INSERT INTO service VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
    public static final String insert_employee = "INSERT INTO employee VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    public static final String insert_contract_details = "INSERT INTO contract_details (`id`, `contract_id`, `attach_service_id`, `quantity`) VALUES (?, ?, ?, ?)";
    public static final String insert_contract = "insert into contract (start_date, end_date, deposit, total_money, employee_id, customer_id, service_id) values (?,?,?,total_money_service(?),?,?,?)";
    public static final String search_customer = "select * from customer where id = ";
    public static final String search_contract_details = "select * from contract_details where contract_id = ? ";
    public static final String search_contract = "select * from contract where id = ? ";
    public static final String search_employee = "select * from employee where id = ";
    public static final String search_service = "select * from service where id = ?";
    public static final String search_name_customer = "select * from customer where name regexp ?";
    public static final String search_name_employee = "select * from employee where name regexp ? ";
    public static final String search_name_service = "select * from service where name regexp ?";
    public static final String delete_customer = "{call delete_table(?)}";
    public static final String delete_employee = "delete from employee where id = ?";
    public static final String delete_service = "delete from service where id = ?";
    public static final String delete_contract = "delete from contract where id = ? ";
    public static final String update_employee = "UPDATE employee SET `id` = ?, `name` = ?, `birthday` = ?, `id_card` = ?, `salary` = ?, `phone` = ?, `email` = ?, `address` = ?, `position_id` = ?,`education_degree_id` = ?,`division_id` = ? WHERE id = ?";
    public static final String update_service = "UPDATE service SET `id` = ?, `name` = ?, `area` = ?, `service_cost` = ?, `max_people` = ?, `standard_room` = ?, `description_other_convenience` = ?, `pool_area` = ?, `number_of_floors` = ?,`facility_text` = ?,`rent_type_id` = ?,`service_type_id` = ? WHERE id = ?";
    public static final String update_contract = "update contract set start_date = ?, end_date =?, deposit=?, total_money = total_money_service(?), employee_id=?, customer_id=?, service_id=? where id = ?";
    public static final String update_customer = "UPDATE customer SET `id` = ?, `type_customer_id` = ?, `name` = ?, `birthday` = ?, `id_card` = ?, `gender` = ?, `phone` = ?, `email` = ?, `address` = ? WHERE id = ?";
}
