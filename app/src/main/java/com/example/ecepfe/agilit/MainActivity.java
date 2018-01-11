package com.example.ecepfe.agilit;

import android.content.ClipData;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;


public class MainActivity extends AppCompatActivity {

    ScrollView zonededrop1, zonededrop2, zonededrop3, scrollViewTest;
    LinearLayout linearLayoutTest, linearLayoutTest2, utilisateursList;
    TextView textcont1, textcont2, textcont3, textcont4, textcont5, textcont6, texttemp;
    ImageView picutilisateur1, picutilisateur2, picutilisateur3, picutilisateur4, picutilisateur5, picutilisateur6, imageViewtemp, imageViewtemp2, imageViewtemp3;
    RelativeLayout container1, container2, container3, container4, container5, container6, containertemp, containertemp2, containertemppopup;
    Button mButton;
    //List<String> myimagetag = new ArrayList<String>();

    Integer Toggle = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Déplacez les tâches");

        zonededrop1 = (ScrollView) findViewById(R.id.zonedrop1);
        zonededrop2 = (ScrollView) findViewById(R.id.zonedrop2);
        zonededrop3 = (ScrollView) findViewById(R.id.zonedrop3);

        container1 = (RelativeLayout) findViewById(R.id.container1);
        container2 = (RelativeLayout) findViewById(R.id.container2);
        container3 = (RelativeLayout) findViewById(R.id.container3);
        container4 = (RelativeLayout) findViewById(R.id.container4);
        container5 = (RelativeLayout) findViewById(R.id.container5);
        container6 = (RelativeLayout) findViewById(R.id.container6);

        textcont1 = (TextView) findViewById(R.id.contenertext1);
        textcont2 = (TextView) findViewById(R.id.contenertext2);
        textcont3 = (TextView) findViewById(R.id.contenertext3);
        textcont4 = (TextView) findViewById(R.id.contenertext4);
        textcont5 = (TextView) findViewById(R.id.contenertext5);
        textcont6 = (TextView) findViewById(R.id.contenertext6);

        picutilisateur1 = (ImageView) findViewById(R.id.picutilisateur1);
        picutilisateur2 = (ImageView) findViewById(R.id.picutilisateur2);
        picutilisateur3 = (ImageView) findViewById(R.id.picutilisateur3);
        picutilisateur4 = (ImageView) findViewById(R.id.picutilisateur4);
        picutilisateur5 = (ImageView) findViewById(R.id.picutilisateur5);
        picutilisateur6 = (ImageView) findViewById(R.id.picutilisateur6);



        container1.setOnLongClickListener(containerLongClickListener);
        container2.setOnLongClickListener(containerLongClickListener);
        container3.setOnLongClickListener(containerLongClickListener);
        container4.setOnLongClickListener(containerLongClickListener);
        container5.setOnLongClickListener(containerLongClickListener);
        container6.setOnLongClickListener(containerLongClickListener);

        container1.setOnClickListener(affichagepopupdisplaycontent);
        container2.setOnClickListener(affichagepopupdisplaycontent);
        container3.setOnClickListener(affichagepopupdisplaycontent);
        container4.setOnClickListener(affichagepopupdisplaycontent);
        container5.setOnClickListener(affichagepopupdisplaycontent);
        container6.setOnClickListener(affichagepopupdisplaycontent);

        picutilisateur1.setOnLongClickListener(DisplaylongClickListenerUtilisateur);
        picutilisateur2.setOnLongClickListener(DisplaylongClickListenerUtilisateur);
        picutilisateur3.setOnLongClickListener(DisplaylongClickListenerUtilisateur);
        picutilisateur4.setOnLongClickListener(DisplaylongClickListenerUtilisateur);
        picutilisateur5.setOnLongClickListener(DisplaylongClickListenerUtilisateur);
        picutilisateur6.setOnLongClickListener(DisplaylongClickListenerUtilisateur);

