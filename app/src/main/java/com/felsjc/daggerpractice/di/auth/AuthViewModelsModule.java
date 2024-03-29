package com.felsjc.daggerpractice.di.auth;

import androidx.lifecycle.ViewModel;

import com.felsjc.daggerpractice.di.ViewModelKey;
import com.felsjc.daggerpractice.ui.auth.AuthViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class AuthViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel.class)
    public abstract ViewModel bindAuthViewModel(AuthViewModel viewModel);


}
