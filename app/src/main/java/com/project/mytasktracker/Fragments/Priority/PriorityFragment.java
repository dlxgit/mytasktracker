package com.project.mytasktracker.Fragments.Priority;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.project.mytasktracker.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PriorityFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PriorityFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PriorityFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private String mParam1;

    private OnFragmentInteractionListener mListener;

    private ListView listView;
    private PriorityListViewAdapter adapter;

    public PriorityFragment() {
        // Required empty public constructor
    }

    public static PriorityFragment newInstance(String param1) {
        PriorityFragment fragment = new PriorityFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_priority, container, false);
        listView = (ListView) view.findViewById(R.id.priority_fragment_listview);
        initAdapter();
        listView.setAdapter(adapter);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public void initAdapter() {
        ArrayList<PriorityItem> priorityItems = new ArrayList<>();
        for(int i = 4; i > 0; --i) {
            priorityItems.add(new PriorityItem(i));
        }
        adapter = new PriorityListViewAdapter(priorityItems, this, listView );
    }
}
