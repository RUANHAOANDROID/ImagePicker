package com.lcw.library.imagepicker.manager;

import com.lcw.library.imagepicker.utils.ImageLoader;

import java.util.ArrayList;

/**
 * 统一配置管理类
 * Create by: chenWei.li
 * Date: 2019/1/23
 * Time: 10:32 AM
 * Email: lichenwei.me@foxmail.com
 */
public class ConfigManager {

    public static final int SELECT_MODE_SINGLE = 0;
    public static final int SELECT_MODE_MULTI = 1;

    private String title;//标题
    private boolean showCamera;//是否显示拍照Item，默认不显示
    private boolean showRecordVideo;//是否显示录制视频，默认不显示
    private boolean showImage = true;//是否显示图片，默认显示
    private boolean showVideo = true;//是否显示视频，默认显示
    private boolean filterGif = false;//是否过滤GIF图片，默认不过滤
    private int selectionMode = SELECT_MODE_SINGLE;//选择模式，默认单选
    private int maxCount = 1;//最大选择数量，默认为1
    private int maxDuration = 30;//最大拍摄时间，默认为30秒
    private boolean singleType = true;//是否只支持选单类型（图片或者视频）
    private ArrayList<String> imagePaths;//上一次选择的图片地址集合

    private ImageLoader imageLoader;

    private static volatile ConfigManager mConfigManager;

    private ConfigManager() {
    }

    public static ConfigManager getInstance() {
        if (mConfigManager == null) {
            synchronized (SelectionManager.class) {
                if (mConfigManager == null) {
                    mConfigManager = new ConfigManager();
                }
            }
        }
        return mConfigManager;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isShowCamera() {
        return showCamera;
    }

    public void setShowCamera(boolean showCamera) {
        this.showCamera = showCamera;
    }

    public boolean isShowRecordVideo() {
        return showRecordVideo;
    }

    public void setShowRecordVideo(boolean showRecordVideo) {
        this.showRecordVideo = showRecordVideo;
    }

    public boolean isShowImage() {
        return showImage;
    }

    public void setShowImage(boolean showImage) {
        this.showImage = showImage;
    }

    public boolean isShowVideo() {
        return showVideo;
    }

    public void setShowVideo(boolean showVideo) {
        this.showVideo = showVideo;
    }

    public int getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(int maxCount) {
        if (maxCount > 1) {
            setSelectionMode(SELECT_MODE_MULTI);
        }
        this.maxCount = maxCount;
    }

    public int getMaxDuration() {
        return maxDuration;
    }

    public void setMaxDuration(int maxDuration) {
        this.maxDuration = maxDuration;
    }

    public boolean isFilterGif() {
        return filterGif;
    }

    public void setFilterGif(boolean filterGif) {
        this.filterGif = filterGif;
    }

    public int getSelectionMode() {
        return selectionMode;
    }

    public void setSelectionMode(int mSelectionMode) {
        this.selectionMode = mSelectionMode;
    }

    public ArrayList<String> getImagePaths() {
        return imagePaths;
    }

    public void setImagePaths(ArrayList<String> imagePaths) {
        this.imagePaths = imagePaths;
    }

    public ImageLoader getImageLoader() throws Exception {
        if (imageLoader == null) {
            throw new Exception("imageLoader is null");
        }
        return imageLoader;
    }

    public boolean isSingleType() {
        return singleType;
    }

    public void setSingleType(boolean singleType) {
        this.singleType = singleType;
    }

    public void setImageLoader(ImageLoader imageLoader) {
        this.imageLoader = imageLoader;
    }

    /**
     * 重置设置
     */
    public void reset() {
        title = "";//标题
        showCamera = false;//是否显示拍照Item，默认不显示
        showRecordVideo = false;//是否显示录制视频，默认不显示
        showImage = true;//是否显示图片，默认显示
        showVideo = true;//是否显示视频，默认显示
        filterGif = false;//是否过滤GIF图片，默认不过滤
        selectionMode = SELECT_MODE_SINGLE;//选择模式，默认单选
        maxCount = 1;//最大选择数量，默认为1
        maxDuration = 30;//最大拍摄时间，默认为30秒
        singleType = false;//是否只支持选单类型（图片或者视频）
        imagePaths = null;//上一次选择的图片地址集合
        imageLoader = null;
    }
}
