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

import ro.capac.android.capac2018.di.PerActivity;
import ro.capac.android.capac2018.di.module.ActivityModule;
import ro.capac.android.capac2018.ui.about.AboutFragment;
import ro.capac.android.capac2018.ui.feed.FeedActivity;
import ro.capac.android.capac2018.ui.feed.blogs.BlogFragment;
import ro.capac.android.capac2018.ui.feed.opensource.OpenSourceFragment;
import ro.capac.android.capac2018.ui.login.LoginActivity;
import ro.capac.android.capac2018.ui.main.MainActivity;
import ro.capac.android.capac2018.ui.main.rating.RateUsDialog;
import ro.capac.android.capac2018.ui.splash.SplashActivity;
import ro.capac.android.capac2018.di.PerActivity;
import ro.capac.android.capac2018.di.module.ActivityModule;
import ro.capac.android.capac2018.ui.about.AboutFragment;
import ro.capac.android.capac2018.ui.feed.FeedActivity;
import ro.capac.android.capac2018.ui.feed.blogs.BlogFragment;
import ro.capac.android.capac2018.ui.feed.opensource.OpenSourceFragment;
import ro.capac.android.capac2018.ui.login.LoginActivity;
import ro.capac.android.capac2018.ui.main.MainActivity;
import ro.capac.android.capac2018.ui.main.rating.RateUsDialog;
import ro.capac.android.capac2018.ui.splash.SplashActivity;

import dagger.Component;
import ro.capac.android.capac2018.di.PerActivity;
import ro.capac.android.capac2018.di.module.ActivityModule;
import ro.capac.android.capac2018.ui.about.AboutFragment;
import ro.capac.android.capac2018.ui.feed.FeedActivity;
import ro.capac.android.capac2018.ui.feed.blogs.BlogFragment;
import ro.capac.android.capac2018.ui.feed.opensource.OpenSourceFragment;
import ro.capac.android.capac2018.ui.login.LoginActivity;
import ro.capac.android.capac2018.ui.main.MainActivity;
import ro.capac.android.capac2018.ui.main.rating.RateUsDialog;
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

    void inject(FeedActivity activity);

    void inject(AboutFragment fragment);

    void inject(OpenSourceFragment fragment);

    void inject(BlogFragment fragment);

    void inject(RateUsDialog dialog);

    void inject(TopActivity activity);


}
