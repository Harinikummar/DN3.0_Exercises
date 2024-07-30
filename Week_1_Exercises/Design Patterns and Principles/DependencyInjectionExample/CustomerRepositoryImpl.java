package DependencyInjectionExample;


public class CustomerRepositoryImpl implements CustomerRepository {
 @Override
 public Customer findCustomerById(int id) {
     return new Customer(id, "Customer1", "367 street, Chennai, India");
 }
}

