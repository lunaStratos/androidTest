package lottomaster.lunastratos.com.lottomaster.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import lottomaster.lunastratos.com.lottomaster.LottoInfoAsyncTask;
import lottomaster.lunastratos.com.lottomaster.R;

public class BeforeFragment extends Fragment {
    TextView randomText;

    Button beforeClickBtn;
    TextView beforeText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_before,container,false);

        beforeText = v.findViewById(R.id.beforeText);
        beforeClickBtn = v.findViewById(R.id.beforeLottoBtn);
        beforeClickBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String [] beforeLottoAddress = {"http://hangang.dkserver.wo.tc", "before"};
                LottoInfoAsyncTask task = new LottoInfoAsyncTask(beforeText);
                task.execute(beforeLottoAddress);

            }
        });

    return v;

    }


}
