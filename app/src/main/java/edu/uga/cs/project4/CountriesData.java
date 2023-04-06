package edu.uga.cs.project4;

import static androidx.constraintlayout.widget.ConstraintLayoutStates.TAG;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.opencsv.CSVReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CountriesData {
    private SQLiteDatabase db;
    private SQLiteOpenHelper countriesDbHelper;

    public List<Country> countries;

    public CountriesData(Context context) {
        this.countriesDbHelper = CountriesDataTableHelper.getInstance(context);
    }

    public void open() {
        db = countriesDbHelper.getWritableDatabase();
    }

    public void close() {
        if (countriesDbHelper != null)
            countriesDbHelper.close();
    }

    /**
     * need to revise this part.

     */
    public Country storeCountry(Country countries) {
        ContentValues values = new ContentValues();
        //countries = new ArrayList<Country>();
        try {
            InputStream in_s = getClass().getClassLoader().getResourceAsStream("country_continent.csv");
            CSVReader reader = new CSVReader(new InputStreamReader(in_s));

            String[] nextRow;
            while ((nextRow = reader.readNext()) != null) {

                int id = 0;
                for (int i = 0; i < nextRow.length; i++) {


                    String name = nextRow[0];
                    String continent = nextRow[1];
                    Country country = new Country(id, name, continent);
                    //countries.add(country);
                    id++;

                }
            }
        }
        catch(Exception e){
            Log.e(TAG, e.toString());
        }

        /*
        values.put(CountriesDataTableHelper.COUNTRIES_COLUMN_NAME, countries.getCountry());
        values.put(CountriesDataTableHelper.COUNTRIES_COLUMN_CONTINENT, countries.getContinent());

        long id = db.insert(CountriesDataTableHelper.TABLE_COUNTRIES, null, values);

        countries.setId(id);


         */
        return countries;
    }
}