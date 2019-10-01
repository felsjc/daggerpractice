package com.felsjc.daggerpractice.di.main;

import androidx.lifecycle.ViewModel;

import com.felsjc.daggerpractice.di.ViewModelKey;
import com.felsjc.daggerpractice.ui.main.posts.PostsViewModel;
import com.felsjc.daggerpractice.ui.main.profile.ProfileViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class MainViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel.class)
    public abstract ViewModel bindProfileViewModel(ProfileViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(PostsViewModel.class)
    public abstract ViewModel bindPostsViewModel(PostsViewModel viewModel);
}
