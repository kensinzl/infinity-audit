package nz.co.indepth.infinity.repository;

import nz.co.indepth.infinity.entity.Movie;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    /**
     * Derived Queries
     * Using Intelligence Hitting, By "name" is referring to the field name
     *
     * https://thoughts-on-java.org/ultimate-guide-derived-queries-with-spring-data-jpa/
     * perform like this select m from Movie m where m.moviename = moviename
     */
    public Optional<Movie> findByMovieName(String movieName);
    public Optional<Movie> findMovieByMovieName(String movieName);

    @Query("select m from Movie m where m.movieName like %:movieName%")
    public List<Movie> fetchMovieByName(@Param ("movieName") String movieName, Pageable pageable);


    /**
     * perform like this select m from Movie m where m.moviename like '%moviename%'
     */
    public List<Movie> findByMovieNameContains(String moviename);
    public List<Movie> findByMovieNameContaining(String moviename);
    public List<Movie> findByMovieNameIsContaining(String moviename);
    /**
     * perform like this select m from Movie m where m.moviename like 'moviename%'
     */
    public List<Movie> findByMovieNameStartingWith(String moviename);
    public List<Movie> findByMovieNameStartsWith(String moviename);
    public List<Movie> findByMovieNameIsStartingWith(String moviename);
    /**
     * perform like this select m from Movie m where m.moviename like '%moviename'
     */
    public List<Movie> findByMovieNameEndingWith(String moviename);
    public List<Movie> findByMovieNameEndsWith(String moviename);
    public List<Movie> findByMovieNameIsEndingWith(String moviename);
    /**
     * perform like this select m from Movie m where m.moviename not like '%moviename%'
     */
    public List<Movie> findByMovieNameNotContaining(String moviename);
    public List<Movie> findByMovieNameNotContains(String moviename);
    public List<Movie> findByMovieNameIsNotContaining(String moviename);

    /**
     * delete from movie where author = author
     * delete from movie where movieName = movieName
     */
    public void deleteByAuthor(String author);
    public void deleteByMovieName(String movieName);


}
