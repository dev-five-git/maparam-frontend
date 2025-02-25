package com.example.myapplication.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.Activities.HomeCommentDetailActivity;
import com.example.myapplication.Activities.TimeLineCommentDetailActivity;
import com.example.myapplication.Activities.TimeLineMapActivity;
import com.example.myapplication.Adapter.TimeLinePostAdapter;
import com.example.myapplication.Model.KeywordPostModel;
import com.example.myapplication.Model.TimeLinePostModel;
import com.example.myapplication.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TimeLineFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TimeLineFragment extends Fragment {
    private static String TAG = "TimeLineFragment";
    ImageView map_icon;
    TextView tagList;
    TextView moreText;
    RecyclerView timeLinePostRecycler;
    FloatingActionButton addPostBtn;
    TimeLinePostAdapter adapter;
    private ArrayList<TimeLinePostModel> timeLinePostModels;
    private View view;
    private Context context;
    public TimeLineFragment() {

    }
    public static TimeLineFragment newInstance(Context context) {
        TimeLineFragment fragment = new TimeLineFragment();
        fragment.context = context;
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }
    public void onResume() {
        super.onResume();
        Log.e(TAG,"D");
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_time_line,container,false);
        map_icon = view.findViewById(R.id.map_icon);
        tagList = view.findViewById(R.id.tagList);
        moreText = view.findViewById(R.id.more_text);
        timeLinePostRecycler = view.findViewById(R.id.TimeLinePostRecycler);
        addPostBtn = view.findViewById(R.id.addPostBtn);
        makingAdapter();
        clickMapBuilding();
        return view;
    }

    public void makingAdapter(){
        timeLinePostModels = new ArrayList<>();
        for (int i = 0;i<15;i++){
            TimeLinePostModel model;
            ArrayList<String> tagList = new ArrayList<>();
            for (int j = 0;j<1;j++){
                tagList.add("마파람");
            }
            if (i % 2 == 0 ) {
                model = new TimeLinePostModel("마파람", "20대", "2021-12-01", "마파람 로고입니다",
                        "https://postfiles.pstatic.net/MjAyMTEyMDFfMjEw/MDAxNjM4MzUwNTA1MDIx.G0T_h-dSZOCzEim1GHmXKKEGE3H825gARh6bEfGEcocg.aUZ5pX-u81tDGlP5dxcXdqiQUnaeqOrbndBiNcGMgrMg.PNG.xldi29/%EB%AC%BC%EA%B2%B0%EA%B3%A0%EB%9E%98.png?type=w966",i,i,tagList);

            }else{
                model = new TimeLinePostModel("마파람", "20대", "2021-12-01", "마파람 로고입니다",
                        "",i,i,tagList);
            }
            timeLinePostModels.add(model);
        }
        adapter = new TimeLinePostAdapter(timeLinePostModels,context, new TimeLinePostAdapter.ClickButton() {
            @Override
            public void clickComment() {
                getActivity().startActivity(new Intent(getActivity(), TimeLineCommentDetailActivity.class));
            }
        });
        timeLinePostRecycler.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        timeLinePostRecycler.setAdapter(adapter);
    }
    public void clickMapBuilding(){
        map_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, TimeLineMapActivity.class);
                startActivity(intent);
            }
        });
    }
}