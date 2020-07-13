package app.bottomtab.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import app.bottomtab.R;

public class FunMbtiFragment2 extends Fragment {

    private Button btn_prev2;
    private Button btn_back2;
    private View view;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mbti2, container, false);
        btn_prev2 = view.findViewById(R.id.btn_prev2);

        btn_prev2.setOnClickListener(new View.OnClickListener() { // fragment 2로 이동한다.
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle(); // 무언가를 담을 수 있는 것 : bundle
                bundle.putString("fromFrag1", "홍드로이드 프래그먼트 2"); // 넘겨줄 값
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                // transaction : fragment를 관리함

                FunMbtiFragment3 funMbtiFragment3 = new FunMbtiFragment3();
                funMbtiFragment3.setArguments(bundle);
                // setArguments : fragment안에 bundle을 넣어줌

                transaction.replace(R.id.main_frame, funMbtiFragment3);
                transaction.commit();
                // 저장!
            }
        });


        btn_back2 = view.findViewById(R.id.btn_back2);

        btn_back2.setOnClickListener(new View.OnClickListener() { // fragment 2로 이동한다.
            @Override
            public void onClick(View view) {
//                Bundle bundle = new Bundle(); // 무언가를 담을 수 있는 것 : bundle
//                bundle.putString("fromFrag1", "홍드로이드 프래그먼트 2"); // 넘겨줄 값
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                // transaction : fragment를 관리함

                FunMbtiFragment1 funMbtiFragment1 = new FunMbtiFragment1();
//                NotificationsFragment.setArguments(bundle);
                // setArguments : fragment안에 bundle을 넣어줌

                transaction.replace(R.id.main_frame, funMbtiFragment1);
                // click하면 fragment 생성부터 교체까지 다 함
                transaction.commit(); // 저장!
            }
        });
        return view;
    }
}
