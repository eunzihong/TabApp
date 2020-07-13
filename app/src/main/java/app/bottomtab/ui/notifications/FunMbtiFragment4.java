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

public class FunMbtiFragment4 extends Fragment {

    private Button btn_prev4;
    private View view;

    private RadioGroup JP1, JP2, JP3;
    private int E_count, I_count;
    int check1, check2, check3, sum;

    private Context context;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mbti4, container, false);
        btn_prev4 = view.findViewById(R.id.btn_prev4);

        JP1 = view.findViewById(R.id.JP1);
        JP2 = view.findViewById(R.id.JP2);
        JP3 = view.findViewById(R.id.JP3);
        context = container.getContext();

        btn_prev4.setOnClickListener(new View.OnClickListener() { // fragment 2로 이동한다.
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle(); // 무언가를 담을 수 있는 것 : bundle
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                // transaction : fragment를 관리함

                FunMbtiFragment_result funMbtiFragment_result = new FunMbtiFragment_result();
                // setArguments : fragment안에 bundle을 넣어줌

                sum = check1 + check2 + check3;
                String[] tmp = {"j", "j", "p", "p"};
                String fromfrag3 = getArguments().getString("fromFrag3");
                bundle.putString("fromFrag4", fromfrag3 + tmp[sum]); // 넘겨줄 값
                funMbtiFragment_result.setArguments(bundle);
                Toast.makeText(context,fromfrag3 + tmp[sum], Toast.LENGTH_SHORT).show();

                transaction.replace(R.id.main_frame, funMbtiFragment_result);
                transaction.commit();
                // 저장!
            }
        });

        JP1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.J1) {
                    check1 = 0;
                }
                else {
                    check1 = 1;
                }
            }
        });
        JP2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.J2) {
                    check2 = 0;
                }
                else {
                    check2 = 1;
                }
            }
        });
        JP3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.J3) {
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
