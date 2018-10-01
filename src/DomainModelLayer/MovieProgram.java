package DomainModelLayer;


import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class MovieProgram {

    private Movie movie;
    private Program program;

    private DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    public MovieProgram(Movie movie, Program program){
        this.movie = movie;
        this.program =program;
    }

    @Override
    public String toString() {
        return "Suited for age "+ movie.getAgeIndication() + " and up , Title: " + program.getTitle() + ", Duration: " + dateFormat.format(program.getTimeSpan());
    }
}
