package me.foly.si.core;

public interface IAssetsManager<TImage,TFont> {
    TImage getAsset(String imgSrc);

    TFont getFont(String fontSrc);

    boolean isPreloadingDone();

    double getPreloadingProgress();

    int[] getContour(String imgSrc);
}
