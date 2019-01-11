package lottomaster.lunastratos.com.lottomaster.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import lottomaster.lunastratos.com.lottomaster.LottoInfoAsyncTask;
import lottomaster.lunastratos.com.lottomaster.R;

public class BeforeFragment extends Fragment {
    EditText insert_beforeNum;

    Button beforeClickBtn;
    TextView beforeText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_before, container, false);

        beforeText = v.findViewById(R.id.beforeText);
        beforeClickBtn = v.findViewById(R.id.beforeLottoBtn);
        insert_beforeNum = v.findViewById(R.id.insert_beforeNum);

        beforeClickBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // "http://hangang.dkserver.wo.tc"
                if (insert_beforeNum.getText().toString().equals("")) {
                    Toast.makeText(getContext(), "숫자를 입력해 주세요.", Toast.LENGTH_LONG).show();
                    return;
                }

                String address = "https://www.dhlottery.co.kr/gameResult.do?method=byWin&drwNo=" + insert_beforeNum.getText();
                Log.d("", address);
                String[] beforeLottoAddress = {address, "now"};
                LottoInfoAsyncTask task = new LottoInfoAsyncTask(beforeText);
                task.execute(beforeLottoAddress);


            }
        });

        return v;

    }


}
