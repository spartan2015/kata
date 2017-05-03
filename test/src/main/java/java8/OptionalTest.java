package java8;

import lombok.Data;
import org.junit.Test;

import java.util.Optional;

/**
 4.3. Describe the unique characteristics of the Optional classes

 */
public class OptionalTest {

    @Data
    static class Person{
        Optional<Car> optCar;
    }

    @Data
    static class Car{
        Optional<Insurance> optInsurance;
    }

    @Data
    static class Insurance{
        String name;

    }

    @Test
    public void test(){

        Optional<Car> c = Optional.of(new Car());
        Optional<Car> optCar = Optional.ofNullable(null);

        Optional<Insurance> optInsurance = Optional.empty();

//        Optional<String> optStr = optInsurance.map(Insurance::getName);
//        optStr.ifPresent(System.out::println);
//
//        Optional<Person> person = Optional.empty();


//        String str = person
//                .flatMap(Person::getOptCar)
//                .flatMap(Car::getOptInsurance)
//                .map(Insurance::getName).orElse("Unknown");

    }
}
