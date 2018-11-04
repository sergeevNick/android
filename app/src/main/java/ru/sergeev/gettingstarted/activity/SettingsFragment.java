package ru.sergeev.gettingstarted.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;

import ru.sergeev.gettingstarted.R;

import static android.app.Activity.RESULT_OK;

/**
 * Created by serge on 21.02.2018.
 */

public class SettingsFragment extends Fragment {
    private Button updatePhoto;
    private Button changePassword;
    private ImageView photo;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_settings, container, false);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        photo = view.findViewById(R.id.settingsImage);
        changePassword = view.findViewById(R.id.updatePassword);
        updatePhoto = view.findViewById(R.id.updateImageButton);
        updatePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateProfileImage(v);
            }
        });
        getActivity().setTitle("Настройки");
    }

    public void updateProfileImage(View view) {
        Intent pickerPhotoIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(pickerPhotoIntent, 20);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri selectedImage;
        InputStream inputStream;
        Bitmap bitmap;

        if (resultCode == RESULT_OK) {
            if (requestCode == 20) {
                selectedImage = data.getData();

                try {
                    inputStream = getActivity().getContentResolver().openInputStream(selectedImage);
                    bitmap = BitmapFactory.decodeStream(inputStream);
                    photo.setImageBitmap(bitmap);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    Toast.makeText(this.getContext(), "Error while loading image: ", Toast.LENGTH_LONG).show();

                }
            }
        }

        switch (resultCode) {
            case 0:
                if (resultCode == RESULT_OK) {
                    selectedImage = data.getData();
                    try {
                        inputStream = getActivity().getContentResolver().openInputStream(selectedImage);
                        bitmap = BitmapFactory.decodeStream(inputStream);
                        photo.setImageBitmap(bitmap);

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                        Toast.makeText(this.getContext(), "Error while loading image: ", Toast.LENGTH_LONG).show();

                    }
                }
                break;
            case 2:
                if (resultCode == RESULT_OK) {
                    selectedImage = data.getData();
                    try {
                        inputStream = getActivity().getContentResolver().openInputStream(selectedImage);
                        bitmap = BitmapFactory.decodeStream(inputStream);
                        photo.setImageBitmap(bitmap);

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                        Toast.makeText(this.getContext(), "Error while loading image: ", Toast.LENGTH_LONG).show();

                    }
                }
                break;
        }
    }
}
