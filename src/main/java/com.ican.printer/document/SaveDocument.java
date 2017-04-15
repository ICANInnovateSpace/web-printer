package com.ican.printer.document;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by mrzhou on 17-4-14.
 * 上传文档文件操作类
 */
public class SaveDocument {

    /**
     * 将上传的文件转存到upload文件夹
     * 并返回文件的绝对路径（用于给openoffice
     * 计算文档页数）
     *
     * @param request http请求
     * @return 文件转存的绝对路径
     * */
    public String getSaveDocument(HttpServletRequest request){
        String documentPath = null;
        //判断是否为上传文件类型请求
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (isMultipart){
            //创建文件上传器
            ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
            //解析请求
            List<FileItem> fileItems = null;
            try {
                fileItems = servletFileUpload.parseRequest(request);
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
            //迭代判断请求信息
            Iterator<FileItem> iterator = fileItems.iterator();
            while (iterator.hasNext()){
                FileItem next = iterator.next();
                //不是普通的表单数据
                if (!next.isFormField()){
                    //获取文件的名字和需要转存的路径
                    String fileName = next.getName();
                    String basePath = request.getRealPath("/upload");
                    //获取当前的时间
                    String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                    String filePath = basePath + "/" + date + " " + fileName;
                    //保存文件的绝对路径，用于返回
                    documentPath = filePath;
                    File file = new File(filePath);
                    try {
                        //转存文件
                        next.write(file);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return documentPath;
    }
}
