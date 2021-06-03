package org.techtown.challengesemestersystem;

import com.android.volley.Cache;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.DiskBasedCache;

public class RegisterRequest {
    public static RequestQueue mrequestQueue;

    public RequestQueue getRequestQueue(){
       return mrequestQueue;
    }
    public <T> void addToRequestQueue(Request<T> request){
        mrequestQueue.add(request);
    }
}
