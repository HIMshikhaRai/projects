package com.example.himshikha.bloodo;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import android.util.Log;

public class instanceIdService extends FirebaseInstanceIdService {

    private static final String REG_TOKEN="REG_TOKEN";

    public void onTokenRefresh(){
        String recent_token=FirebaseInstanceId.getInstance().getToken();
        Log.d(REG_TOKEN,recent_token);
    }
}
