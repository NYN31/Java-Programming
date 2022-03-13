package com.ThreadProject;

public class Main {
    public static void main(String[] args){
        final String downloadDir = "/home/noyon_admin/pictureDownload";
        final String url = "https://drive.google.com/uc?export=download&id=1If09rjeGZxSCxjMpkYPJN87784YjT235";

        DownloadManager downloadManager = new DownloadManager();
        downloadManager.download(url, downloadDir);
    }
}
