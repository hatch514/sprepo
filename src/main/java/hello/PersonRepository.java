package hello;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long>{
    @Query(value = "select p.nickname, count(p) from person p where p.bool=false group by p.nickname",
    nativeQuery = true)
    List<Person> findFalse();
}
