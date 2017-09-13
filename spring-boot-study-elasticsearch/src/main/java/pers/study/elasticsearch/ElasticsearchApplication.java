package pers.study.elasticsearch;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.Assert;
import pers.study.elasticsearch.model.Customer;
import pers.study.elasticsearch.repo.CustomerRepository;

import java.util.List;

/**
 * @author : panxin
 */
@SpringBootApplication
public class ElasticsearchApplication implements CommandLineRunner {

    @Autowired
    private CustomerRepository repository;

    public static void main(String[] args) {
        // Igo Targaryen
        SpringApplication.run(ElasticsearchApplication.class, args).close();
    }

    @Override
    public void run(String... strings) throws Exception {
        repository.deleteAll();

        save();

        fetch();
    }

    private void fetch() {
        System.out.println("try to find by Id in [1, 3]");
        Customer nedStark = repository.findOne(1L);
        Customer jonSnow = repository.findOne(3L);

        Assert.notNull(nedStark, "Ned Stark is not exists");
        Assert.notNull(jonSnow, "Jon Snow is not exists");
        System.out.println(nedStark);
        System.out.println(jonSnow);
        System.out.println("==============================");

        System.out.println("try to find all");
        List<Customer> actors = Lists.newArrayList();
        repository.findAll().forEach(actors::add);

        actors.forEach(System.out::println);
        System.out.println("==============================");

        System.out.println("try to find by firstName = " + jonSnow.getFirstName());
        jonSnow = repository.findByFirstName(jonSnow.getFirstName());
        Assert.notNull(nedStark, "first name = " + jonSnow.getFirstName() + " is not exists");

        System.out.println(jonSnow.toString());
        System.out.println("==============================");

        System.out.println("try to find by lastName = " + nedStark.getLastName());
        List<Customer> starks = repository.findByLastName(nedStark.getLastName());
        Assert.notNull(starks, "Family stark is not exists");

        starks.forEach(System.out::println);
    }

    private void save() {
        Customer nedStark = Customer.builder().id(1L).firstName("Ned").lastName("Stark").build();
        Customer arayStark = Customer.builder().id(2L).firstName("Aray").lastName("Stark").build();
        Customer jonSnow = Customer.builder().id(3L).firstName("Jon").lastName("Snow").build();

        repository.save(nedStark);
        repository.save(arayStark);
        repository.save(jonSnow);
    }

}
