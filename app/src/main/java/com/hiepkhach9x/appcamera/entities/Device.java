package com.hiepkhach9x.appcamera.entities;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by hungh on 12/27/2016.
 */

public class Device implements Parcelable {
    private String deviceName;
    private ArrayList<Camera> cameras;

    public Device(String deviceName, ArrayList<Camera> cameras) {
        this.deviceName = deviceName;
        this.cameras = cameras;
    }

    public Device() {
    }

    protected Device(Parcel in) {
        deviceName = in.readString();
        cameras = in.createTypedArrayList(Camera.CREATOR);
    }

    public static final Creator<Device> CREATOR = new Creator<Device>() {
        @Override
        public Device createFromParcel(Parcel in) {
            return new Device(in);
        }

        @Override
        public Device[] newArray(int size) {
            return new Device[size];
        }
    };

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public ArrayList<Camera> getCameras() {
        return cameras;
    }

    public void setCameras(ArrayList<Camera> cameras) {
        if(cameras == null) {
            this.cameras = new ArrayList<>();
        }
        this.cameras = cameras;
    }

    @Override
    public String toString() {
        return "Device: " + deviceName + ": NumberCamera: " + cameras.size();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(deviceName);
        dest.writeTypedList(cameras);
    }

    public static class Camera implements Parcelable {
        private String cameraName;
        private String cameraId;
        private boolean isOnline;

        public Camera() {
        }

        public Camera(String cameraName, String cameraId) {
            this.cameraName = cameraName;
            this.cameraId = cameraId;
        }

        protected Camera(Parcel in) {
            cameraName = in.readString();
            cameraId = in.readString();
            isOnline = in.readByte() != 0;
        }

        public static final Creator<Camera> CREATOR = new Creator<Camera>() {
            @Override
            public Camera createFromParcel(Parcel in) {
                return new Camera(in);
            }

            @Override
            public Camera[] newArray(int size) {
                return new Camera[size];
            }
        };

        public void setCameraName(String cameraName) {
            this.cameraName = cameraName;
        }

        public void setCameraId(String cameraId) {
            this.cameraId = cameraId;
        }

        public String getCameraName() {
            return cameraName;
        }

        public String getCameraId() {
            return cameraId;
        }

        public boolean isOnline() {
            return isOnline;
        }

        public void setOnline(boolean online) {
            isOnline = online;
        }

        @Override
        public String toString() {
            return "Camera: " + cameraName + "---ID: " + cameraId;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(cameraName);
            dest.writeString(cameraId);
            dest.writeByte((byte) (isOnline ? 1 : 0));
        }
    }
}
