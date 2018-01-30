package com.example.ecepfe.agilit;

/**
 * Created by Jean on 29/01/2018.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Utilisateurs {

    @SerializedName("list_member")
    @Expose
    private List<ListMember> listMember = null;

    public List<ListMember> getListMember() {
        return listMember;
    }

    public void setListMember(List<ListMember> listMember) {
        this.listMember = listMember;
    }

}
