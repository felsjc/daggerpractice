package com.felsjc.daggerpractice.network.auth;

import com.felsjc.daggerpractice.models.User;
import com.felsjc.daggerpractice.ui.auth.AuthResource;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AuthApi {

    @GET("users/{id}")
    Flowable<User> getUser(
            @Path("id") int id
            );
}
