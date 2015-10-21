# android-support-v7-palette-example

This is demostration of how to extract color from `bitmap` using android palette support library. As show below.

![first_01](https://cloud.githubusercontent.com/assets/10304040/10637105/3df3df5a-7821-11e5-8706-91c39ef6ea57.png)
![second](https://cloud.githubusercontent.com/assets/10304040/10637104/3df3c0c4-7821-11e5-9fee-0a0769f51df8.png)
![third](https://cloud.githubusercontent.com/assets/10304040/10637103/3df1cbc0-7821-11e5-9fb0-479b1e2f9c56.png)


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
