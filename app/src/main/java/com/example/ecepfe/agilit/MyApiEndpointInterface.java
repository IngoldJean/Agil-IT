package com.example.ecepfe.agilit;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.*;

/**
 * Created by Jean on 22/01/2018.
 */

public interface MyApiEndpointInterface {

    @GET("sprint/8")
    Call<ListeTaches> getAllTache();

    @GET("issue/{id}/changestatus/{status}")
    Call<Void> changestatusget(@Path("id") String id, @Path("status") Integer statusid);

    @GET("project/{projectkey}/members")
    Call<Utilisateurs> getAllUtilisateurs(@Path("projectkey") String projectkey);


    /*@POST("issue/{id}/changestatus")
    Call<Void> changestatus(@Path("id") String id, @Body ChangeStatus changeStatus);*/

    @POST("post")
    Call<Void> changestatu(@Body ClassTemp classTemp);

    @POST("issue/{id}/changestatus")
    Call<Void> changestatus(@Path("id") String id, @HeaderMap Map<String,String> headers, @Body ChangeStatus changeStatus);
}
