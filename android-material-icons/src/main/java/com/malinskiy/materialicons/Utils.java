package com.malinskiy.materialicons;

import android.R;
import android.content.Context;
import android.util.Log;

import java.io.*;

import static android.util.TypedValue.COMPLEX_UNIT_DIP;
import static android.util.TypedValue.applyDimension;
import static com.malinskiy.materialicons.Iconify.IconValue;

class Utils {

    public static final String ICON_FONT_FOLDER = "icon_tmp";
    public static final String NAME_PREFIX      = "{md";

    private Utils() {
        // Prevents instantiation
    }

    static int convertDpToPx(Context context, float dp) {
        return (int) applyDimension(COMPLEX_UNIT_DIP, dp,
                                    context.getResources().getDisplayMetrics());
    }

    static boolean isEnabled(int[] stateSet) {
        for (int state : stateSet)
            if (state == R.attr.state_enabled)
                return true;
        return false;
    }

    static File resourceToFile(Context context, String resourceName) throws IOException {
        File f = null;
        if (context.getFilesDir() == null)
            f = new File(context.getCacheDir(), ICON_FONT_FOLDER);
        else
            f = new File(context.getFilesDir(), ICON_FONT_FOLDER);
        if (!f.exists())
            if (!f.mkdirs()) {
                Log.e(Iconify.TAG, "Font folder creation failed");
                throw new IllegalStateException("Cannot create Iconify font destination folder");
            }
        File outPath = new File(f, resourceName);
        if (outPath.exists()) return outPath;

        BufferedOutputStream bos = null;
        InputStream inputStream = null;
        try {
            inputStream = Iconify.class.getClassLoader().getResourceAsStream(resourceName);
            byte[] buffer = new byte[inputStream.available()];
            bos = new BufferedOutputStream(new FileOutputStream(outPath));
            int l = 0;
            while ((l = inputStream.read(buffer)) > 0) {
                bos.write(buffer, 0, l);
            }
            return outPath;
        } finally {
            closeQuietly(bos);
            closeQuietly(inputStream);
        }
    }

    private static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                // Don't care
            }
        }
    }

    public static StringBuilder replaceIcons(StringBuilder text) {
        int startIndex = text.indexOf(NAME_PREFIX);
        if (startIndex == -1) {
            return text;
        }

        int endIndex = text.substring(startIndex).indexOf("}") + startIndex + 1;

        String iconString = text.substring(startIndex + 1, endIndex - 1);
        iconString = iconString.replaceAll("-", "_");
        try {

            IconValue value = IconValue.valueOf(iconString);
            String iconValue = String.valueOf(value.character);

            text = text.replace(startIndex, endIndex, iconValue);
            return replaceIcons(text);

        } catch (IllegalArgumentException e) {
            Log.w(Iconify.TAG, "Wrong icon name: " + iconString);
            return text;
        }
    }
}
