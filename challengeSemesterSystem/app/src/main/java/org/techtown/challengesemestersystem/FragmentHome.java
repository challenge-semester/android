package org.techtown.challengesemestersystem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class FragmentHome extends Fragment {

    private ListView listview;
    private BoardAdapter boardAdapter;
    private Button btn_create, btn_search;
    private EditText edit_search;

    public FragmentHome (){ }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.board,container,false);
        //ViewGroup rootView=(ViewGroup)inflater.inflate(R.layout.f,container,false);

        btn_create=(Button)view.findViewById(R.id.btn_create);
        btn_search=(Button)view.findViewById(R.id.btn_search);
        edit_search=(EditText)view.findViewById(R.id.edit_search);

        btn_create.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), BoardCreateActivity.class);
                startActivity(intent);
            }
        });

        btn_search.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });

        listview=(ListView)view.findViewById(R.id.listview_board);
        boardAdapter=new BoardAdapter();

        boardAdapter.addItem_board(ContextCompat.getDrawable(getActivity(),R.drawable.ic_baseline_person_24),"익명","5/20 16:42",
                "아룡하세요오 혹시 컴퓨터공학과 재학 중이신 분 계신가요?? ",
                3,2);
        boardAdapter.addItem_board(ContextCompat.getDrawable(getActivity(),R.drawable.ic_baseline_person_24),"익명","5/20 16:45",
                "동아리 멤버 구합니다!!",
                8,9);
        boardAdapter.addItem_board(ContextCompat.getDrawable(getActivity(),R.drawable.ic_baseline_person_24),"익명","5/20 16:48",
                "청년들의 설레는 꿈이 모이는 거리\n" +
                        "청.설.모. 프로젝트 참여자 모집 안내\n" +
                        "\n" +
                        "■ 신청기간\n" +
                        " - 2021년 5월 26일까지 (20:00까지)\n" +
                        "\n" +
                        "■ 신청방법\n" +
                        " - 위뮤즈(http://wemuz.me)의 청설모 프로젝트 페이지에서 신청\n" +
                        "\n" +
                        "■ 대상\n" +
                        "- 청년(만 19세 이상 34세 이하)\n" +
                        " * 이번 프로그램은 청년지원사업으로 운영되어 청년만 참가 가능합니다.\n" +
                        "\n" +
                        "■ 활동 안내\n" +
                        " - 연제구 인근 세병교에서 버스킹 문화공연활동 진행\n" +
                        " - 매달 문화의 날(마지막 주 수요일)에 2팀씩 공연\n" +
                        " - 팀당 20분간 버스킹 연주 진행\n" +
                        " - SNS 페이지에 뮤지션 소개 및 홍보 진행\n" +
                        " - 거리예술 활성화 지원 사업 규정에 따른 공연 개런티 지급\n" +
                        " - 공연 활동 이후 연제구 내 복지시설에 마스크 기부\n" +
                        "\n" +
                        "■ 문의사항\n" +
                        " - wemuzmusic@gmail.com\n" +
                        " - ☎ : 0l0-46l3-3797",
                133,22);
        boardAdapter.addItem_board(ContextCompat.getDrawable(getActivity(),R.drawable.ic_baseline_person_24),"익명","5/20 17:02",
                "안녕안녕 나는 지수야~ 헬륨가스 먹었더니 요로케됐지",
                1,1);
        boardAdapter.addItem_board(ContextCompat.getDrawable(getActivity(),R.drawable.ic_baseline_person_24),"익명","5/20 17:43",
                "222222222222222222222222222222222222222",
                0,2);
        boardAdapter.addItem_board(ContextCompat.getDrawable(getActivity(),R.drawable.ic_baseline_person_24),"익명","5/20 17:43",
                "아 졸작 발표 언제 끝나나... 마치고 바로 집가야지 집마려웡!!!",
                13,8);
        boardAdapter.addItem_board(ContextCompat.getDrawable(getActivity(),R.drawable.ic_baseline_person_24),"익명","5/20 17:43",
                "청년, 음악 하자!\n" +
                        "청음 커뮤니티 구성원 모집 안내\n" +
                        "\n" +
                        "■ 신청기간\n" +
                        " - 2021년 5월 10일 ~ 5월 23일 (20:00까지)\n" +
                        "\n" +
                        "■ 신청방법\n" +
                        " - 위뮤즈(http://wemuz.me)의 청음 커뮤니티 페이지에서 신청\n" +
                        "\n" +
                        "■ 대상\n" +
                        " - 청년(만 19세 이상 34세 이하)\n" +
                        " * 이번 프로그램은 청년지원사업으로 운영되어 청년만 참가 가능합니다.\n" +
                        "\n" +
                        "■ 진행 안내\n" +
                        " - 12주 프로그램으로 신청자들로 음악 팀을 구성하여 음악 커뮤니티 활동 진행\n" +
                        " - 연주곡 2곡 완곡 목표로 하여 오프라인 팀 활동 수행\n" +
                        " - 주차 별 활동 미션 有\n" +
                        " - 참가비 무료 (전액 지원)\n" +
                        " - 활동기간 동안 연습 공간 무료 제공\n" +
                        " * 전액 지원을 통해 운영하는 프로그램이므로 끝까지 성실하게 완료가능하신 분만 신청 부탁드립니다.\n" +
                        " ** 코로나 진행 수칙을 최대한 고려하며, 확진 의심자의 경우 참가가 불가합니다.\n" +
                        "\n" +
                        "■ 진행 프로그램\n" +
                        " [팀 합주활동]\n" +
                        " - 매주 1회 지정 연습 장소에서 자율적인 팀 음악 활동 진행\n" +
                        " - 활동 지원을 위 지역예술인과의 멘토링 포함\n" +
                        " - 팀별 곡 선정 및 편곡 등에 멘토님들이 조언\n" +
                        " - 연주 방향성 지도 및 도움\n" +
                        "\n" +
                        " [버스킹 / 공연활동]\n" +
                        " - 버스킹 공연행사 및 스테이지 공연 진\n" +
                        " - 월 1회 야외 버스킹 진행\n" +
                        " - 옴니버스 형태의 영상 앨범 제작\n" +
                        "\n" +
                        " [커뮤니티 활동]\n" +
                        " - 매달 1회 문화예술 컨퍼런스 개최\n" +
                        " - 백스테이지 투어\n" +
                        " - 음악감상회\n" +
                        " * 코로나 19 영향에 따라 변동될 수 있음\n" +
                        "\n" +
                        "■ 문의사항\n" +
                        " - wemuzmusic@gmail.com\n" +
                        " - ☎ : 0l0-46l3-3797",
                0,2);

        listview.setAdapter(boardAdapter);
        return view;

    }
}