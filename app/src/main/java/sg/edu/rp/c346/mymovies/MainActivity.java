package sg.edu.rp.c346.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ListView lvMovie;
    ArrayList<Movie> alMovieList;
    CustomAdapter caMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Calendar watchDate = Calendar.getInstance();

        lvMovie = findViewById(R.id.listViewMovie);
        alMovieList = new ArrayList();

        watchDate.set(2014, 11-1, 15);
        Movie movie1 = new Movie("The Avengers", 2012, "pg13", "Action | Sci-Fi", watchDate, "Golden Village - Bishan", "Nick Fury of S.H.I.E.L.D. assembles a team of superheroes to save the planet from Loki and his army.");
        alMovieList.add(movie1);

        watchDate.set(2015, 5-1, 15);
        Movie movie2 = new Movie("Planes", 2013, "pg", "Animation | Comedy", watchDate, "Cathay - AMK Hub", "A crop-dusting plane with a fear of heights lives his dream of competing in a famous around-the-world aerial race.");
        alMovieList.add(movie2);

        caMovie = new CustomAdapter(this, R.layout.row, alMovieList);
        lvMovie.setAdapter(caMovie);

        lvMovie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                Movie currentMovie = alMovieList.get(position);
                i.putExtra("title", currentMovie.getTitle());
                i.putExtra("year", currentMovie.getYear());
                i.putExtra("rated", currentMovie.getRated());
                i.putExtra("genre", currentMovie.getGenre());
                i.putExtra("watchDate", currentMovie.getWatched_on());
                i.putExtra("theatre", currentMovie.getIn_theatre());
                i.putExtra("description", currentMovie.getDescription());
                startActivity(i);
            }
        });
    }
}