package com.felsjc.daggerpractice.di;

import com.felsjc.daggerpractice.di.auth.AuthModule;
import com.felsjc.daggerpractice.di.auth.AuthViewModelsModule;
import com.felsjc.daggerpractice.di.main.MainFragmentBuildersModule;
import com.felsjc.daggerpractice.di.main.MainModule;
import com.felsjc.daggerpractice.di.main.MainViewModelsModule;
import com.felsjc.daggerpractice.ui.auth.AuthActivity;
import com.felsjc.daggerpractice.ui.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
            modules = {AuthViewModelsModule.class, AuthModule.class}
    )
    abstract AuthActivity contributeAuthActivity();

    @ContributesAndroidInjector(
            modules = {MainFragmentBuildersModule.class, MainViewModelsModule.class, MainModule.class}
    )
    abstract MainActivity contributeMainActivity();
}
