package com.example.ecepfe.agilit;

import android.content.ClipData;
import android.os.AsyncTask;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    ScrollView zonededrop1, zonededrop2, zonededrop3, scrollViewTest;
    LinearLayout linearLayoutTest, linearLayoutTest2, utilisateursList;
    TextView utilname1, utilname2, utilname3, utilname4, utilname5, utilname6, texttemp;
    ImageView picutilisateur1, picutilisateur2, picutilisateur3, picutilisateur4, picutilisateur5, picutilisateur6, imageViewtemp, imageViewtemp2, imageViewtemp3, vertRema, bleuRema, jauneRema, rougeRema;
    RelativeLayout containertemp, containertemp2, containertemppopup;
    ProgressBar progressBarTempsParole;
    ContainerTache testcontainer = new ContainerTache();
    ContainerTache testcontainer2 = new ContainerTache();
    ContainerTache testcontainer3 = new ContainerTache();

    Integer index =0;

    public MyApiEndpointInterface apiInterface;
    public ListeTaches listeTachexemple;
    public List<ListIssue> listissuestemp;
    public Utilisateurs utilisateurs;
    public List<ListMember> members;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Kanban");

        global_variable_set();

        //region Affectation des variables
        zonededrop1 = (ScrollView) findViewById(R.id.zonedrop1);
        zonededrop2 = (ScrollView) findViewById(R.id.zonedrop2);
        zonededrop3 = (ScrollView) findViewById(R.id.zonedrop3);

        picutilisateur1 = (ImageView) findViewById(R.id.picutilisateur1);
        picutilisateur2 = (ImageView) findViewById(R.id.picutilisateur2);
        picutilisateur3 = (ImageView) findViewById(R.id.picutilisateur3);
        picutilisateur4 = (ImageView) findViewById(R.id.picutilisateur4);
        picutilisateur5 = (ImageView) findViewById(R.id.picutilisateur5);
        picutilisateur6 = (ImageView) findViewById(R.id.picutilisateur6);

        utilname1 = (TextView) findViewById(R.id.nomutilisateur1);
        utilname2 = (TextView) findViewById(R.id.nomutilisateur2);
        utilname3 = (TextView) findViewById(R.id.nomutilisateur3);
        utilname4 = (TextView) findViewById(R.id.nomutilisateur4);
        utilname5 = (TextView) findViewById(R.id.nomutilisateur5);
        utilname6 = (TextView) findViewById(R.id.nomutilisateur6);

        vertRema = (ImageView) findViewById(R.id.IVvertRema);
        jauneRema = (ImageView) findViewById(R.id.IVjauneRema);
        rougeRema = (ImageView) findViewById(R.id.IVrougeRema);
        bleuRema = (ImageView) findViewById(R.id.IVbleuRema);

        progressBarTempsParole = (ProgressBar) findViewById(R.id.progressbarParole);
        //endregion

        recuplist();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //region Listenerisation

        picutilisateur1.setOnLongClickListener(assigneUtilisateurORReminer);
        picutilisateur2.setOnLongClickListener(assigneUtilisateurORReminer);
        picutilisateur3.setOnLongClickListener(assigneUtilisateurORReminer);
        picutilisateur4.setOnLongClickListener(assigneUtilisateurORReminer);
        picutilisateur5.setOnLongClickListener(assigneUtilisateurORReminer);
        picutilisateur6.setOnLongClickListener(assigneUtilisateurORReminer);

        picutilisateur1.setOnClickListener(onClickpicture);
        picutilisateur2.setOnClickListener(onClickpicture);
        picutilisateur3.setOnClickListener(onClickpicture);
        picutilisateur4.setOnClickListener(onClickpicture);
        picutilisateur5.setOnClickListener(onClickpicture);
        picutilisateur6.setOnClickListener(onClickpicture);

        bleuRema.setOnLongClickListener(assigneUtilisateurORReminer);
        rougeRema.setOnLongClickListener(assigneUtilisateurORReminer);
        jauneRema.setOnLongClickListener(assigneUtilisateurORReminer);
        vertRema.setOnLongClickListener(assigneUtilisateurORReminer);

        zonededrop1.setOnDragListener(null);
        zonededrop2.setOnDragListener(null);
        zonededrop3.setOnDragListener(null);
        //endregion

        //region Generation manuelle de la liste des containers
        List<String> testlist = new ArrayList<String>();
        List<String> testlist2 = new ArrayList<String>();
        List<String> testlist3 = new ArrayList<String>();
        List<String> testlistserver = new ArrayList<String>();
        testlist.add("admin");
        testlist.add("antoine.duhesme");
        testlist.add("corentin.leal");

        testlist2.add("laurent.lieng");

        testlist3.add("corentin.leal");
        testlist3.add("antoine.duhesme");
        testlist3.add("jean.ingold");



        testcontainer.setUtilisateurs(testlist);
        testcontainer.setEtatdelatache("etat2");
        testcontainer.setRemaining(22);
        testcontainer.setTache("Voici une tâche créer dynamiquement, Sorry to post to an old question but I was able to fix it using a totally different solution. I was getting this exception but I changed the first line of my onCreatView override from this:");

        Global.listecontainer.add(testcontainer);

        testcontainer2.setUtilisateurs(testlist2);
        testcontainer2.setEtatdelatache("etat1");
        testcontainer2.setTache("deustache");
        testcontainer2.setRemaining(36);

        Global.listecontainer.add(testcontainer2);

        testcontainer3.setUtilisateurs(testlist3);
        testcontainer3.setEtatdelatache("etat3");
        testcontainer3.setTache("I noticed that when you print a View (implicitly calling toString()), the data printed includes the ID String used in layout files (the one you want) instead of the integer returned by getId(). So I looked at the source code for View's toString() to see how Android was getting that info, and it's actually not too complicated. Try this:");
        testcontainer3.setRemaining(27);

        Global.listecontainer.add(testcontainer3);

        //endregion

        //region Generation via appel API de la liste des containers
        apiInterface = RetrofitBuilder.getRetrofitBuilder().create(MyApiEndpointInterface.class);
        listeTachexemple = null;
        Call<ListeTaches> call = apiInterface.getAllTache();

        call.enqueue(new Callback<ListeTaches>() {
            @Override
            public void onResponse(Call<ListeTaches> call, Response<ListeTaches> response) {
                listeTachexemple = response.body();

                List<ListIssue> listissuestemp;

                if (listeTachexemple != null) {
                    listissuestemp = listeTachexemple.getListIssue();
                    for(ListIssue issue : listissuestemp) {
                        conversionIssueToContainer(issue);
                    }
                }
                ajouterTachesDynamiquement(Global.listecontainer);

                //region Listenerisation modulable
                linearLayoutTest = (LinearLayout) findViewById(R.id.fullscreen);
                //prendre tous les éléments de l'écran
                for (int index = 0; index < (linearLayoutTest).getChildCount(); ++index) {
                    View nextChild = (linearLayoutTest).getChildAt(index);
                    //Si c'est un ScrollView
                    if (nextChild instanceof ScrollView) {
                        scrollViewTest = (ScrollView) findViewById(nextChild.getId());
                        //prendre tous les éléments des scrollviews
                        for (int index2 = 0; index2 < (scrollViewTest).getChildCount(); ++index2) {
                            View nextChild2 = (scrollViewTest).getChildAt(index2);
                            //Si c'est un LinearLayout
                            if (nextChild2 instanceof LinearLayout) {
                                linearLayoutTest2 = (LinearLayout) findViewById(nextChild2.getId());
                                //prendre tous les éléments du LinearLayout
                                for (int index3 = 0; index3 < (linearLayoutTest2).getChildCount(); ++index3) {
                                    View nextChild3 = (linearLayoutTest2).getChildAt(index3);
                                    //Si c'est un RelativeLayout
                                    if (nextChild3 instanceof RelativeLayout) {
                                        containertemp = (RelativeLayout) findViewById(nextChild3.getId());
                                        containertemp.setOnLongClickListener(containerLongClickListener);
                                        containertemp.setOnClickListener(affichagepopupdisplaycontent);
                                    }
                                }
                            }
                        }
                    }
                }
                //endregion
            }

            @Override
            public void onFailure(Call<ListeTaches> call, Throwable t) {
                Log.i("test", "fail");
                Log.i("ERROR", t.getMessage());
            }
        });
        //endregion

        //region Listenerisation modulable
        /*linearLayoutTest = (LinearLayout) findViewById(R.id.fullscreen);
        //prendre tous les éléments de l'écran
        for (int index = 0; index < (linearLayoutTest).getChildCount(); ++index) {
            View nextChild = (linearLayoutTest).getChildAt(index);
            //Si c'est un ScrollView
            if (nextChild instanceof ScrollView) {
                scrollViewTest = (ScrollView) findViewById(nextChild.getId());
                //prendre tous les éléments des scrollviews
                for (int index2 = 0; index2 < (scrollViewTest).getChildCount(); ++index2) {
                    View nextChild2 = (scrollViewTest).getChildAt(index2);
                    //Si c'est un LinearLayout
                    if (nextChild2 instanceof LinearLayout) {
                        linearLayoutTest2 = (LinearLayout) findViewById(nextChild2.getId());
                        //prendre tous les éléments du LinearLayout
                        for (int index3 = 0; index3 < (linearLayoutTest2).getChildCount(); ++index3) {
                            View nextChild3 = (linearLayoutTest2).getChildAt(index3);
                            //Si c'est un RelativeLayout
                            if (nextChild3 instanceof RelativeLayout) {
                                containertemp = (RelativeLayout) findViewById(nextChild3.getId());
                                containertemp.setOnLongClickListener(containerLongClickListener);
                                containertemp.setOnClickListener(affichagepopupdisplaycontent);
                            }
                        }
                    }
                }
            }
        }*/
        //endregion

        //region Gestion du indicateur de temps de parole
        progressBarTempsParole.setBackgroundColor(getResources().getColor(R.color.bleutimer));
        progressBarTempsParole.setProgress(0);

        Thread t = new Thread(){
            @Override
            public void run() {
                super.run();
                try{
                    while (!isInterrupted()){
                        Thread.sleep(1500);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Integer progres = 0;
                                progres = progressBarTempsParole.getProgress() + 1;
                                if(progres > 80){
                                    progressBarTempsParole.setBackgroundColor(getResources().getColor(R.color.orangetimer));
                                }
                                if(progres > 100){
                                    progressBarTempsParole.setBackgroundColor(getResources().getColor(R.color.rougetimer));
                                }
                                progressBarTempsParole.setProgress(progres);
                            }
                        });
                    }
                }catch (Exception ex){
                    Log.i("error thread", String.valueOf(ex));
                }
            }
        };
        t.start();
        //endregion
    }

    private void conversionIssueToContainer(ListIssue issue) {

        List<String> utilisateur = new ArrayList<String>();
        Assignee assignetemp;

        //Log.i("description", String.valueOf(issue.getTitle()));
        //Log.i("status", issue.getStatus());
        //Log.i("Remainings", String.valueOf(issue.getTimeRemaining()));
        assignetemp = issue.getAssignee();
        //Log.i("utilisateur", assignetemp.getUsername());
        //Log.i("id", issue.getId());

        ContainerTache testcontainerfromserver = Global.lcontainertemp.get(Global.incrementeurtempcontainer);
        Global.incrementeurtempcontainer = Global.incrementeurtempcontainer + 1;

        testcontainerfromserver.setRemaining(10);
        testcontainerfromserver.setTache(String.valueOf(issue.getTitle()));
        testcontainerfromserver.setId(issue.getId());

        if (Objects.equals(issue.getStatus(), "Done")) {
            testcontainerfromserver.setEtatdelatache("etat3");
        }
        if (Objects.equals(issue.getStatus(), "To Do")) {
            testcontainerfromserver.setEtatdelatache("etat1");
        }
        if (Objects.equals(issue.getStatus(), "In Progress")) {
            testcontainerfromserver.setEtatdelatache("etat2");
        }
        utilisateur.add(assignetemp.getUsername());

        testcontainerfromserver.setUtilisateurs(utilisateur);

        //Log.i("description 2", testcontainerfromserver.getTache());
        //Log.i("status 2", testcontainerfromserver.getEtatdelatache());
        //Log.i("Remainings 2", String.valueOf(testcontainerfromserver.getRemaining()));
        //Log.i("utilisateur 2", String.valueOf(testcontainerfromserver.getUtilisateurs()));

        Global.listecontainer.add(testcontainerfromserver);
    }


    //region Affichage popup  (OnClickListener)
    View.OnClickListener affichagepopupdisplaycontent = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            AlertDialog.Builder mbuilder = new AlertDialog.Builder(MainActivity.this);
            final View mView = getLayoutInflater().inflate(R.layout.tachedeataille, null);

            containertemp2 = (RelativeLayout) findViewById(v.getId());
            containertemppopup = (RelativeLayout) findViewById(v.getId());


            for(int index=0; index<(containertemp2).getChildCount(); ++index) {
                View nextChild = (containertemp2).getChildAt(index);

                if (nextChild instanceof TextView) {
                    texttemp = (TextView) findViewById(nextChild.getId());
                    TextView textView = (TextView) mView.findViewById(R.id.popuptextdetaille);
                    textView.setText(texttemp.getText());

                    Global.dernierIDpopup=nextChild.getId();

                    final Button mButton = (Button) mView.findViewById(R.id.buttoncorrection);
                    final Button mButton2 = (Button) mView.findViewById(R.id.validationcorrection);

                    mButton.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View v) {
                            TextView mText = (TextView) mView.findViewById(R.id.popuptextdetaille);
                            mText.setVisibility(View.GONE);

                            EditText mEdit = (EditText) mView.findViewById(R.id.tachecorrigee);
                            mEdit.setText(mText.getText());

                            mEdit.setVisibility(View.VISIBLE);

                            mButton2.setVisibility(View.VISIBLE);
                        }
                    });

                    mButton2.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View v) {
                            EditText mEdit = (EditText) mView.findViewById(R.id.tachecorrigee);
                            TextView mText = (TextView) mView.findViewById(R.id.popuptextdetaille);

                            mText.setText(mEdit.getText());

                            mEdit.setVisibility(View.GONE);
                            mText.setVisibility(View.VISIBLE);

                            TextView texttache = (TextView) findViewById(Global.dernierIDpopup);
                            texttache.setText(mText.getText());

                            mButton2.setVisibility(View.GONE);
                        }
                    });

                    mbuilder.setView(mView);
                    AlertDialog dialog = mbuilder.create();
                    dialog.show();
                }
            }
        }
    };
    //endregion

    //region Focus sur les tâches de l'utilisateur  (OnClickListener)
    View.OnClickListener onClickpicture = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            //Tous les utilisateurs
            utilisateursList = (LinearLayout) findViewById(R.id.list_des_perso);
            for (int inde = 0; inde < (utilisateursList).getChildCount(); ++inde) {
                View nextChil = (utilisateursList).getChildAt(inde);
                if (nextChil instanceof ImageView) {
                    imageViewtemp = (ImageView) nextChil;
                    //mettre en transparence
                    imageViewtemp.setImageAlpha(128);
                }
            }

            imageViewtemp = (ImageView) findViewById(v.getId());
            imageViewtemp.setImageAlpha(255);

            linearLayoutTest = (LinearLayout) findViewById(R.id.fullscreen);
            //prendre tous les éléments de l'écran
            for (int index = 0; index < (linearLayoutTest).getChildCount(); ++index) {
                View nextChild = (linearLayoutTest).getChildAt(index);
                //Si c'est un ScrollView
                if (nextChild instanceof ScrollView) {
                    scrollViewTest = (ScrollView) findViewById(nextChild.getId());
                    //prendre tous les éléments des scrollviews
                    for (int index2 = 0; index2 < (scrollViewTest).getChildCount(); ++index2) {
                        View nextChild2 = (scrollViewTest).getChildAt(index2);
                        //Si c'est un LinearLayout
                        if (nextChild2 instanceof LinearLayout) {
                            linearLayoutTest2 = (LinearLayout) findViewById(nextChild2.getId());
                            //prendre tous les éléments du LinearLayout
                            for (int index3 = 0; index3 < (linearLayoutTest2).getChildCount(); ++index3) {
                                View nextChild3 = (linearLayoutTest2).getChildAt(index3);
                                //Si c'est un RelativeLayout
                                if (nextChild3 instanceof RelativeLayout) {
                                    containertemp = (RelativeLayout) findViewById(nextChild3.getId());
                                    containertemp.setAlpha(0.5F);
                                    for (int index4 = 0; index4 < (containertemp).getChildCount(); ++index4) {
                                        View nextChild4 = (containertemp).getChildAt(index4);
                                        if (nextChild4 instanceof ImageView) {

                                            ImageView imageViewtemp2 = (ImageView) findViewById(nextChild4.getId());

                                            if (imageViewtemp2.getTag() == imageViewtemp.getTag()) {
                                                containertemp.setAlpha(1F);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    //endregion

    //region Lancement Drag container  (OnLongClickListener)
    View.OnLongClickListener containerLongClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {

            linearLayoutTest = (LinearLayout) findViewById(R.id.fullscreen);
            //prendre tous les éléments de l'écran
            for (int index = 0; index < (linearLayoutTest).getChildCount(); ++index) {
                View nextChild = (linearLayoutTest).getChildAt(index);
                //Si c'est un ScrollView
                if (nextChild instanceof ScrollView) {
                    scrollViewTest = (ScrollView) findViewById(nextChild.getId());
                    //prendre tous les éléments des scrollviews
                    for (int index2 = 0; index2 < (scrollViewTest).getChildCount(); ++index2) {
                        View nextChild2 = (scrollViewTest).getChildAt(index2);
                        //Si c'est un LinearLayout
                        if (nextChild2 instanceof LinearLayout) {
                            linearLayoutTest2 = (LinearLayout) findViewById(nextChild2.getId());
                            //prendre tous les éléments du LinearLayout
                            for (int index3 = 0; index3 < (linearLayoutTest2).getChildCount(); ++index3) {
                                View nextChild3 = (linearLayoutTest2).getChildAt(index3);
                                //Si c'est un RelativeLayout
                                if (nextChild3 instanceof RelativeLayout) {
                                    containertemp = (RelativeLayout) findViewById(nextChild3.getId());
                                    containertemp.setOnDragListener(null);
                                    containertemp.setOnLongClickListener(containerLongClickListener);
                                }
                            }
                        }
                    }
                }
            }

            zonededrop1.setOnDragListener(onDragListener);
            zonededrop2.setOnDragListener(onDragListener);
            zonededrop3.setOnDragListener(onDragListener);

            ClipData clipData = ClipData.newPlainText("", "");
            View.DragShadowBuilder dragShadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(clipData, dragShadowBuilder, v, 0);
            v.setVisibility(View.GONE);
            return true;
        }
    };
    //endregion

    //region Assignation Utilisateur ou Reminer  (OnLongClickListener)
    View.OnLongClickListener assigneUtilisateurORReminer = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {

            zonededrop1.setOnDragListener(null);
            zonededrop2.setOnDragListener(null);
            zonededrop3.setOnDragListener(null);

            linearLayoutTest = (LinearLayout) findViewById(R.id.fullscreen);
            //prendre tous les éléments de l'écran
            for (int index = 0; index < (linearLayoutTest).getChildCount(); ++index) {
                View nextChild = (linearLayoutTest).getChildAt(index);
                //Si c'est un ScrollView
                if (nextChild instanceof ScrollView) {
                    scrollViewTest = (ScrollView) findViewById(nextChild.getId());
                    //prendre tous les éléments des scrollviews
                    for (int index2 = 0; index2 < (scrollViewTest).getChildCount(); ++index2) {
                        View nextChild2 = (scrollViewTest).getChildAt(index2);
                        //Si c'est un LinearLayout
                        if (nextChild2 instanceof LinearLayout) {
                            linearLayoutTest2 = (LinearLayout) findViewById(nextChild2.getId());
                            //prendre tous les éléments du LinearLayout
                            for (int index3 = 0; index3 < (linearLayoutTest2).getChildCount(); ++index3) {
                                View nextChild3 = (linearLayoutTest2).getChildAt(index3);
                                //Si c'est un RelativeLayout
                                if (nextChild3 instanceof RelativeLayout) {
                                    containertemp = (RelativeLayout) findViewById(nextChild3.getId());
                                    containertemp.setOnLongClickListener(null);
                                    containertemp.setOnDragListener(onDragListenerUserPic);
                                }
                            }
                        }
                    }
                }
            }

            bleuRema.setOnLongClickListener(assigneUtilisateurORReminer);
            rougeRema.setOnLongClickListener(assigneUtilisateurORReminer);
            jauneRema.setOnLongClickListener(assigneUtilisateurORReminer);
            vertRema.setOnLongClickListener(assigneUtilisateurORReminer);

            utilisateursList = (LinearLayout) findViewById(R.id.list_des_perso);
            for(int inde=0; inde<(utilisateursList).getChildCount(); ++inde) {
                View nextChil = (utilisateursList).getChildAt(inde);
                if (nextChil instanceof ImageView) {
                    imageViewtemp = (ImageView) nextChil;
                    imageViewtemp.setImageAlpha(255);
                }
            }

            linearLayoutTest = (LinearLayout) findViewById(R.id.fullscreen);

            for(int index=0; index<(linearLayoutTest).getChildCount(); ++index) {
                View nextChild = (linearLayoutTest).getChildAt(index);
                if (nextChild instanceof ScrollView) {

                    scrollViewTest = (ScrollView) findViewById(nextChild.getId());
                    for(int index2=0; index2<(scrollViewTest).getChildCount(); ++index2) {
                        View nextChild2 = (scrollViewTest).getChildAt(index2);
                        if (nextChild2 instanceof LinearLayout) {

                            linearLayoutTest2 = (LinearLayout) findViewById(nextChild2.getId());
                            for(int index3=0; index3<(linearLayoutTest2).getChildCount(); ++index3) {
                                View nextChild3 = (linearLayoutTest2).getChildAt(index3);
                                if (nextChild3 instanceof RelativeLayout) {

                                    containertemp = (RelativeLayout) findViewById(nextChild3.getId());
                                    containertemp.setAlpha(1F);
                                }
                            }
                        }
                    }
                }
            }

            ClipData clipData = ClipData.newPlainText("", "");
            View.DragShadowBuilder dragShadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(clipData, dragShadowBuilder, v, 0);
            return true;
        }
    };
    //endregion

    //region Drop container  (OnDragListener)
    View.OnDragListener onDragListener = new View.OnDragListener(){
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragevent=event.getAction();

            final View view = (View) event.getLocalState();

            containertemp = (RelativeLayout) findViewById(view.getId());

            switch (dragevent){
                case DragEvent.ACTION_DRAG_STARTED:
                    containertemp.setVisibility(View.GONE);

                case DragEvent.ACTION_DRAG_ENTERED:
                    break;

                case DragEvent.ACTION_DROP:

                    containertemp.setVisibility(View.VISIBLE);
                    if(v.getId()==R.id.zonedrop2){
                        ViewGroup from = (ViewGroup) view.getParent();
                        from.removeView(view);
                        LinearLayout container = (LinearLayout) findViewById(R.id.list_des_taches2);
                        container.addView(view);
                        changeStatus((String) view.getTag(), 2);
                        break;
                    }
                    if(v.getId()==R.id.zonedrop1){
                        ViewGroup from = (ViewGroup) view.getParent();
                        from.removeView(view);
                        LinearLayout container = (LinearLayout) findViewById(R.id.list_des_taches1);
                        container.addView(view);
                        changeStatus((String) view.getTag(), 1);
                        break;
                    }
                    if(v.getId()==R.id.zonedrop3){
                        ViewGroup from = (ViewGroup) view.getParent();
                        from.removeView(view);
                        LinearLayout container = (LinearLayout) findViewById(R.id.list_des_taches3);
                        container.addView(view);
                        changeStatus((String) view.getTag(), 3);
                        break;
                    }
                    break;
            }
            return true;
        }
    };
    //endregion

    //region Drop Utilisateur ou Reminer   (OnDragListener)
    View.OnDragListener onDragListenerUserPic = new View.OnDragListener(){
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragevent=event.getAction();

            final View view = (View) event.getLocalState();

            imageViewtemp = (ImageView) findViewById(view.getId());

            switch (dragevent){
                case DragEvent.ACTION_DRAG_STARTED:

                case DragEvent.ACTION_DRAG_ENTERED:
                    break;

                case DragEvent.ACTION_DROP:

                    int ender = 0;
                    int dejavu = 0;
                    containertemp = (RelativeLayout) findViewById(v.getId());

                    if(Objects.equals(String.valueOf(imageViewtemp.getTag()), "bleuR") || Objects.equals(String.valueOf(imageViewtemp.getTag()), "jauneR") || Objects.equals(String.valueOf(imageViewtemp.getTag()), "rougeR") || Objects.equals(String.valueOf(imageViewtemp.getTag()), "vertR"))
                    {
                        for(int indexR1=0; indexR1<(containertemp).getChildCount(); ++indexR1) {
                            View nextChildR1 = (containertemp).getChildAt(indexR1);

                            if (Objects.equals(String.valueOf(nextChildR1.getTag()), "deposeR")) {
                                ImageView temp = new ImageView(MainActivity.this);
                                linearLayoutTest = (LinearLayout) findViewById(nextChildR1.getId());

                                switch (String.valueOf(imageViewtemp.getTag())){
                                    case "bleuR":
                                        recalculerReminer(linearLayoutTest, 4);
                                        break;
                                    case "rougeR":
                                        recalculerReminer(linearLayoutTest, 10);
                                        break;
                                    case "vertR":
                                        recalculerReminer(linearLayoutTest, 1);
                                        break;
                                    case "jauneR":
                                        recalculerReminer(linearLayoutTest, 2);
                                        break;
                                }
                                LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(30, 30);

                            }
                        }

                        break;
                    }

                    for(int index=0; index<(containertemp).getChildCount(); ++index) {
                        View nextChild = (containertemp).getChildAt(index);
                        if(nextChild.getTag() != imageViewtemp.getTag()) {
                            if (nextChild instanceof ImageView) {
                                if (Objects.equals(String.valueOf(nextChild.getTag()), "unused") && ender == 0) {
                                    for(int indexx=0; indexx<(containertemp).getChildCount(); ++indexx) {
                                        View nextChildx = (containertemp).getChildAt(indexx);
                                        if (nextChildx instanceof ImageView) {
                                            imageViewtemp3 = (ImageView) findViewById(nextChildx.getId());
                                            if (nextChildx.getTag() == imageViewtemp.getTag()) {
                                                dejavu = 1;
                                                Toast.makeText(MainActivity.this,"Utilisateur déjà assigné à cette tâche",
                                                        Toast.LENGTH_LONG).show();
                                            }
                                        }
                                    }

                                    if(dejavu == 0){
                                        imageViewtemp2 = (ImageView) findViewById(nextChild.getId());
                                        imageViewtemp2.setVisibility(View.VISIBLE);
                                        imageViewtemp2.setImageDrawable(imageViewtemp.getDrawable());
                                        imageViewtemp2.setTag(imageViewtemp.getTag());
                                        ender = 1;
                                    }
                                    dejavu=0;
                                }
                            }
                        }
                    }
                    break;

            }

            linearLayoutTest = (LinearLayout) findViewById(R.id.fullscreen);
            //prendre tous les éléments de l'écran
            for (int index = 0; index < (linearLayoutTest).getChildCount(); ++index) {
                View nextChild = (linearLayoutTest).getChildAt(index);
                //Si c'est un ScrollView
                if (nextChild instanceof ScrollView) {
                    scrollViewTest = (ScrollView) findViewById(nextChild.getId());
                    //prendre tous les éléments des scrollviews
                    for (int index2 = 0; index2 < (scrollViewTest).getChildCount(); ++index2) {
                        View nextChild2 = (scrollViewTest).getChildAt(index2);
                        //Si c'est un LinearLayout
                        if (nextChild2 instanceof LinearLayout) {
                            linearLayoutTest2 = (LinearLayout) findViewById(nextChild2.getId());
                            //prendre tous les éléments du LinearLayout
                            for (int index3 = 0; index3 < (linearLayoutTest2).getChildCount(); ++index3) {
                                View nextChild3 = (linearLayoutTest2).getChildAt(index3);
                                //Si c'est un RelativeLayout
                                if (nextChild3 instanceof RelativeLayout) {
                                    containertemp = (RelativeLayout) findViewById(nextChild3.getId());
                                    containertemp.setOnLongClickListener(containerLongClickListener);
                                }
                            }
                        }
                    }
                }
            }
            return true;
        }
    };
    //endregion



    public void ajouterTachesDynamiquement(List<ContainerTache> listecontainer){

        for(ContainerTache containerfl : listecontainer) {
            creationContainer(containerfl);
        }
    }

    public void creationContainer(ContainerTache container){

        LinearLayout ttt;

        RelativeLayout construction = new RelativeLayout(this);
        TextView tempText = new TextView(MainActivity.this);
        ImageView tempImageDY1 = new ImageView(MainActivity.this);
        ImageView tempImageDY2 = new ImageView(MainActivity.this);
        ImageView tempImageDY3 = new ImageView(MainActivity.this);
        ImageView tempImageDY4 = new ImageView(MainActivity.this);
        LinearLayout linearTemp = new LinearLayout(MainActivity.this);

        LinearLayout.LayoutParams paramsContainer = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        paramsContainer.setMargins(15,15,15,15);
        construction.setLayoutParams(paramsContainer);
        construction.setBackgroundResource(R.color.colorgris);

        RelativeLayout.LayoutParams paramsImage1 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        paramsImage1.setMargins(4,4,4,4);
        paramsImage1.height = 60;
        paramsImage1.width = 60;
        tempImageDY1.setVisibility(View.GONE);



        if(container.getUtilisateurs().size() > 0) {

            utilisateursList = (LinearLayout) findViewById(R.id.list_des_perso);
            for (int index = 0; index < (utilisateursList).getChildCount(); ++index) {
                View nextChild = (utilisateursList).getChildAt(index);
                if (nextChild instanceof ImageView) {
                    imageViewtemp = (ImageView) nextChild;
                    if(String.valueOf(imageViewtemp.getTag()).equals(String.valueOf(container.getUtilisateurs().get(0)))){
                        tempImageDY1.setImageDrawable(imageViewtemp.getDrawable());
                        tempImageDY1.setTag(imageViewtemp.getTag());
                    }
                }
            }
            tempImageDY1.setVisibility(View.VISIBLE);
        }else{
            tempImageDY1.setTag("unused");
        }



        tempImageDY1.setId(Global.idImagelist.get(Global.incrementeurIDimage));
        Global.incrementeurIDimage = Global.incrementeurIDimage + 1;

        RelativeLayout.LayoutParams paramsImage2 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        paramsImage2.setMargins(4,4,4,4);
        paramsImage2.height = 60;
        paramsImage2.width = 60;
        paramsImage2.addRule(RelativeLayout.BELOW, Global.idImagelist.get(Global.incrementeurIDimage - 1));
        tempImageDY2.setVisibility(View.GONE);


        if(container.getUtilisateurs().size() > 1) {
            utilisateursList = (LinearLayout) findViewById(R.id.list_des_perso);
            for (int index = 0; index < (utilisateursList).getChildCount(); ++index) {
                View nextChild = (utilisateursList).getChildAt(index);
                if (nextChild instanceof ImageView) {
                    imageViewtemp = (ImageView) nextChild;
                    if (String.valueOf(imageViewtemp.getTag()).equals(String.valueOf(container.getUtilisateurs().get(1)))) {
                        tempImageDY2.setImageDrawable(imageViewtemp.getDrawable());
                        tempImageDY2.setTag(imageViewtemp.getTag());
                    }
                }
            }
            tempImageDY2.setVisibility(View.VISIBLE);
        }else{
            tempImageDY2.setTag("unused");
        }


        tempImageDY2.setId(Global.idImagelist.get(Global.incrementeurIDimage));
        Global.incrementeurIDimage = Global.incrementeurIDimage + 1;

        RelativeLayout.LayoutParams paramsImage3 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        paramsImage3.setMargins(4,4,4,4);
        paramsImage3.height = 60;
        paramsImage3.width = 60;
        paramsImage3.addRule(RelativeLayout.BELOW, Global.idImagelist.get(Global.incrementeurIDimage - 1));
        tempImageDY3.setVisibility(View.GONE);


        if(container.getUtilisateurs().size() > 2) {
            utilisateursList = (LinearLayout) findViewById(R.id.list_des_perso);
            for (int index = 0; index < (utilisateursList).getChildCount(); ++index) {
                View nextChild = (utilisateursList).getChildAt(index);
                if (nextChild instanceof ImageView) {
                    imageViewtemp = (ImageView) nextChild;
                    if(String.valueOf(imageViewtemp.getTag()).equals(String.valueOf(container.getUtilisateurs().get(2)))){
                        tempImageDY3.setImageDrawable(imageViewtemp.getDrawable());
                        tempImageDY3.setTag(imageViewtemp.getTag());
                    }
                }
            }
            tempImageDY3.setVisibility(View.VISIBLE);
        }else{
            tempImageDY3.setTag("unused");
        }


        tempImageDY3.setId(Global.idImagelist.get(Global.incrementeurIDimage));
        Global.incrementeurIDimage = Global.incrementeurIDimage + 1;

        RelativeLayout.LayoutParams paramsImage4 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        paramsImage4.setMargins(4,4,4,4);
        paramsImage4.height = 60;
        paramsImage4.width = 60;
        paramsImage4.addRule(RelativeLayout.BELOW, Global.idImagelist.get(Global.incrementeurIDimage - 1));
        tempImageDY4.setVisibility(View.GONE);


        if(container.getUtilisateurs().size() > 3) {
            utilisateursList = (LinearLayout) findViewById(R.id.list_des_perso);
            for (int index = 0; index < (utilisateursList).getChildCount(); ++index) {
                View nextChild = (utilisateursList).getChildAt(index);
                if (nextChild instanceof ImageView) {
                    imageViewtemp = (ImageView) nextChild;
                    if(String.valueOf(imageViewtemp.getTag()).equals(String.valueOf(container.getUtilisateurs().get(3)))){
                        tempImageDY4.setImageDrawable(imageViewtemp.getDrawable());
                        tempImageDY4.setTag(imageViewtemp.getTag());
                    }
                }
            }
            tempImageDY4.setVisibility(View.VISIBLE);
        }else{
            tempImageDY4.setTag("unused");
        }


        tempImageDY4.setId(Global.idImagelist.get(Global.incrementeurIDimage));
        Global.incrementeurIDimage = Global.incrementeurIDimage + 1;


        RelativeLayout.LayoutParams paramsText = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        paramsText.setMargins(10,10,10,10);
        paramsText.addRule(RelativeLayout.RIGHT_OF, Global.idImagelist.get(Global.incrementeurIDimage - 4));

        tempText.setText(container.getTache());
        tempText.setTextSize(2,15);
        tempText.setEllipsize(TextUtils.TruncateAt.END);
        tempText.setMaxLines(5);
        tempText.setId(Global.idTextlist.get(Global.incrementeurIDtext));
        Global.incrementeurIDtext = Global.incrementeurIDtext + 1;

        RelativeLayout.LayoutParams paramsLinearDepose = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        paramsLinearDepose.setMargins(10,10,10,10);
        paramsLinearDepose.addRule(RelativeLayout.BELOW, Global.idTextlist.get(Global.incrementeurIDtext - 1));
        paramsLinearDepose.addRule(RelativeLayout.RIGHT_OF, Global.idImagelist.get(Global.incrementeurIDimage - 4));
        linearTemp.setTag("deposeR");
        linearTemp.setOrientation(LinearLayout.HORIZONTAL);
        linearTemp.setId(Global.idLinearlist.get(Global.incrementeurIDlinear));
        Global.incrementeurIDlinear = Global.incrementeurIDlinear + 1;

        if(container.getRemaining()<41){
            ajouterReminerCorrespondant(linearTemp, Global.remainingsDistibution[container.getRemaining()]);
        }
        else {
            Toast.makeText(getApplicationContext(), "La tâche "+container.getTache()+" à un trop long remaining", Toast.LENGTH_LONG).show();
        }

        construction.addView(tempImageDY1, paramsImage1);
        construction.addView(tempImageDY2, paramsImage2);
        construction.addView(tempImageDY3, paramsImage3);
        construction.addView(tempImageDY4, paramsImage4);
        construction.addView(tempText, paramsText);
        construction.addView(linearTemp, paramsLinearDepose);
        construction.setTag(container.getId());

        construction.setId(Global.idContainerlist.get(Global.incrementeurIDcontainer));
        Global.incrementeurIDcontainer = Global.incrementeurIDcontainer + 1;

        if(container.getEtatdelatache().equals("etat1")){
            ttt = (LinearLayout) findViewById(R.id.list_des_taches1);
            ttt.addView(construction);
        }
        if(container.getEtatdelatache().equals("etat2")){
            ttt = (LinearLayout) findViewById(R.id.list_des_taches2);
            ttt.addView(construction);
        }
        if(container.getEtatdelatache().equals("etat3")){
            ttt = (LinearLayout) findViewById(R.id.list_des_taches3);
            ttt.addView(construction);
        }

    }

    public void ajouterReminerCorrespondant(LinearLayout layout, String reminerDistribution){

        //region gestion reminer
        String[] parts = reminerDistribution.split(",");
        Integer i = 0;

        layout.removeAllViews();

        ImageView temp;

        ImageView temp1 = new ImageView(MainActivity.this);
        ImageView temp2 = new ImageView(MainActivity.this);
        ImageView temp3 = new ImageView(MainActivity.this);
        ImageView temp4 = new ImageView(MainActivity.this);
        ImageView temp5 = new ImageView(MainActivity.this);
        ImageView temp6 = new ImageView(MainActivity.this);

        List<ImageView> listIV = new ArrayList<>();
        listIV.add(temp1);
        listIV.add(temp2);
        listIV.add(temp3);
        listIV.add(temp4);
        listIV.add(temp5);
        listIV.add(temp6);

        LinearLayout.LayoutParams paramsReminer = new LinearLayout.LayoutParams(30, 30);

        paramsReminer.setMargins(10,0,10,10);
        paramsReminer.height = 30;
        paramsReminer.width = 30;

        for(String couleur : parts){
            temp = listIV.get(i);
            i++;
            switch (couleur){
                case "bleu":
                    temp.setBackgroundColor(ContextCompat.getColor(this, R.color.bleuremaining));
                    temp.setTag("bleuR");
                    layout.addView(temp, paramsReminer);
                    break;
                case "vert":
                    temp.setBackgroundColor(ContextCompat.getColor(this, R.color.vertremaining));
                    temp.setTag("vertR");
                    layout.addView(temp, paramsReminer);
                    break;
                case "jaune":
                    temp.setBackgroundColor(ContextCompat.getColor(this, R.color.jauneremaining));
                    temp.setTag("jauneR");
                    layout.addView(temp, paramsReminer);
                    break;
                case "rouge":
                    temp.setBackgroundColor(ContextCompat.getColor(this, R.color.rougeremaining));
                    temp.setTag("rougeR");
                    layout.addView(temp, paramsReminer);
                    break;
            }
        }
        //endregion
    }

    public void recalculerReminer(LinearLayout layout, Integer valuetoadd){

        Integer valuework=0;
        String distribution;

        valuework=valuework+valuetoadd;

        for(int index=0; index<(layout).getChildCount(); ++index) {
            View nextChild = (layout).getChildAt(index);
            if (nextChild instanceof ImageView) {
                switch (String.valueOf(nextChild.getTag())){
                    case "bleuR":
                        valuework=valuework+4;
                        break;
                    case "rougeR":
                        valuework=valuework+10;
                        break;
                    case "vertR":
                        valuework=valuework+1;
                        break;
                    case "jauneR":
                        valuework=valuework+2;
                        break;
                }
            }
        }
        if(valuework<41) {
            distribution = Global.remainingsDistibution[valuework];
            Log.i("final", String.valueOf(valuework));
            Log.i("final", distribution);
            ajouterReminerCorrespondant(layout, distribution);
        }else {
            Toast.makeText(this,"Remining spérieur à 20 jours!",Toast.LENGTH_LONG).show();
        }

    }

    public void global_variable_set() {

        Global.idImagelist.clear();
        Global.incrementeurIDimage = 0;
        Global.idImagelist.add(R.id.IVid1);
        Global.idImagelist.add(R.id.IVid2);
        Global.idImagelist.add(R.id.IVid3);
        Global.idImagelist.add(R.id.IVid4);
        Global.idImagelist.add(R.id.IVid5);
        Global.idImagelist.add(R.id.IVid6);
        Global.idImagelist.add(R.id.IVid7);
        Global.idImagelist.add(R.id.IVid8);
        Global.idImagelist.add(R.id.IVid9);
        Global.idImagelist.add(R.id.IVid10);
        Global.idImagelist.add(R.id.IVid11);
        Global.idImagelist.add(R.id.IVid12);
        Global.idImagelist.add(R.id.IVid13);
        Global.idImagelist.add(R.id.IVid14);
        Global.idImagelist.add(R.id.IVid15);
        Global.idImagelist.add(R.id.IVid16);
        Global.idImagelist.add(R.id.IVid17);
        Global.idImagelist.add(R.id.IVid18);
        Global.idImagelist.add(R.id.IVid19);
        Global.idImagelist.add(R.id.IVid20);
        Global.idImagelist.add(R.id.IVid21);
        Global.idImagelist.add(R.id.IVid22);
        Global.idImagelist.add(R.id.IVid23);
        Global.idImagelist.add(R.id.IVid24);
        Global.idImagelist.add(R.id.IVid25);
        Global.idImagelist.add(R.id.IVid26);
        Global.idImagelist.add(R.id.IVid27);
        Global.idImagelist.add(R.id.IVid28);
        Global.idImagelist.add(R.id.IVid29);
        Global.idImagelist.add(R.id.IVid30);
        Global.idImagelist.add(R.id.IVid31);
        Global.idImagelist.add(R.id.IVid32);
        Global.idImagelist.add(R.id.IVid33);
        Global.idImagelist.add(R.id.IVid34);
        Global.idImagelist.add(R.id.IVid35);
        Global.idImagelist.add(R.id.IVid36);
        Global.idImagelist.add(R.id.IVid37);
        Global.idImagelist.add(R.id.IVid38);
        Global.idImagelist.add(R.id.IVid39);
        Global.idImagelist.add(R.id.IVid40);
        Global.idImagelist.add(R.id.IVid41);
        Global.idImagelist.add(R.id.IVid42);
        Global.idImagelist.add(R.id.IVid43);
        Global.idImagelist.add(R.id.IVid44);
        Global.idImagelist.add(R.id.IVid45);
        Global.idImagelist.add(R.id.IVid46);
        Global.idImagelist.add(R.id.IVid47);
        Global.idImagelist.add(R.id.IVid48);
        Global.idImagelist.add(R.id.IVid49);
        Global.idImagelist.add(R.id.IVid50);
        Global.idImagelist.add(R.id.IVid51);
        Global.idImagelist.add(R.id.IVid52);
        Global.idImagelist.add(R.id.IVid53);
        Global.idImagelist.add(R.id.IVid54);
        Global.idImagelist.add(R.id.IVid55);
        Global.idImagelist.add(R.id.IVid56);
        Global.idImagelist.add(R.id.IVid57);
        Global.idImagelist.add(R.id.IVid58);
        Global.idImagelist.add(R.id.IVid59);
        Global.idImagelist.add(R.id.IVid60);
        Global.idImagelist.add(R.id.IVid61);
        Global.idImagelist.add(R.id.IVid62);
        Global.idImagelist.add(R.id.IVid63);
        Global.idImagelist.add(R.id.IVid64);
        Global.idImagelist.add(R.id.IVid65);
        Global.idImagelist.add(R.id.IVid66);
        Global.idImagelist.add(R.id.IVid67);
        Global.idImagelist.add(R.id.IVid68);
        Global.idImagelist.add(R.id.IVid69);
        Global.idImagelist.add(R.id.IVid70);
        Global.idImagelist.add(R.id.IVid71);
        Global.idImagelist.add(R.id.IVid72);
        Global.idImagelist.add(R.id.IVid73);
        Global.idImagelist.add(R.id.IVid74);
        Global.idImagelist.add(R.id.IVid75);
        Global.idImagelist.add(R.id.IVid76);
        Global.idImagelist.add(R.id.IVid77);
        Global.idImagelist.add(R.id.IVid78);
        Global.idImagelist.add(R.id.IVid79);
        Global.idImagelist.add(R.id.IVid80);

        Global.idTextlist.clear();
        Global.incrementeurIDtext =0;
        Global.idTextlist.add(R.id.TVid1);
        Global.idTextlist.add(R.id.TVid2);
        Global.idTextlist.add(R.id.TVid3);
        Global.idTextlist.add(R.id.TVid4);
        Global.idTextlist.add(R.id.TVid5);
        Global.idTextlist.add(R.id.TVid6);
        Global.idTextlist.add(R.id.TVid7);
        Global.idTextlist.add(R.id.TVid8);
        Global.idTextlist.add(R.id.TVid9);
        Global.idTextlist.add(R.id.TVid10);
        Global.idTextlist.add(R.id.TVid11);
        Global.idTextlist.add(R.id.TVid12);
        Global.idTextlist.add(R.id.TVid13);
        Global.idTextlist.add(R.id.TVid14);
        Global.idTextlist.add(R.id.TVid15);
        Global.idTextlist.add(R.id.TVid16);
        Global.idTextlist.add(R.id.TVid17);
        Global.idTextlist.add(R.id.TVid18);
        Global.idTextlist.add(R.id.TVid19);
        Global.idTextlist.add(R.id.TVid20);

        Global.idContainerlist.clear();
        Global.idContainerlist.add(R.id.Containerid1);
        Global.idContainerlist.add(R.id.Containerid2);
        Global.idContainerlist.add(R.id.Containerid3);
        Global.idContainerlist.add(R.id.Containerid4);
        Global.idContainerlist.add(R.id.Containerid5);
        Global.idContainerlist.add(R.id.Containerid6);
        Global.idContainerlist.add(R.id.Containerid7);
        Global.idContainerlist.add(R.id.Containerid8);
        Global.idContainerlist.add(R.id.Containerid9);
        Global.idContainerlist.add(R.id.Containerid10);
        Global.idContainerlist.add(R.id.Containerid11);
        Global.idContainerlist.add(R.id.Containerid12);
        Global.idContainerlist.add(R.id.Containerid13);
        Global.idContainerlist.add(R.id.Containerid14);
        Global.idContainerlist.add(R.id.Containerid15);
        Global.idContainerlist.add(R.id.Containerid16);
        Global.idContainerlist.add(R.id.Containerid17);
        Global.idContainerlist.add(R.id.Containerid18);
        Global.idContainerlist.add(R.id.Containerid19);
        Global.idContainerlist.add(R.id.Containerid20);

        Global.idLinearlist.clear();
        Global.idLinearlist.add(R.id.Linearid1);
        Global.idLinearlist.add(R.id.Linearid2);
        Global.idLinearlist.add(R.id.Linearid3);
        Global.idLinearlist.add(R.id.Linearid4);
        Global.idLinearlist.add(R.id.Linearid5);
        Global.idLinearlist.add(R.id.Linearid6);
        Global.idLinearlist.add(R.id.Linearid7);
        Global.idLinearlist.add(R.id.Linearid8);
        Global.idLinearlist.add(R.id.Linearid9);
        Global.idLinearlist.add(R.id.Linearid10);
        Global.idLinearlist.add(R.id.Linearid11);
        Global.idLinearlist.add(R.id.Linearid12);
        Global.idLinearlist.add(R.id.Linearid13);
        Global.idLinearlist.add(R.id.Linearid14);
        Global.idLinearlist.add(R.id.Linearid15);
        Global.idLinearlist.add(R.id.Linearid16);
        Global.idLinearlist.add(R.id.Linearid17);
        Global.idLinearlist.add(R.id.Linearid18);
        Global.idLinearlist.add(R.id.Linearid19);
        Global.idLinearlist.add(R.id.Linearid20);

        Global.lcontainertemp.clear();
        ContainerTache testcontainer1 = new ContainerTache();
        Global.lcontainertemp.add(testcontainer1);
        ContainerTache testcontainer2 = new ContainerTache();
        Global.lcontainertemp.add(testcontainer2);
        ContainerTache testcontainer3 = new ContainerTache();
        Global.lcontainertemp.add(testcontainer3);
        ContainerTache testcontainer4 = new ContainerTache();
        Global.lcontainertemp.add(testcontainer4);
        ContainerTache testcontainer5 = new ContainerTache();
        Global.lcontainertemp.add(testcontainer5);
        ContainerTache testcontainer6 = new ContainerTache();
        Global.lcontainertemp.add(testcontainer6);
        ContainerTache testcontainer7 = new ContainerTache();
        Global.lcontainertemp.add(testcontainer7);
        ContainerTache testcontainer8 = new ContainerTache();
        Global.lcontainertemp.add(testcontainer8);
        ContainerTache testcontainer9 = new ContainerTache();
        Global.lcontainertemp.add(testcontainer9);
        ContainerTache testcontainer10 = new ContainerTache();
        Global.lcontainertemp.add(testcontainer10);
        ContainerTache testcontainer11 = new ContainerTache();
        Global.lcontainertemp.add(testcontainer11);
        ContainerTache testcontainer12 = new ContainerTache();
        Global.lcontainertemp.add(testcontainer12);
        ContainerTache testcontainer13 = new ContainerTache();
        Global.lcontainertemp.add(testcontainer13);
        ContainerTache testcontainer14 = new ContainerTache();
        Global.lcontainertemp.add(testcontainer14);
        ContainerTache testcontainer15 = new ContainerTache();
        Global.lcontainertemp.add(testcontainer15);
        ContainerTache testcontainer16 = new ContainerTache();
        Global.lcontainertemp.add(testcontainer16);
        ContainerTache testcontainer17 = new ContainerTache();
        Global.lcontainertemp.add(testcontainer17);
        ContainerTache testcontainer18 = new ContainerTache();
        Global.lcontainertemp.add(testcontainer18);
        ContainerTache testcontainer19 = new ContainerTache();
        Global.lcontainertemp.add(testcontainer19);
        ContainerTache testcontainer20 = new ContainerTache();
        Global.lcontainertemp.add(testcontainer20);
    }

    public void posttest(View view) {

        ChangeStatus change = new ChangeStatus();
        change.setStatus_id(3);
        HashMap<String, String> header = new HashMap<String, String>();
        header.put("Content-type", "application/x-www-form-urlencoded");

        String envois = "\"status_id\": 3";

        ClassTemp classTemp = new ClassTemp();
        classTemp.setStrange("laurent");

        apiInterface = RetrofitBuilder.getRetrofitBuilder().create(MyApiEndpointInterface.class);


        //Call<Void> call = apiInterface.changestatus("TA-1", header, change);
        //Call<Void> call = apiInterface.changestatu(classTemp);
        Call<Void> call = apiInterface.changestatusget("TA-1", 2);

        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                Log.i("test", "sucess");
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.i("test", "fail");
            }
        });
    }

    public void reinitilisationTimer(View view) {
        progressBarTempsParole.setProgress(0);
        progressBarTempsParole.setBackgroundColor(getResources().getColor(R.color.bleutimer));
    }

    public void changeStatus(String id, Integer status){

        apiInterface = RetrofitBuilder.getRetrofitBuilder().create(MyApiEndpointInterface.class);
        Call<Void> call = apiInterface.changestatusget(id, status);

        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                Log.i("test", "sucess");
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.i("test", "fail");
            }
        });
    }

    public void recuplist(){
        final List<ImageView>imgV = new ArrayList<>();

        imgV.add(picutilisateur1);
        imgV.add(picutilisateur2);
        imgV.add(picutilisateur3);
        imgV.add(picutilisateur4);
        imgV.add(picutilisateur5);
        imgV.add(picutilisateur6);


        apiInterface = RetrofitBuilder.getRetrofitBuilder().create(MyApiEndpointInterface.class);
        Call<Utilisateurs> call = apiInterface.getAllUtilisateurs("TA");

        call.enqueue(new Callback<Utilisateurs>() {
            @Override
            public void onResponse(Call<Utilisateurs> call, Response<Utilisateurs> response) {
                utilisateurs = response.body();
                members = utilisateurs.getListMember();

                for(ListMember member : members){

                    if(!member.getId().matches("(?i).*addon.*"))
                    {
                        if(index <6) {
                            Log.i("membre", member.getId());
                            imageViewtemp = imgV.get(index);
                            imageViewtemp.setTag(member.getId());
                            index++;
                        }else{
                            Toast.makeText(MainActivity.this, "Trop d'utilisateurs dans JIRA", Toast.LENGTH_LONG).show();
                        }

                    }
                }

            }

            @Override
            public void onFailure(Call<Utilisateurs> call, Throwable t) {

            }
        });
    }
}
