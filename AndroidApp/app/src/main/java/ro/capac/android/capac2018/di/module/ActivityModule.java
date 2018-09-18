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

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;
import ro.capac.android.capac2018.di.ActivityContext;
import ro.capac.android.capac2018.di.PerActivity;
import ro.capac.android.capac2018.ui.categories.CategoriesMvpPresenter;
import ro.capac.android.capac2018.ui.categories.CategoriesMvpView;
import ro.capac.android.capac2018.ui.categories.CategoriesPresenter;
import ro.capac.android.capac2018.ui.categorized_events.CategorizedEventsMvpPresenter;
import ro.capac.android.capac2018.ui.categorized_events.CategorizedEventsMvpView;
import ro.capac.android.capac2018.ui.categorized_events.CategorizedEventsPresenter;
import ro.capac.android.capac2018.ui.chat.ChatMvpPresenter;
import ro.capac.android.capac2018.ui.chat.ChatMvpView;
import ro.capac.android.capac2018.ui.chat.ChatPresenter;
import ro.capac.android.capac2018.ui.create_event.CreateEventMvpPresenter;
import ro.capac.android.capac2018.ui.create_event.CreateEventMvpView;
import ro.capac.android.capac2018.ui.create_event.CreateEventPresenter;
import ro.capac.android.capac2018.ui.events.EventsMvpPresenter;
import ro.capac.android.capac2018.ui.events.EventsMvpView;
import ro.capac.android.capac2018.ui.events.EventsPresenter;
import ro.capac.android.capac2018.ui.login.LoginMvpPresenter;
import ro.capac.android.capac2018.ui.login.LoginMvpView;
import ro.capac.android.capac2018.ui.login.LoginPresenter;
import ro.capac.android.capac2018.ui.main.MainMvpPresenter;
import ro.capac.android.capac2018.ui.main.MainMvpView;
import ro.capac.android.capac2018.ui.main.MainPresenter;
import ro.capac.android.capac2018.ui.main.rating.RatingDialogMvpPresenter;
import ro.capac.android.capac2018.ui.main.rating.RatingDialogMvpView;
import ro.capac.android.capac2018.ui.main.rating.RatingDialogPresenter;
import ro.capac.android.capac2018.ui.news.NewsMvpPresenter;
import ro.capac.android.capac2018.ui.news.NewsMvpView;
import ro.capac.android.capac2018.ui.news.NewsPresenter;
import ro.capac.android.capac2018.ui.profile.MyProfileMvpPresenter;
import ro.capac.android.capac2018.ui.profile.MyProfileMvpView;
import ro.capac.android.capac2018.ui.profile.MyProfilePresenter;
import ro.capac.android.capac2018.ui.registration.RegistrationMvpPresenter;
import ro.capac.android.capac2018.ui.registration.RegistrationMvpView;
import ro.capac.android.capac2018.ui.registration.RegistrationPresenter;
import ro.capac.android.capac2018.ui.settings.SettingsMvpPresenter;
import ro.capac.android.capac2018.ui.settings.SettingsMvpView;
import ro.capac.android.capac2018.ui.settings.SettingsPresenter;
import ro.capac.android.capac2018.ui.splash.SplashMvpPresenter;
import ro.capac.android.capac2018.ui.splash.SplashMvpView;
import ro.capac.android.capac2018.ui.splash.SplashPresenter;
import ro.capac.android.capac2018.ui.top.TopMvpPresenter;
import ro.capac.android.capac2018.ui.top.TopMvpView;
import ro.capac.android.capac2018.ui.top.TopPresenter;
import ro.capac.android.capac2018.utils.rx.AppSchedulerProvider;
import ro.capac.android.capac2018.utils.rx.SchedulerProvider;

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
    @PerActivity
    TopMvpPresenter<TopMvpView> provideTopPresenter(TopPresenter<TopMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    RegistrationMvpPresenter<RegistrationMvpView> provideRegistrationPresenter(RegistrationPresenter<RegistrationMvpView> presenter) {
        return presenter;
    }

    @Provides
    EventsMvpPresenter<EventsMvpView> provideEventsPresenter(
            EventsPresenter<EventsMvpView> presenter) {
        return presenter;
    }

    @Provides
    MyProfileMvpPresenter<MyProfileMvpView> provideMyProfilePresenter(
            MyProfilePresenter<MyProfileMvpView> presenter) {
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
    @PerActivity
    CreateEventMvpPresenter<CreateEventMvpView> provideCreateEventPresenter(
            CreateEventPresenter<CreateEventMvpView> presenter) {
        return presenter;
    }
    @Provides
    @PerActivity
    CategorizedEventsMvpPresenter<CategorizedEventsMvpView> provideCategorizedEventsPresenter(
            CategorizedEventsPresenter<CategorizedEventsMvpView> presenter) {
        return presenter;
    }

    @Provides
    CategoriesMvpPresenter<CategoriesMvpView> provideCategoriesPresenter(
            CategoriesPresenter<CategoriesMvpView> presenter) {
        return presenter;
    }
    @Provides
    ChatMvpPresenter<ChatMvpView> provideChatPresenter(
            ChatPresenter<ChatMvpView> presenter) {
        return presenter;
    }

    @Provides
    NewsMvpPresenter<NewsMvpView> provideNewsPresenter(
            NewsPresenter<NewsMvpView> presenter){
        return presenter;
    }

    @Provides
    SettingsMvpPresenter<SettingsMvpView> provideSettingsPresenter(
            SettingsPresenter<SettingsMvpView> presenter) {
        return presenter;
    }
    @Provides
    RatingDialogMvpPresenter<RatingDialogMvpView> provideRateUsPresenter(
            RatingDialogPresenter<RatingDialogMvpView> presenter) {
        return presenter;
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }
}
