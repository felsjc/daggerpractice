package com.felsjc.daggerpractice.di;

import com.felsjc.daggerpractice.di.auth.AuthModule;
import com.felsjc.daggerpractice.di.auth.AuthViewModelsModule;
import com.felsjc.daggerpractice.ui.auth.AuthActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
            modules = {AuthViewModelsModule.class, AuthModule.class}
    )
    abstract AuthActivity contributeAuthActivity();


}
