package com.felsjc.daggerpractice.di;

import androidx.lifecycle.ViewModelProvider;

import com.felsjc.daggerpractice.viewmodels.ViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelFactoryModule {

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory modelViewProviderFactory);
}
