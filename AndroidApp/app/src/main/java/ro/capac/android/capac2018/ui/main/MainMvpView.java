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

    void openJoinEventActivity();

    void openCreateEventActivity();

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
