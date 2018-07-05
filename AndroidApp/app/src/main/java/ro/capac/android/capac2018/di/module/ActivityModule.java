/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package ro.capac.android.capac2018.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import ro.capac.android.capac2018.data.network.model.BlogResponse;
import ro.capac.android.capac2018.data.network.model.OpenSourceResponse;
import ro.capac.android.capac2018.di.ActivityContext;
import ro.capac.android.capac2018.di.PerActivity;
import ro.capac.android.capac2018.ui.about.AboutMvpPresenter;
import ro.capac.android.capac2018.ui.about.AboutMvpView;
import ro.capac.android.capac2018.ui.about.AboutPresenter;
import ro.capac.android.capac2018.ui.feed.FeedMvpPresenter;
import ro.capac.android.capac2018.ui.feed.FeedMvpView;
import ro.capac.android.capac2018.ui.feed.FeedPagerAdapter;
import ro.capac.android.capac2018.ui.feed.FeedPresenter;
import ro.capac.android.capac2018.ui.feed.blogs.BlogAdapter;
import ro.capac.android.capac2018.ui.feed.blogs.BlogMvpPresenter;
import ro.capac.android.capac2018.ui.feed.blogs.BlogMvpView;
import ro.capac.android.capac2018.ui.feed.blogs.BlogPresenter;
import ro.capac.android.capac2018.ui.feed.opensource.OpenSourceAdapter;
import ro.capac.android.capac2018.ui.feed.opensource.OpenSourceMvpPresenter;
import ro.capac.android.capac2018.ui.feed.opensource.OpenSourceMvpView;
import ro.capac.android.capac2018.ui.feed.opensource.OpenSourcePresenter;
import ro.capac.android.capac2018.ui.login.LoginMvpPresenter;
import ro.capac.android.capac2018.ui.login.LoginMvpView;
import ro.capac.android.capac2018.ui.login.LoginPresenter;
import ro.capac.android.capac2018.ui.main.MainMvpPresenter;
import ro.capac.android.capac2018.ui.main.MainMvpView;
import ro.capac.android.capac2018.ui.main.MainPresenter;
import ro.capac.android.capac2018.ui.main.rating.RatingDialogMvpPresenter;
import ro.capac.android.capac2018.ui.main.rating.RatingDialogMvpView;
import ro.capac.android.capac2018.ui.main.rating.RatingDialogPresenter;
import ro.capac.android.capac2018.ui.splash.SplashMvpPresenter;
import ro.capac.android.capac2018.ui.splash.SplashMvpView;
import ro.capac.android.capac2018.ui.splash.SplashPresenter;
import ro.capac.android.capac2018.utils.rx.AppSchedulerProvider;
import ro.capac.android.capac2018.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by janisharali on 27/01/17.
 */

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @PerActivity
    SplashMvpPresenter<SplashMvpView> provideSplashPresenter(
            SplashPresenter<SplashMvpView> presenter) {
        return presenter;
    }

    @Provides
    AboutMvpPresenter<AboutMvpView> provideAboutPresenter(
            AboutPresenter<AboutMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    LoginMvpPresenter<LoginMvpView> provideLoginPresenter(
            LoginPresenter<LoginMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> provideMainPresenter(
            MainPresenter<MainMvpView> presenter) {
        return presenter;
    }

    @Provides
    RatingDialogMvpPresenter<RatingDialogMvpView> provideRateUsPresenter(
            RatingDialogPresenter<RatingDialogMvpView> presenter) {
        return presenter;
    }

    @Provides
    FeedMvpPresenter<FeedMvpView> provideFeedPresenter(
            FeedPresenter<FeedMvpView> presenter) {
        return presenter;
    }

    @Provides
    OpenSourceMvpPresenter<OpenSourceMvpView> provideOpenSourcePresenter(
            OpenSourcePresenter<OpenSourceMvpView> presenter) {
        return presenter;
    }

    @Provides
    BlogMvpPresenter<BlogMvpView> provideBlogMvpPresenter(
            BlogPresenter<BlogMvpView> presenter) {
        return presenter;
    }

    @Provides
    FeedPagerAdapter provideFeedPagerAdapter(AppCompatActivity activity) {
        return new FeedPagerAdapter(activity.getSupportFragmentManager());
    }

    @Provides
    OpenSourceAdapter provideOpenSourceAdapter() {
        return new OpenSourceAdapter(new ArrayList<OpenSourceResponse.Repo>());
    }

    @Provides
    BlogAdapter provideBlogAdapter() {
        return new BlogAdapter(new ArrayList<BlogResponse.Blog>());
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }
}
