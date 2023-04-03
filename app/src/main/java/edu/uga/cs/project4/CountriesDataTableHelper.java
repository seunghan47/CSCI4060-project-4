package edu.uga.cs.project4;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class CountriesDataTableHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "countries.db";
    private static final int    DB_VERSION = 1;
    private static CountriesDataTableHelper helperInstance;
    public static final String  TABLE_COUNTRIES = "countries";
    public static final String  COUNTRIES_COLUMN_ID = "_id";
    public static final String  COUNTRIES_COLUMN_NAME = "name";
    public static final String  COUNTRIES_COLUMN_CONTINENT = "continent";
    private static final String CREATE_COUNTRIES =
        "create table " + TABLE_COUNTRIES + "("
            + COUNTRIES_COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COUNTRIES_COLUMN_NAME + "TEXT,"
            + COUNTRIES_COLUMN_CONTINENT + "TEXT,"
            + ")";
    public CountriesDataTableHelper( Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public static synchronized CountriesDataTableHelper getInstance( Context context ) {
        if (helperInstance == null) {
            helperInstance = new CountriesDataTableHelper(context.getApplicationContext());
        }
        return helperInstance;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL( CREATE_COUNTRIES );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL ( "drop table if exists " + TABLE_COUNTRIES );
        onCreate( db );
    }

    public class CountriesData {
        private SQLiteDatabase db;
        private SQLiteOpenHelper countriesDbHelper;
        public CountriesData( Context context ) {
            this.countriesDbHelper = CountriesDataTableHelper.getInstance( context );
        }
        public void open() {
            db = countriesDbHelper.getWritableDatabase();
        }
        public void close() {
            if( countriesDbHelper != null )
                countriesDbHelper.close();
        }
    }

    public Countries storeCountry( Countries countries ) {
        ContentValues values = new ContentValues();



    }


}
