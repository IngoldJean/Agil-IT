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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    ScrollView zonededrop1, zonededrop2, zonededrop3;
    LinearLayout linearLayoutTest, linearLayoutTest2, utilisateursList;
    ScrollView scrollViewTest;
    TextView textcont1, textcont2, textcont3, textcont4, textcont5, textcont6, texttemp;
    ImageView picutilisateur1, picutilisateur2, picutilisateur3, picutilisateur4, picutilisateur5, picutilisateur6, imageViewtemp;
    RelativeLayout container1, container2, container3, container4, container5, container6, containertemp, containertemp2;
    Button mButton;

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



        container1.setOnLongClickListener(longClickListener);
        container2.setOnLongClickListener(longClickListener);
        container3.setOnLongClickListener(longClickListener);
        container4.setOnLongClickListener(longClickListener);
        container5.setOnLongClickListener(longClickListener);
        container6.setOnLongClickListener(longClickListener);

        container1.setOnClickListener(affichagepopup2);
        container2.setOnClickListener(affichagepopup2);
        container3.setOnClickListener(affichagepopup2);
        container4.setOnClickListener(affichagepopup2);
        container5.setOnClickListener(affichagepopup2);
        container6.setOnClickListener(affichagepopup2);

        picutilisateur1.setOnLongClickListener(longClickListenerUtilisateur);
        picutilisateur2.setOnLongClickListener(longClickListenerUtilisateur);
        picutilisateur3.setOnLongClickListener(longClickListenerUtilisateur);
        picutilisateur4.setOnLongClickListener(longClickListenerUtilisateur);
        picutilisateur5.setOnLongClickListener(longClickListenerUtilisateur);
        picutilisateur6.setOnLongClickListener(longClickListenerUtilisateur);

        zonededrop1.setOnDragListener(onDragListener);
        zonededrop2.setOnDragListener(onDragListener);
        zonededrop3.setOnDragListener(onDragListener);
    }



    View.OnClickListener affichagepopup2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            AlertDialog.Builder mbuilder = new AlertDialog.Builder(MainActivity.this);
            View mView = getLayoutInflater().inflate(R.layout.tachedeataille, null);

            containertemp2 = (RelativeLayout) findViewById(v.getId());

            for(int index=0; index<(containertemp2).getChildCount(); ++index) {
                View nextChild = (containertemp2).getChildAt(index);

                if (nextChild instanceof TextView) {
                    texttemp = (TextView) findViewById(nextChild.getId());
                    TextView textView = (TextView) mView.findViewById(R.id.popuptextdetaille);
                    textView.setText(texttemp.getText());
                    mbuilder.setView(mView);
                    AlertDialog dialog = mbuilder.create();
                    dialog.show();
                }
            }

        }
    };


    View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            ClipData clipData = ClipData.newPlainText("", "");
            View.DragShadowBuilder dragShadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(clipData, dragShadowBuilder, v, 0);
            v.setVisibility(View.INVISIBLE);
            return true;
        }
    };

    View.OnLongClickListener longClickListenerUtilisateur = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {

            utilisateursList = (LinearLayout) findViewById(R.id.list_des_perso);
            for(int inde=0; inde<(utilisateursList).getChildCount(); ++inde) {
                View img = (utilisateursList).getChildAt(inde);
                imageViewtemp = (ImageView) img;
                imageViewtemp.setImageAlpha(128);
            }


            imageViewtemp = (ImageView) findViewById(v.getId());
            imageViewtemp.setImageAlpha(255);

            linearLayoutTest = (LinearLayout) findViewById(R.id.fullscreen);

            for(int index=0; index<(linearLayoutTest).getChildCount(); ++index) {
                View nextChild = (linearLayoutTest).getChildAt(index);
                if (nextChild instanceof ScrollView) {
                    Log.i("cherche", "Scrollview");

                    scrollViewTest = (ScrollView) findViewById(nextChild.getId());
                    for(int index2=0; index2<(scrollViewTest).getChildCount(); ++index2) {
                        View nextChild2 = (scrollViewTest).getChildAt(index2);
                        if (nextChild2 instanceof LinearLayout) {
                            Log.i("cherche", "LinearLayout");

                            linearLayoutTest2 = (LinearLayout) findViewById(nextChild2.getId());
                            for(int index3=0; index3<(linearLayoutTest2).getChildCount(); ++index3) {
                                View nextChild3 = (linearLayoutTest2).getChildAt(index3);
                                if (nextChild3 instanceof RelativeLayout) {
                                    Log.i("cherche", "RelativeLayout");

                                    containertemp = (RelativeLayout) findViewById(nextChild3.getId());
                                    containertemp.setAlpha(0.5F);
                                    for(int index4=0; index4<(containertemp).getChildCount(); ++index4) {
                                        View nextChild4 = (containertemp).getChildAt(index4);
                                        if (nextChild4 instanceof ImageView) {
                                            Log.i("cherche", "ImageView");

                                            ImageView imageViewtemp2 = (ImageView) findViewById(nextChild4.getId());

                                            if (imageViewtemp2.getTag() == imageViewtemp.getTag()){
                                                Log.i("trouve", "conclue");
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

            Log.i("test", String.valueOf(view.getId()));
            containertemp = (RelativeLayout) findViewById(view.getId());

            switch (dragevent){
                case DragEvent.ACTION_DRAG_STARTED:
                    //imagetemp.setVisibility(View.INVISIBLE);
                    containertemp.setVisibility(View.INVISIBLE);

                case DragEvent.ACTION_DRAG_ENTERED:
                    break;

                case DragEvent.ACTION_DROP:
                    Log.i("drag lisener", "drop");

                    //imagetemp.setVisibility(View.VISIBLE);
                    containertemp.setVisibility(View.VISIBLE);
                    if(v.getId()==R.id.zonedrop2){
                        Log.i("ok","ok");
                        ViewGroup from = (ViewGroup) view.getParent();
                        from.removeView(view);
                        //LinearLayout container = (LinearLayout) v;
                        LinearLayout container = (LinearLayout) findViewById(R.id.list_des_taches2);
                        container.addView(view);
                        break;
                    }
                    if(v.getId()==R.id.zonedrop1){
                        Log.i("ok","ok");
                        ViewGroup from = (ViewGroup) view.getParent();
                        from.removeView(view);
                        //LinearLayout container = (LinearLayout) v;
                        LinearLayout container = (LinearLayout) findViewById(R.id.list_des_taches1);
                        container.addView(view);
                        break;
                    }
                    if(v.getId()==R.id.zonedrop3){
                        Log.i("ok","ok");
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

            mButton.setText("Déplacement");
            Toggle = 0;
        }else {
            if (Toggle == 0) {
                zonededrop1.setOnDragListener(onDragListener);
                zonededrop2.setOnDragListener(onDragListener);
                zonededrop3.setOnDragListener(onDragListener);
                container1.setOnLongClickListener(longClickListener);
                container2.setOnLongClickListener(longClickListener);
                container3.setOnLongClickListener(longClickListener);
                container4.setOnLongClickListener(longClickListener);
                container5.setOnLongClickListener(longClickListener);
                container6.setOnLongClickListener(longClickListener);

                mButton.setText("Assignation");
                Toggle = 1;
            }
        }
    }
}
