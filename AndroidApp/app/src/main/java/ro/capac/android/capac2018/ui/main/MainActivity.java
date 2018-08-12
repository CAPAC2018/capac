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

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;
import ro.capac.android.capac2018.R;
import ro.capac.android.capac2018.ui.about.AboutFragment;
import ro.capac.android.capac2018.ui.base.BaseActivity;
import ro.capac.android.capac2018.ui.categories.CategoriesFragment;
import ro.capac.android.capac2018.ui.chat.ChatFragment;
import ro.capac.android.capac2018.ui.create_event.CreateEventActivity;
import ro.capac.android.capac2018.ui.events.EventsFragment;
import ro.capac.android.capac2018.ui.join_event.JoinEventActivity;
import ro.capac.android.capac2018.ui.profile.MyProfileFragment;
import ro.capac.android.capac2018.ui.settings.SettingsFragment;
import ro.capac.android.capac2018.ui.top.TopActivity;



public class MainActivity extends BaseActivity implements MainMvpView {
    @Inject
    MainMvpPresenter<MainMvpView> mPresenter;

    @BindView(R.id.toolbar_title)
    TextView mToolbar;

    private String currentFragmentTAG;
    LinearLayout expandedToolbar;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);
        expandedToolbar = findViewById(R.id.expanded_toolbar);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_feed:
                        if(!currentFragmentTAG.equals(EventsFragment.TAG)) {
                            mToolbar.setText("Feed");
                            showEventsFragment();
                            currentFragmentTAG = EventsFragment.TAG;
                        }
                        return true;
                    case R.id.navigation_profile:
                        if(!currentFragmentTAG.equals(MyProfileFragment.TAG)) {
                            mToolbar.setText("My Profile");
                            showMyProfileFragment();
                            currentFragmentTAG = MyProfileFragment.TAG;
                        }
                        return true;
                    case R.id.navigation_news:
                        if(!currentFragmentTAG.equals(ChatFragment.TAG)) {
                            mToolbar.setText("Chat");
                            showChatFragment();
                            currentFragmentTAG = ChatFragment.TAG;
                        }
                        return true;
                    case R.id.navigation_categories_events:
                        if(!currentFragmentTAG.equals(CategoriesFragment.TAG)) {
                            mToolbar.setText("Categories");
                            showCategoriesFragment();
                            currentFragmentTAG = CategoriesFragment.TAG;
                        }
                        return true;
                }
                return false;
            }
        });
        showInitialFragment();
    }

    private void showInitialFragment(){
        mToolbar.setText("Feed");
        getSupportFragmentManager()
                .beginTransaction()
                .disallowAddToBackStack()
                .setCustomAnimations(R.anim.fade_in,R.anim.fade_out)
                .add(R.id.frame, EventsFragment.newInstance(), EventsFragment.TAG)
                .commit();
        currentFragmentTAG = EventsFragment.TAG;
    }

    @OnClick(R.id.expand_toolbar)
    public void expandToolbar(){
        if(expandedToolbar.getVisibility()== View.VISIBLE) {
            expandedToolbar.setVisibility(View.GONE);
            findViewById(R.id.expand_toolbar).setActivated(false);
        }
        else {
            expandedToolbar.setVisibility(View.VISIBLE);
            findViewById(R.id.expand_toolbar).setActivated(true);
        }
    }

    @Override
    public void showEventsFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .disallowAddToBackStack()
                .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                .replace(R.id.frame, EventsFragment.newInstance(), EventsFragment.TAG)
                .commit();
    }
    @Override
    public void showCategoriesFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .disallowAddToBackStack()
                .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                .replace(R.id.frame, CategoriesFragment.newInstance(), CategoriesFragment.TAG)
                .commit();
    }
    @Override
    public void showChatFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .disallowAddToBackStack()
                .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                .replace(R.id.frame, ChatFragment.newInstance(), ChatFragment.TAG)
                .commit();
    }
    @Override
    public void showMyProfileFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .disallowAddToBackStack()
                .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                .replace(R.id.frame, MyProfileFragment.newInstance(), MyProfileFragment.TAG)
                .commit();
    }
    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(AboutFragment.TAG);
        if (fragment == null) {
            super.onBackPressed();
        } else {
            onFragmentDetached(AboutFragment.TAG);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {

    }

    @Override
    public void onFragmentAttached() {
    }

    @Override
    public void onFragmentDetached(String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(tag);
        if (fragment != null) {
            fragmentManager
                    .beginTransaction()
                    .disallowAddToBackStack()
                    .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                    .detach(fragment)
                    .commitNow();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Drawable drawable = item.getIcon();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }

      /*  switch (item.getItemId()) {
            case R.id.action_user_profile:{
                Intent intent = MyProfileActivity.getStartIntent(this);
                startActivity(intent);
                finish();
                return true;
            }
            case R.id.action_copy:
                return true;
            case R.id.action_share:
                return true;
            case R.id.action_delete:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }*/
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void openTopActivity() {
        startActivity(TopActivity.getStartIntent(this));
        finish();
    }
    @OnClick(R.id.temporary_logout_button)
    public void logOut(){
        mPresenter.onLogOutClick();
    }
    @OnClick(R.id.btn_event_join)
    public void openJoinEventActivity() {
        startActivity(JoinEventActivity.getStartIntent(this));
    }
    @OnClick(R.id.btn_event_create)
    public void openCreateEventActivity() {
        startActivity(CreateEventActivity.getStartIntent(this));
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
