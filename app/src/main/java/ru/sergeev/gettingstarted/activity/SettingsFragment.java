package ru.sergeev.gettingstarted.activity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ru.sergeev.gettingstarted.R;

import static android.app.Activity.RESULT_OK;

/**
 * Created by serge on 21.02.2018.
 */

public class SettingsFragment extends Fragment {

    private Button updatePhoto;
    private Button changePassword;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_settings, container, false);
        return v;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        changePassword=view.findViewById(R.id.updatePassword);
        updatePhoto = view.findViewById(R.id.updateImageButton);
        updatePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateProfileImage(v);
            }
        });
        getActivity().setTitle("Настройки");
    }

    public void updateProfileImage(View view){
        Intent pickerPhotoIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(pickerPhotoIntent,0);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 0:
                if(requestCode == RESULT_OK){
                    Log.i("SettingsFragment", "case 0");
                }
                break;
            case 2:
                if(requestCode == RESULT_OK){
                    Log.i("SettingsFragment", "case 1");
                }
                break;
        }
    }
}
