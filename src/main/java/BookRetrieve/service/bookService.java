package BookRetrieve.service;

import BookRetrieve.model.Book;
import BookRetrieve.repository.repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class bookService {

    @Autowired
    repo testRepo;



    /*
        Handles the PATCH request for publisher discount.
        Query the repo to grab all books from the given publisher, save into a list.
        Iterate through the list calling the setDiscount function, which simply runs
        price *= discount / 100. After each one is done, save all and return.
     */
    public List<Book> updatePublisherDiscount(String publisher, double discountPercent) {
        List<Book> allFromPublisher = testRepo.findBypublisher(publisher);

        Iterator<Book> iterate = allFromPublisher.iterator();
        while(iterate.hasNext()) {
            iterate.next().setDiscount(discountPercent);
        }
        testRepo.saveAll(allFromPublisher);
        return allFromPublisher;
    }
}






