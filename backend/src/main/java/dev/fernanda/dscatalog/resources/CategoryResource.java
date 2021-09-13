package dev.fernanda.dscatalog.resources;

import dev.fernanda.dscatalog.entities.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/categories") //usually the route is in the plural
public class CategoryResource {

    @GetMapping
    public ResponseEntity<List<Category>> findAll() { //ResponseEntity is an object that encapsulates a http response
        List<Category> list = new ArrayList<>();
        list.add(new Category(1L, "Books"));
        list.add(new Category(2L, "Electronics"));
        return ResponseEntity
                .ok()
                .body(list);
    }

}
