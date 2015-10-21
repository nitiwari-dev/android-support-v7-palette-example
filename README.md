# android-support-v7-palette-example

This is demostration of how to extract color from bitmap usign android support v7 palette library.

<b>Steps 1:</b> Add this into build.gradle.

    compile 'com.android.support:palette-v7:+'


<b>Step 2:</b>  Provide the bitmap to fecth `swatch` list containing `rgb` values as shown below.
        
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                swatchesList = palette.getSwatches();
            }
        });
    }


We get `titleText`, `bodyText`, `RGB`, `HSL (Hue, Saturation, Lightness)` respectively.

This example too extract the `rgb` value from the `drawable` and display it into the `background` of parent layout using interval of 1sec.

