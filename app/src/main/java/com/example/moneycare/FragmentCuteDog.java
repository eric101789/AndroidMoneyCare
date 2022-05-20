package com.example.moneycare;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentCuteDog#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentCuteDog extends Fragment {

    final static String TAG = "MainActivity";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ImageView iv;

    public FragmentCuteDog() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentCuteDog.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentCuteDog newInstance(String param1, String param2) {
        FragmentCuteDog fragment = new FragmentCuteDog();
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
    public void onStart() {
        super.onStart();
        Message msg = myHandler.obtainMessage();
        msg.what = IMAGE_TWO;
        myHandler.sendMessageDelayed(msg, 200);

    }

    @Override
    public void onStop() {
        myHandler.removeCallbacksAndMessages(null);
        super.onStop();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View root = inflater.inflate(R.layout.activity_cute_dog, container, false);
        iv = root.findViewById(R.id.imageView4);

        return root;
    }

    final int IMAGE_ONE = 1;
    final int IMAGE_TWO = 2;
    final int IMAGE_THREE = 3;

    private Handler myHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case IMAGE_ONE:
                    iv.setImageResource(R.drawable.ic_dog_rotate_right_1);
                    Log.d(TAG, "Image_one: " + SystemClock.elapsedRealtime());
                    msg = this.obtainMessage();
                    msg.what = IMAGE_TWO;
                    myHandler.sendMessageDelayed(msg,200); // 0.2秒後執⾏
                    break;
                case IMAGE_TWO:
                    iv.setImageResource(R.drawable.ic_dog_rotate_right_2);
                    Log.d(TAG, "Image_two: " + SystemClock.elapsedRealtime());
                    msg = this.obtainMessage();
                    msg.what = IMAGE_THREE;
                    myHandler.sendMessageDelayed(msg,200); // 0.2秒後執⾏
                    break;
                case IMAGE_THREE:
                    iv.setImageResource(R.drawable.ic_dog_rotate_right_3);
                    Log.d(TAG, "Image_three: " + SystemClock.elapsedRealtime());
                    msg = this.obtainMessage();
                    msg.what = IMAGE_ONE;
                    myHandler.sendMessageDelayed(msg,200); // 0.2秒後執⾏
                    break;
            }
        }
    };
}