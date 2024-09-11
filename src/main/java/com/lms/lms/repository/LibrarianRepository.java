package com.lms.lms.repository;

import com.lms.lms.model.Librarian;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LibrarianRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    public LibrarianRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    public List<Librarian> getAllLibrarian() {
        return mongoTemplate.findAll(Librarian.class);
    }

    public Librarian getLibrarianById(String librarianId) {
      return mongoTemplate.findById(librarianId,Librarian.class);
    }

    public void saveNewLibrarian(Librarian librarian) {
        mongoTemplate.save(librarian,"Librarian");
    }

    public void saveLibrarians(List<Librarian> librariansList) {
        librariansList.forEach(librarian -> {
            mongoTemplate.save(librarian,"Librarian");
        });
    }
    public void deleteLibrarianById(String librarianId){
        Query query = new Query();
        query.addCriteria(Criteria.where("librarianId").is(librarianId));
        mongoTemplate.findAndRemove(query,Librarian.class);
    }

    public void saveUpdatedLibrarian(Librarian librarian) {
        mongoTemplate.save(librarian,"Librarian");
    }

    public void deleteAllLibrarians() {
        mongoTemplate.remove(new Query(),"Librarian");
    }
}
