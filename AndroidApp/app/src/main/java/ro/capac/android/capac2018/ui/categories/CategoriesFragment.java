package ro.capac.android.capac2018.ui.categories;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import ro.capac.android.capac2018.R;
import ro.capac.android.capac2018.data.db.model.Category;
import ro.capac.android.capac2018.di.component.ActivityComponent;
import ro.capac.android.capac2018.ui.base.BaseFragment;
import ro.capac.android.capac2018.ui.categorized_events.CategorizedEventsActivity;
import ro.capac.android.capac2018.ui.dialog.CategoryProposeFragment;

public class CategoriesFragment extends BaseFragment implements CategoriesMvpView {
    public static final String TAG = "CategoriesFragment";

    @Inject
    CategoriesMvpPresenter<CategoriesMvpView> mPresenter;

    public static CategoriesFragment newInstance() {
        Bundle args = new Bundle();
        CategoriesFragment fragment = new CategoriesFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void openCategorizedEventsActivity(String category) {
        startActivity(CategorizedEventsActivity.getStartIntent(this.getContext()).putExtra("category",category));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_categories, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(CategoriesFragment.this);
            setUnBinder(ButterKnife.bind(this, view));
            mPresenter.onAttach(this);
        }
        ListView listView = view.findViewById(R.id.categories_container);
        ArrayList<Category> categories = Category.getAllCategories();
        Log.d(TAG, "onCreateView: category 1:" + categories.get(0));
        final CategoryAdapter adapter = new CategoryAdapter(this.getContext(),categories);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new GridView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openCategorizedEventsActivity(adapter.getItem(position).name);
            }
        });
        return view;
    }
    @Override
    protected void setUp(View view) {

    }
    @OnClick(R.id.btn_new_category)
    public void showProposeCategoryDialog()
    {
        CategoryProposeFragment newFragment = new CategoryProposeFragment();
        newFragment.setShowsDialog(true);
        newFragment.show(getFragmentManager(), CategoryProposeFragment.TAG);

    }

    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }


}
