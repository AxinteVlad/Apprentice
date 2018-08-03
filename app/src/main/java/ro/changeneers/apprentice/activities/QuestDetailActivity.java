package ro.changeneers.apprentice.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ro.changeneers.apprentice.ApprenticeApplication;
import ro.changeneers.apprentice.R;
import ro.changeneers.apprentice.models.Curs;
import ro.changeneers.apprentice.models.Quest;

public class QuestDetailActivity extends AppCompatActivity {

    private static final int EASY = 1;
    private static final int MEDIUM = 2;
    private static final int HARD = 3;

    ScrollView scrollView;

    TextView titleQuest;
    TextView impQuest;
    TextView ceInvQuest;

    TextView titleCurs1;
    TextView textCurs1Pro;
    TextView textCurs1Contra;

    TextView titleCurs2;
    TextView textCurs2Pro;
    TextView textCurs2Contra;

    TextView titleCurs3;
    TextView textCurs3Pro;
    TextView textCurs3Contra;

    private List<Quest> localList;
    private Quest quest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest_detail);

//        Curs curs  = new Curs("0","Getting started","https://www.udemy.com/java-tutorial/","se ocupa foarte bine de notiuni de la 0",
//                "dureaza 16 ore");
//            Intent intent = getIntent();
//            int incomingQuestId = intent.getExtras().getInt("ID");
//            List<Curs> cursuri = new ArrayList<>();
//            cursuri.add(curs);
//            cursuri.add(curs);
//            cursuri.add(curs);
//            Quest quest = new Quest("0", "Getting Started", "Este important pentru ca e nevoie sa iti pui bazele programrii intainte sa incepi ceva mai complicat",
//                    "Vei invata ce inseamna notiunile de baza ale programarii in general", 0, cursuri);

        Intent intent = getIntent();
        String incomingQuestId = intent.getExtras().getString("ID");
        int difficulty = intent.getExtras().getInt("DIFFICULTY");

        switch (difficulty) {
            case EASY:
                localList = ApprenticeApplication.getQuestListEasyDB();
                break;
            case MEDIUM:
                localList = ApprenticeApplication.getQuestListEasyDB();
                break;
            case HARD:
                localList = ApprenticeApplication.getQuestListEasyDB();
                break;
        }

        for (int i = 0; i < localList.size(); i++) {
            if(localList.get(i).id ==incomingQuestId){
                quest = localList.get(i);
                break;
            }

        }


        scrollView = findViewById(R.id.scrollviewid);


        titleQuest = findViewById(R.id.TextViewQuestDetailTitle);
        titleQuest.setText(quest.title);
        impQuest = findViewById(R.id.TextViewQuestDetailImportanta);
        impQuest.setText(quest.importanta);
        ceInvQuest = findViewById(R.id.TextViewQuestDetailCeInvat);
        ceInvQuest.setText(quest.ceInvat);

        titleCurs1 = findViewById(R.id.TextViewTitleCurs1);
        titleCurs1.setText(quest.getListCursuri().get(0).title);
        titleCurs2 = findViewById(R.id.TextViewTitleCurs2);
        titleCurs2.setText(quest.getListCursuri().get(1).title);
        titleCurs3 = findViewById(R.id.TextViewTitleCurs3);
        titleCurs3.setText(quest.getListCursuri().get(2).title);

        final View curs1View = findViewById(R.id.childCurs1);
        textCurs1Pro = curs1View.findViewById(R.id.TextViewPro);
        textCurs1Pro.setText(quest.getListCursuri().get(0).pro);
        textCurs1Contra = curs1View.findViewById(R.id.TextViewContra);
        textCurs1Contra.setText(quest.getListCursuri().get(0).contra);


        final View curs2View = findViewById(R.id.childCurs2);
        textCurs2Pro = curs2View.findViewById(R.id.TextViewPro);
        textCurs2Pro.setText(quest.getListCursuri().get(1).pro);
        textCurs2Contra = curs2View.findViewById(R.id.TextViewContra);
        textCurs2Contra.setText(quest.getListCursuri().get(1).pro);


        final View curs3View = findViewById(R.id.childCurs3);
        textCurs3Pro = curs3View.findViewById(R.id.TextViewPro);
        textCurs3Pro.setText(quest.getListCursuri().get(2).pro);
        textCurs3Contra = curs3View.findViewById(R.id.TextViewContra);
        textCurs3Contra.setText(quest.getListCursuri().get(2).contra);

        final ViewGroup transitionCurs1 = (ViewGroup) findViewById(R.id.LinearLayoutParentCurs1);
        transitionCurs1.setOnClickListener(new View.OnClickListener() {
            boolean visible = false;

            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition(transitionCurs1);
                visible = !visible;
                curs1View.setVisibility(visible ? View.VISIBLE : View.GONE);
                curs1View.findViewById(R.id.ButtonBeginQuest).requestFocus();


            }
        });

        final ViewGroup transitionCurs2 = (ViewGroup) findViewById(R.id.LinearLayoutParentCurs2);
        transitionCurs2.setOnClickListener(new View.OnClickListener() {
            boolean visible = false;

            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition(transitionCurs2);
                visible = !visible;
                curs2View.setVisibility(visible ? View.VISIBLE : View.GONE);
                curs2View.findViewById(R.id.ButtonBeginQuest).requestFocus();

            }
        });

        final ViewGroup transitionCurs3 = (ViewGroup) findViewById(R.id.LinearLayoutParentCurs3);
        transitionCurs3.setOnClickListener(new View.OnClickListener() {
            boolean visible = false;

            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition(transitionCurs3);
                visible = !visible;
                curs3View.setVisibility(visible ? View.VISIBLE : View.GONE);
                curs3View.findViewById(R.id.ButtonBeginQuest).requestFocus();
            }
        });
    }
}
