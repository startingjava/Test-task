package ua.oleg.romanyuta.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.oleg.romanyuta.api.service.AuthorService;
import ua.oleg.romanyuta.domain.Author;
import ua.oleg.romanyuta.domain.AuthorShortInfo;



import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }


    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<Author> getAuthor(@PathVariable("id") Long id) {
        Author author = authorService.getAuthor(id);

        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Author>> getAllAuthors() {
        List<Author> authors = authorService.getAllAuthors();

        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    @RequestMapping(value="/info/short/{id}", method = RequestMethod.GET)
    public ResponseEntity<AuthorShortInfo> getAuthorShortInfo(@PathVariable("id") Long id) {
        AuthorShortInfo authorShortInfo = authorService.getAuthorShortInfo(id);

        return new ResponseEntity<>(authorShortInfo, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        author = authorService.createAuthor(author);

        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Author> updateAuthor(@RequestBody Author author) {
        author = authorService.updateAuthor(author);

        return new ResponseEntity<>(author, HttpStatus.OK);
    }

}
