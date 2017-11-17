package com.example.admin.day3week2;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ListView lvCeleb;

    private CelAdapter celAdapter;
    private List<Celebrity> celebrityList1;


    public FirstFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FirstFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FirstFragment newInstance(String param1, String param2) {
        FirstFragment fragment = new FirstFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
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
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        // Inflate the layout for this fragment
        celebrityList1 = new ArrayList<>();
        celebrityList1.add(new Celebrity("Johnny Depp", "Johnny Depp is perhaps one of the most versatile " +
                "actors of his day and age in Hollywood. He was born John Christopher Depp II in Owensboro, Kentucky, on June 9, 1963, " +
                "to Betty Sue (Wells), who worked as a waitress, and John Christopher Depp, a civil engineer.", R.drawable.johnnydepp));
        celebrityList1.add(new Celebrity("Al Pacino", "One of the greatest actors in all of film history, Al Pacino established himself during one of film's greatest decades, the 1970s, and has become an enduring and iconic figure in the world of American movies. ",R.drawable.alpacino));

        celAdapter = new CelAdapter(getActivity(), R.layout.fragment_first, celebrityList1);
        return view;


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lvCeleb = view.findViewById(R.id.lvCeleb);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        lvCeleb.setAdapter(celAdapter);
        lvCeleb.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


CelDetailFragment celDetailFragment = new CelDetailFragment();
                Log.d(TAG, "onItemClick: "+celebrityList1.get(i).getName());
Bundle bundle = new Bundle();
bundle.putString("Celeb Name", celebrityList1.get(i).getName());
bundle.putString("Celeb Details", celebrityList1.get(i).getDescription());
bundle.putInt("Celeb Image", celebrityList1.get(i).getImageId());
celDetailFragment.setArguments(bundle);
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.flDescription,celDetailFragment).commit();
            }
        });
        super.onActivityCreated(savedInstanceState);
    }
}
