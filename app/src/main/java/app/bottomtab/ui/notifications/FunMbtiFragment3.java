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

public class FunMbtiFragment3 extends Fragment {

    private Button btn_prev3;
    private View view;

    private RadioGroup TF1, TF2, TF3;
    private int E_count, I_count;
    int check1, check2, check3, sum;

    private Context context;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mbti3, container, false);
        btn_prev3 = view.findViewById(R.id.btn_prev3);

        TF1 = view.findViewById(R.id.TF1);
        TF2 = view.findViewById(R.id.TF2);
        TF3 = view.findViewById(R.id.TF3);
        context = container.getContext();


        btn_prev3.setOnClickListener(new View.OnClickListener() { // fragment 2로 이동한다.
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle(); // 무언가를 담을 수 있는 것 : bundle
                FragmentTransaction transaction =
                        getActivity().getSupportFragmentManager().beginTransaction();
                // transaction : fragment를 관리함

                FunMbtiFragment4 funMbtiFragment4 = new FunMbtiFragment4();
                // setArguments : fragment안에 bundle을 넣어줌

                sum = check1 + check2 + check3;
                String[] tmp = {"t", "t", "f", "f"};
                String fromfrag2 = getArguments().getString("fromFrag2");
                bundle.putString("fromFrag3", fromfrag2 + tmp[sum]); // 넘겨줄 값
                funMbtiFragment4.setArguments(bundle);
                Toast.makeText(context, fromfrag2 + tmp[sum], Toast.LENGTH_SHORT).show();

                transaction.replace(R.id.main_frame, funMbtiFragment4);
                transaction.commit();
                // 저장!
            }
        });

        TF1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.T1) {
                    check1 = 0;
                }
                else {
                    check1 = 1;
                }
            }
        });
        TF2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.T2) {
                    check2 = 0;
                }
                else {
                    check2 = 1;
                }
            }
        });
        TF3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.T3) {
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
