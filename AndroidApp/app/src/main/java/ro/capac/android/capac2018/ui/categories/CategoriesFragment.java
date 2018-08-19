package ro.capac.android.capac2018.ui.categories;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.ButterKnife;
import ro.capac.android.capac2018.R;
import ro.capac.android.capac2018.data.db.model.Category;
import ro.capac.android.capac2018.di.component.ActivityComponent;
import ro.capac.android.capac2018.ui.base.BaseFragment;
import ro.capac.android.capac2018.ui.categorized_events.CategorizedEventsActivity;

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
    public void openCategorizedEventsActivity() {
        startActivity(CategorizedEventsActivity.getStartIntent(this.getContext()));
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
        GridView gridView = view.findViewById(R.id.categories_container);
        ArrayList<Category> categories = Category.getAllCategories();
        CategoryAdapter adapter = new CategoryAdapter(this.getContext(),categories);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new GridView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openCategorizedEventsActivity();
            }
        });
        return view;
    }
    @Override
    protected void setUp(View view) {

    }
    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }


}