package edu.uga.cs.project4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

/**
 * Creates layout of the country quiz
 */
public class CountryQuiz extends AppCompatActivity {

    //ViewPager for swiper layout
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_quiz);

        ViewPager2 pager = findViewById(R.id.viewPager);
        CountryQuizPagerAdapter cqpAdapter = new CountryQuizPagerAdapter(getSupportFragmentManager(), getLifecycle());
        pager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        pager.setAdapter(cqpAdapter);

    }
}