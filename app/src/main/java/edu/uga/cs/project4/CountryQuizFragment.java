package edu.uga.cs.project4;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CountryQuizFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 * This fragment populates the country quiz
 */
public class CountryQuizFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private int count = 0;
    CountriesData countriesData = new CountriesData(getContext());
    Quiz quiz = new Quiz(countriesData);
   // private static final String[] countryQuizzes = {

    //  }

    // TODO:
    private String mParam1;
    private String mParam2;
    RadioGroup radioGroup;
    RadioButton radioButton;
    RadioButton radioButton1;
    RadioButton radioButton2;
    TextView textView;

    public CountryQuizFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment CountryQuizFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CountryQuizFragment newInstance(int questionNum) {
        CountryQuizFragment fragment = new CountryQuizFragment();
        Bundle args = new Bundle();
        args.putInt("question Num", questionNum);
       // args.putString(ARG_PARAM1, param1);
       // args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_country_quiz, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState ) {
        //public void onActivityCreated(Bundle savedInstanceState) {
        super.onViewCreated( view, savedInstanceState );
        textView = view.findViewById(R.id.textView);
        radioGroup = view.findViewById(R.id.radioGroup);
        radioButton = view.findViewById(R.id.radioButton);
        radioButton1 = view.findViewById(R.id.radioButton2);
        radioButton2 = view.findViewById(R.id.radioButton3);

        while(count < 6) {
            quiz.questionList.get(count).country.getCountry();
            textView.setText(quiz.questionList.get(count).country.getCountry() + "is in the continent of xxxxx");
            radioButton.setText(quiz.questionList.get(count).answersGroup[0]);
            radioButton1.setText(quiz.questionList.get(count).answersGroup[1]);
            radioButton2.setText(quiz.questionList.get(count).answersGroup[2]);
        }

    }

    public static int getNumberOfVersions(){
        return 6;
    }
}