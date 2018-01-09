package com.example.ecepfe.agilit;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Jean on 09/01/2018.
 */

public class AssignementDesTaches extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_main);
        setTitle("Assignez des tâches");
    }

    public void launchActiviteAssign(View view) {
    }
}
