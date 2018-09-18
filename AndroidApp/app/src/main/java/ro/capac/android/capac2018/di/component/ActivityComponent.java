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

package ro.capac.android.capac2018.di.component;

import dagger.Component;
import ro.capac.android.capac2018.di.PerActivity;
import ro.capac.android.capac2018.di.module.ActivityModule;
import ro.capac.android.capac2018.ui.categories.CategoriesFragment;
import ro.capac.android.capac2018.ui.categorized_events.CategorizedEventsActivity;
import ro.capac.android.capac2018.ui.chat.ChatFragment;
import ro.capac.android.capac2018.ui.create_event.CreateEventActivity;
import ro.capac.android.capac2018.ui.events.EventsFragment;
import ro.capac.android.capac2018.ui.join_event.JoinEventActivity;
import ro.capac.android.capac2018.ui.login.LoginActivity;
import ro.capac.android.capac2018.ui.main.MainActivity;
import ro.capac.android.capac2018.ui.main.rating.RateUsDialog;
import ro.capac.android.capac2018.ui.news.NewsFragment;
import ro.capac.android.capac2018.ui.profile.MyProfileFragment;
import ro.capac.android.capac2018.ui.registration.RegistrationActivity;
import ro.capac.android.capac2018.ui.settings.SettingsFragment;
import ro.capac.android.capac2018.ui.splash.SplashActivity;
import ro.capac.android.capac2018.ui.top.TopActivity;

/**
 * Created by janisharali on 27/01/17.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);

    void inject(LoginActivity activity);

    void inject(SplashActivity activity);

    void inject(RateUsDialog dialog);

    void inject(TopActivity activity);

    void inject(RegistrationActivity activity);

    void inject(JoinEventActivity activity);

    void inject(CreateEventActivity activity);

    void inject(CategorizedEventsActivity activity);

    void inject(EventsFragment fragment);

    void inject(MyProfileFragment fragment);

    void inject(CategoriesFragment fragment);

    void inject(SettingsFragment fragment);

    void inject(ChatFragment fragment);

    void inject(NewsFragment fragment);
}
