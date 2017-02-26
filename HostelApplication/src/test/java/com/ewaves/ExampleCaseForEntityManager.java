package com.ewaves;

public class ExampleCaseForEntityManager {

   /* @PersistenceContext(unitName = "movie-unit", type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    public void addMovie(Movie movie) {
        entityManager.persist(movie);
    }

    public void deleteMovie(Movie movie) {
        entityManager.remove(movie);
    }

    public List<Movie> findByRating(Rating rating) {
        final Query query = entityManager.createQuery("SELECT m FROM Movie as m WHERE m.rating = :rating");
        query.setParameter("rating", rating);
        return query.getResultList();
    }

    public List<Movie> getMovies() throws Exception {
        Query query = entityManager.createQuery("SELECT m from Movie as m");
        return query.getResultList();
    }*/

}
