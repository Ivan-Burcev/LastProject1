package com.javarush.quest.burcev.enums;

public class PreparedValues {


    public static String[] getMovies(){
        String[] movies = new String[5];
        movies = new String[5];
        movies[0] = "terminator";
        movies[1] = "men_in_black";
        movies[2] = "brother";
        movies[3] = "matrix";
        movies[4] = "pulp_fiction";
        return movies;
    }
    public static String[] getRiddles(){
        String[] riddles = new String[5];
        riddles = new String[5];
        riddles[0] = "girl";
        riddles[1] = "water";
        riddles[2] = "ice";
        riddles[3] = "newspaper";
        riddles[4] = "knife";
        return riddles;
    }
    public static Movie[] getMoviesEnumMovies(){
        Movie[] moviesEnum = new Movie[5];
        moviesEnum[0] = Movie.FIRST_MOVIE;
        moviesEnum[1] = Movie.SECOND_MOVIE;
        moviesEnum[2] = Movie.THIRD_MOVIE;
        moviesEnum[3] = Movie.FOURTH_MOVIE;
        moviesEnum[4] = Movie.FIFTH_MOVIE;
        return moviesEnum;
    }
    public static Riddles[] getRiddlesEnum(){

        Riddles[] riddlesEnum = new Riddles[5];
        riddlesEnum[0] = Riddles.FIRST_RIDDLE;
        riddlesEnum[1] = Riddles.SECOND_RIDDLE;
        riddlesEnum[2] = Riddles.THIRD_RIDDLE;
        riddlesEnum[3] = Riddles.FOURTH_RIDDLE;
        riddlesEnum[4] = Riddles.FIFTH_RIDDLE;
        return riddlesEnum;
    }


}
