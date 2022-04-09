package com.learn.world.spring.test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestTree {

    public static void main(String[] args) {
     String root="D:\\workspaces\\idea\\data-source";
     File dir = new File(root);
     TreeBean parent = new TreeBean();
     parent.setPath("");
     parent.setFullPath("");
     listTree(dir,parent);
     int i=0;
     Map<String, List<String>> map = new HashMap<>();
     printTree("",parent,map);
     map.entrySet().forEach(en->{
         System.out.println("|"+en.getKey());
         for (String p : en.getValue()) {
             System.out.println("|----------"+p);
         }
     });
    }

    private static void printTree(String path,TreeBean parent,Map<String,List<String>> map) {
        String nextPath = path + "." + parent.getPath();
        if(parent.getChilds() != null){
            for (TreeBean cd : parent.getChilds()) {
                printTree(nextPath,cd,map);
            }
        }else {
            if(parent.getFullPath().contains("/src/main/java/")){
                String[] split = parent.getFullPath().split("/src/main/java/");
                List<String> ps = map.get(split[0]);
                if(ps == null){
                    ps = new ArrayList<>();
                    map.put(split[0],ps);
                }
                ps.add(split[1].replace("/","."));
            }
//            System.out.println(parent.getFullPath());
        }
    }

    private static void listTree(File dir, TreeBean parent) {
        if(dir.isDirectory()){
            if(dir.getAbsolutePath().contains(".")){
                return;
            }
            TreeBean tb = new TreeBean();
            tb.setPath(dir.getName());
            tb.setFullPath(parent.getFullPath()+"/"+dir.getName());
            parent.addChild(tb);
            File[] files = dir.listFiles();
            if(files != null && files.length > 0){
                for (File file : files) {
                    if(file.isDirectory()){
                        listTree(file,tb);
                    }
                }
            }
        }
    }
}

class TreeBean{

    private String path;
    private String fullPath;

    private TreeBean parent;

    private List<TreeBean> childs;

    public String getFullPath() {
        return fullPath;
    }

    public void setFullPath(String fullPath) {
        this.fullPath = fullPath;
    }

    public void addChild(TreeBean child){
        if(childs == null){
            childs = new ArrayList<>();

        }
        childs.add(child);
    }
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public TreeBean getParent() {
        return parent;
    }

    public void setParent(TreeBean parent) {
        this.parent = parent;
    }

    public List<TreeBean> getChilds() {
        return childs;
    }

    public void setChilds(List<TreeBean> childs) {
        this.childs = childs;
    }
}
