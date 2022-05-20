package com.example.moneycare.ui.main;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.moneycare.R;
import com.example.moneycare.databinding.FragmentTabbedBinding;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    final static String TAG = "TabbedActivity";

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;
    private FragmentTabbedBinding binding;

    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        Log.d(TAG, "enter Fragment's newInstance()");
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = new ViewModelProvider(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        binding = FragmentTabbedBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        int position = getArguments().getInt(ARG_SECTION_NUMBER);

        final TextView textView = binding.sectionLabel;
        pageViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        Log.d(TAG, "enter " + position + "Fragment's onCreateView()");
        return root;
    }

    @Override
    public void onStart() {
        super.onStart();

        int position = getArguments().getInt(ARG_SECTION_NUMBER);
        Log.d(TAG, "enter " + position + "Fragment's onStart()");
    }

    @Override
    public void onStop() {
        int position = getArguments().getInt(ARG_SECTION_NUMBER);

        Log.d(TAG, "enter " + position + "Fragment's onStop()");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}