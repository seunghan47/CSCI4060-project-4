package edu.uga.cs.project4;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CountriesData {
    private SQLiteDatabase db;
    private SQLiteOpenHelper countriesDbHelper;

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
     * @param countries
     * @return
     */
    public Country storeCountry(Country countries) {
        ContentValues values = new ContentValues();

        values.put(CountriesDataTableHelper.COUNTRIES_COLUMN_NAME, countries.getCountry());
        values.put(CountriesDataTableHelper.COUNTRIES_COLUMN_CONTINENT, countries.getContinent());

        long id = db.insert(CountriesDataTableHelper.TABLE_COUNTRIES, null, values);

        countries.setId(id);

        return countries;
    }
}