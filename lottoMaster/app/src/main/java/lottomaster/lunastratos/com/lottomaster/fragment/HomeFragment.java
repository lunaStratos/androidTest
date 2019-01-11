package lottomaster.lunastratos.com.lottomaster.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;

import lottomaster.lunastratos.com.lottomaster.LottoInfoAsyncTask;
import lottomaster.lunastratos.com.lottomaster.R;

public class HomeFragment extends Fragment {

    TextView insert_home;
    HashMap map;

    public HomeFragment(HashMap map) {
        this.map = map;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home,container,false);
        insert_home = v.findViewById(R.id.insert_home);

        Log.i("HomeFragment", map.toString());
        if(map !=null){
            insert_home.setText(map.toString());
        }else{
            getNowLottoInfo();
        }


        return v;

    }

    public void getNowLottoInfo(){
        String [] nowLottoAddress = {"https://www.dhlottery.co.kr/gameResult.do?method=byWin", "now"};
        LottoInfoAsyncTask task = new LottoInfoAsyncTask(insert_home);
        task.execute(nowLottoAddress);
    }


}
