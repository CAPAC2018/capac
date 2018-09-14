package ro.capac.android.capac2018.ui.dialog;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.OnClick;
import ro.capac.android.capac2018.R;
import ro.capac.android.capac2018.di.component.ActivityComponent;
import ro.capac.android.capac2018.ui.base.BaseDialog;
import ro.capac.android.capac2018.ui.main.MainActivity;

public class CategoryProposeFragment extends BaseDialog {

    public final static String TAG = "CategoryPropose";

    @BindView(R.id.input_edit_text)
    EditText mSport;

    public static CategoryProposeFragment newInstance() {
        CategoryProposeFragment fragment = new CategoryProposeFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
    Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_propose_category, container, false);

        return view;
    }
    @Override
    @OnClick(R.id.btn_later2)
    public void onLaterClicked()
    {
        dismissDialog(TAG);
    }
    @Override
    @OnClick(R.id.btn_submit2)
    public void submitEntry()
    {
        dismissDialog(TAG);
    }
    @Override
    protected void setUp(View view) {

    }
}
