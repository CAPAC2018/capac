package ro.capac.android.capac2018.ui.top;
import ro.capac.android.capac2018.di.PerActivity;
import ro.capac.android.capac2018.ui.base.MvpPresenter;
import ro.capac.android.capac2018.ui.base.MvpView;

@PerActivity
public interface TopMvpPresenter<V extends TopMvpView & MvpView> extends MvpPresenter<V> {

}
