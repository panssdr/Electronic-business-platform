package domain;

import java.io.File;

public class Images {
    private String[] files; //图片目录下所有文件
    private String path; //图片目录

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String[] getFiles() {//获取图片目录下所有文件名
        if(path==null){
            return null;
        }
        File parentDirectory = new File(path);//目录
        files = parentDirectory.list();//取目录中所有的文件
        return files;
    }

}
