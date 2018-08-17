package ro.capac.android.capac2018.ui.categories;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import ro.capac.android.capac2018.data.DataManager;
import ro.capac.android.capac2018.ui.base.BasePresenter;
import ro.capac.android.capac2018.utils.rx.SchedulerProvider;

public class CategoriesPresenter<V extends CategoriesMvpView> extends BasePresenter<V>
        implements CategoriesMvpPresenter<V> {

    @Inject
    public CategoriesPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

}
