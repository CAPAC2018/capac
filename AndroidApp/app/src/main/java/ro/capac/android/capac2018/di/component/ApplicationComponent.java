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

import android.app.Application;
import android.content.Context;

import ro.capac.android.capac2018.MvpApp;
import ro.capac.android.capac2018.data.DataManager;
import ro.capac.android.capac2018.di.ApplicationContext;
import ro.capac.android.capac2018.service.SyncService;
import ro.capac.android.capac2018.MvpApp;
import ro.capac.android.capac2018.data.DataManager;
import ro.capac.android.capac2018.di.ApplicationContext;
import ro.capac.android.capac2018.di.module.ApplicationModule;
import ro.capac.android.capac2018.service.SyncService;

import javax.inject.Singleton;

import dagger.Component;
import ro.capac.android.capac2018.MvpApp;
import ro.capac.android.capac2018.data.DataManager;
import ro.capac.android.capac2018.di.ApplicationContext;
import ro.capac.android.capac2018.service.SyncService;

/**
 * Created by janisharali on 27/01/17.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MvpApp app);

    void inject(SyncService service);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();
}