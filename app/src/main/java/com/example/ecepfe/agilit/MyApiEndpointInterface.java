package com.example.ecepfe.agilit;

import retrofit2.Call;
import retrofit2.http.*;

/**
 * Created by Jean on 22/01/2018.
 */

public interface MyApiEndpointInterface {

    @GET("issue/AIS-1/issuetype")
    Call<Example> getIssue();

    @GET("issue/AIS-1/assignee")
    Call<Example> getAssignee();

    @GET("issue/AIS-1/status")
    Call<Example> getStatus();

    @GET("issue/AIS-1")
    Call<Example> getAllData();

}
