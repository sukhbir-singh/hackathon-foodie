package com.hackathon.csec.foodie;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    private LoginButton loginButton;
    private CallbackManager callbackManager;
    private ArrayList<String> permission;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_login, container, false);
        loginButton= (LoginButton) v.findViewById(R.id.loginButton);
        loginButton.setFragment(this);
        permission=new ArrayList<>();
        permission.add("email");
        permission.add("user_friends");
        loginButton.setReadPermissions(permission);
        callbackManager=CallbackManager.Factory.create();
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                GraphRequest graphRequest=GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        String name="",email="",picUrl="";
                        if(object.has("name")){
                            try {
                                name=object.getString("name");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        if(object.has("email")){
                            try {
                                email=object.getString("email");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                        if(object.has("id")){
                            try {
                                String id=object.getString("id");
                                picUrl="https://graph.facebook.com/"+id+"/picture?width=200&height=200";
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        saveUserData(name,email,picUrl);

                    }
                });
                Bundle b=new Bundle();
                b.putString("fields","name,email,id");
                graphRequest.setParameters(b);
                graphRequest.executeAsync();

            }

            @Override
            public void onCancel() {
                   getActivity().startActivity(new Intent(getActivity(),MainActivity.class));
                   getActivity().finish();
            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(getActivity(),"Error Occur While Making Facebook Login,Please Try Again!!",Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode,resultCode,data);
    }

    private void saveUserData(String name,String email,String picUrl){

    }
}
