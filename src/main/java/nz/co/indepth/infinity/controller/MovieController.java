package nz.co.indepth.infinity.controller;

import nz.co.indepth.infinity.po.MoviePO;
import nz.co.indepth.infinity.serviceimpl.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    private MovieServiceImpl movieService;

    @PostMapping
    public ResponseEntity<MoviePO> createMovie(@RequestBody MoviePO moviePO) {
        MoviePO createdMoviePO = movieService.createMovie (moviePO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMoviePO);
    }

    @PutMapping
    public MoviePO updateMovie(@RequestBody MoviePO moviePO) {
        MoviePO updatedMoviePO = movieService.updateMovie (moviePO);
        return updatedMoviePO;
    }

    @GetMapping
    public List<MoviePO> findMovieByName(@RequestParam(name="name", required=false) String name) {
        return movieService.findMovieByName (name);
    }

    @GetMapping("/{name}")
    public MoviePO fetchByMovieName(@PathVariable("name") String name) {
        return movieService.findByMovieName (name);
    }

    @DeleteMapping
    public String deleteMovie(@RequestBody MoviePO moviePO) {
        return movieService.deleteMovie (moviePO);
    }

}
