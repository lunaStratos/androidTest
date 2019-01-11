package lottomaster.lunastratos.com.lottomaster.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import lottomaster.lunastratos.com.lottomaster.R;

public class RandomFragment extends Fragment {
    TextView randomText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_random, container, false);
        randomText = v.findViewById(R.id.randomText);
        int [] resultArr = makeRandom();
        int drawNum1 = resultArr[0];
        int drawNum2 = resultArr[1];
        int drawNum3 = resultArr[2];
        int drawNum4 = resultArr[3];
        int drawNum5 = resultArr[4];
        int drawNum6 = resultArr[5];

        randomText.setText(drawNum1 + " " + drawNum2+ " " + drawNum3+ " " + drawNum4+ " " + drawNum5+ " " + drawNum6);
        return v;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    private int[] makeRandom() {
        List<Integer> arr = new ArrayList<>();
        for (int i = 1; i < 46; i++) {
            arr.add(i);
        }
        Collections.shuffle(arr);

        int [] resultArr = new int[6];
        for (int i = 0; i < 6; i++) {
            resultArr[i] = arr.get(i);
        }

        Arrays.sort(resultArr);

        return resultArr;
    }


}
