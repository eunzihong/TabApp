package app.bottomtab.ui.notifications;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import app.bottomtab.R;

public class FunMbtiFragment2 extends Fragment {

    private Button btn_prev2;
    private View view;

    private RadioGroup SN1, SN2, SN3;
    private int E_count, I_count;
    int check1, check2, check3, sum;

    private Context context;
    String fromfrag1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mbti2, container, false);
        btn_prev2 = view.findViewById(R.id.btn_prev2);

        SN1 = view.findViewById(R.id.SN1);
        SN2 = view.findViewById(R.id.SN2);
        SN3 = view.findViewById(R.id.SN3);
        context = container.getContext();

        fromfrag1 = getArguments().getString("fromFrag1");

        btn_prev2.setOnClickListener(new View.OnClickListener() { // fragment 2로 이동한다.
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle(); // 무언가를 담을 수 있는 것 : bundle
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                // transaction : fragment를 관리함

                FunMbtiFragment3 funMbtiFragment3 = new FunMbtiFragment3();
                // setArguments : fragment안에 bundle을 넣어줌

                sum = check1 + check2 + check3;
                String[] tmp = {"s", "s", "n", "n"};
                bundle.putString("fromFrag2", fromfrag1 + tmp[sum]); // 넘겨줄 값
                funMbtiFragment3.setArguments(bundle);


                transaction.replace(R.id.main_frame, funMbtiFragment3);
                transaction.commit();
                // 저장!
            }
        });

        SN1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.S1) {
                    check1 = 0;
                }
                else {
                    check1 = 1;
                }
            }
        });
        SN2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.S2) {
                    check2 = 0;
                }
                else {
                    check2 = 1;
                }
            }
        });
        SN3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.S3) {
                    check3 = 0;
                }
                else {
                    check3 = 1;
                }
            }
        });

        return view;
    }
}
