package com.example.ecepfe.agilit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jean on 11/01/2018.
 */

public class Global {

    public static int dernierIDpopup=0;
    public static String remainingsDistibution[] = {"vide", "vert", "jaune", "jaune,vert", "bleu", "bleu,vert", "bleu,jaune", "bleu,jaune,vert",
            "bleu,bleu", "bleu,bleu,vert", "rouge", "rouge,vert", "rouge,jaune", "rouge,jaune,vert", "rouge,bleu", "rouge,bleu,vert", "rouge,bleu,jaune",
            "rouge,bleu,jaune,vert", "rouge,bleu,bleu", "rouge,bleu,bleu,vert", "rouge,rouge", "rouge,rouge,vert", "rouge,rouge,jaune", "rouge,rouge,jaune,vert",
            "rouge,rouge,bleu", "rouge,rouge,bleu,vert", "rouge,rouge,bleu,jaune", "rouge,rouge,bleu,jaune,vert", "rouge,rouge,bleu,bleu",
            "rouge,rouge,bleu,bleu,vert", "rouge,rouge,rouge", "rouge,rouge,rouge,vert", "rouge,rouge,rouge,jaune", "rouge,rouge,rouge,jaune,vert",
            "rouge,rouge,rouge,bleu", "rouge,rouge,rouge,bleu,vert", "rouge,rouge,rouge,bleu,jaune", "rouge,rouge,rouge,bleu,jaune,vert", "rouge,rouge,rouge,bleu,bleu",
            "rouge,rouge,rouge,bleu,bleu,vert", "rouge,rouge,rouge,rouge"};

    public static List<Integer> idImagelist = new ArrayList<Integer>();
    public static Integer incrementeurIDimage = 0;

    public static List<Integer> idTextlist = new ArrayList<Integer>();
    public static Integer incrementeurIDtext = 0;

    public static List<Integer> idContainerlist = new ArrayList<Integer>();
    public static Integer incrementeurIDcontainer = 0;

    public static List<Integer> idLinearlist = new ArrayList<Integer>();
    public static Integer incrementeurIDlinear = 0;

    public static List<ContainerTache> listecontainer = new ArrayList<ContainerTache>();


}
