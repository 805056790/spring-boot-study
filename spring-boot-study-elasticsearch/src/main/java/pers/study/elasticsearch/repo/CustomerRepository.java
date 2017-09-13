package pers.study.elasticsearch.repo;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import pers.study.elasticsearch.model.Customer;

import java.util.List;

/**
 * @author : panxin
 */
public interface CustomerRepository extends ElasticsearchRepository<Customer, Long> {

    Customer findByFirstName(String firstName);

    List<Customer> findByLastName(String firstName);

}
