package com.android.addrinks.addrinks;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    private static final int RECOVERY_DIALOG_REQUEST = 1;

    VideoView videoview;
    ProgressDialog pDialog;
    View v;

    String VideoURL = "android.resource://com.android.addrinks.addrinks/"+R.raw.testvideo;

    public MainActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_main, container, false);

        videoview = (VideoView) v.findViewById(R.id.video_view);
        // Create a progressbar
        /*pDialog = new ProgressDialog(getActivity());
        // Set progressbar message
        pDialog.setMessage("Buffering...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        // Show progressbar
        pDialog.show();*/

        try {
            // Start the MediaController
            MediaController mediacontroller = new MediaController(
                    getActivity());
            mediacontroller.setAnchorView(videoview);
            // Get the URL from String VideoURL
            Uri video = Uri.parse(VideoURL);
            videoview.setMediaController(mediacontroller);
            videoview.setVideoURI(video);
            videoview.requestFocus();
            //videoview.start();

        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }

        return v;
    }
}