        zonededrop1.setOnDragListener(onDragListener);
        zonededrop2.setOnDragListener(onDragListener);
        zonededrop3.setOnDragListener(onDragListener);
    }



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

                    /*for(int index2=0; index2<(containertemppopup).getChildCount(); ++index2) {
                        View nextChild2 = (containertemppopup).getChildAt(index2);
                        if (nextChild2 instanceof ImageView) {
                            imageViewtemp = (ImageView) findViewById(nextChild2.getId());
                            myimagetag.add(String.valueOf(imageViewtemp.getTag()));
                        }
                    }

                    Iterator<String> myListIterator = myimagetag.iterator();
                    while (myListIterator.hasNext()) {
                        String coord = myListIterator.next();
                    }

                    containertemp = (RelativeLayout) mView.findViewById(R.id.popup);
                    for(int index3=0; index3<(containertemp).getChildCount(); ++index3) {
                        View nextChild3 = (containertemp).getChildAt(index3);
                        if (nextChild3 instanceof ImageView) {
                            imageViewtemp2 = (ImageView) findViewById(nextChild3.getId());

                        }
                    }*/

                    mbuilder.setView(mView);
                    AlertDialog dialog = mbuilder.create();
                    dialog.show();
                }
            }
        }
    };


    View.OnLongClickListener containerLongClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            ClipData clipData = ClipData.newPlainText("", "");
            View.DragShadowBuilder dragShadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(clipData, dragShadowBuilder, v, 0);
            v.setVisibility(View.GONE);
            return true;
        }
    };

    View.OnLongClickListener assigneUtilisateur = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            ClipData clipData = ClipData.newPlainText("", "");
            View.DragShadowBuilder dragShadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(clipData, dragShadowBuilder, v, 0);
            return true;
        }
    };

    View.OnLongClickListener DisplaylongClickListenerUtilisateur = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {

            utilisateursList = (LinearLayout) findViewById(R.id.list_des_perso);
            for(int inde=0; inde<(utilisateursList).getChildCount(); ++inde) {
                View nextChil = (utilisateursList).getChildAt(inde);
                if (nextChil instanceof ImageView) {
                    imageViewtemp = (ImageView) nextChil;
                    imageViewtemp.setImageAlpha(128);
                }
            }

            imageViewtemp = (ImageView) findViewById(v.getId());
            imageViewtemp.setImageAlpha(255);

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
                                    containertemp.setAlpha(0.5F);
                                    for(int index4=0; index4<(containertemp).getChildCount(); ++index4) {
                                        View nextChild4 = (containertemp).getChildAt(index4);
                                        if (nextChild4 instanceof ImageView) {

                                            ImageView imageViewtemp2 = (ImageView) findViewById(nextChild4.getId());

                                            if (imageViewtemp2.getTag() == imageViewtemp.getTag()){
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
            return true;
        }
    };


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
                        //LinearLayout container = (LinearLayout) v;
                        LinearLayout container = (LinearLayout) findViewById(R.id.list_des_taches2);
                        container.addView(view);
                        break;
                    }
                    if(v.getId()==R.id.zonedrop1){
                        ViewGroup from = (ViewGroup) view.getParent();
                        from.removeView(view);
                        LinearLayout container = (LinearLayout) findViewById(R.id.list_des_taches1);
                        container.addView(view);
                        break;
                    }
                    if(v.getId()==R.id.zonedrop3){
                        ViewGroup from = (ViewGroup) view.getParent();
                        from.removeView(view);
                        LinearLayout container = (LinearLayout) findViewById(R.id.list_des_taches3);
                        container.addView(view);
                        break;
                    }
                    break;
            }
            return true;
        }
    };


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
            return true;
        }
    };


    public void launchActiviteAssign(View view) {

        mButton = (Button) findViewById(R.id.boutonassign);

        if(Toggle == 1) {
            zonededrop1.setOnDragListener(null);
            zonededrop2.setOnDragListener(null);
            zonededrop3.setOnDragListener(null);

            container1.setOnLongClickListener(null);
            container2.setOnLongClickListener(null);
            container3.setOnLongClickListener(null);
            container4.setOnLongClickListener(null);
            container5.setOnLongClickListener(null);
            container6.setOnLongClickListener(null);

            container1.setOnDragListener(onDragListenerUserPic);
            container2.setOnDragListener(onDragListenerUserPic);
            container3.setOnDragListener(onDragListenerUserPic);
            container4.setOnDragListener(onDragListenerUserPic);
            container5.setOnDragListener(onDragListenerUserPic);
            container6.setOnDragListener(onDragListenerUserPic);

            picutilisateur1.setOnLongClickListener(assigneUtilisateur);
            picutilisateur2.setOnLongClickListener(assigneUtilisateur);
            picutilisateur3.setOnLongClickListener(assigneUtilisateur);
            picutilisateur4.setOnLongClickListener(assigneUtilisateur);
            picutilisateur5.setOnLongClickListener(assigneUtilisateur);
            picutilisateur6.setOnLongClickListener(assigneUtilisateur);

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

            mButton.setText("Déplacement");
            Toggle = 0;
        }else {
            if (Toggle == 0) {

                container1.setOnDragListener(null);
                container2.setOnDragListener(null);
                container3.setOnDragListener(null);
                container4.setOnDragListener(null);
                container5.setOnDragListener(null);
                container6.setOnDragListener(null);

                picutilisateur1.setOnLongClickListener(DisplaylongClickListenerUtilisateur);
                picutilisateur2.setOnLongClickListener(DisplaylongClickListenerUtilisateur);
                picutilisateur3.setOnLongClickListener(DisplaylongClickListenerUtilisateur);
                picutilisateur4.setOnLongClickListener(DisplaylongClickListenerUtilisateur);
                picutilisateur5.setOnLongClickListener(DisplaylongClickListenerUtilisateur);
                picutilisateur6.setOnLongClickListener(DisplaylongClickListenerUtilisateur);

                container1.setOnLongClickListener(containerLongClickListener);
                container2.setOnLongClickListener(containerLongClickListener);
                container3.setOnLongClickListener(containerLongClickListener);
                container4.setOnLongClickListener(containerLongClickListener);
                container5.setOnLongClickListener(containerLongClickListener);
                container6.setOnLongClickListener(containerLongClickListener);

                zonededrop1.setOnDragListener(onDragListener);
                zonededrop2.setOnDragListener(onDragListener);
                zonededrop3.setOnDragListener(onDragListener);

                mButton.setText("Assignation");
                Toggle = 1;
            }
        }
    }
}
