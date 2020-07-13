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

import java.util.HashMap;

import app.bottomtab.R;

public class FunMbtiFragment1 extends Fragment {

    private Button btn_prev1;
    private View view;

    private RadioGroup EI1, EI2, EI3;
    private int E_count, I_count;
    int check1, check2, check3, sum;

    private Context context;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mbti1, container, false);
        btn_prev1 = view.findViewById(R.id.btn_prev1);

        EI1 = view.findViewById(R.id.EI1);
        EI2 = view.findViewById(R.id.EI2);
        EI3 = view.findViewById(R.id.EI3);
        context = container.getContext();


        btn_prev1.setOnClickListener(new View.OnClickListener() { // fragment 2로 이동한다.
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle(); // 무언가를 담을 수 있는 것 : bundle
                bundle.putString("fromFrag1", "홍드로이드 프래그먼트 2"); // 넘겨줄 값
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                // transaction : fragment를 관리함

                FunMbtiFragment2 funMbtiFragment2 = new FunMbtiFragment2();
                funMbtiFragment2.setArguments(bundle);
                // setArguments : fragment안에 bundle을 넣어줌

                sum = check1 + check2 + check3;
                String[] tmp = {"000", "111", "222", "333"};
                Toast.makeText(context, tmp[sum], Toast.LENGTH_SHORT).show();


                transaction.replace(R.id.main_frame, funMbtiFragment2);
                transaction.commit();
                // 저장!
            }
        });

        EI1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.E1) {
                    check1 = 0;
                }
                else {
                    check1 = 1;
                }
            }
        });
        EI2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.E2) {
                    check2 = 0;
                }
                else {
                    check2 = 1;
                }
            }
        });
        EI3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.E3) {
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
