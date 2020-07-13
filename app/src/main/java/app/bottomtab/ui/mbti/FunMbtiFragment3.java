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

public class FunMbtiFragment3 extends Fragment {

    private Button btn_prev3;
    private Button btn_back3;
    private View view;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mbti3, container, false);
        btn_prev3 = view.findViewById(R.id.btn_prev3);

        btn_prev3.setOnClickListener(new View.OnClickListener() { // fragment 2로 이동한다.
            @Override
            public void onClick(View view) {
                //비워 둠
            }
        });


        btn_back3 = view.findViewById(R.id.btn_back3);

        btn_back3.setOnClickListener(new View.OnClickListener() { // fragment 2로 이동한다.
            @Override
            public void onClick(View view) {
//                Bundle bundle = new Bundle(); // 무언가를 담을 수 있는 것 : bundle
//                bundle.putString("fromFrag1", "홍드로이드 프래그먼트 2"); // 넘겨줄 값
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                // transaction : fragment를 관리함

                FunMbtiFragment2 funMbtiFragment2 = new FunMbtiFragment2();
//                NotificationsFragment.setArguments(bundle);
                // setArguments : fragment안에 bundle을 넣어줌

                transaction.replace(R.id.main_frame, funMbtiFragment2);
                // click하면 fragment 생성부터 교체까지 다 함
                transaction.commit(); // 저장!
            }
        });
        return view;
    }
}
