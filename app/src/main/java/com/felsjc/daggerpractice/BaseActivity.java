package com.felsjc.daggerpractice;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.felsjc.daggerpractice.models.User;
import com.felsjc.daggerpractice.ui.auth.AuthActivity;
import com.felsjc.daggerpractice.ui.auth.AuthResource;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

import static com.felsjc.daggerpractice.ui.auth.AuthResource.AuthStatus.AUTHENTICATED;
import static com.felsjc.daggerpractice.ui.auth.AuthResource.AuthStatus.ERROR;
import static com.felsjc.daggerpractice.ui.auth.AuthResource.AuthStatus.LOADING;
import static com.felsjc.daggerpractice.ui.auth.AuthResource.AuthStatus.NOT_AUTHENTICATED;

public abstract class BaseActivity extends DaggerAppCompatActivity {

    private static final String TAG = "BaseActivity";

    @Inject
    public SessionManager sessionManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        subscribeObservers();
    }

    private void subscribeObservers() {
        sessionManager.getAuthUser().observe(this, new Observer<AuthResource<User>>() {
            @Override
            public void onChanged(final AuthResource<User> userAuthResource) {
                if (userAuthResource != null) {
                    switch (userAuthResource.status) {
                        case LOADING: {

                            break;
                        }
                        case AUTHENTICATED: {

                            Log.d(TAG, "onChanged: LOGIN SUCCESS: " +
                                    userAuthResource.data.getEmail());
                            break;
                        }
                        case ERROR: {
                            Log.d(TAG, "onChanged: " + userAuthResource.message);
                            break;
                        }
                        case NOT_AUTHENTICATED: {
                            navLoginScreen();
                            break;
                        }
                    }
                }
            }
        });
    }

    private void navLoginScreen() {
        Intent intent = new Intent(this, AuthActivity.class);
        startActivity(intent);
        finish();
    }
}
