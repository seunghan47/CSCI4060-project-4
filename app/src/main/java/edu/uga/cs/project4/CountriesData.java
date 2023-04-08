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

/**
 * Reads CSV data and stores countries in SQL
 */
public class CountriesData {
    private SQLiteDatabase db;
    private SQLiteOpenHelper countriesDbHelper;

    public List<Country> countriesList;

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
     * Reads from csv and inserts into SQL table
     */
    public Country storeCountry(Country countries) {
        ContentValues values = new ContentValues();
        countriesList = new ArrayList<Country>();
        try {
            InputStream in_s = getClass().getClassLoader().getResourceAsStream("country_continent.csv");
            CSVReader reader = new CSVReader(new InputStreamReader(in_s));

            String[] nextRow;
            while ((nextRow = reader.readNext()) != null) {


                for (int i = 0; i < nextRow.length; i++) {


                    String name = nextRow[0];
                    String continent = nextRow[1];
                    Country country = new Country( name, continent);
                    countriesList.add(country);
                    values.put(CountriesDataTableHelper.COUNTRIES_COLUMN_NAME, countries.getCountry());
                    values.put(CountriesDataTableHelper.COUNTRIES_COLUMN_CONTINENT, countries.getContinent());
                    long id = db.insert(CountriesDataTableHelper.TABLE_COUNTRIES, null, values);

                    country.setId(id);
                    return country;
                }
            }
        }
        catch(Exception e){
            Log.e(TAG, e.toString());
        }

        return countries;
    }
}