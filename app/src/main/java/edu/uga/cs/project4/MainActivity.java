package edu.uga.cs.project4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;

/**
 * Main activity
 */
public class MainActivity extends AppCompatActivity{
    final String TAG = "CSVReading";
    private Button quizButton;
    private Button resultButton;
    private TextView textView;

    private CountriesDataTableHelper db;
    private CountriesData database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quizButton = findViewById(R.id.button);
        resultButton = findViewById(R.id.button2);
        textView = findViewById(R.id.textView);

        String dbName = "countries";
        File dbFile = this.getDatabasePath(dbName);

        if (dbFile.exists()) {
            return;
        } else {
            //;
        }


        //Creates new activity
        quizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass( view.getContext(), CountryQuiz.class );

                startActivity( intent );
            }
        });

    }

}