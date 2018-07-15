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

package ro.capac.android.capac2018.ui.main;

import ro.capac.android.capac2018.data.db.model.Question;
import ro.capac.android.capac2018.data.db.model.Question;
import ro.capac.android.capac2018.ui.base.MvpView;

import java.util.List;

import ro.capac.android.capac2018.data.db.model.Question;

/**
 * Created by janisharali on 27/01/17.
 */

public interface MainMvpView extends MvpView {

    void openTopActivity();

    void showAboutFragment();

    void refreshQuestionnaire(List<Question> questionList);

    void reloadQuestionnaire(List<Question> questionList);

    void updateUserName(String currentUserName);

    void updateUserEmail(String currentUserEmail);

    void updateUserProfilePic(String currentUserProfilePicUrl);

    void updateAppVersion();

    void showRateUsDialog();

    void openMyFeedActivity();

    void closeNavigationDrawer();

    void lockDrawer();

    void unlockDrawer();
}
