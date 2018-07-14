package com.mikelzuzu.spring5webapp.boostrap;

import com.mikelzuzu.spring5webapp.model.Author;
import com.mikelzuzu.spring5webapp.model.Book;
import com.mikelzuzu.spring5webapp.model.Publisher;
import com.mikelzuzu.spring5webapp.repository.AuthorRepository;
import com.mikelzuzu.spring5webapp.repository.BookRepository;
import com.mikelzuzu.spring5webapp.repository.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData(){
        // Puublisher
        Publisher publisher = new Publisher();
        publisher.setName("O Really");
        publisher.setAddress("Bilbao kalea, Dublin");
        publisherRepository.save(publisher);

        //Dani
        Author dani = new Author("Dani", "Poma");
        Book spring = new Book("Spring in action", "1234", publisher);
        dani.getBooks().add(spring);
        spring.getAuthors().add(dani);

        authorRepository.save(dani);
        bookRepository.save(spring);

        //Mik
        Author mik = new Author("Mik", "Zuz");
        Book dropwizard = new Book("Dropwizard in action", "1122", publisher);
        mik.getBooks().add(dropwizard);
        dropwizard.getAuthors().add(mik);

        authorRepository.save(mik);
        bookRepository.save(dropwizard);
    }
}
