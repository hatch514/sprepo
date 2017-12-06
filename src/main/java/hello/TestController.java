package hello;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    ResultContentRepository resultContentRepository;

    @RequestMapping("/greeting")
    public Iterable<Person> greeting() {
        String ret = "aaa";
        Iterable<Person> result = personRepository.findAll();
        return result;
    }

    @RequestMapping("/result")
    public Iterable<ResultContent> result() {
        Iterable<ResultContent> result = resultContentRepository.findAll();
        return result;
    }

    @RequestMapping("/return")
    public List<ResultContent> ret() {
        Iterable<ResultContent> result = resultContentRepository.findAll();
        ArrayList<ResultContent> myList = new ArrayList<ResultContent>();

        for(ResultContent r:result){
            myList.add(r);
        }

        return myList;
    }

    @RequestMapping("/count")
    public List<Person> cont() {
        List<Person> result = personRepository.findFalse();

        return result;
    }
}