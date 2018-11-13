package com.baizhi.controller;

import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import com.baizhi.utils.DurationUtil;
import com.sun.glass.ui.Size;
import com.sun.xml.internal.ws.api.message.Attachment;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

@Controller
@RequestMapping("/chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;

    @RequestMapping("/showAll")
    public @ResponseBody
    List<Chapter> showAll() {
        List<Chapter> all = chapterService.findAll();
        return all;
    }

    @RequestMapping("/save")
    public @ResponseBody
    Map<String, Object> save(HttpSession session, MultipartFile upload, Chapter chapter) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            String filename = upload.getOriginalFilename();
            String mp3 = session.getServletContext().getRealPath("/back/mp3");
            long size = upload.getSize();
            Double s = size / 1024.0 / 1024;
            s = (double) Math.round(s * 100) / 100;//获取小数点后两位
            String s1 = s.toString();

            chapter.setSize(s1 + "MB");

            chapter.setTitle(filename);

            chapter.setDownpath("/back/mp3/" + filename);

            upload.transferTo(new File(mp3 + "/" + upload.getOriginalFilename()));
            File filee = new File(mp3 + "/" + upload.getOriginalFilename());//获取音频
            String time = DurationUtil.getVideoTime(filee);//调用工具类获取时长
            chapter.setDuration(time);
            chapterService.add(chapter);
            map.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("msg", e.getMessage());
        }
        return map;
    }

    //下载音频
    @RequestMapping("/download")
    public void download(String fileName,HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(fileName);
        //根据接受文件名去服务中指定目录读取文件
        String realPath = request.getSession().getServletContext().getRealPath("/back/mp3/");
        System.out.println(realPath);
        //以文件输入流读取文件
        FileInputStream is = new FileInputStream(new File(realPath, fileName));
        //设置响应头
        response.setHeader("content-disposition","attachment;fileName="+URLEncoder.encode(fileName, "UTF-8"));
        //获取响应输出流
        ServletOutputStream os = response.getOutputStream();
        //使用IOUtils工具类  拷贝文佳
        IOUtils.copy(is,os);
        //关流
        IOUtils.closeQuietly(is);
        IOUtils.closeQuietly(os);

    }


   /* @RequestMapping("/findAll")
    public @ResponseBody String findAll(Chapter chapter,HttpSession session) {
        System.out.println(albumId);
        List<Chapter> chapterList = chapterService.findAll(chapter.getAlbumid());
        if (chapterList == null) {
            session.setAttribute("flag", false);
        } else {
            session.setAttribute("chapterList", chapterList);
            session.setAttribute("flag", true);
        }
        return "yes";
    }*/


    /*@RequestMapping("download")
    @ResponseBody
    public void downloadChapter(String url, String oldName, HttpServletRequest request, HttpServletResponse response) {

        String projectPath = request.getSession().getServletContext().getRealPath("/");
        File file = new File(projectPath);
        String webappPath = file.getParent();
        String filePath = webappPath + url;
        File downFile = new File(filePath);
        String fileName = null;

        try {
            fileName = new String(oldName.getBytes("utf-8"), "iso-8859-1");
            //URLEncoder.encode(url,"utf-8")
            response.setHeader("content-disposition", "attachment;fileName=" + fileName);
            response.setContentType("/back/mp3/");
            ServletOutputStream sos = response.getOutputStream();
            sos.write(FileUtils.readFileToByteArray(downFile));
            System.out.println("hll");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }*/


 /* @RequestMapping("/download")
  public void download(String fileName, String openStyle, HttpServletRequest request, HttpServletResponse response) throws Exception {

      //1.根据接收的文件名去服务中指定目录读取文件
      String realPath = request.getSession().getServletContext().getRealPath("/back/mp3/");
      String filenames[] = fileName.toString().split("/");
      String filename = filenames[filenames.length-1];
      //2.以文件输入流读取文件
      FileInputStream is = new FileInputStream(new File(realPath, filename));
      //2.1 设置响应头
      response.setHeader("content-disposition", openStyle+";fileName=" + URLEncoder.encode(fileName, "UTF-8"));
      //3.获取响应输出流
      ServletOutputStream os = response.getOutputStream();
      //4.使用IOUtils工具类
      IOUtils.copy(is, os);
      //5.关流
      IOUtils.closeQuietly(is);//安静关流
      IOUtils.closeQuietly(os);
  }*/
}
