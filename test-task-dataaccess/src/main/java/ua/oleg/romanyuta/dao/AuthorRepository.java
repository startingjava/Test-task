package ua.oleg.romanyuta.dao;


import ua.oleg.romanyuta.domain.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuthorRepository extends CrudRepository <Author, Long> {
}
