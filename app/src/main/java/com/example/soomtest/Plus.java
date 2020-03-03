package com.example.soomtest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.prefs.Preferences;

import de.hdodenhof.circleimageview.CircleImageView;

public class Plus extends AppCompatActivity {

    AppCompatImageView adPhoto1, adPhoto2, adPhoto3, adPhoto4, adPhoto5, adPhoto6, adPhoto7, adPhoto8,video_photo;
    AppCompatImageView plus1, plus2, plus3, plus4, plus5, plus6, plus7, plus8,BackBtn;
    BottomSheetDialog bottomSheetDialog,bottomSheetDialog1;
    private Button videoBtn;
    private VideoView videoView;
    private static final String VIDEO_DIRECTORY = "/demonuts";
    private int GALLERY = 1000, CAMERA = 2000;
    private MediaController mediacontroller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plus_activity);

        adPhoto1 = findViewById(R.id.add_photo_1);
        adPhoto2 = findViewById(R.id.add_photo_2);
        adPhoto3 = findViewById(R.id.add_photo_3);
        adPhoto4 = findViewById(R.id.add_photo_4);
        adPhoto5 = findViewById(R.id.add_photo_5);
        adPhoto6 = findViewById(R.id.add_photo_6);
        adPhoto7 = findViewById(R.id.add_photo_7);
        adPhoto8 = findViewById(R.id.add_photo_8);
        plus1 = findViewById(R.id.plus1);
        plus2 = findViewById(R.id.plus2);
        plus3 = findViewById(R.id.plus3);
        plus4 = findViewById(R.id.plus4);
        plus5 = findViewById(R.id.plus5);
        plus6 = findViewById(R.id.plus6);
        plus7 = findViewById(R.id.plus7);
        plus8 = findViewById(R.id.plus8);
        videoBtn = (Button) findViewById(R.id.btn_viedo);
        video_photo = findViewById(R.id.video_photo);
        videoView = (VideoView) findViewById(R.id.vv);
        mediacontroller = new MediaController(this);
        mediacontroller.setAnchorView(videoView);
        BackBtn = findViewById(R.id.btnBack);

        adPhoto1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomSheet(0, 100);
            }
        });

        adPhoto2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomSheet(1, 200);
            }
        });

        adPhoto3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomSheet(2, 300);
            }
        });

        adPhoto4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomSheet(3, 400);
            }
        });

        adPhoto5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomSheet(4, 500);

            }
        });

        adPhoto6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomSheet(5, 600);

            }
        });

        adPhoto7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomSheet(6, 700);

            }
        });

        adPhoto8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomSheet(7, 800);

            }
        });

        videoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomSheetVideo();
            }
        });

        BackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });

    }

    void showBottomSheetVideo() {

        bottomSheetDialog1 = new BottomSheetDialog(this, R.style.SheetDialog);
        final View bottomSheetDialogView = getLayoutInflater().inflate(R.layout.choose_video, null);
        bottomSheetDialog1.setContentView(bottomSheetDialogView);

        View btnGallery = bottomSheetDialogView.findViewById(R.id.btnGallery_video);
        View btnCamera = bottomSheetDialogView.findViewById(R.id.btnCamera_video);
        View btnCancel = bottomSheetDialogView.findViewById(R.id.btnCancel_video);

        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseVideoFromGallary();
                bottomSheetDialog1.dismiss();
            }
        });
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takeVideoFromCamera();
                bottomSheetDialog1.dismiss();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialog1.dismiss();
            }
        });
        bottomSheetDialog1.show();
    }

    private void showPictureDialog() {
        AlertDialog.Builder pictureDialog = new AlertDialog.Builder(this);
        pictureDialog.setTitle("Select Action");
        String[] pictureDialogItems = {
                "Select video from gallery",
                "Record video from camera"};
        pictureDialog.setItems(pictureDialogItems,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                chooseVideoFromGallary();
                                break;
                            case 1:
                                takeVideoFromCamera();
                                break;
                        }
                    }
                });
        pictureDialog.show();
    }

    public void chooseVideoFromGallary() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(galleryIntent, GALLERY);
    }

    private void takeVideoFromCamera() {
        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        startActivityForResult(intent, CAMERA);
    }

    void showBottomSheet(final int cameraCode, final int galleryCode) {

        bottomSheetDialog = new BottomSheetDialog(this, R.style.SheetDialog);
        final View bottomSheetDialogView = getLayoutInflater().inflate(R.layout.choose_picture, null);
        bottomSheetDialog.setContentView(bottomSheetDialogView);

        View btnGallery = bottomSheetDialogView.findViewById(R.id.btnGallery);
        View btnCamera = bottomSheetDialogView.findViewById(R.id.btnCamera);
        View btnCancel = bottomSheetDialogView.findViewById(R.id.btnCancel);

        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gallery = new Intent();
                gallery.setType("image/*");
                gallery.setAction(Intent.ACTION_GET_CONTENT);

                startActivityForResult(Intent.createChooser(gallery, "Select Picture"), galleryCode);
                bottomSheetDialog.dismiss();
            }
        });
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, cameraCode);
                bottomSheetDialog.dismiss();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 0:
                if (resultCode == -1) {
                    Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
                    adPhoto1.setImageBitmap(thumbnail);
                    plus1.setVisibility(View.GONE);
                } else if (resultCode == RESULT_OK) {
                    Uri selectedImage = data.getData();
                    adPhoto1.setImageURI(selectedImage);
                    plus1.setVisibility(View.GONE);

                }
                break;

            case 1:
                if (resultCode == -1) {
                    Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
                    adPhoto2.setImageBitmap(thumbnail);
                    plus2.setVisibility(View.GONE);
                }
                break;
            case 2:
                if (resultCode == -1) {
                    Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
                    adPhoto3.setImageBitmap(thumbnail);
                    plus3.setVisibility(View.GONE);
                }
                break;

            case 3:
                if (resultCode == -1) {
                    Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
                    adPhoto4.setImageBitmap(thumbnail);
                    plus4.setVisibility(View.GONE);
                }
                break;
            case 4:
                if (resultCode == -1) {
                    Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
                    adPhoto5.setImageBitmap(thumbnail);
                    plus5.setVisibility(View.GONE);
                }
                break;

            case 5:
                if (resultCode == -1) {
                    Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
                    adPhoto6.setImageBitmap(thumbnail);
                    plus6.setVisibility(View.GONE);
                }
                break;
            case 6:
                if (resultCode == -1) {
                    Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
                    adPhoto7.setImageBitmap(thumbnail);
                    plus7.setVisibility(View.GONE);
                }
                break;

            case 7:
                if (resultCode == -1) {
                    Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
                    adPhoto8.setImageBitmap(thumbnail);
                    plus8.setVisibility(View.GONE);
                }
                break;
            case 100:
                if (resultCode == RESULT_OK) {
                    Uri selectedImage = data.getData();
                    adPhoto1.setImageURI(selectedImage);
                    plus1.setVisibility(View.GONE);

                }
                break;
            case 200:
                if (resultCode == RESULT_OK) {
                    Uri selectedImage = data.getData();
                    adPhoto2.setImageURI(selectedImage);
                    plus2.setVisibility(View.GONE);

                }
                break;
            case 300:
                if (resultCode == RESULT_OK) {
                    Uri selectedImage = data.getData();
                    adPhoto3.setImageURI(selectedImage);
                    plus3.setVisibility(View.GONE);

                }
                break;
            case 400:
                if (resultCode == RESULT_OK) {
                    Uri selectedImage = data.getData();
                    adPhoto4.setImageURI(selectedImage);
                    plus4.setVisibility(View.GONE);

                }
                break;
            case 500:
                if (resultCode == RESULT_OK) {
                    Uri selectedImage = data.getData();
                    adPhoto5.setImageURI(selectedImage);
                    plus5.setVisibility(View.GONE);

                }
                break;
            case 600:
                if (resultCode == RESULT_OK) {
                    Uri selectedImage = data.getData();
                    adPhoto6.setImageURI(selectedImage);
                    plus6.setVisibility(View.GONE);

                }
                break;
            case 700:
                if (resultCode == RESULT_OK) {
                    Uri selectedImage = data.getData();
                    adPhoto7.setImageURI(selectedImage);
                    plus7.setVisibility(View.GONE);

                }
                break;
            case 800:
                if (resultCode == RESULT_OK) {
                    Uri selectedImage = data.getData();
                    adPhoto8.setImageURI(selectedImage);
                    plus8.setVisibility(View.GONE);

                }
                break;
            case 1000:
                if (requestCode == GALLERY) {
                    Log.d("what", "gale");
                    if (data != null) {
                        Uri contentURI = data.getData();

                        String selectedVideoPath = getPath(contentURI);
                        Log.d("path", selectedVideoPath);
                        video_photo.setVisibility(View.GONE);
                        saveVideoToInternalStorage(selectedVideoPath);
                        videoView.setMediaController(mediacontroller);
                        videoView.setVideoURI(contentURI);
                        videoView.requestFocus();
                        videoView.start();
                    }
                }
                break;
            case 2000:
                if (requestCode == CAMERA) {
                    Uri contentURI = data.getData();
                    String recordedVideoPath = getPath(contentURI);
                    Log.d("frrr",recordedVideoPath);
                    video_photo.setVisibility(View.GONE);
                    saveVideoToInternalStorage(recordedVideoPath);
                    videoView.setMediaController(mediacontroller);
                    videoView.setVideoURI(contentURI);
                    videoView.requestFocus();
                    videoView.start();
                }
        }
    }

    private void saveVideoToInternalStorage (String filePath) {

        File newfile;

        try {

            File currentFile = new File(filePath);
            File wallpaperDirectory = new File(Environment.getExternalStorageDirectory() + VIDEO_DIRECTORY);
            newfile = new File(wallpaperDirectory, Calendar.getInstance().getTimeInMillis() + ".mp4");

            if (!wallpaperDirectory.exists()) {
                wallpaperDirectory.mkdirs();
            }

            if(currentFile.exists()){

                InputStream in = new FileInputStream(currentFile);
                OutputStream out = new FileOutputStream(newfile);

                // Copy the bits from instream to outstream
                byte[] buf = new byte[1024];
                int len;

                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                in.close();
                out.close();
                Log.v("vii", "Video file saved successfully.");
            }else{
                Log.v("vii", "Video saving failed. Source file missing.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getPath(Uri uri) {
        String[] projection = { MediaStore.Video.Media.DATA };
        Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
        if (cursor != null) {
            // HERE YOU WILL GET A NULLPOINTER IF CURSOR IS NULL
            // THIS CAN BE, IF YOU USED OI FILE MANAGER FOR PICKING THE MEDIA
            int column_index = cursor
                    .getColumnIndexOrThrow(MediaStore.Video.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        } else
            return null;
    }


}
